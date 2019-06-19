
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class KinesisFirehoseEventRecord {

  public KinesisFirehoseEventRecord() {}

  public KinesisFirehoseEventRecord(JsonObject json) {
    KinesisFirehoseEventRecordConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    KinesisFirehoseEventRecordConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private MilliSecondsEpochTime approximateArrivalTimestamp;
  /**
   * (Required)
   */
  private Buffer data;
  /**
   * (Required)
   */
  private String recordId;

  /**
   * (Required)
   */
  public MilliSecondsEpochTime getApproximateArrivalTimestamp() {
    return approximateArrivalTimestamp;
  }

  /**
   * (Required)
   */
  public KinesisFirehoseEventRecord setApproximateArrivalTimestamp(MilliSecondsEpochTime approximateArrivalTimestamp) {
    this.approximateArrivalTimestamp = approximateArrivalTimestamp;
    return this;
  }

  /**
   * (Required)
   */
  public Buffer getData() {
    return data;
  }

  /**
   * (Required)
   */
  public KinesisFirehoseEventRecord setData(Buffer data) {
    this.data = data;
    return this;
  }

  /**
   * (Required)
   */
  public String getRecordId() {
    return recordId;
  }

  /**
   * (Required)
   */
  public KinesisFirehoseEventRecord setRecordId(String recordId) {
    this.recordId = recordId;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
