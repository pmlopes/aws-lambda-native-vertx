
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class LexDialogAction {

  public LexDialogAction() {}

  public LexDialogAction(JsonObject json) {
    LexDialogActionConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    LexDialogActionConverter.toJson(this, json);
    return json;
  }

  private String fulfillmentState;
  private String intentName;
  private JsonObject message;
  private LexResponseCard responseCard;
  private String slotToElicit;
  private JsonObject slots;
  private String type;

  public String getFulfillmentState() {
    return fulfillmentState;
  }

  public LexDialogAction setFulfillmentState(String fulfillmentState) {
    this.fulfillmentState = fulfillmentState;
    return this;
  }

  public String getIntentName() {
    return intentName;
  }

  public LexDialogAction setIntentName(String intentName) {
    this.intentName = intentName;
    return this;
  }

  public JsonObject getMessage() {
    return message;
  }

  public LexDialogAction setMessage(JsonObject message) {
    this.message = message;
    return this;
  }

  public LexResponseCard getResponseCard() {
    return responseCard;
  }

  public LexDialogAction setResponseCard(LexResponseCard responseCard) {
    this.responseCard = responseCard;
    return this;
  }

  public String getSlotToElicit() {
    return slotToElicit;
  }

  public LexDialogAction setSlotToElicit(String slotToElicit) {
    this.slotToElicit = slotToElicit;
    return this;
  }

  public JsonObject getSlots() {
    return slots;
  }

  public LexDialogAction setSlots(JsonObject slots) {
    this.slots = slots;
    return this;
  }

  public String getType() {
    return type;
  }

  public LexDialogAction setType(String type) {
    this.type = type;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
