
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Date;

@DataObject(generateConverter = true)
public class SNSEntity {

  public SNSEntity() {}

  public SNSEntity(JsonObject json) {
    SNSEntityConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    SNSEntityConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String message;
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
  private String signature;
  /**
   * (Required)
   */
  private String signatureVersion;
  /**
   * (Required)
   */
  private String signingCertUrl;
  /**
   * (Required)
   */
  private String subject;
  /**
   * (Required)
   */
  private Date timestamp;
  /**
   * (Required)
   */
  private String topicArn;
  /**
   * (Required)
   */
  private String type;
  /**
   * (Required)
   */
  private String unsubscribeUrl;

  /**
   * (Required)
   */
  public String getMessage() {
    return message;
  }

  /**
   * (Required)
   */
  public SNSEntity setMessage(String message) {
    this.message = message;
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
  public SNSEntity setMessageAttributes(JsonObject messageAttributes) {
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
  public SNSEntity setMessageId(String messageId) {
    this.messageId = messageId;
    return this;
  }

  /**
   * (Required)
   */
  public String getSignature() {
    return signature;
  }

  /**
   * (Required)
   */
  public SNSEntity setSignature(String signature) {
    this.signature = signature;
    return this;
  }

  /**
   * (Required)
   */
  public String getSignatureVersion() {
    return signatureVersion;
  }

  /**
   * (Required)
   */
  public SNSEntity setSignatureVersion(String signatureVersion) {
    this.signatureVersion = signatureVersion;
    return this;
  }

  /**
   * (Required)
   */
  public String getSigningCertUrl() {
    return signingCertUrl;
  }

  /**
   * (Required)
   */
  public SNSEntity setSigningCertUrl(String signingCertUrl) {
    this.signingCertUrl = signingCertUrl;
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
  public SNSEntity setSubject(String subject) {
    this.subject = subject;
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
  public SNSEntity setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * (Required)
   */
  public String getTopicArn() {
    return topicArn;
  }

  /**
   * (Required)
   */
  public SNSEntity setTopicArn(String topicArn) {
    this.topicArn = topicArn;
    return this;
  }

  /**
   * (Required)
   */
  public String getType() {
    return type;
  }

  /**
   * (Required)
   */
  public SNSEntity setType(String type) {
    this.type = type;
    return this;
  }

  /**
   * (Required)
   */
  public String getUnsubscribeUrl() {
    return unsubscribeUrl;
  }

  /**
   * (Required)
   */
  public SNSEntity setUnsubscribeUrl(String unsubscribeUrl) {
    this.unsubscribeUrl = unsubscribeUrl;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
