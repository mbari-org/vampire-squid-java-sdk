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
public class VideoSequence implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The camera_id property
     */
    private String cameraId;
    /**
     * The description property
     */
    private String description;
    /**
     * The last_updated_time property
     */
    private OffsetDateTime lastUpdatedTime;
    /**
     * The name property
     */
    private String name;
    /**
     * The uuid property
     */
    private UUID uuid;
    /**
     * The videos property
     */
    private java.util.List<Video> videos;
    /**
     * Instantiates a new {@link VideoSequence} and sets the default values.
     */
    public VideoSequence() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link VideoSequence}
     */
    @jakarta.annotation.Nonnull
    public static VideoSequence createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new VideoSequence();
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
     * Gets the camera_id property value. The camera_id property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getCameraId() {
        return this.cameraId;
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
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(6);
        deserializerMap.put("camera_id", (n) -> { this.setCameraId(n.getStringValue()); });
        deserializerMap.put("description", (n) -> { this.setDescription(n.getStringValue()); });
        deserializerMap.put("last_updated_time", (n) -> { this.setLastUpdatedTime(n.getOffsetDateTimeValue()); });
        deserializerMap.put("name", (n) -> { this.setName(n.getStringValue()); });
        deserializerMap.put("uuid", (n) -> { this.setUuid(n.getUUIDValue()); });
        deserializerMap.put("videos", (n) -> { this.setVideos(n.getCollectionOfObjectValues(Video::createFromDiscriminatorValue)); });
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
     * Gets the uuid property value. The uuid property
     * @return a {@link UUID}
     */
    @jakarta.annotation.Nullable
    public UUID getUuid() {
        return this.uuid;
    }
    /**
     * Gets the videos property value. The videos property
     * @return a {@link java.util.List<Video>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<Video> getVideos() {
        return this.videos;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("camera_id", this.getCameraId());
        writer.writeStringValue("description", this.getDescription());
        writer.writeOffsetDateTimeValue("last_updated_time", this.getLastUpdatedTime());
        writer.writeStringValue("name", this.getName());
        writer.writeUUIDValue("uuid", this.getUuid());
        writer.writeCollectionOfObjectValues("videos", this.getVideos());
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
     * Sets the camera_id property value. The camera_id property
     * @param value Value to set for the camera_id property.
     */
    public void setCameraId(@jakarta.annotation.Nullable final String value) {
        this.cameraId = value;
    }
    /**
     * Sets the description property value. The description property
     * @param value Value to set for the description property.
     */
    public void setDescription(@jakarta.annotation.Nullable final String value) {
        this.description = value;
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
     * Sets the uuid property value. The uuid property
     * @param value Value to set for the uuid property.
     */
    public void setUuid(@jakarta.annotation.Nullable final UUID value) {
        this.uuid = value;
    }
    /**
     * Sets the videos property value. The videos property
     * @param value Value to set for the videos property.
     */
    public void setVideos(@jakarta.annotation.Nullable final java.util.List<Video> value) {
        this.videos = value;
    }
}
