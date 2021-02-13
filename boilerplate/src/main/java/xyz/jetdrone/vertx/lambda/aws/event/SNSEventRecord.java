
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class SNSEventRecord {

  public SNSEventRecord() {}

  public SNSEventRecord(JsonObject json) {
    SNSEventRecordConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    SNSEventRecordConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String eventSource;
  /**
   * (Required)
   */
  private String eventSubscriptionArn;
  /**
   * (Required)
   */
  private String eventVersion;
  /**
   * (Required)
   */
  private SNSEntity sns;

  /**
   * (Required)
   */
  public String getEventSource() {
    return eventSource;
  }

  /**
   * (Required)
   */
  public SNSEventRecord setEventSource(String eventSource) {
    this.eventSource = eventSource;
    return this;
  }

  /**
   * (Required)
   */
  public String getEventSubscriptionArn() {
    return eventSubscriptionArn;
  }

  /**
   * (Required)
   */
  public SNSEventRecord setEventSubscriptionArn(String eventSubscriptionArn) {
    this.eventSubscriptionArn = eventSubscriptionArn;
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
  public SNSEventRecord setEventVersion(String eventVersion) {
    this.eventVersion = eventVersion;
    return this;
  }

  /**
   * (Required)
   */
  public SNSEntity getSns() {
    return sns;
  }

  /**
   * (Required)
   */
  public SNSEventRecord setSns(SNSEntity sns) {
    this.sns = sns;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
