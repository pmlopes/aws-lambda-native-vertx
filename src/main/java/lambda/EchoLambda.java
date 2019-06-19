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

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import xyz.jetdrone.vertx.lambda.aws.Lambda;

/**
 * This is a simple example of an echo Lambda.
 */
public class EchoLambda implements Lambda<Object> {

  private EventBus eb;

  @Override
  public void init(Vertx vertx) {
    eb = vertx.eventBus();
  }

  @Override
  public void handle(Message msg) {
    // showcase interop over the eventbus
    eb.send("lambda.DebugLambda", msg.body(), new DeliveryOptions().setHeaders(msg.headers()), send -> {
      // after the message was received and a reply is returned continue
      msg.reply(msg.body());
    });
  }
}
