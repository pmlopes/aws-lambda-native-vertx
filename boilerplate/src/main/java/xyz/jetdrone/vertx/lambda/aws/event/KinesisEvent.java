
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

@DataObject(generateConverter = true)
public class KinesisEvent {

  public KinesisEvent() {}

  public KinesisEvent(JsonObject json) {
    KinesisEventConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    KinesisEventConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private List<KinesisEventRecord> records = new ArrayList<KinesisEventRecord>();

  /**
   * (Required)
   */
  public List<KinesisEventRecord> getRecords() {
    return records;
  }

  /**
   * (Required)
   */
  public KinesisEvent setRecords(List<KinesisEventRecord> records) {
    this.records = records;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
