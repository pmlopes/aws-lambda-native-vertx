
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class S3Bucket {

  public S3Bucket() {}

  public S3Bucket(JsonObject json) {
    S3BucketConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    S3BucketConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String arn;
  /**
   * (Required)
   */
  private String name;
  /**
   * (Required)
   */
  private S3UserIdentity ownerIdentity;

  /**
   * (Required)
   */
  public String getArn() {
    return arn;
  }

  /**
   * (Required)
   */
  public S3Bucket setArn(String arn) {
    this.arn = arn;
    return this;
  }

  /**
   * (Required)
   */
  public String getName() {
    return name;
  }

  /**
   * (Required)
   */
  public S3Bucket setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * (Required)
   */
  public S3UserIdentity getOwnerIdentity() {
    return ownerIdentity;
  }

  /**
   * (Required)
   */
  public S3Bucket setOwnerIdentity(S3UserIdentity ownerIdentity) {
    this.ownerIdentity = ownerIdentity;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
