package org.mbari.vars.vampiresquid.sdk.kiota.v1.videos.videosequence.name;

import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videos.videosequence.name.item.WithVideoSequenceNameItemRequestBuilder;
/**
 * Builds and executes requests for operations under /v1/videos/videosequence/name
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class NameRequestBuilder extends BaseRequestBuilder {
    /**
     * Gets an item from the org.mbari.vars.vampiresquid.sdk.kiota.v1.videos.videosequence.name.item collection
     * @param videoSequenceName Unique identifier of the item
     * @return a {@link WithVideoSequenceNameItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public WithVideoSequenceNameItemRequestBuilder byVideoSequenceName(@jakarta.annotation.Nonnull final String videoSequenceName) {
        Objects.requireNonNull(videoSequenceName);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("videoSequenceName", videoSequenceName);
        return new WithVideoSequenceNameItemRequestBuilder(urlTplParams, requestAdapter);
    }
    /**
     * Instantiates a new {@link NameRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public NameRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videos/videosequence/name", pathParameters);
    }
    /**
     * Instantiates a new {@link NameRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public NameRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videos/videosequence/name", rawUrl);
    }
}
