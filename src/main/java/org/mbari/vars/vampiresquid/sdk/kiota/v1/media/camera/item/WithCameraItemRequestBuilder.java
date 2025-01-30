package org.mbari.vars.vampiresquid.sdk.kiota.v1.media.camera.item;

import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.media.camera.item.item.DatetimeItemRequestBuilder;
/**
 * Builds and executes requests for operations under /v1/media/camera/{cameraId}
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class WithCameraItemRequestBuilder extends BaseRequestBuilder {
    /**
     * Gets an item from the org.mbari.vars.vampiresquid.sdk.kiota.v1.media.camera.item.item collection
     * @param datetimeId Unique identifier of the item
     * @return a {@link DatetimeItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public DatetimeItemRequestBuilder byDatetimeId(@jakarta.annotation.Nonnull final String datetimeId) {
        Objects.requireNonNull(datetimeId);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("datetime%2Did", datetimeId);
        return new DatetimeItemRequestBuilder(urlTplParams, requestAdapter);
    }
    /**
     * Instantiates a new {@link WithCameraItemRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public WithCameraItemRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/media/camera/{cameraId}", pathParameters);
    }
    /**
     * Instantiates a new {@link WithCameraItemRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public WithCameraItemRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/media/camera/{cameraId}", rawUrl);
    }
}
