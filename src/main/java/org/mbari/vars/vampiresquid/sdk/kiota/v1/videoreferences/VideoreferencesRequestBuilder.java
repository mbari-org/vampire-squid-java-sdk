package org.mbari.vars.vampiresquid.sdk.kiota.v1.videoreferences;

import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.BaseRequestConfiguration;
import com.microsoft.kiota.HttpMethod;
import com.microsoft.kiota.QueryParameters;
import com.microsoft.kiota.RequestAdapter;
import com.microsoft.kiota.RequestInformation;
import com.microsoft.kiota.RequestOption;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParsableFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.mbari.vars.vampiresquid.sdk.kiota.models.BadRequest;
import org.mbari.vars.vampiresquid.sdk.kiota.models.NotFound;
import org.mbari.vars.vampiresquid.sdk.kiota.models.ServerError;
import org.mbari.vars.vampiresquid.sdk.kiota.models.Unauthorized;
import org.mbari.vars.vampiresquid.sdk.kiota.models.VideoReference;
import org.mbari.vars.vampiresquid.sdk.kiota.models.VideoReferenceCreate;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videoreferences.item.WithUuItemRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videoreferences.lastupdate.LastupdateRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videoreferences.sha512.Sha512RequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videoreferences.uri.UriRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videoreferences.uris.UrisRequestBuilder;
/**
 * Builds and executes requests for operations under /v1/videoreferences
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class VideoreferencesRequestBuilder extends BaseRequestBuilder {
    /**
     * The lastupdate property
     * @return a {@link LastupdateRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public LastupdateRequestBuilder lastupdate() {
        return new LastupdateRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The sha512 property
     * @return a {@link Sha512RequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public Sha512RequestBuilder sha512() {
        return new Sha512RequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The uri property
     * @return a {@link UriRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public UriRequestBuilder uri() {
        return new UriRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The uris property
     * @return a {@link UrisRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public UrisRequestBuilder uris() {
        return new UrisRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * Gets an item from the org.mbari.vars.vampiresquid.sdk.kiota.v1.videoreferences.item collection
     * @param uuid Unique identifier of the item
     * @return a {@link WithUuItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public WithUuItemRequestBuilder byUuid(@jakarta.annotation.Nonnull final UUID uuid) {
        Objects.requireNonNull(uuid);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("uuid", uuid);
        return new WithUuItemRequestBuilder(urlTplParams, requestAdapter);
    }
    /**
     * Instantiates a new {@link VideoreferencesRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public VideoreferencesRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videoreferences{?limit*,offset*}", pathParameters);
    }
    /**
     * Instantiates a new {@link VideoreferencesRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public VideoreferencesRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videoreferences{?limit*,offset*}", rawUrl);
    }
    /**
     * Find all video references
     * @return a {@link java.util.List<VideoReference>}
     * @throws BadRequest When receiving a 400 status code
     * @throws NotFound When receiving a 404 status code
     * @throws ServerError When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public java.util.List<VideoReference> get() {
        return get(null);
    }
    /**
     * Find all video references
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link java.util.List<VideoReference>}
     * @throws BadRequest When receiving a 400 status code
     * @throws NotFound When receiving a 404 status code
     * @throws ServerError When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public java.util.List<VideoReference> get(@jakarta.annotation.Nullable final java.util.function.Consumer<GetRequestConfiguration> requestConfiguration) {
        final RequestInformation requestInfo = toGetRequestInformation(requestConfiguration);
        final HashMap<String, ParsableFactory<? extends Parsable>> errorMapping = new HashMap<String, ParsableFactory<? extends Parsable>>();
        errorMapping.put("400", BadRequest::createFromDiscriminatorValue);
        errorMapping.put("404", NotFound::createFromDiscriminatorValue);
        errorMapping.put("500", ServerError::createFromDiscriminatorValue);
        return this.requestAdapter.sendCollection(requestInfo, errorMapping, VideoReference::createFromDiscriminatorValue);
    }
    /**
     * Create a video reference
     * @param body The request body
     * @return a {@link VideoReference}
     * @throws BadRequest When receiving a 400 status code
     * @throws Unauthorized When receiving a 401 status code
     * @throws NotFound When receiving a 404 status code
     * @throws ServerError When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public VideoReference post(@jakarta.annotation.Nonnull final VideoReferenceCreate body) {
        return post(body, null);
    }
    /**
     * Create a video reference
     * @param body The request body
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link VideoReference}
     * @throws BadRequest When receiving a 400 status code
     * @throws Unauthorized When receiving a 401 status code
     * @throws NotFound When receiving a 404 status code
     * @throws ServerError When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public VideoReference post(@jakarta.annotation.Nonnull final VideoReferenceCreate body, @jakarta.annotation.Nullable final java.util.function.Consumer<PostRequestConfiguration> requestConfiguration) {
        Objects.requireNonNull(body);
        final RequestInformation requestInfo = toPostRequestInformation(body, requestConfiguration);
        final HashMap<String, ParsableFactory<? extends Parsable>> errorMapping = new HashMap<String, ParsableFactory<? extends Parsable>>();
        errorMapping.put("400", BadRequest::createFromDiscriminatorValue);
        errorMapping.put("401", Unauthorized::createFromDiscriminatorValue);
        errorMapping.put("404", NotFound::createFromDiscriminatorValue);
        errorMapping.put("500", ServerError::createFromDiscriminatorValue);
        return this.requestAdapter.send(requestInfo, errorMapping, VideoReference::createFromDiscriminatorValue);
    }
    /**
     * Find all video references
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toGetRequestInformation() {
        return toGetRequestInformation(null);
    }
    /**
     * Find all video references
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toGetRequestInformation(@jakarta.annotation.Nullable final java.util.function.Consumer<GetRequestConfiguration> requestConfiguration) {
        final RequestInformation requestInfo = new RequestInformation(HttpMethod.GET, urlTemplate, pathParameters);
        requestInfo.configure(requestConfiguration, GetRequestConfiguration::new, x -> x.queryParameters);
        requestInfo.headers.tryAdd("Accept", "application/json");
        return requestInfo;
    }
    /**
     * Create a video reference
     * @param body The request body
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPostRequestInformation(@jakarta.annotation.Nonnull final VideoReferenceCreate body) {
        return toPostRequestInformation(body, null);
    }
    /**
     * Create a video reference
     * @param body The request body
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPostRequestInformation(@jakarta.annotation.Nonnull final VideoReferenceCreate body, @jakarta.annotation.Nullable final java.util.function.Consumer<PostRequestConfiguration> requestConfiguration) {
        Objects.requireNonNull(body);
        final RequestInformation requestInfo = new RequestInformation(HttpMethod.POST, urlTemplate, pathParameters);
        requestInfo.configure(requestConfiguration, PostRequestConfiguration::new);
        requestInfo.headers.tryAdd("Accept", "application/json");
        requestInfo.setContentFromParsable(requestAdapter, "application/json", body);
        return requestInfo;
    }
    /**
     * Returns a request builder with the provided arbitrary URL. Using this method means any other path or query parameters are ignored.
     * @param rawUrl The raw URL to use for the request builder.
     * @return a {@link VideoreferencesRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public VideoreferencesRequestBuilder withUrl(@jakarta.annotation.Nonnull final String rawUrl) {
        Objects.requireNonNull(rawUrl);
        return new VideoreferencesRequestBuilder(rawUrl, requestAdapter);
    }
    /**
     * Find all video references
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public class GetQueryParameters implements QueryParameters {
        @jakarta.annotation.Nullable
        public Integer limit;
        @jakarta.annotation.Nullable
        public Integer offset;
        /**
         * Extracts the query parameters into a map for the URI template parsing.
         * @return a {@link Map<String, Object>}
         */
        @jakarta.annotation.Nonnull
        public Map<String, Object> toQueryParameters() {
            final Map<String, Object> allQueryParams = new HashMap();
            allQueryParams.put("limit", limit);
            allQueryParams.put("offset", offset);
            return allQueryParams;
        }
    }
    /**
     * Configuration for the request such as headers, query parameters, and middleware options.
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public class GetRequestConfiguration extends BaseRequestConfiguration {
        /**
         * Request query parameters
         */
        @jakarta.annotation.Nullable
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
    /**
     * Configuration for the request such as headers, query parameters, and middleware options.
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public class PostRequestConfiguration extends BaseRequestConfiguration {
    }
}
