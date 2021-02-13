
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

@DataObject(generateConverter = true)
public class SQSEvent {

  public SQSEvent() {}

  public SQSEvent(JsonObject json) {
    SQSEventConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    SQSEventConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private List<SQSMessage> records = new ArrayList<SQSMessage>();

  /**
   * (Required)
   */
  public List<SQSMessage> getRecords() {
    return records;
  }

  /**
   * (Required)
   */
  public SQSEvent setRecords(List<SQSMessage> records) {
    this.records = records;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
