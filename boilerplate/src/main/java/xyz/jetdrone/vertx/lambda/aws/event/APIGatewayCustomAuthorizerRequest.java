
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class APIGatewayCustomAuthorizerRequest {

  public APIGatewayCustomAuthorizerRequest() {}

  public APIGatewayCustomAuthorizerRequest(JsonObject json) {
    APIGatewayCustomAuthorizerRequestConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    APIGatewayCustomAuthorizerRequestConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String authorizationToken;
  /**
   * (Required)
   */
  private String methodArn;
  /**
   * (Required)
   */
  private String type;

  /**
   * (Required)
   */
  public String getAuthorizationToken() {
    return authorizationToken;
  }

  /**
   * (Required)
   */
  public APIGatewayCustomAuthorizerRequest setAuthorizationToken(String authorizationToken) {
    this.authorizationToken = authorizationToken;
    return this;
  }

  /**
   * (Required)
   */
  public String getMethodArn() {
    return methodArn;
  }

  /**
   * (Required)
   */
  public APIGatewayCustomAuthorizerRequest setMethodArn(String methodArn) {
    this.methodArn = methodArn;
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
  public APIGatewayCustomAuthorizerRequest setType(String type) {
    this.type = type;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
