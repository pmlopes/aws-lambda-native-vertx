
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class SimpleEmailRecord {

  public SimpleEmailRecord() {}

  public SimpleEmailRecord(JsonObject json) {
    SimpleEmailRecordConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    SimpleEmailRecordConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String eventSource;
  /**
   * (Required)
   */
  private String eventVersion;
  /**
   * (Required)
   */
  private SimpleEmailService ses;

  /**
   * (Required)
   */
  public String getEventSource() {
    return eventSource;
  }

  /**
   * (Required)
   */
  public SimpleEmailRecord setEventSource(String eventSource) {
    this.eventSource = eventSource;
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
  public SimpleEmailRecord setEventVersion(String eventVersion) {
    this.eventVersion = eventVersion;
    return this;
  }

  /**
   * (Required)
   */
  public SimpleEmailService getSes() {
    return ses;
  }

  /**
   * (Required)
   */
  public SimpleEmailRecord setSes(SimpleEmailService ses) {
    this.ses = ses;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
