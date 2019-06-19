
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

@DataObject(generateConverter = true)
public class SimpleEmailEvent {

  public SimpleEmailEvent() {}

  public SimpleEmailEvent(JsonObject json) {
    SimpleEmailEventConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    SimpleEmailEventConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private List<SimpleEmailRecord> records = new ArrayList<SimpleEmailRecord>();

  /**
   * (Required)
   */
  public List<SimpleEmailRecord> getRecords() {
    return records;
  }

  /**
   * (Required)
   */
  public SimpleEmailEvent setRecords(List<SimpleEmailRecord> records) {
    this.records = records;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
