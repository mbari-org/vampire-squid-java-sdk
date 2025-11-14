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
public class VideoUpdate implements AdditionalDataHolder, Parsable {
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
     * The name property
     */
    private String name;
    /**
     * The start property
     */
    private OffsetDateTime start;
    /**
     * The start_timestamp property
     */
    private OffsetDateTime startTimestamp;
    /**
     * The video_sequence_uuid property
     */
    private UUID videoSequenceUuid;
    /**
     * Instantiates a new {@link VideoUpdate} and sets the default values.
     */
    public VideoUpdate() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link VideoUpdate}
     */
    @jakarta.annotation.Nonnull
    public static VideoUpdate createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new VideoUpdate();
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
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(6);
        deserializerMap.put("description", (n) -> { this.setDescription(n.getStringValue()); });
        deserializerMap.put("duration_millis", (n) -> { this.setDurationMillis(n.getLongValue()); });
        deserializerMap.put("name", (n) -> { this.setName(n.getStringValue()); });
        deserializerMap.put("start", (n) -> { this.setStart(n.getOffsetDateTimeValue()); });
        deserializerMap.put("start_timestamp", (n) -> { this.setStartTimestamp(n.getOffsetDateTimeValue()); });
        deserializerMap.put("video_sequence_uuid", (n) -> { this.setVideoSequenceUuid(n.getUUIDValue()); });
        return deserializerMap;
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
     * Gets the start property value. The start property
     * @return a {@link OffsetDateTime}
     */
    @jakarta.annotation.Nullable
    public OffsetDateTime getStart() {
        return this.start;
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
     * Gets the video_sequence_uuid property value. The video_sequence_uuid property
     * @return a {@link UUID}
     */
    @jakarta.annotation.Nullable
    public UUID getVideoSequenceUuid() {
        return this.videoSequenceUuid;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("description", this.getDescription());
        writer.writeLongValue("duration_millis", this.getDurationMillis());
        writer.writeStringValue("name", this.getName());
        writer.writeOffsetDateTimeValue("start", this.getStart());
        writer.writeOffsetDateTimeValue("start_timestamp", this.getStartTimestamp());
        writer.writeUUIDValue("video_sequence_uuid", this.getVideoSequenceUuid());
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
     * Sets the name property value. The name property
     * @param value Value to set for the name property.
     */
    public void setName(@jakarta.annotation.Nullable final String value) {
        this.name = value;
    }
    /**
     * Sets the start property value. The start property
     * @param value Value to set for the start property.
     */
    public void setStart(@jakarta.annotation.Nullable final OffsetDateTime value) {
        this.start = value;
    }
    /**
     * Sets the start_timestamp property value. The start_timestamp property
     * @param value Value to set for the start_timestamp property.
     */
    public void setStartTimestamp(@jakarta.annotation.Nullable final OffsetDateTime value) {
        this.startTimestamp = value;
    }
    /**
     * Sets the video_sequence_uuid property value. The video_sequence_uuid property
     * @param value Value to set for the video_sequence_uuid property.
     */
    public void setVideoSequenceUuid(@jakarta.annotation.Nullable final UUID value) {
        this.videoSequenceUuid = value;
    }
}
