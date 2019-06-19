
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class SecondsEpochTime {

  public SecondsEpochTime() {}

  public SecondsEpochTime(JsonObject json) {
    SecondsEpochTimeConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    SecondsEpochTimeConverter.toJson(this, json);
    return json;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
