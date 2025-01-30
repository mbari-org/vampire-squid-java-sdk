package org.mbari.vars.vampiresquid.sdk.kiota.v1.media.camera.item.item;

import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.BaseRequestConfiguration;
import com.microsoft.kiota.HttpMethod;
import com.microsoft.kiota.RequestAdapter;
import com.microsoft.kiota.RequestInformation;
import com.microsoft.kiota.RequestOption;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParsableFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.mbari.vars.vampiresquid.sdk.kiota.models.BadRequest;
import org.mbari.vars.vampiresquid.sdk.kiota.models.Media;
import org.mbari.vars.vampiresquid.sdk.kiota.models.NotFound;
import org.mbari.vars.vampiresquid.sdk.kiota.models.ServerError;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.media.camera.item.item.item.WithEndTimestampItemRequestBuilder;
/**
 * Builds and executes requests for operations under /v1/media/camera/{cameraId}/{datetime-id}
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class DatetimeItemRequestBuilder extends BaseRequestBuilder {
    /**
     * Gets an item from the org.mbari.vars.vampiresquid.sdk.kiota.v1.media.camera.item.item.item collection
     * @param endTimestamp Unique identifier of the item
     * @return a {@link WithEndTimestampItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public WithEndTimestampItemRequestBuilder byEndTimestamp(@jakarta.annotation.Nonnull final String endTimestamp) {
        Objects.requireNonNull(endTimestamp);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("endTimestamp", endTimestamp);
        return new WithEndTimestampItemRequestBuilder(urlTplParams, requestAdapter);
    }
    /**
     * Instantiates a new {@link DatetimeItemRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public DatetimeItemRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/media/camera/{cameraId}/{datetime%2Did}", pathParameters);
    }
    /**
     * Instantiates a new {@link DatetimeItemRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public DatetimeItemRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/media/camera/{cameraId}/{datetime%2Did}", rawUrl);
    }
    /**
     * Find media by cameraId and datetime
     * @return a {@link java.util.List<Media>}
     * @throws BadRequest When receiving a 400 status code
     * @throws NotFound When receiving a 404 status code
     * @throws ServerError When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public java.util.List<Media> get() {
        return get(null);
    }
    /**
     * Find media by cameraId and datetime
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link java.util.List<Media>}
     * @throws BadRequest When receiving a 400 status code
     * @throws NotFound When receiving a 404 status code
     * @throws ServerError When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public java.util.List<Media> get(@jakarta.annotation.Nullable final java.util.function.Consumer<GetRequestConfiguration> requestConfiguration) {
        final RequestInformation requestInfo = toGetRequestInformation(requestConfiguration);
        final HashMap<String, ParsableFactory<? extends Parsable>> errorMapping = new HashMap<String, ParsableFactory<? extends Parsable>>();
        errorMapping.put("400", BadRequest::createFromDiscriminatorValue);
        errorMapping.put("404", NotFound::createFromDiscriminatorValue);
        errorMapping.put("500", ServerError::createFromDiscriminatorValue);
        return this.requestAdapter.sendCollection(requestInfo, errorMapping, Media::createFromDiscriminatorValue);
    }
    /**
     * Find media by cameraId and datetime
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toGetRequestInformation() {
        return toGetRequestInformation(null);
    }
    /**
     * Find media by cameraId and datetime
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toGetRequestInformation(@jakarta.annotation.Nullable final java.util.function.Consumer<GetRequestConfiguration> requestConfiguration) {
        final RequestInformation requestInfo = new RequestInformation(HttpMethod.GET, urlTemplate, pathParameters);
        requestInfo.configure(requestConfiguration, GetRequestConfiguration::new);
        requestInfo.headers.tryAdd("Accept", "application/json");
        return requestInfo;
    }
    /**
     * Returns a request builder with the provided arbitrary URL. Using this method means any other path or query parameters are ignored.
     * @param rawUrl The raw URL to use for the request builder.
     * @return a {@link DatetimeItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public DatetimeItemRequestBuilder withUrl(@jakarta.annotation.Nonnull final String rawUrl) {
        Objects.requireNonNull(rawUrl);
        return new DatetimeItemRequestBuilder(rawUrl, requestAdapter);
    }
    /**
     * Configuration for the request such as headers, query parameters, and middleware options.
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public class GetRequestConfiguration extends BaseRequestConfiguration {
    }
}
