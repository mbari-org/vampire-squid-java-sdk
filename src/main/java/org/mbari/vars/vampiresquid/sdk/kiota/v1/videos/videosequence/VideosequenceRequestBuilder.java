package org.mbari.vars.vampiresquid.sdk.kiota.v1.videos.videosequence;

import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videos.videosequence.item.WithVideoSequenceUuItemRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videos.videosequence.name.NameRequestBuilder;
/**
 * Builds and executes requests for operations under /v1/videos/videosequence
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class VideosequenceRequestBuilder extends BaseRequestBuilder {
    /**
     * The name property
     * @return a {@link NameRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public NameRequestBuilder name() {
        return new NameRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * Gets an item from the org.mbari.vars.vampiresquid.sdk.kiota.v1.videos.videosequence.item collection
     * @param videoSequenceUuid Unique identifier of the item
     * @return a {@link WithVideoSequenceUuItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public WithVideoSequenceUuItemRequestBuilder byVideoSequenceUuid(@jakarta.annotation.Nonnull final UUID videoSequenceUuid) {
        Objects.requireNonNull(videoSequenceUuid);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("videoSequenceUuid", videoSequenceUuid);
        return new WithVideoSequenceUuItemRequestBuilder(urlTplParams, requestAdapter);
    }
    /**
     * Instantiates a new {@link VideosequenceRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public VideosequenceRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videos/videosequence", pathParameters);
    }
    /**
     * Instantiates a new {@link VideosequenceRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public VideosequenceRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videos/videosequence", rawUrl);
    }
}
