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

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

/**
 * Your Lambda function's handler is the method that Lambda calls when your function is invoked.
 *
 * In the following example, the class MyFunction implements a lambda handler. The handler takes
 * one object as input and returns a JSON document.
 *
 * <code>
 *     (msg) -> {
 *         System.out.println(msg.body());
 *         msg.reply(new JsonObject().put("hello", "world"));
 *     }
 * </code>
 *
 * The message body is an object that contains the payload that's provided by the invoker. If the payload is a JSON
 * document, the event object is a {@link JsonObject}. Otherwise, it's a {@link Buffer}. The {@link Message} object has
 * methods and properties that provide information about the invocation, the headers, and the execution environment.
 *
 * The handler is executed every time your Lambda function is invoked. Static code outside of the handler or the
 * {@link Lambda#init(Vertx)} method is executed once per instance of the function. If your handler uses resources like
 * SDK clients and database connections, you can create them outside of the handler method to reuse them for multiple
 * invocations.
 *
 * Each instance of your lambda can process multiple invocation events, but it only processes one event at a time.
 * The number of instances processing an event at any given time is your function's concurrency. For more information
 * about the Lambda execution context, see AWS Lambda Execution Context.
 */
@FunctionalInterface
public interface Lambda<T> extends Handler<Message<T>> {

  String LAMBDA_RUNTIME_AWS_REQUEST_ID = "Lambda-Runtime-Aws-Request-Id";
  String LAMBDA_RUNTIME_DEADLINE_MS = "Lambda-Runtime-Deadline-Ms";
  String LAMBDA_RUNTIME_INVOKE_FUNCTION_ARN = "Lambda-Runtime-Invoke-Function-Arn";
  String LAMBDA_RUNTIME_TRACE_ID = "Lambda-Runtime-Trace-Id";
  String LAMBDA_RUNTIME_CLIENT_CONTEXT = "Lambda-Runtime-Client-Context";
  String LAMBDA_RUNTIME_COGNITO_IDENTITY = "Lambda-Runtime-Cognito-Identity";

  /**
   * Default initialization. It can be used if a function needs to access vertx or the eventbus.
   *
   * @param vertx the current vertx instance.
   */
  default void init(Vertx vertx) {
    // NO-OP!
  }
}
