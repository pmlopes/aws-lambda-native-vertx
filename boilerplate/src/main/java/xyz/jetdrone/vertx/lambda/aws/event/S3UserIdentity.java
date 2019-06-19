
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class S3UserIdentity {

  public S3UserIdentity() {}

  public S3UserIdentity(JsonObject json) {
    S3UserIdentityConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    S3UserIdentityConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String principalId;

  /**
   * (Required)
   */
  public String getPrincipalId() {
    return principalId;
  }

  /**
   * (Required)
   */
  public S3UserIdentity setPrincipalId(String principalId) {
    this.principalId = principalId;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
