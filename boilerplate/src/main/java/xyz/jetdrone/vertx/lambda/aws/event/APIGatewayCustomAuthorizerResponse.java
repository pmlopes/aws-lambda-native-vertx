
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class APIGatewayCustomAuthorizerResponse {

  public APIGatewayCustomAuthorizerResponse() {}

  public APIGatewayCustomAuthorizerResponse(JsonObject json) {
    APIGatewayCustomAuthorizerResponseConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    APIGatewayCustomAuthorizerResponseConverter.toJson(this, json);
    return json;
  }

  private JsonObject context;
  /**
   * (Required)
   */
  private APIGatewayCustomAuthorizerPolicy policyDocument;
  /**
   * (Required)
   */
  private String principalId;
  private String usageIdentifierKey;

  public JsonObject getContext() {
    return context;
  }

  public APIGatewayCustomAuthorizerResponse setContext(JsonObject context) {
    this.context = context;
    return this;
  }

  /**
   * (Required)
   */
  public APIGatewayCustomAuthorizerPolicy getPolicyDocument() {
    return policyDocument;
  }

  /**
   * (Required)
   */
  public APIGatewayCustomAuthorizerResponse setPolicyDocument(APIGatewayCustomAuthorizerPolicy policyDocument) {
    this.policyDocument = policyDocument;
    return this;
  }

  /**
   * (Required)
   */
  public String getPrincipalId() {
    return principalId;
  }

  /**
   * (Required)
   */
  public APIGatewayCustomAuthorizerResponse setPrincipalId(String principalId) {
    this.principalId = principalId;
    return this;
  }

  public String getUsageIdentifierKey() {
    return usageIdentifierKey;
  }

  public APIGatewayCustomAuthorizerResponse setUsageIdentifierKey(String usageIdentifierKey) {
    this.usageIdentifierKey = usageIdentifierKey;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
