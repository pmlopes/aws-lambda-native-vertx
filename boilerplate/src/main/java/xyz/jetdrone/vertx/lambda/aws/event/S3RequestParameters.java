
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class S3RequestParameters {

  public S3RequestParameters() {}

  public S3RequestParameters(JsonObject json) {
    S3RequestParametersConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    S3RequestParametersConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String sourceIPAddress;

  /**
   * (Required)
   */
  public String getSourceIPAddress() {
    return sourceIPAddress;
  }

  /**
   * (Required)
   */
  public S3RequestParameters setSourceIPAddress(String sourceIPAddress) {
    this.sourceIPAddress = sourceIPAddress;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
