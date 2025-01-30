package org.mbari.vars.vampiresquid.sdk.kiota.v1.videos.names;

import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videos.names.videosequence.VideosequenceRequestBuilder;
/**
 * Builds and executes requests for operations under /v1/videos/names
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class NamesRequestBuilder extends BaseRequestBuilder {
    /**
     * The videosequence property
     * @return a {@link VideosequenceRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public VideosequenceRequestBuilder videosequence() {
        return new VideosequenceRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * Instantiates a new {@link NamesRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public NamesRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videos/names", pathParameters);
    }
    /**
     * Instantiates a new {@link NamesRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public NamesRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videos/names", rawUrl);
    }
}
