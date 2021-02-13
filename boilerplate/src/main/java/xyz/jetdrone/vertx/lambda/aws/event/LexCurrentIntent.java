
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class LexCurrentIntent {

  public LexCurrentIntent() {}

  public LexCurrentIntent(JsonObject json) {
    LexCurrentIntentConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    LexCurrentIntentConverter.toJson(this, json);
    return json;
  }

  private String confirmationStatus;
  private String name;
  private JsonObject slotDetails;
  private JsonObject slots;

  public String getConfirmationStatus() {
    return confirmationStatus;
  }

  public LexCurrentIntent setConfirmationStatus(String confirmationStatus) {
    this.confirmationStatus = confirmationStatus;
    return this;
  }

  public String getName() {
    return name;
  }

  public LexCurrentIntent setName(String name) {
    this.name = name;
    return this;
  }

  public JsonObject getSlotDetails() {
    return slotDetails;
  }

  public LexCurrentIntent setSlotDetails(JsonObject slotDetails) {
    this.slotDetails = slotDetails;
    return this;
  }

  public JsonObject getSlots() {
    return slots;
  }

  public LexCurrentIntent setSlots(JsonObject slots) {
    this.slots = slots;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
