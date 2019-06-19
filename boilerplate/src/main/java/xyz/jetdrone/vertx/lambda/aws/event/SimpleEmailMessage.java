
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@DataObject(generateConverter = true)
public class SimpleEmailMessage {

  public SimpleEmailMessage() {}

  public SimpleEmailMessage(JsonObject json) {
    SimpleEmailMessageConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    SimpleEmailMessageConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private SimpleEmailCommonHeaders commonHeaders;
  /**
   * (Required)
   */
  private List<String> destination = new ArrayList<String>();
  /**
   * (Required)
   */
  private List<SimpleEmailHeader> headers = new ArrayList<SimpleEmailHeader>();
  /**
   * (Required)
   */
  private Boolean headersTruncated;
  /**
   * (Required)
   */
  private String messageId;
  /**
   * (Required)
   */
  private String source;
  /**
   * (Required)
   */
  private Date timestamp;

  /**
   * (Required)
   */
  public SimpleEmailCommonHeaders getCommonHeaders() {
    return commonHeaders;
  }

  /**
   * (Required)
   */
  public SimpleEmailMessage setCommonHeaders(SimpleEmailCommonHeaders commonHeaders) {
    this.commonHeaders = commonHeaders;
    return this;
  }

  /**
   * (Required)
   */
  public List<String> getDestination() {
    return destination;
  }

  /**
   * (Required)
   */
  public SimpleEmailMessage setDestination(List<String> destination) {
    this.destination = destination;
    return this;
  }

  /**
   * (Required)
   */
  public List<SimpleEmailHeader> getHeaders() {
    return headers;
  }

  /**
   * (Required)
   */
  public SimpleEmailMessage setHeaders(List<SimpleEmailHeader> headers) {
    this.headers = headers;
    return this;
  }

  /**
   * (Required)
   */
  public Boolean getHeadersTruncated() {
    return headersTruncated;
  }

  /**
   * (Required)
   */
  public SimpleEmailMessage setHeadersTruncated(Boolean headersTruncated) {
    this.headersTruncated = headersTruncated;
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
  public SimpleEmailMessage setMessageId(String messageId) {
    this.messageId = messageId;
    return this;
  }

  /**
   * (Required)
   */
  public String getSource() {
    return source;
  }

  /**
   * (Required)
   */
  public SimpleEmailMessage setSource(String source) {
    this.source = source;
    return this;
  }

  /**
   * (Required)
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * (Required)
   */
  public SimpleEmailMessage setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
