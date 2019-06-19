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

import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.RunTestOnContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import xyz.jetdrone.vertx.lambda.aws.Lambda;

import java.util.ServiceLoader;

@RunWith(VertxUnitRunner.class)
public class QOTDLambdaTest {

  @Rule
  public RunTestOnContext rule = new RunTestOnContext();

  @Before
  public void beforeTest() {
    // register all lambda's into the eventbus
    ServiceLoader<Lambda> serviceLoader = ServiceLoader.load(Lambda.class);
    for (Lambda fn : serviceLoader) {
      fn.init(rule.vertx());
      rule.vertx().eventBus().localConsumer(fn.getClass().getName(), fn);
    }
  }

  @Test
  public void shouldGetAQOTD(TestContext should) {
    final Async test = should.async();
    final EventBus eb = rule.vertx().eventBus();

    eb.<Buffer>send(QOTDLambda.class.getName(), Buffer.buffer(), msg -> {
      if (msg.failed()) {
        should.fail(msg.cause());
      } else {
        should.assertNotNull(msg.result().body());
        should.assertTrue(msg.result().body().length() > 0);
        test.complete();
      }
    });
  }

}
