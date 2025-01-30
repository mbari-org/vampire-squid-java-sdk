package org.mbari.vars.vampiresquid.sdk.kiota.v1.videoreferences.sha512;

import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videoreferences.sha512.item.WithSha512ItemRequestBuilder;
/**
 * Builds and executes requests for operations under /v1/videoreferences/sha512
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class Sha512RequestBuilder extends BaseRequestBuilder {
    /**
     * Gets an item from the org.mbari.vars.vampiresquid.sdk.kiota.v1.videoreferences.sha512.item collection
     * @param sha512 Unique identifier of the item
     * @return a {@link WithSha512ItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public WithSha512ItemRequestBuilder bySha512(@jakarta.annotation.Nonnull final String sha512) {
        Objects.requireNonNull(sha512);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("sha512", sha512);
        return new WithSha512ItemRequestBuilder(urlTplParams, requestAdapter);
    }
    /**
     * Instantiates a new {@link Sha512RequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public Sha512RequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videoreferences/sha512", pathParameters);
    }
    /**
     * Instantiates a new {@link Sha512RequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public Sha512RequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videoreferences/sha512", rawUrl);
    }
}
