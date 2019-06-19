
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class SQSMessage {

  public SQSMessage() {}

  public SQSMessage(JsonObject json) {
    SQSMessageConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    SQSMessageConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private JsonObject attributes;
  /**
   * (Required)
   */
  private String awsRegion;
  /**
   * (Required)
   */
  private String body;
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
  private String md5OfBody;
  /**
   * (Required)
   */
  private String md5OfMessageAttributes;
  /**
   * (Required)
   */
  private JsonObject messageAttributes;
  /**
   * (Required)
   */
  private String messageId;
  /**
   * (Required)
   */
  private String receiptHandle;

  /**
   * (Required)
   */
  public JsonObject getAttributes() {
    return attributes;
  }

  /**
   * (Required)
   */
  public SQSMessage setAttributes(JsonObject attributes) {
    this.attributes = attributes;
    return this;
  }

  /**
   * (Required)
   */
  public String getAwsRegion() {
    return awsRegion;
  }

  /**
   * (Required)
   */
  public SQSMessage setAwsRegion(String awsRegion) {
    this.awsRegion = awsRegion;
    return this;
  }

  /**
   * (Required)
   */
  public String getBody() {
    return body;
  }

  /**
   * (Required)
   */
  public SQSMessage setBody(String body) {
    this.body = body;
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
  public SQSMessage setEventSource(String eventSource) {
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
  public SQSMessage setEventSourceARN(String eventSourceARN) {
    this.eventSourceARN = eventSourceARN;
    return this;
  }

  /**
   * (Required)
   */
  public String getMd5OfBody() {
    return md5OfBody;
  }

  /**
   * (Required)
   */
  public SQSMessage setMd5OfBody(String md5OfBody) {
    this.md5OfBody = md5OfBody;
    return this;
  }

  /**
   * (Required)
   */
  public String getMd5OfMessageAttributes() {
    return md5OfMessageAttributes;
  }

  /**
   * (Required)
   */
  public SQSMessage setMd5OfMessageAttributes(String md5OfMessageAttributes) {
    this.md5OfMessageAttributes = md5OfMessageAttributes;
    return this;
  }

  /**
   * (Required)
   */
  public JsonObject getMessageAttributes() {
    return messageAttributes;
  }

  /**
   * (Required)
   */
  public SQSMessage setMessageAttributes(JsonObject messageAttributes) {
    this.messageAttributes = messageAttributes;
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
  public SQSMessage setMessageId(String messageId) {
    this.messageId = messageId;
    return this;
  }

  /**
   * (Required)
   */
  public String getReceiptHandle() {
    return receiptHandle;
  }

  /**
   * (Required)
   */
  public SQSMessage setReceiptHandle(String receiptHandle) {
    this.receiptHandle = receiptHandle;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
