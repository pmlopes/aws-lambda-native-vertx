package lambda;

import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;
import vertx.lambda.Lambda;

public class MyLambda implements Lambda {

  @Override
  public Future<Buffer> call(Buffer request) {
    return Future.succeededFuture(request.appendBuffer(Buffer.buffer("!")));
  }
}
