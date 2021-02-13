
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class APIGatewayProxyResponse {

  public APIGatewayProxyResponse() {}

  public APIGatewayProxyResponse(JsonObject json) {
    APIGatewayProxyResponseConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    APIGatewayProxyResponseConverter.toJson(this, json);
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
  private Boolean isBase64Encoded;
  /**
   * (Required)
   */
  private Integer statusCode;

  /**
   * (Required)
   */
  public String getBody() {
    return body;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyResponse setBody(String body) {
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
  public APIGatewayProxyResponse setHeaders(JsonObject headers) {
    this.headers = headers;
    return this;
  }

  public Boolean getIsBase64Encoded() {
    return isBase64Encoded;
  }

  public APIGatewayProxyResponse setIsBase64Encoded(Boolean isBase64Encoded) {
    this.isBase64Encoded = isBase64Encoded;
    return this;
  }

  /**
   * (Required)
   */
  public Integer getStatusCode() {
    return statusCode;
  }

  /**
   * (Required)
   */
  public APIGatewayProxyResponse setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
