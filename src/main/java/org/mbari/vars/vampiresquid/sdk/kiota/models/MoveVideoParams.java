package org.mbari.vars.vampiresquid.sdk.kiota.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class MoveVideoParams implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The duration_millis property
     */
    private Long durationMillis;
    /**
     * The start_timestamp property
     */
    private OffsetDateTime startTimestamp;
    /**
     * The video_name property
     */
    private String videoName;
    /**
     * Instantiates a new {@link MoveVideoParams} and sets the default values.
     */
    public MoveVideoParams() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link MoveVideoParams}
     */
    @jakarta.annotation.Nonnull
    public static MoveVideoParams createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new MoveVideoParams();
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
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(3);
        deserializerMap.put("duration_millis", (n) -> { this.setDurationMillis(n.getLongValue()); });
        deserializerMap.put("start_timestamp", (n) -> { this.setStartTimestamp(n.getOffsetDateTimeValue()); });
        deserializerMap.put("video_name", (n) -> { this.setVideoName(n.getStringValue()); });
        return deserializerMap;
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
     * Gets the video_name property value. The video_name property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getVideoName() {
        return this.videoName;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeLongValue("duration_millis", this.getDurationMillis());
        writer.writeOffsetDateTimeValue("start_timestamp", this.getStartTimestamp());
        writer.writeStringValue("video_name", this.getVideoName());
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
     * Sets the duration_millis property value. The duration_millis property
     * @param value Value to set for the duration_millis property.
     */
    public void setDurationMillis(@jakarta.annotation.Nullable final Long value) {
        this.durationMillis = value;
    }
    /**
     * Sets the start_timestamp property value. The start_timestamp property
     * @param value Value to set for the start_timestamp property.
     */
    public void setStartTimestamp(@jakarta.annotation.Nullable final OffsetDateTime value) {
        this.startTimestamp = value;
    }
    /**
     * Sets the video_name property value. The video_name property
     * @param value Value to set for the video_name property.
     */
    public void setVideoName(@jakarta.annotation.Nullable final String value) {
        this.videoName = value;
    }
}
