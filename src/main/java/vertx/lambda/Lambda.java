package vertx.lambda;

import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;

public interface Lambda {

  Future<Buffer> call(Buffer request);
}
