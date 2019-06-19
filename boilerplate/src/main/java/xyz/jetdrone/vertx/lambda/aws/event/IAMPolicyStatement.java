
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

@DataObject(generateConverter = true)
public class IAMPolicyStatement {

  public IAMPolicyStatement() {}

  public IAMPolicyStatement(JsonObject json) {
    IAMPolicyStatementConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    IAMPolicyStatementConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private List<String> action = new ArrayList<String>();
  /**
   * (Required)
   */
  private String effect;
  /**
   * (Required)
   */
  private List<String> resource = new ArrayList<String>();

  /**
   * (Required)
   */
  public List<String> getAction() {
    return action;
  }

  /**
   * (Required)
   */
  public IAMPolicyStatement setAction(List<String> action) {
    this.action = action;
    return this;
  }

  /**
   * (Required)
   */
  public String getEffect() {
    return effect;
  }

  /**
   * (Required)
   */
  public IAMPolicyStatement setEffect(String effect) {
    this.effect = effect;
    return this;
  }

  /**
   * (Required)
   */
  public List<String> getResource() {
    return resource;
  }

  /**
   * (Required)
   */
  public IAMPolicyStatement setResource(List<String> resource) {
    this.resource = resource;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
