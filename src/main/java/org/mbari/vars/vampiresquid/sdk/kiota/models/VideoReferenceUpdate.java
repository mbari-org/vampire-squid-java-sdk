package org.mbari.vars.vampiresquid.sdk.kiota.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class VideoReferenceUpdate implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The audio_codec property
     */
    private String audioCodec;
    /**
     * The container property
     */
    private String container;
    /**
     * The description property
     */
    private String description;
    /**
     * The frame_rate property
     */
    private Double frameRate;
    /**
     * The height property
     */
    private Integer height;
    /**
     * The sha512 property
     */
    private byte[] sha512;
    /**
     * The size_bytes property
     */
    private Long sizeBytes;
    /**
     * The uri property
     */
    private String uri;
    /**
     * The video_codec property
     */
    private String videoCodec;
    /**
     * The video_uuid property
     */
    private UUID videoUuid;
    /**
     * The width property
     */
    private Integer width;
    /**
     * Instantiates a new {@link VideoReferenceUpdate} and sets the default values.
     */
    public VideoReferenceUpdate() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link VideoReferenceUpdate}
     */
    @jakarta.annotation.Nonnull
    public static VideoReferenceUpdate createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new VideoReferenceUpdate();
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
     * Gets the audio_codec property value. The audio_codec property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getAudioCodec() {
        return this.audioCodec;
    }
    /**
     * Gets the container property value. The container property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getContainer() {
        return this.container;
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
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(11);
        deserializerMap.put("audio_codec", (n) -> { this.setAudioCodec(n.getStringValue()); });
        deserializerMap.put("container", (n) -> { this.setContainer(n.getStringValue()); });
        deserializerMap.put("description", (n) -> { this.setDescription(n.getStringValue()); });
        deserializerMap.put("frame_rate", (n) -> { this.setFrameRate(n.getDoubleValue()); });
        deserializerMap.put("height", (n) -> { this.setHeight(n.getIntegerValue()); });
        deserializerMap.put("sha512", (n) -> { this.setSha512(n.getByteArrayValue()); });
        deserializerMap.put("size_bytes", (n) -> { this.setSizeBytes(n.getLongValue()); });
        deserializerMap.put("uri", (n) -> { this.setUri(n.getStringValue()); });
        deserializerMap.put("video_codec", (n) -> { this.setVideoCodec(n.getStringValue()); });
        deserializerMap.put("video_uuid", (n) -> { this.setVideoUuid(n.getUUIDValue()); });
        deserializerMap.put("width", (n) -> { this.setWidth(n.getIntegerValue()); });
        return deserializerMap;
    }
    /**
     * Gets the frame_rate property value. The frame_rate property
     * @return a {@link Double}
     */
    @jakarta.annotation.Nullable
    public Double getFrameRate() {
        return this.frameRate;
    }
    /**
     * Gets the height property value. The height property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getHeight() {
        return this.height;
    }
    /**
     * Gets the sha512 property value. The sha512 property
     * @return a {@link byte[]}
     */
    @jakarta.annotation.Nullable
    public byte[] getSha512() {
        return this.sha512;
    }
    /**
     * Gets the size_bytes property value. The size_bytes property
     * @return a {@link Long}
     */
    @jakarta.annotation.Nullable
    public Long getSizeBytes() {
        return this.sizeBytes;
    }
    /**
     * Gets the uri property value. The uri property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getUri() {
        return this.uri;
    }
    /**
     * Gets the video_codec property value. The video_codec property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getVideoCodec() {
        return this.videoCodec;
    }
    /**
     * Gets the video_uuid property value. The video_uuid property
     * @return a {@link UUID}
     */
    @jakarta.annotation.Nullable
    public UUID getVideoUuid() {
        return this.videoUuid;
    }
    /**
     * Gets the width property value. The width property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getWidth() {
        return this.width;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("audio_codec", this.getAudioCodec());
        writer.writeStringValue("container", this.getContainer());
        writer.writeStringValue("description", this.getDescription());
        writer.writeDoubleValue("frame_rate", this.getFrameRate());
        writer.writeIntegerValue("height", this.getHeight());
        writer.writeByteArrayValue("sha512", this.getSha512());
        writer.writeLongValue("size_bytes", this.getSizeBytes());
        writer.writeStringValue("uri", this.getUri());
        writer.writeStringValue("video_codec", this.getVideoCodec());
        writer.writeUUIDValue("video_uuid", this.getVideoUuid());
        writer.writeIntegerValue("width", this.getWidth());
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
     * Sets the audio_codec property value. The audio_codec property
     * @param value Value to set for the audio_codec property.
     */
    public void setAudioCodec(@jakarta.annotation.Nullable final String value) {
        this.audioCodec = value;
    }
    /**
     * Sets the container property value. The container property
     * @param value Value to set for the container property.
     */
    public void setContainer(@jakarta.annotation.Nullable final String value) {
        this.container = value;
    }
    /**
     * Sets the description property value. The description property
     * @param value Value to set for the description property.
     */
    public void setDescription(@jakarta.annotation.Nullable final String value) {
        this.description = value;
    }
    /**
     * Sets the frame_rate property value. The frame_rate property
     * @param value Value to set for the frame_rate property.
     */
    public void setFrameRate(@jakarta.annotation.Nullable final Double value) {
        this.frameRate = value;
    }
    /**
     * Sets the height property value. The height property
     * @param value Value to set for the height property.
     */
    public void setHeight(@jakarta.annotation.Nullable final Integer value) {
        this.height = value;
    }
    /**
     * Sets the sha512 property value. The sha512 property
     * @param value Value to set for the sha512 property.
     */
    public void setSha512(@jakarta.annotation.Nullable final byte[] value) {
        this.sha512 = value;
    }
    /**
     * Sets the size_bytes property value. The size_bytes property
     * @param value Value to set for the size_bytes property.
     */
    public void setSizeBytes(@jakarta.annotation.Nullable final Long value) {
        this.sizeBytes = value;
    }
    /**
     * Sets the uri property value. The uri property
     * @param value Value to set for the uri property.
     */
    public void setUri(@jakarta.annotation.Nullable final String value) {
        this.uri = value;
    }
    /**
     * Sets the video_codec property value. The video_codec property
     * @param value Value to set for the video_codec property.
     */
    public void setVideoCodec(@jakarta.annotation.Nullable final String value) {
        this.videoCodec = value;
    }
    /**
     * Sets the video_uuid property value. The video_uuid property
     * @param value Value to set for the video_uuid property.
     */
    public void setVideoUuid(@jakarta.annotation.Nullable final UUID value) {
        this.videoUuid = value;
    }
    /**
     * Sets the width property value. The width property
     * @param value Value to set for the width property.
     */
    public void setWidth(@jakarta.annotation.Nullable final Integer value) {
        this.width = value;
    }
}
