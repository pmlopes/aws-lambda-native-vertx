
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Date;

@DataObject(generateConverter = true)
public class S3EventRecord {

  public S3EventRecord() {}

  public S3EventRecord(JsonObject json) {
    S3EventRecordConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    S3EventRecordConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String awsRegion;
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
  private Date eventTime;
  /**
   * (Required)
   */
  private String eventVersion;
  /**
   * (Required)
   */
  private S3RequestParameters requestParameters;
  /**
   * (Required)
   */
  private JsonObject responseElements;
  /**
   * (Required)
   */
  private S3Entity s3;
  /**
   * (Required)
   */
  private S3UserIdentity userIdentity;

  /**
   * (Required)
   */
  public String getAwsRegion() {
    return awsRegion;
  }

  /**
   * (Required)
   */
  public S3EventRecord setAwsRegion(String awsRegion) {
    this.awsRegion = awsRegion;
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
  public S3EventRecord setEventName(String eventName) {
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
  public S3EventRecord setEventSource(String eventSource) {
    this.eventSource = eventSource;
    return this;
  }

  /**
   * (Required)
   */
  public Date getEventTime() {
    return eventTime;
  }

  /**
   * (Required)
   */
  public S3EventRecord setEventTime(Date eventTime) {
    this.eventTime = eventTime;
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
  public S3EventRecord setEventVersion(String eventVersion) {
    this.eventVersion = eventVersion;
    return this;
  }

  /**
   * (Required)
   */
  public S3RequestParameters getRequestParameters() {
    return requestParameters;
  }

  /**
   * (Required)
   */
  public S3EventRecord setRequestParameters(S3RequestParameters requestParameters) {
    this.requestParameters = requestParameters;
    return this;
  }

  /**
   * (Required)
   */
  public JsonObject getResponseElements() {
    return responseElements;
  }

  /**
   * (Required)
   */
  public S3EventRecord setResponseElements(JsonObject responseElements) {
    this.responseElements = responseElements;
    return this;
  }

  /**
   * (Required)
   */
  public S3Entity getS3() {
    return s3;
  }

  /**
   * (Required)
   */
  public S3EventRecord setS3(S3Entity s3) {
    this.s3 = s3;
    return this;
  }

  /**
   * (Required)
   */
  public S3UserIdentity getUserIdentity() {
    return userIdentity;
  }

  /**
   * (Required)
   */
  public S3EventRecord setUserIdentity(S3UserIdentity userIdentity) {
    this.userIdentity = userIdentity;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
