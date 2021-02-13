
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class S3Object {

  public S3Object() {}

  public S3Object(JsonObject json) {
    S3ObjectConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    S3ObjectConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String eTag;
  /**
   * (Required)
   */
  private String key;
  /**
   * (Required)
   */
  private String sequencer;
  /**
   * (Required)
   */
  private Integer size;
  /**
   * (Required)
   */
  private String urlDecodedKey;
  /**
   * (Required)
   */
  private String versionId;

  /**
   * (Required)
   */
  public String geteTag() {
    return eTag;
  }

  /**
   * (Required)
   */
  public S3Object seteTag(String eTag) {
    this.eTag = eTag;
    return this;
  }

  /**
   * (Required)
   */
  public String getKey() {
    return key;
  }

  /**
   * (Required)
   */
  public S3Object setKey(String key) {
    this.key = key;
    return this;
  }

  /**
   * (Required)
   */
  public String getSequencer() {
    return sequencer;
  }

  /**
   * (Required)
   */
  public S3Object setSequencer(String sequencer) {
    this.sequencer = sequencer;
    return this;
  }

  /**
   * (Required)
   */
  public Integer getSize() {
    return size;
  }

  /**
   * (Required)
   */
  public S3Object setSize(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * (Required)
   */
  public String getUrlDecodedKey() {
    return urlDecodedKey;
  }

  /**
   * (Required)
   */
  public S3Object setUrlDecodedKey(String urlDecodedKey) {
    this.urlDecodedKey = urlDecodedKey;
    return this;
  }

  /**
   * (Required)
   */
  public String getVersionId() {
    return versionId;
  }

  /**
   * (Required)
   */
  public S3Object setVersionId(String versionId) {
    this.versionId = versionId;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
