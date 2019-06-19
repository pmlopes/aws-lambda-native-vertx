
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

@DataObject(generateConverter = true)
public class SimpleEmailCommonHeaders {

  public SimpleEmailCommonHeaders() {}

  public SimpleEmailCommonHeaders(JsonObject json) {
    SimpleEmailCommonHeadersConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    SimpleEmailCommonHeadersConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String date;
  /**
   * (Required)
   */
  private List<String> from = new ArrayList<String>();
  /**
   * (Required)
   */
  private String messageId;
  /**
   * (Required)
   */
  private String returnPath;
  /**
   * (Required)
   */
  private String subject;
  /**
   * (Required)
   */
  private List<String> to = new ArrayList<String>();

  /**
   * (Required)
   */
  public String getDate() {
    return date;
  }

  /**
   * (Required)
   */
  public SimpleEmailCommonHeaders setDate(String date) {
    this.date = date;
    return this;
  }

  /**
   * (Required)
   */
  public List<String> getFrom() {
    return from;
  }

  /**
   * (Required)
   */
  public SimpleEmailCommonHeaders setFrom(List<String> from) {
    this.from = from;
    return this;
  }

  /**
   * (Required)
   */
  public String getMessageId() {
    return messageId;
  }

  /**
   * (Required)
   */
  public SimpleEmailCommonHeaders setMessageId(String messageId) {
    this.messageId = messageId;
    return this;
  }

  /**
   * (Required)
   */
  public String getReturnPath() {
    return returnPath;
  }

  /**
   * (Required)
   */
  public SimpleEmailCommonHeaders setReturnPath(String returnPath) {
    this.returnPath = returnPath;
    return this;
  }

  /**
   * (Required)
   */
  public String getSubject() {
    return subject;
  }

  /**
   * (Required)
   */
  public SimpleEmailCommonHeaders setSubject(String subject) {
    this.subject = subject;
    return this;
  }

  /**
   * (Required)
   */
  public List<String> getTo() {
    return to;
  }

  /**
   * (Required)
   */
  public SimpleEmailCommonHeaders setTo(List<String> to) {
    this.to = to;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
