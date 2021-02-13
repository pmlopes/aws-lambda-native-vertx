
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

@DataObject(generateConverter = true)
public class KinesisFirehoseEvent {

  public KinesisFirehoseEvent() {}

  public KinesisFirehoseEvent(JsonObject json) {
    KinesisFirehoseEventConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    KinesisFirehoseEventConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String deliveryStreamArn;
  /**
   * (Required)
   */
  private String invocationId;
  /**
   * (Required)
   */
  private List<KinesisFirehoseEventRecord> records = new ArrayList<KinesisFirehoseEventRecord>();
  /**
   * (Required)
   */
  private String region;

  /**
   * (Required)
   */
  public String getDeliveryStreamArn() {
    return deliveryStreamArn;
  }

  /**
   * (Required)
   */
  public KinesisFirehoseEvent setDeliveryStreamArn(String deliveryStreamArn) {
    this.deliveryStreamArn = deliveryStreamArn;
    return this;
  }

  /**
   * (Required)
   */
  public String getInvocationId() {
    return invocationId;
  }

  /**
   * (Required)
   */
  public KinesisFirehoseEvent setInvocationId(String invocationId) {
    this.invocationId = invocationId;
    return this;
  }

  /**
   * (Required)
   */
  public List<KinesisFirehoseEventRecord> getRecords() {
    return records;
  }

  /**
   * (Required)
   */
  public KinesisFirehoseEvent setRecords(List<KinesisFirehoseEventRecord> records) {
    this.records = records;
    return this;
  }

  /**
   * (Required)
   */
  public String getRegion() {
    return region;
  }

  /**
   * (Required)
   */
  public KinesisFirehoseEvent setRegion(String region) {
    this.region = region;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
