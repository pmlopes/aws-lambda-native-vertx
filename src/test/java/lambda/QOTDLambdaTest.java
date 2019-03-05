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

import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.RunTestOnContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class QOTDLambdaTest {

  private final QOTDLambda fn = new QOTDLambda();

  @Rule
  public RunTestOnContext rule = new RunTestOnContext();

  @Test
  public void shouldGetAQOTD(TestContext should) {
    final Async test = should.async();

    Future<Buffer> fut = fn.call(rule.vertx(), MultiMap.caseInsensitiveMultiMap(), null);

    fut.setHandler(call -> {
      if (call.failed()) {
        should.fail(call.cause());
      } else {
        should.assertNotNull(call.result());
        should.assertTrue(call.result().length() > 0);
        test.complete();
      }
    });
  }

}
