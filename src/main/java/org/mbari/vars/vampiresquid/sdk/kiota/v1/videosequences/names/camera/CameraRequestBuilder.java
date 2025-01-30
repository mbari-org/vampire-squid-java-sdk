package org.mbari.vars.vampiresquid.sdk.kiota.v1.videosequences.names.camera;

import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videosequences.names.camera.item.WithCameraItemRequestBuilder;
/**
 * Builds and executes requests for operations under /v1/videosequences/names/camera
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class CameraRequestBuilder extends BaseRequestBuilder {
    /**
     * Gets an item from the org.mbari.vars.vampiresquid.sdk.kiota.v1.videosequences.names.camera.item collection
     * @param cameraid Unique identifier of the item
     * @return a {@link WithCameraItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public WithCameraItemRequestBuilder byCameraid(@jakarta.annotation.Nonnull final String cameraid) {
        Objects.requireNonNull(cameraid);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("cameraid", cameraid);
        return new WithCameraItemRequestBuilder(urlTplParams, requestAdapter);
    }
    /**
     * Instantiates a new {@link CameraRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public CameraRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videosequences/names/camera", pathParameters);
    }
    /**
     * Instantiates a new {@link CameraRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public CameraRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videosequences/names/camera", rawUrl);
    }
}
