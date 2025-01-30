package org.mbari.vars.vampiresquid.sdk.kiota.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class HealthStatus implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The application property
     */
    private String application;
    /**
     * The availableProcessors property
     */
    private Integer availableProcessors;
    /**
     * The description property
     */
    private String description;
    /**
     * The freeMemory property
     */
    private Long freeMemory;
    /**
     * The jdkVersion property
     */
    private String jdkVersion;
    /**
     * The maxMemory property
     */
    private Long maxMemory;
    /**
     * The totalMemory property
     */
    private Long totalMemory;
    /**
     * The version property
     */
    private String version;
    /**
     * Instantiates a new {@link HealthStatus} and sets the default values.
     */
    public HealthStatus() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link HealthStatus}
     */
    @jakarta.annotation.Nonnull
    public static HealthStatus createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new HealthStatus();
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
     * Gets the application property value. The application property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getApplication() {
        return this.application;
    }
    /**
     * Gets the availableProcessors property value. The availableProcessors property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getAvailableProcessors() {
        return this.availableProcessors;
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
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(8);
        deserializerMap.put("application", (n) -> { this.setApplication(n.getStringValue()); });
        deserializerMap.put("availableProcessors", (n) -> { this.setAvailableProcessors(n.getIntegerValue()); });
        deserializerMap.put("description", (n) -> { this.setDescription(n.getStringValue()); });
        deserializerMap.put("freeMemory", (n) -> { this.setFreeMemory(n.getLongValue()); });
        deserializerMap.put("jdkVersion", (n) -> { this.setJdkVersion(n.getStringValue()); });
        deserializerMap.put("maxMemory", (n) -> { this.setMaxMemory(n.getLongValue()); });
        deserializerMap.put("totalMemory", (n) -> { this.setTotalMemory(n.getLongValue()); });
        deserializerMap.put("version", (n) -> { this.setVersion(n.getStringValue()); });
        return deserializerMap;
    }
    /**
     * Gets the freeMemory property value. The freeMemory property
     * @return a {@link Long}
     */
    @jakarta.annotation.Nullable
    public Long getFreeMemory() {
        return this.freeMemory;
    }
    /**
     * Gets the jdkVersion property value. The jdkVersion property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getJdkVersion() {
        return this.jdkVersion;
    }
    /**
     * Gets the maxMemory property value. The maxMemory property
     * @return a {@link Long}
     */
    @jakarta.annotation.Nullable
    public Long getMaxMemory() {
        return this.maxMemory;
    }
    /**
     * Gets the totalMemory property value. The totalMemory property
     * @return a {@link Long}
     */
    @jakarta.annotation.Nullable
    public Long getTotalMemory() {
        return this.totalMemory;
    }
    /**
     * Gets the version property value. The version property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getVersion() {
        return this.version;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("application", this.getApplication());
        writer.writeIntegerValue("availableProcessors", this.getAvailableProcessors());
        writer.writeStringValue("description", this.getDescription());
        writer.writeLongValue("freeMemory", this.getFreeMemory());
        writer.writeStringValue("jdkVersion", this.getJdkVersion());
        writer.writeLongValue("maxMemory", this.getMaxMemory());
        writer.writeLongValue("totalMemory", this.getTotalMemory());
        writer.writeStringValue("version", this.getVersion());
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
     * Sets the application property value. The application property
     * @param value Value to set for the application property.
     */
    public void setApplication(@jakarta.annotation.Nullable final String value) {
        this.application = value;
    }
    /**
     * Sets the availableProcessors property value. The availableProcessors property
     * @param value Value to set for the availableProcessors property.
     */
    public void setAvailableProcessors(@jakarta.annotation.Nullable final Integer value) {
        this.availableProcessors = value;
    }
    /**
     * Sets the description property value. The description property
     * @param value Value to set for the description property.
     */
    public void setDescription(@jakarta.annotation.Nullable final String value) {
        this.description = value;
    }
    /**
     * Sets the freeMemory property value. The freeMemory property
     * @param value Value to set for the freeMemory property.
     */
    public void setFreeMemory(@jakarta.annotation.Nullable final Long value) {
        this.freeMemory = value;
    }
    /**
     * Sets the jdkVersion property value. The jdkVersion property
     * @param value Value to set for the jdkVersion property.
     */
    public void setJdkVersion(@jakarta.annotation.Nullable final String value) {
        this.jdkVersion = value;
    }
    /**
     * Sets the maxMemory property value. The maxMemory property
     * @param value Value to set for the maxMemory property.
     */
    public void setMaxMemory(@jakarta.annotation.Nullable final Long value) {
        this.maxMemory = value;
    }
    /**
     * Sets the totalMemory property value. The totalMemory property
     * @param value Value to set for the totalMemory property.
     */
    public void setTotalMemory(@jakarta.annotation.Nullable final Long value) {
        this.totalMemory = value;
    }
    /**
     * Sets the version property value. The version property
     * @param value Value to set for the version property.
     */
    public void setVersion(@jakarta.annotation.Nullable final String value) {
        this.version = value;
    }
}
