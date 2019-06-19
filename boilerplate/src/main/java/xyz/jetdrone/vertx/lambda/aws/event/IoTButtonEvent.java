
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class IoTButtonEvent {

  public IoTButtonEvent() {}

  public IoTButtonEvent(JsonObject json) {
    IoTButtonEventConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    IoTButtonEventConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private String batteryVoltage;
  /**
   * (Required)
   */
  private String clickType;
  /**
   * (Required)
   */
  private String serialNumber;

  /**
   * (Required)
   */
  public String getBatteryVoltage() {
    return batteryVoltage;
  }

  /**
   * (Required)
   */
  public IoTButtonEvent setBatteryVoltage(String batteryVoltage) {
    this.batteryVoltage = batteryVoltage;
    return this;
  }

  /**
   * (Required)
   */
  public String getClickType() {
    return clickType;
  }

  /**
   * (Required)
   */
  public IoTButtonEvent setClickType(String clickType) {
    this.clickType = clickType;
    return this;
  }

  /**
   * (Required)
   */
  public String getSerialNumber() {
    return serialNumber;
  }

  /**
   * (Required)
   */
  public IoTButtonEvent setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
