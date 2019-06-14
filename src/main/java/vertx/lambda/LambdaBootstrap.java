/*
 * Copyright 2019 Paulo Lopes.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */
package vertx.lambda;

import io.vertx.core.*;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;

import static java.lang.System.getenv;

import java.text.MessageFormat;
import java.util.ServiceLoader;

/**
 * Main entrypoint for the application.
 */
public class LambdaBootstrap extends AbstractVerticle {

  private static final String LAMBDA_VERSION_DATE = "2018-06-01";

  private static final String LAMBDA_RUNTIME_TEMPLATE = "/{0}/runtime/invocation/next";
  private static final String LAMBDA_INVOCATION_TEMPLATE = "/{0}/runtime/invocation/{1}/response";
  private static final String LAMBDA_INIT_ERROR_TEMPLATE = "/{0}/runtime/init/error";
  private static final String LAMBDA_ERROR_TEMPLATE = "/{0}/runtime/invocation/{1}/error";

  public static void main(String[] args) {
    try {
      final VertxOptions vertxOptions = new VertxOptions().setEventLoopPoolSize(1);
      final JsonObject config = new JsonObject();
      final DeploymentOptions deploymentOptions = new DeploymentOptions().setConfig(config);

      String runtimeApi = getenv("AWS_LAMBDA_RUNTIME_API");

      int sep = runtimeApi.indexOf(':');
      if (sep != -1) {
        config.put("host", runtimeApi.substring(0, sep));
        config.put("port", Integer.parseInt(runtimeApi.substring(sep + 1)));
      } else {
        config.put("host", runtimeApi);
      }
      config.put("runtimeUrl", MessageFormat.format(LAMBDA_RUNTIME_TEMPLATE, LAMBDA_VERSION_DATE));


      Vertx.vertx(vertxOptions).deployVerticle(new LambdaBootstrap(), deploymentOptions, deploy -> {
        if (deploy.failed()) {
          System.err.println(deploy.cause().getMessage());
          // the whole startup failed
          System.exit(1);
        }
      });
    } catch (RuntimeException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  private WebClient client;

  @Override
  public void start() {
    final JsonObject config = context.config();
    final EventBus eb = vertx.eventBus();

    // register all lambda's into the eventbus
    ServiceLoader<Lambda> serviceLoader = ServiceLoader.load(Lambda.class);
    for (Lambda fn : serviceLoader) {
      fn.init(vertx);
      eb.localConsumer(fn.getClass().getName(), fn);
    }

    // create an WebClient
    this.client = WebClient.create(vertx, new WebClientOptions()
      .setDefaultPort(config.getInteger("port", 80))
      .setDefaultHost(config.getString("host")));

    // Get the handler class and method name from the Lambda Configuration in the format of <fqcn>
    final String fn = getenv("_HANDLER");

    if (fn == null) {
      // Not much else to do handler can't be found.
      final String uri = MessageFormat.format(LAMBDA_INIT_ERROR_TEMPLATE, LAMBDA_VERSION_DATE);
      fail(uri, "Could not find handler method", "InitError");
    } else {
      processEvents(fn);
    }
  }

  private void processEvents(String fn) {
    final EventBus eb = vertx.eventBus();
    final JsonObject config = context.config();

    client.get(config.getString("runtimeUrl")).send(getAbs -> {
      if (getAbs.succeeded()) {
        HttpResponse<Buffer> response = getAbs.result();

        if (response.statusCode() != 200) {
          System.err.println("ERR: HTTP status code <" + response.statusCode() + ">");
          System.exit(0);
        }

        String requestId = response.getHeader(Lambda.LAMBDA_RUNTIME_AWS_REQUEST_ID);

        // Invoke Handler Method
        eb.<Buffer>send(fn, response.body(), new DeliveryOptions().setHeaders(response.headers()), msg -> {
          if (msg.succeeded()) {
            // Post the results of Handler Invocation
            String invocationUrl = MessageFormat.format(LAMBDA_INVOCATION_TEMPLATE, LAMBDA_VERSION_DATE, requestId);
            success(invocationUrl, msg.result().body(), ack -> {
              if (ack.failed()) {
                System.err.println("ERR: " + ack.cause().getMessage());
                // terminate the process
                System.exit(1);
              } else {
                // process the next call
                // run on context to avoid large stacks
                vertx.runOnContext(v -> processEvents(fn));
              }
            });
          } else {
            String initErrorUrl = MessageFormat.format(LAMBDA_ERROR_TEMPLATE, LAMBDA_VERSION_DATE, requestId);
            fail(initErrorUrl, "Invocation Error", "RuntimeError");
          }
        });
      } else {
        getAbs.cause().printStackTrace();
        System.exit(1);
      }
    });
  }

  private void success(String requestURI, Buffer result, Handler<AsyncResult<Void>> handler) {
    client.post(requestURI)
      .sendBuffer(result, ar -> {
        if (ar.succeeded()) {
          // we don't really care about the response
          handler.handle(Future.succeededFuture());
        } else {
          handler.handle(Future.failedFuture(ar.cause()));
        }
      });
  }

  private void fail(String requestURI, String errMsg, String errType) {
    System.err.println("ERR: " + errMsg);

    final JsonObject error = new JsonObject()
      .put("errorMessage", errMsg)
      .put("errorType", errType);

    client.post(requestURI)
      .sendJson(error, ar -> {
        if (ar.failed()) {
          ar.cause().printStackTrace();
        }
        // terminate the process
        System.exit(1);
      });
  }
}
