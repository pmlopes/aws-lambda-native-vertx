
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

@DataObject(generateConverter = true)
public class S3Event {

  public S3Event() {}

  public S3Event(JsonObject json) {
    S3EventConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    S3EventConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private List<S3EventRecord> records = new ArrayList<S3EventRecord>();

  /**
   * (Required)
   */
  public List<S3EventRecord> getRecords() {
    return records;
  }

  /**
   * (Required)
   */
  public S3Event setRecords(List<S3EventRecord> records) {
    this.records = records;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
