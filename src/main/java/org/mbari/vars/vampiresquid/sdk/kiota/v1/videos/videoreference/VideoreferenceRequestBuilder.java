package org.mbari.vars.vampiresquid.sdk.kiota.v1.videos.videoreference;

import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videos.videoreference.item.WithVideoReferenceUuItemRequestBuilder;
/**
 * Builds and executes requests for operations under /v1/videos/videoreference
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class VideoreferenceRequestBuilder extends BaseRequestBuilder {
    /**
     * Gets an item from the org.mbari.vars.vampiresquid.sdk.kiota.v1.videos.videoreference.item collection
     * @param videoReferenceUuid Unique identifier of the item
     * @return a {@link WithVideoReferenceUuItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public WithVideoReferenceUuItemRequestBuilder byVideoReferenceUuid(@jakarta.annotation.Nonnull final UUID videoReferenceUuid) {
        Objects.requireNonNull(videoReferenceUuid);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("videoReferenceUuid", videoReferenceUuid);
        return new WithVideoReferenceUuItemRequestBuilder(urlTplParams, requestAdapter);
    }
    /**
     * Instantiates a new {@link VideoreferenceRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public VideoreferenceRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videos/videoreference", pathParameters);
    }
    /**
     * Instantiates a new {@link VideoreferenceRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public VideoreferenceRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videos/videoreference", rawUrl);
    }
}
