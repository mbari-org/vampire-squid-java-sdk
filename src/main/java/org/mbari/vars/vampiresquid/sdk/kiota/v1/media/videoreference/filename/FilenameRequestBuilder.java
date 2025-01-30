package org.mbari.vars.vampiresquid.sdk.kiota.v1.media.videoreference.filename;

import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.media.videoreference.filename.item.WithFilenameItemRequestBuilder;
/**
 * Builds and executes requests for operations under /v1/media/videoreference/filename
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class FilenameRequestBuilder extends BaseRequestBuilder {
    /**
     * Gets an item from the org.mbari.vars.vampiresquid.sdk.kiota.v1.media.videoreference.filename.item collection
     * @param filename Unique identifier of the item
     * @return a {@link WithFilenameItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public WithFilenameItemRequestBuilder byFilename(@jakarta.annotation.Nonnull final String filename) {
        Objects.requireNonNull(filename);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("filename", filename);
        return new WithFilenameItemRequestBuilder(urlTplParams, requestAdapter);
    }
    /**
     * Instantiates a new {@link FilenameRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public FilenameRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/media/videoreference/filename", pathParameters);
    }
    /**
     * Instantiates a new {@link FilenameRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public FilenameRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/media/videoreference/filename", rawUrl);
    }
}
