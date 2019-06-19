
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@DataObject(generateConverter = true)
public class SimpleEmailReceipt {

  public SimpleEmailReceipt() {}

  public SimpleEmailReceipt(JsonObject json) {
    SimpleEmailReceiptConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    SimpleEmailReceiptConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private SimpleEmailReceiptAction action;
  /**
   * (Required)
   */
  private SimpleEmailVerdict dkimVerdict;
  /**
   * (Required)
   */
  private SimpleEmailVerdict dmarcPolicy;
  /**
   * (Required)
   */
  private SimpleEmailVerdict dmarcVerdict;
  /**
   * (Required)
   */
  private Integer processingTimeMillis;
  /**
   * (Required)
   */
  private List<String> recipients = new ArrayList<String>();
  /**
   * (Required)
   */
  private SimpleEmailVerdict spamVerdict;
  /**
   * (Required)
   */
  private SimpleEmailVerdict spfVerdict;
  /**
   * (Required)
   */
  private Date timestamp;
  /**
   * (Required)
   */
  private SimpleEmailVerdict virusVerdict;

  /**
   * (Required)
   */
  public SimpleEmailReceiptAction getAction() {
    return action;
  }

  /**
   * (Required)
   */
  public SimpleEmailReceipt setAction(SimpleEmailReceiptAction action) {
    this.action = action;
    return this;
  }

  /**
   * (Required)
   */
  public SimpleEmailVerdict getDkimVerdict() {
    return dkimVerdict;
  }

  /**
   * (Required)
   */
  public SimpleEmailReceipt setDkimVerdict(SimpleEmailVerdict dkimVerdict) {
    this.dkimVerdict = dkimVerdict;
    return this;
  }

  /**
   * (Required)
   */
  public SimpleEmailVerdict getDmarcPolicy() {
    return dmarcPolicy;
  }

  /**
   * (Required)
   */
  public SimpleEmailReceipt setDmarcPolicy(SimpleEmailVerdict dmarcPolicy) {
    this.dmarcPolicy = dmarcPolicy;
    return this;
  }

  /**
   * (Required)
   */
  public SimpleEmailVerdict getDmarcVerdict() {
    return dmarcVerdict;
  }

  /**
   * (Required)
   */
  public SimpleEmailReceipt setDmarcVerdict(SimpleEmailVerdict dmarcVerdict) {
    this.dmarcVerdict = dmarcVerdict;
    return this;
  }

  /**
   * (Required)
   */
  public Integer getProcessingTimeMillis() {
    return processingTimeMillis;
  }

  /**
   * (Required)
   */
  public SimpleEmailReceipt setProcessingTimeMillis(Integer processingTimeMillis) {
    this.processingTimeMillis = processingTimeMillis;
    return this;
  }

  /**
   * (Required)
   */
  public List<String> getRecipients() {
    return recipients;
  }

  /**
   * (Required)
   */
  public SimpleEmailReceipt setRecipients(List<String> recipients) {
    this.recipients = recipients;
    return this;
  }

  /**
   * (Required)
   */
  public SimpleEmailVerdict getSpamVerdict() {
    return spamVerdict;
  }

  /**
   * (Required)
   */
  public SimpleEmailReceipt setSpamVerdict(SimpleEmailVerdict spamVerdict) {
    this.spamVerdict = spamVerdict;
    return this;
  }

  /**
   * (Required)
   */
  public SimpleEmailVerdict getSpfVerdict() {
    return spfVerdict;
  }

  /**
   * (Required)
   */
  public SimpleEmailReceipt setSpfVerdict(SimpleEmailVerdict spfVerdict) {
    this.spfVerdict = spfVerdict;
    return this;
  }

  /**
   * (Required)
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * (Required)
   */
  public SimpleEmailReceipt setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * (Required)
   */
  public SimpleEmailVerdict getVirusVerdict() {
    return virusVerdict;
  }

  /**
   * (Required)
   */
  public SimpleEmailReceipt setVirusVerdict(SimpleEmailVerdict virusVerdict) {
    this.virusVerdict = virusVerdict;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
