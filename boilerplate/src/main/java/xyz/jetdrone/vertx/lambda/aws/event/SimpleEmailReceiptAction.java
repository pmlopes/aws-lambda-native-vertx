
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class SimpleEmailReceiptAction {

  public SimpleEmailReceiptAction() {}

  public SimpleEmailReceiptAction(JsonObject json) {
    SimpleEmailReceiptActionConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    SimpleEmailReceiptActionConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String functionArn;
  /**
   * (Required)
   */
  private String invocationType;
  /**
   * (Required)
   */
  private String type;

  /**
   * (Required)
   */
  public String getFunctionArn() {
    return functionArn;
  }

  /**
   * (Required)
   */
  public SimpleEmailReceiptAction setFunctionArn(String functionArn) {
    this.functionArn = functionArn;
    return this;
  }

  /**
   * (Required)
   */
  public String getInvocationType() {
    return invocationType;
  }

  /**
   * (Required)
   */
  public SimpleEmailReceiptAction setInvocationType(String invocationType) {
    this.invocationType = invocationType;
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
  public SimpleEmailReceiptAction setType(String type) {
    this.type = type;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
