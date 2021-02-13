
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class S3Entity {

  public S3Entity() {}

  public S3Entity(JsonObject json) {
    S3EntityConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    S3EntityConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private S3Bucket bucket;
  /**
   * (Required)
   */
  private String configurationId;
  /**
   * (Required)
   */
  private S3Object object;
  /**
   * (Required)
   */
  private String s3SchemaVersion;

  /**
   * (Required)
   */
  public S3Bucket getBucket() {
    return bucket;
  }

  /**
   * (Required)
   */
  public S3Entity setBucket(S3Bucket bucket) {
    this.bucket = bucket;
    return this;
  }

  /**
   * (Required)
   */
  public String getConfigurationId() {
    return configurationId;
  }

  /**
   * (Required)
   */
  public S3Entity setConfigurationId(String configurationId) {
    this.configurationId = configurationId;
    return this;
  }

  /**
   * (Required)
   */
  public S3Object getObject() {
    return object;
  }

  /**
   * (Required)
   */
  public S3Entity setObject(S3Object object) {
    this.object = object;
    return this;
  }

  /**
   * (Required)
   */
  public String getS3SchemaVersion() {
    return s3SchemaVersion;
  }

  /**
   * (Required)
   */
  public S3Entity setS3SchemaVersion(String s3SchemaVersion) {
    this.s3SchemaVersion = s3SchemaVersion;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
