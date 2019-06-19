
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@DataObject(generateConverter = true)
public class CloudWatchEvent {

  public CloudWatchEvent() {}

  public CloudWatchEvent(JsonObject json) {
    CloudWatchEventConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    CloudWatchEventConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String account;
  /**
   * (Required)
   */
  private List<Integer> detail = new ArrayList<Integer>();
  /**
   * (Required)
   */
  private String detailType;
  /**
   * (Required)
   */
  private String id;
  /**
   * (Required)
   */
  private String region;
  /**
   * (Required)
   */
  private List<String> resources = new ArrayList<String>();
  /**
   * (Required)
   */
  private String source;
  /**
   * (Required)
   */
  private Date time;
  /**
   * (Required)
   */
  private String version;

  /**
   * (Required)
   */
  public String getAccount() {
    return account;
  }

  /**
   * (Required)
   */
  public CloudWatchEvent setAccount(String account) {
    this.account = account;
    return this;
  }

  /**
   * (Required)
   */
  public List<Integer> getDetail() {
    return detail;
  }

  /**
   * (Required)
   */
  public CloudWatchEvent setDetail(List<Integer> detail) {
    this.detail = detail;
    return this;
  }

  /**
   * (Required)
   */
  public String getDetailType() {
    return detailType;
  }

  /**
   * (Required)
   */
  public CloudWatchEvent setDetailType(String detailType) {
    this.detailType = detailType;
    return this;
  }

  /**
   * (Required)
   */
  public String getId() {
    return id;
  }

  /**
   * (Required)
   */
  public CloudWatchEvent setId(String id) {
    this.id = id;
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
  public CloudWatchEvent setRegion(String region) {
    this.region = region;
    return this;
  }

  /**
   * (Required)
   */
  public List<String> getResources() {
    return resources;
  }

  /**
   * (Required)
   */
  public CloudWatchEvent setResources(List<String> resources) {
    this.resources = resources;
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
  public CloudWatchEvent setSource(String source) {
    this.source = source;
    return this;
  }

  /**
   * (Required)
   */
  public Date getTime() {
    return time;
  }

  /**
   * (Required)
   */
  public CloudWatchEvent setTime(Date time) {
    this.time = time;
    return this;
  }

  /**
   * (Required)
   */
  public String getVersion() {
    return version;
  }

  /**
   * (Required)
   */
  public CloudWatchEvent setVersion(String version) {
    this.version = version;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
