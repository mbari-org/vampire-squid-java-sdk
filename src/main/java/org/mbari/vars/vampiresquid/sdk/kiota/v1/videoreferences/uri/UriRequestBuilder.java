package org.mbari.vars.vampiresquid.sdk.kiota.v1.videoreferences.uri;

import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videoreferences.uri.item.WithUriItemRequestBuilder;
/**
 * Builds and executes requests for operations under /v1/videoreferences/uri
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class UriRequestBuilder extends BaseRequestBuilder {
    /**
     * Gets an item from the org.mbari.vars.vampiresquid.sdk.kiota.v1.videoreferences.uri.item collection
     * @param uri Unique identifier of the item
     * @return a {@link WithUriItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public WithUriItemRequestBuilder byUri(@jakarta.annotation.Nonnull final String uri) {
        Objects.requireNonNull(uri);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("uri", uri);
        return new WithUriItemRequestBuilder(urlTplParams, requestAdapter);
    }
    /**
     * Instantiates a new {@link UriRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public UriRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videoreferences/uri", pathParameters);
    }
    /**
     * Instantiates a new {@link UriRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public UriRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videoreferences/uri", rawUrl);
    }
}
