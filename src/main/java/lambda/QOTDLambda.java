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
import io.vertx.core.eventbus.Message;
import xyz.jetdrone.vertx.lambda.aws.Lambda;

import java.util.Random;

/**
 * A simple QOTD Lambda
 */
public class QOTDLambda implements Lambda<Buffer> {

  private static final Random RANDOM = new Random();

  private static final String[] QUOTES = {
    "If you find a random command on the internet, try running it as root. What's the worse that could happen?",
    "Can root create a process that even root can't kill?",
    "There's no place like ~",
    "Thou shalt not kill -9.",
    "The 'n' in unmount is missing, leaving it as umount! If you find it, please write to Bell Labs, 600 Mountain Avenue Murray Hill, NJ.",
    "echo \"Just another useless use of cat.\" | cat",
    "`echo \"Just another useless use of backticks.\"`",
    "We've just created a special character device for handling complaints, conveniently located at /dev/null.",
    "false - do nothing, unsuccessfully"
  };

  @Override
  public void handle(Message<Buffer> msg) {
    // return a random qotd
    msg.reply(Buffer.buffer(QUOTES[RANDOM.nextInt(QUOTES.length)]));
  }
}
