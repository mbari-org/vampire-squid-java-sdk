package org.mbari.vars.vampiresquid.sdk.kiota.v1;

import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.auth.AuthRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.health.HealthRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.media.MediaRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videoreferences.VideoreferencesRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videos.VideosRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videosequences.VideosequencesRequestBuilder;
/**
 * Builds and executes requests for operations under /v1
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class V1RequestBuilder extends BaseRequestBuilder {
    /**
     * The auth property
     * @return a {@link AuthRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public AuthRequestBuilder auth() {
        return new AuthRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The health property
     * @return a {@link HealthRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public HealthRequestBuilder health() {
        return new HealthRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The media property
     * @return a {@link MediaRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public MediaRequestBuilder media() {
        return new MediaRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The videoreferences property
     * @return a {@link VideoreferencesRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public VideoreferencesRequestBuilder videoreferences() {
        return new VideoreferencesRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The videos property
     * @return a {@link VideosRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public VideosRequestBuilder videos() {
        return new VideosRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The videosequences property
     * @return a {@link VideosequencesRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public VideosequencesRequestBuilder videosequences() {
        return new VideosequencesRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * Instantiates a new {@link V1RequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public V1RequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1", pathParameters);
    }
    /**
     * Instantiates a new {@link V1RequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public V1RequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1", rawUrl);
    }
}
