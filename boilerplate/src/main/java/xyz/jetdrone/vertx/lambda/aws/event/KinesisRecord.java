
package xyz.jetdrone.vertx.lambda.aws.event;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class KinesisRecord {

  public KinesisRecord() {}

  public KinesisRecord(JsonObject json) {
    KinesisRecordConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    KinesisRecordConverter.toJson(this, json);
    return json;
  }

  /**
   * (Required)
   */
  private SecondsEpochTime approximateArrivalTimestamp;
  /**
   * (Required)
   */
  private Buffer data;
  private String encryptionType;
  /**
   * (Required)
   */
  private String kinesisSchemaVersion;
  /**
   * (Required)
   */
  private String partitionKey;
  /**
   * (Required)
   */
  private String sequenceNumber;

  /**
   * (Required)
   */
  public SecondsEpochTime getApproximateArrivalTimestamp() {
    return approximateArrivalTimestamp;
  }

  /**
   * (Required)
   */
  public KinesisRecord setApproximateArrivalTimestamp(SecondsEpochTime approximateArrivalTimestamp) {
    this.approximateArrivalTimestamp = approximateArrivalTimestamp;
    return this;
  }

  /**
   * (Required)
   */
  public Buffer getData() {
    return data;
  }

  /**
   * (Required)
   */
  public KinesisRecord setData(Buffer data) {
    this.data = data;
    return this;
  }

  public String getEncryptionType() {
    return encryptionType;
  }

  public KinesisRecord setEncryptionType(String encryptionType) {
    this.encryptionType = encryptionType;
    return this;
  }

  /**
   * (Required)
   */
  public String getKinesisSchemaVersion() {
    return kinesisSchemaVersion;
  }

  /**
   * (Required)
   */
  public KinesisRecord setKinesisSchemaVersion(String kinesisSchemaVersion) {
    this.kinesisSchemaVersion = kinesisSchemaVersion;
    return this;
  }

  /**
   * (Required)
   */
  public String getPartitionKey() {
    return partitionKey;
  }

  /**
   * (Required)
   */
  public KinesisRecord setPartitionKey(String partitionKey) {
    this.partitionKey = partitionKey;
    return this;
  }

  /**
   * (Required)
   */
  public String getSequenceNumber() {
    return sequenceNumber;
  }

  /**
   * (Required)
   */
  public KinesisRecord setSequenceNumber(String sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
    return this;
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}
