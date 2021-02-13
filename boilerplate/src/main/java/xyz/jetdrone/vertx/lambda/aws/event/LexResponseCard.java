
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

@DataObject(generateConverter = true)
public class LexResponseCard {

  public LexResponseCard() {}

  public LexResponseCard(JsonObject json) {
    LexResponseCardConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    LexResponseCardConverter.toJson(this, json);
    return json;
  }

  private String contentType;
  private List<Attachment> genericAttachments = new ArrayList<Attachment>();
  private Integer version;

  public String getContentType() {
    return contentType;
  }

  public LexResponseCard setContentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  public List<Attachment> getGenericAttachments() {
    return genericAttachments;
  }

  public LexResponseCard setGenericAttachments(List<Attachment> genericAttachments) {
    this.genericAttachments = genericAttachments;
    return this;
  }

  public Integer getVersion() {
    return version;
  }

  public LexResponseCard setVersion(Integer version) {
    this.version = version;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
