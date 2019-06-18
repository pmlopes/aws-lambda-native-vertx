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

import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.Message;
import vertx.lambda.Lambda;

/**
 * This is a simple example of a Lambda. that prints to the STDOUT the job and returns it as is.
 */
public class DebugLambda implements Lambda<Object> {

  @Override
  public void handle(Message msg) {
    System.out.println("HEADERS: " + msg.headers());
    System.out.println("BODY: " + msg.body());

    msg.reply(msg.body(), new DeliveryOptions().setHeaders(msg.headers()));
  }
}
