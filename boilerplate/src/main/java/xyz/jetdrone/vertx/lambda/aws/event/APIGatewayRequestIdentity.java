
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class APIGatewayRequestIdentity {

  public APIGatewayRequestIdentity() {}

  public APIGatewayRequestIdentity(JsonObject json) {
    APIGatewayRequestIdentityConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    APIGatewayRequestIdentityConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String accountId;
  /**
   * (Required)
   */
  private String apiKey;
  /**
   * (Required)
   */
  private String caller;
  /**
   * (Required)
   */
  private String cognitoAuthenticationProvider;
  /**
   * (Required)
   */
  private String cognitoAuthenticationType;
  /**
   * (Required)
   */
  private String cognitoIdentityId;
  /**
   * (Required)
   */
  private String cognitoIdentityPoolId;
  /**
   * (Required)
   */
  private String sourceIp;
  /**
   * (Required)
   */
  private String user;
  /**
   * (Required)
   */
  private String userAgent;
  /**
   * (Required)
   */
  private String userArn;

  /**
   * (Required)
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * (Required)
   */
  public APIGatewayRequestIdentity setAccountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * (Required)
   */
  public String getApiKey() {
    return apiKey;
  }

  /**
   * (Required)
   */
  public APIGatewayRequestIdentity setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }

  /**
   * (Required)
   */
  public String getCaller() {
    return caller;
  }

  /**
   * (Required)
   */
  public APIGatewayRequestIdentity setCaller(String caller) {
    this.caller = caller;
    return this;
  }

  /**
   * (Required)
   */
  public String getCognitoAuthenticationProvider() {
    return cognitoAuthenticationProvider;
  }

  /**
   * (Required)
   */
  public APIGatewayRequestIdentity setCognitoAuthenticationProvider(String cognitoAuthenticationProvider) {
    this.cognitoAuthenticationProvider = cognitoAuthenticationProvider;
    return this;
  }

  /**
   * (Required)
   */
  public String getCognitoAuthenticationType() {
    return cognitoAuthenticationType;
  }

  /**
   * (Required)
   */
  public APIGatewayRequestIdentity setCognitoAuthenticationType(String cognitoAuthenticationType) {
    this.cognitoAuthenticationType = cognitoAuthenticationType;
    return this;
  }

  /**
   * (Required)
   */
  public String getCognitoIdentityId() {
    return cognitoIdentityId;
  }

  /**
   * (Required)
   */
  public APIGatewayRequestIdentity setCognitoIdentityId(String cognitoIdentityId) {
    this.cognitoIdentityId = cognitoIdentityId;
    return this;
  }

  /**
   * (Required)
   */
  public String getCognitoIdentityPoolId() {
    return cognitoIdentityPoolId;
  }

  /**
   * (Required)
   */
  public APIGatewayRequestIdentity setCognitoIdentityPoolId(String cognitoIdentityPoolId) {
    this.cognitoIdentityPoolId = cognitoIdentityPoolId;
    return this;
  }

  /**
   * (Required)
   */
  public String getSourceIp() {
    return sourceIp;
  }

  /**
   * (Required)
   */
  public APIGatewayRequestIdentity setSourceIp(String sourceIp) {
    this.sourceIp = sourceIp;
    return this;
  }

  /**
   * (Required)
   */
  public String getUser() {
    return user;
  }

  /**
   * (Required)
   */
  public APIGatewayRequestIdentity setUser(String user) {
    this.user = user;
    return this;
  }

  /**
   * (Required)
   */
  public String getUserAgent() {
    return userAgent;
  }

  /**
   * (Required)
   */
  public APIGatewayRequestIdentity setUserAgent(String userAgent) {
    this.userAgent = userAgent;
    return this;
  }

  /**
   * (Required)
   */
  public String getUserArn() {
    return userArn;
  }

  /**
   * (Required)
   */
  public APIGatewayRequestIdentity setUserArn(String userArn) {
    this.userArn = userArn;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
