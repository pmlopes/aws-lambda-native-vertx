
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class LexEvent {

  public LexEvent() {}

  public LexEvent(JsonObject json) {
    LexEventConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    LexEventConverter.toJson(this, json);
    return json;
  }

  private LexBot bot;
  private LexCurrentIntent currentIntent;
  private LexDialogAction dialogAction;
  private String inputTranscript;
  private String invocationSource;
  private String messageVersion;
  private String outputDialogMode;
  private JsonObject requestAttributes;
  private JsonObject sessionAttributes;
  private String userId;

  public LexBot getBot() {
    return bot;
  }

  public LexEvent setBot(LexBot bot) {
    this.bot = bot;
    return this;
  }

  public LexCurrentIntent getCurrentIntent() {
    return currentIntent;
  }

  public LexEvent setCurrentIntent(LexCurrentIntent currentIntent) {
    this.currentIntent = currentIntent;
    return this;
  }

  public LexDialogAction getDialogAction() {
    return dialogAction;
  }

  public LexEvent setDialogAction(LexDialogAction dialogAction) {
    this.dialogAction = dialogAction;
    return this;
  }

  public String getInputTranscript() {
    return inputTranscript;
  }

  public LexEvent setInputTranscript(String inputTranscript) {
    this.inputTranscript = inputTranscript;
    return this;
  }

  public String getInvocationSource() {
    return invocationSource;
  }

  public LexEvent setInvocationSource(String invocationSource) {
    this.invocationSource = invocationSource;
    return this;
  }

  public String getMessageVersion() {
    return messageVersion;
  }

  public LexEvent setMessageVersion(String messageVersion) {
    this.messageVersion = messageVersion;
    return this;
  }

  public String getOutputDialogMode() {
    return outputDialogMode;
  }

  public LexEvent setOutputDialogMode(String outputDialogMode) {
    this.outputDialogMode = outputDialogMode;
    return this;
  }

  public JsonObject getRequestAttributes() {
    return requestAttributes;
  }

  public LexEvent setRequestAttributes(JsonObject requestAttributes) {
    this.requestAttributes = requestAttributes;
    return this;
  }

  public JsonObject getSessionAttributes() {
    return sessionAttributes;
  }

  public LexEvent setSessionAttributes(JsonObject sessionAttributes) {
    this.sessionAttributes = sessionAttributes;
    return this;
  }

  public String getUserId() {
    return userId;
  }

  public LexEvent setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
