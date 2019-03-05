package vertx.lambda;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;

import static java.lang.System.getenv;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class LambdaBootstrap {

  private static final String LAMBDA_VERSION_DATE = "2018-06-01";
  private static final String LAMBDA_RUNTIME_URL_TEMPLATE = "http://{0}/{1}/runtime/invocation/next";
  private static final String LAMBDA_INVOCATION_URL_TEMPLATE = "http://{0}/{1}/runtime/invocation/{2}/response";
  private static final String LAMBDA_INIT_ERROR_URL_TEMPLATE = "http://{0}/{1}/runtime/init/error";
  private static final String LAMBDA_ERROR_URL_TEMPLATE = "http://{0}/{1}/runtime/invocation/{2}/error";

  private static final Map<String, Lambda> HANDLERS = new HashMap<>();

  static {
    // load all handlers available, if this becomes a performance
    ServiceLoader<Lambda> serviceLoader = ServiceLoader.load(Lambda.class);
    for (Lambda fn : serviceLoader) {
      HANDLERS.put(fn.getClass().getName(), fn);
    }
  }

  public static void main(String[] args) {
    new LambdaBootstrap(Vertx.vertx());
  }

  private final WebClient client;

  private final String runtimeApi;
  private final Lambda fn;

  private LambdaBootstrap(Vertx vertx) {
    // create an WebClient
    this.client = WebClient.create(vertx);

    this.runtimeApi = getenv("AWS_LAMBDA_RUNTIME_API");
    // Get the handler class and method name from the Lambda Configuration in the format of <fqcn>
    this.fn = HANDLERS.get(getenv("_HANDLER"));
    final String runtimeUrl = MessageFormat.format(LAMBDA_RUNTIME_URL_TEMPLATE, runtimeApi, LAMBDA_VERSION_DATE);

    if (fn == null) {
      // Not much else to do handler can't be found.
      fail(MessageFormat.format(LAMBDA_INIT_ERROR_URL_TEMPLATE, runtimeApi, LAMBDA_VERSION_DATE), "Could not find handler method", "InitError");
      return;
    }

    client.getAbs(runtimeUrl).send(getAbs -> {
      if (getAbs.succeeded()) {
        HttpResponse<Buffer> response = getAbs.result();

        String requestId = response.getHeader("Lambda-Runtime-Aws-Request-Id");

        try {
          // Invoke Handler Method
          fn.call(response.body())
            .setHandler(ar -> {
              if (ar.succeeded()) {
                // Post the results of Handler Invocation
                String invocationUrl = MessageFormat.format(LAMBDA_INVOCATION_URL_TEMPLATE, runtimeApi, LAMBDA_VERSION_DATE, requestId);
                success(invocationUrl, ar.result());
              } else {
                String initErrorUrl = MessageFormat.format(LAMBDA_ERROR_URL_TEMPLATE, runtimeApi, LAMBDA_VERSION_DATE, requestId);
                fail(initErrorUrl, "Invocation Error", "RuntimeError");
                ar.cause().printStackTrace();
              }
            });

        } catch (Exception e) {
          String initErrorUrl = MessageFormat.format(LAMBDA_ERROR_URL_TEMPLATE, runtimeApi, LAMBDA_VERSION_DATE, requestId);
          fail(initErrorUrl, "Invocation Error", "RuntimeError");
          e.printStackTrace();
        }
      } else {
        getAbs.cause().printStackTrace();
      }
    });
  }

  private void success(String successUrl, Buffer result) {

    client.postAbs(successUrl)
      .sendBuffer(result, ar -> {
        if (ar.succeeded()) {
          // we don't really care about the response
          System.exit(0);
        } else {
          ar.cause().printStackTrace();
          System.exit(1);
        }
      });
  }

  private void fail(String errorUrl, String errMsg, String errType) {

    final JsonObject error = new JsonObject()
      .put("errorMessage", errMsg)
      .put("errorType", errType);

    client.postAbs(errorUrl)
      .sendJson(error, ar -> {
        if (ar.succeeded()) {
          // we don't really care about the response
          System.exit(0);
        } else {
          ar.cause().printStackTrace();
          System.exit(1);
        }
      });
  }
}
