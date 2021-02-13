
package xyz.jetdrone.vertx.lambda.aws.event;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class LexBot {

  public LexBot() {}

  public LexBot(JsonObject json) {
    LexBotConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    LexBotConverter.toJson(this, json);
    return json;
  }

  private String alias;
  private String name;
  private String version;

  public String getAlias() {
    return alias;
  }

  public LexBot setAlias(String alias) {
    this.alias = alias;
    return this;
  }

  public String getName() {
    return name;
  }

  public LexBot setName(String name) {
    this.name = name;
    return this;
  }

  public String getVersion() {
    return version;
  }

  public LexBot setVersion(String version) {
    this.version = version;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
