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
package lambda;

import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import vertx.lambda.Lambda;
import vertx.lambda.event.APIGatewayProxyRequest;
import vertx.lambda.event.APIGatewayProxyResponse;

/**
 * You can use a Lambda function to process requests from an Application Load Balancer.
 *
 * Elastic Load Balancing supports Lambda functions as a target for an Application Load Balancer.
 * Use load balancer rules to route HTTP requests to a function, based on path or header values.
 * Process the request and return an HTTP response from your Lambda function.
 *
 * Elastic Load Balancing invokes your Lambda function synchronously with an event that contains
 * the request body and metadata.
 */
public class ApplicationLoadBalancerLambda implements Lambda<JsonObject> {
  @Override
  public void handle(Message<JsonObject> event) {
    // the payload should be a proxy request
    APIGatewayProxyRequest req = new APIGatewayProxyRequest(event.body());
    // print the payload
    System.out.println(req);

    // Here your business logic...

    event.reply(
      new APIGatewayProxyResponse()
        .setStatusCode(200)
        .setIsBase64Encoded(false)
        .setHeaders(new JsonObject()
            .put("Content-Type", "text/html"))
        .setBody("<h1>Hello from Lambda!</h1>")
      // convert to JSON as it's the expected format by lambda
      .toJson());
  }
}
