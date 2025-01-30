package org.mbari.vars.vampiresquid.sdk.kiota.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class Video implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The description property
     */
    private String description;
    /**
     * The duration_millis property
     */
    private Long durationMillis;
    /**
     * The last_updated_time property
     */
    private OffsetDateTime lastUpdatedTime;
    /**
     * The name property
     */
    private String name;
    /**
     * The start_timestamp property
     */
    private OffsetDateTime startTimestamp;
    /**
     * The uuid property
     */
    private UUID uuid;
    /**
     * The video_references property
     */
    private java.util.List<VideoReference> videoReferences;
    /**
     * Instantiates a new {@link Video} and sets the default values.
     */
    public Video() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link Video}
     */
    @jakarta.annotation.Nonnull
    public static Video createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new Video();
    }
    /**
     * Gets the AdditionalData property value. Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     * @return a {@link Map<String, Object>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, Object> getAdditionalData() {
        return this.additionalData;
    }
    /**
     * Gets the description property value. The description property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getDescription() {
        return this.description;
    }
    /**
     * Gets the duration_millis property value. The duration_millis property
     * @return a {@link Long}
     */
    @jakarta.annotation.Nullable
    public Long getDurationMillis() {
        return this.durationMillis;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(7);
        deserializerMap.put("description", (n) -> { this.setDescription(n.getStringValue()); });
        deserializerMap.put("duration_millis", (n) -> { this.setDurationMillis(n.getLongValue()); });
        deserializerMap.put("last_updated_time", (n) -> { this.setLastUpdatedTime(n.getOffsetDateTimeValue()); });
        deserializerMap.put("name", (n) -> { this.setName(n.getStringValue()); });
        deserializerMap.put("start_timestamp", (n) -> { this.setStartTimestamp(n.getOffsetDateTimeValue()); });
        deserializerMap.put("uuid", (n) -> { this.setUuid(n.getUUIDValue()); });
        deserializerMap.put("video_references", (n) -> { this.setVideoReferences(n.getCollectionOfObjectValues(VideoReference::createFromDiscriminatorValue)); });
        return deserializerMap;
    }
    /**
     * Gets the last_updated_time property value. The last_updated_time property
     * @return a {@link OffsetDateTime}
     */
    @jakarta.annotation.Nullable
    public OffsetDateTime getLastUpdatedTime() {
        return this.lastUpdatedTime;
    }
    /**
     * Gets the name property value. The name property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getName() {
        return this.name;
    }
    /**
     * Gets the start_timestamp property value. The start_timestamp property
     * @return a {@link OffsetDateTime}
     */
    @jakarta.annotation.Nullable
    public OffsetDateTime getStartTimestamp() {
        return this.startTimestamp;
    }
    /**
     * Gets the uuid property value. The uuid property
     * @return a {@link UUID}
     */
    @jakarta.annotation.Nullable
    public UUID getUuid() {
        return this.uuid;
    }
    /**
     * Gets the video_references property value. The video_references property
     * @return a {@link java.util.List<VideoReference>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<VideoReference> getVideoReferences() {
        return this.videoReferences;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("description", this.getDescription());
        writer.writeLongValue("duration_millis", this.getDurationMillis());
        writer.writeOffsetDateTimeValue("last_updated_time", this.getLastUpdatedTime());
        writer.writeStringValue("name", this.getName());
        writer.writeOffsetDateTimeValue("start_timestamp", this.getStartTimestamp());
        writer.writeUUIDValue("uuid", this.getUuid());
        writer.writeCollectionOfObjectValues("video_references", this.getVideoReferences());
        writer.writeAdditionalData(this.getAdditionalData());
    }
    /**
     * Sets the AdditionalData property value. Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     * @param value Value to set for the AdditionalData property.
     */
    public void setAdditionalData(@jakarta.annotation.Nullable final Map<String, Object> value) {
        this.additionalData = value;
    }
    /**
     * Sets the description property value. The description property
     * @param value Value to set for the description property.
     */
    public void setDescription(@jakarta.annotation.Nullable final String value) {
        this.description = value;
    }
    /**
     * Sets the duration_millis property value. The duration_millis property
     * @param value Value to set for the duration_millis property.
     */
    public void setDurationMillis(@jakarta.annotation.Nullable final Long value) {
        this.durationMillis = value;
    }
    /**
     * Sets the last_updated_time property value. The last_updated_time property
     * @param value Value to set for the last_updated_time property.
     */
    public void setLastUpdatedTime(@jakarta.annotation.Nullable final OffsetDateTime value) {
        this.lastUpdatedTime = value;
    }
    /**
     * Sets the name property value. The name property
     * @param value Value to set for the name property.
     */
    public void setName(@jakarta.annotation.Nullable final String value) {
        this.name = value;
    }
    /**
     * Sets the start_timestamp property value. The start_timestamp property
     * @param value Value to set for the start_timestamp property.
     */
    public void setStartTimestamp(@jakarta.annotation.Nullable final OffsetDateTime value) {
        this.startTimestamp = value;
    }
    /**
     * Sets the uuid property value. The uuid property
     * @param value Value to set for the uuid property.
     */
    public void setUuid(@jakarta.annotation.Nullable final UUID value) {
        this.uuid = value;
    }
    /**
     * Sets the video_references property value. The video_references property
     * @param value Value to set for the video_references property.
     */
    public void setVideoReferences(@jakarta.annotation.Nullable final java.util.List<VideoReference> value) {
        this.videoReferences = value;
    }
}
