
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class APIGatewayProxyRequest {

  public APIGatewayProxyRequest() {}

  public APIGatewayProxyRequest(JsonObject json) {
    APIGatewayProxyRequestConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    APIGatewayProxyRequestConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String body;
  /**
   * (Required)
   */
  private JsonObject headers;
  /**
   * (Required)
   */
  private String httpMethod;
  private Boolean isBase64Encoded;
  /**
   * (Required)
   */
  private String path;
  /**
   * (Required)
   */
  private JsonObject pathParameters;
  /**
   * (Required)
   */
  private JsonObject queryStringParameters;
  /**
   * (Required)
   */
  private APIGatewayProxyRequestContext requestContext;
  /**
   * (Required)
   */
  private String resource;
  /**
   * (Required)
   */
  private JsonObject stageVariables;

  /**
   * (Required)
   */
  public String getBody() {
    return body;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequest setBody(String body) {
    this.body = body;
    return this;
  }

  /**
   * (Required)
   */
  public JsonObject getHeaders() {
    return headers;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequest setHeaders(JsonObject headers) {
    this.headers = headers;
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
  public APIGatewayProxyRequest setHttpMethod(String httpMethod) {
    this.httpMethod = httpMethod;
    return this;
  }

  public Boolean getIsBase64Encoded() {
    return isBase64Encoded;
  }

  public APIGatewayProxyRequest setIsBase64Encoded(Boolean isBase64Encoded) {
    this.isBase64Encoded = isBase64Encoded;
    return this;
  }

  /**
   * (Required)
   */
  public String getPath() {
    return path;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequest setPath(String path) {
    this.path = path;
    return this;
  }

  /**
   * (Required)
   */
  public JsonObject getPathParameters() {
    return pathParameters;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequest setPathParameters(JsonObject pathParameters) {
    this.pathParameters = pathParameters;
    return this;
  }

  /**
   * (Required)
   */
  public JsonObject getQueryStringParameters() {
    return queryStringParameters;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequest setQueryStringParameters(JsonObject queryStringParameters) {
    this.queryStringParameters = queryStringParameters;
    return this;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequestContext getRequestContext() {
    return requestContext;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequest setRequestContext(APIGatewayProxyRequestContext requestContext) {
    this.requestContext = requestContext;
    return this;
  }

  /**
   * (Required)
   */
  public String getResource() {
    return resource;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequest setResource(String resource) {
    this.resource = resource;
    return this;
  }

  /**
   * (Required)
   */
  public JsonObject getStageVariables() {
    return stageVariables;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyRequest setStageVariables(JsonObject stageVariables) {
    this.stageVariables = stageVariables;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
