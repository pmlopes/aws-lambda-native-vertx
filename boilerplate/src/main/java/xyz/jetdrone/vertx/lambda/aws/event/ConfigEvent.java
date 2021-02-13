
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class ConfigEvent {

  public ConfigEvent() {}

  public ConfigEvent(JsonObject json) {
    ConfigEventConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    ConfigEventConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String accountId;
  /**
   * (Required)
   */
  private String configRuleArn;
  /**
   * (Required)
   */
  private String configRuleId;
  /**
   * (Required)
   */
  private String configRuleName;
  /**
   * (Required)
   */
  private Boolean eventLeftScope;
  /**
   * (Required)
   */
  private String executionRoleArn;
  /**
   * (Required)
   */
  private String invokingEvent;
  /**
   * (Required)
   */
  private String resultToken;
  /**
   * (Required)
   */
  private String ruleParameters;
  /**
   * (Required)
   */
  private String version;

  /**
   * (Required)
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * (Required)
   */
  public ConfigEvent setAccountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * (Required)
   */
  public String getConfigRuleArn() {
    return configRuleArn;
  }

  /**
   * (Required)
   */
  public ConfigEvent setConfigRuleArn(String configRuleArn) {
    this.configRuleArn = configRuleArn;
    return this;
  }

  /**
   * (Required)
   */
  public String getConfigRuleId() {
    return configRuleId;
  }

  /**
   * (Required)
   */
  public ConfigEvent setConfigRuleId(String configRuleId) {
    this.configRuleId = configRuleId;
    return this;
  }

  /**
   * (Required)
   */
  public String getConfigRuleName() {
    return configRuleName;
  }

  /**
   * (Required)
   */
  public ConfigEvent setConfigRuleName(String configRuleName) {
    this.configRuleName = configRuleName;
    return this;
  }

  /**
   * (Required)
   */
  public Boolean getEventLeftScope() {
    return eventLeftScope;
  }

  /**
   * (Required)
   */
  public ConfigEvent setEventLeftScope(Boolean eventLeftScope) {
    this.eventLeftScope = eventLeftScope;
    return this;
  }

  /**
   * (Required)
   */
  public String getExecutionRoleArn() {
    return executionRoleArn;
  }

  /**
   * (Required)
   */
  public ConfigEvent setExecutionRoleArn(String executionRoleArn) {
    this.executionRoleArn = executionRoleArn;
    return this;
  }

  /**
   * (Required)
   */
  public String getInvokingEvent() {
    return invokingEvent;
  }

  /**
   * (Required)
   */
  public ConfigEvent setInvokingEvent(String invokingEvent) {
    this.invokingEvent = invokingEvent;
    return this;
  }

  /**
   * (Required)
   */
  public String getResultToken() {
    return resultToken;
  }

  /**
   * (Required)
   */
  public ConfigEvent setResultToken(String resultToken) {
    this.resultToken = resultToken;
    return this;
  }

  /**
   * (Required)
   */
  public String getRuleParameters() {
    return ruleParameters;
  }

  /**
   * (Required)
   */
  public ConfigEvent setRuleParameters(String ruleParameters) {
    this.ruleParameters = ruleParameters;
    return this;
  }

  /**
   * (Required)
   */
  public String getVersion() {
    return version;
  }

  /**
   * (Required)
   */
  public ConfigEvent setVersion(String version) {
    this.version = version;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
