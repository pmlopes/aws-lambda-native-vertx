
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class Attachment {

  public Attachment() {}

  public Attachment(JsonObject json) {
    AttachmentConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    AttachmentConverter.toJson(this, json);
    return json;
  }

  private String attachmentLinkUrl;
  private JsonArray buttons = new JsonArray();
  private String imageUrl;
  private String subTitle;
  private String title;

  public String getAttachmentLinkUrl() {
    return attachmentLinkUrl;
  }

  public Attachment setAttachmentLinkUrl(String attachmentLinkUrl) {
    this.attachmentLinkUrl = attachmentLinkUrl;
    return this;
  }

  public JsonArray getButtons() {
    return buttons;
  }

  public Attachment setButtons(JsonArray buttons) {
    this.buttons = buttons;
    return this;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public Attachment setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  public String getSubTitle() {
    return subTitle;
  }

  public Attachment setSubTitle(String subTitle) {
    this.subTitle = subTitle;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public Attachment setTitle(String title) {
    this.title = title;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
