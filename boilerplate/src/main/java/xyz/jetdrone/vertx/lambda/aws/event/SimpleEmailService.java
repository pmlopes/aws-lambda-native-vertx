
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class SimpleEmailService {

  public SimpleEmailService() {}

  public SimpleEmailService(JsonObject json) {
    SimpleEmailServiceConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    SimpleEmailServiceConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private SimpleEmailMessage mail;
  /**
   * (Required)
   */
  private SimpleEmailReceipt receipt;

  /**
   * (Required)
   */
  public SimpleEmailMessage getMail() {
    return mail;
  }

  /**
   * (Required)
   */
  public SimpleEmailService setMail(SimpleEmailMessage mail) {
    this.mail = mail;
    return this;
  }

  /**
   * (Required)
   */
  public SimpleEmailReceipt getReceipt() {
    return receipt;
  }

  /**
   * (Required)
   */
  public SimpleEmailService setReceipt(SimpleEmailReceipt receipt) {
    this.receipt = receipt;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
