
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class KinesisEventRecord {

  public KinesisEventRecord() {}

  public KinesisEventRecord(JsonObject json) {
    KinesisEventRecordConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    KinesisEventRecordConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String awsRegion;
  /**
   * (Required)
   */
  private String eventID;
  /**
   * (Required)
   */
  private String eventName;
  /**
   * (Required)
   */
  private String eventSource;
  /**
   * (Required)
   */
  private String eventSourceARN;
  /**
   * (Required)
   */
  private String eventVersion;
  /**
   * (Required)
   */
  private String invokeIdentityArn;
  /**
   * (Required)
   */
  private KinesisRecord kinesis;

  /**
   * (Required)
   */
  public String getAwsRegion() {
    return awsRegion;
  }

  /**
   * (Required)
   */
  public KinesisEventRecord setAwsRegion(String awsRegion) {
    this.awsRegion = awsRegion;
    return this;
  }

  /**
   * (Required)
   */
  public String getEventID() {
    return eventID;
  }

  /**
   * (Required)
   */
  public KinesisEventRecord setEventID(String eventID) {
    this.eventID = eventID;
    return this;
  }

  /**
   * (Required)
   */
  public String getEventName() {
    return eventName;
  }

  /**
   * (Required)
   */
  public KinesisEventRecord setEventName(String eventName) {
    this.eventName = eventName;
    return this;
  }

  /**
   * (Required)
   */
  public String getEventSource() {
    return eventSource;
  }

  /**
   * (Required)
   */
  public KinesisEventRecord setEventSource(String eventSource) {
    this.eventSource = eventSource;
    return this;
  }

  /**
   * (Required)
   */
  public String getEventSourceARN() {
    return eventSourceARN;
  }

  /**
   * (Required)
   */
  public KinesisEventRecord setEventSourceARN(String eventSourceARN) {
    this.eventSourceARN = eventSourceARN;
    return this;
  }

  /**
   * (Required)
   */
  public String getEventVersion() {
    return eventVersion;
  }

  /**
   * (Required)
   */
  public KinesisEventRecord setEventVersion(String eventVersion) {
    this.eventVersion = eventVersion;
    return this;
  }

  /**
   * (Required)
   */
  public String getInvokeIdentityArn() {
    return invokeIdentityArn;
  }

  /**
   * (Required)
   */
  public KinesisEventRecord setInvokeIdentityArn(String invokeIdentityArn) {
    this.invokeIdentityArn = invokeIdentityArn;
    return this;
  }

  /**
   * (Required)
   */
  public KinesisRecord getKinesis() {
    return kinesis;
  }

  /**
   * (Required)
   */
  public KinesisEventRecord setKinesis(KinesisRecord kinesis) {
    this.kinesis = kinesis;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
