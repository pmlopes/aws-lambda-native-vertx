
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class APIGatewayProxyRequestContext {

  public APIGatewayProxyRequestContext() {}

  public APIGatewayProxyRequestContext(JsonObject json) {
    APIGatewayProxyRequestContextConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    APIGatewayProxyRequestContextConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String accountId;
  /**
   * (Required)
   */
  private String apiId;
  /**
   * (Required)
   */
  private JsonObject authorizer;
  /**
   * (Required)
   */
  private String httpMethod;
  /**
   * (Required)
   */
  private APIGatewayRequestIdentity identity;
  /**
   * (Required)
   */
  private String requestId;
  /**
   * (Required)
   */
  private String resourceId;
  /**
   * (Required)
   */
  private String resourcePath;
  /**
   * (Required)
   */
  private String stage;

  /**
   * (Required)
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequestContext setAccountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * (Required)
   */
  public String getApiId() {
    return apiId;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequestContext setApiId(String apiId) {
    this.apiId = apiId;
    return this;
  }

  /**
   * (Required)
   */
  public JsonObject getAuthorizer() {
    return authorizer;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequestContext setAuthorizer(JsonObject authorizer) {
    this.authorizer = authorizer;
    return this;
  }

  /**
   * (Required)
   */
  public String getHttpMethod() {
    return httpMethod;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequestContext setHttpMethod(String httpMethod) {
    this.httpMethod = httpMethod;
    return this;
  }

  /**
   * (Required)
   */
  public APIGatewayRequestIdentity getIdentity() {
    return identity;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequestContext setIdentity(APIGatewayRequestIdentity identity) {
    this.identity = identity;
    return this;
  }

  /**
   * (Required)
   */
  public String getRequestId() {
    return requestId;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequestContext setRequestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

  /**
   * (Required)
   */
  public String getResourceId() {
    return resourceId;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequestContext setResourceId(String resourceId) {
    this.resourceId = resourceId;
    return this;
  }

  /**
   * (Required)
   */
  public String getResourcePath() {
    return resourcePath;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequestContext setResourcePath(String resourcePath) {
    this.resourcePath = resourcePath;
    return this;
  }

  /**
   * (Required)
   */
  public String getStage() {
    return stage;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequestContext setStage(String stage) {
    this.stage = stage;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
