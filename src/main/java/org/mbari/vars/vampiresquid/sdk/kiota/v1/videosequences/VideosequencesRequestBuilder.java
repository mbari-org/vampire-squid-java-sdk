package org.mbari.vars.vampiresquid.sdk.kiota.v1.videosequences;

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
import org.mbari.vars.vampiresquid.sdk.kiota.models.VideoSequence;
import org.mbari.vars.vampiresquid.sdk.kiota.models.VideoSequenceCreate;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videosequences.camera.CameraRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videosequences.cameras.CamerasRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videosequences.item.WithUuItemRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videosequences.lastupdate.LastupdateRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videosequences.name.NameRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.videosequences.names.NamesRequestBuilder;
/**
 * Builds and executes requests for operations under /v1/videosequences
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class VideosequencesRequestBuilder extends BaseRequestBuilder {
    /**
     * The camera property
     * @return a {@link CameraRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public CameraRequestBuilder camera() {
        return new CameraRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The cameras property
     * @return a {@link CamerasRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public CamerasRequestBuilder cameras() {
        return new CamerasRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The lastupdate property
     * @return a {@link LastupdateRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public LastupdateRequestBuilder lastupdate() {
        return new LastupdateRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The name property
     * @return a {@link NameRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public NameRequestBuilder name() {
        return new NameRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The names property
     * @return a {@link NamesRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public NamesRequestBuilder names() {
        return new NamesRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * Gets an item from the org.mbari.vars.vampiresquid.sdk.kiota.v1.videosequences.item collection
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
     * Instantiates a new {@link VideosequencesRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public VideosequencesRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videosequences{?limit*,offset*}", pathParameters);
    }
    /**
     * Instantiates a new {@link VideosequencesRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public VideosequencesRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/videosequences{?limit*,offset*}", rawUrl);
    }
    /**
     * Find all video sequences
     * @return a {@link java.util.List<VideoSequence>}
     * @throws BadRequest When receiving a 400 status code
     * @throws NotFound When receiving a 404 status code
     * @throws ServerError When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public java.util.List<VideoSequence> get() {
        return get(null);
    }
    /**
     * Find all video sequences
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link java.util.List<VideoSequence>}
     * @throws BadRequest When receiving a 400 status code
     * @throws NotFound When receiving a 404 status code
     * @throws ServerError When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public java.util.List<VideoSequence> get(@jakarta.annotation.Nullable final java.util.function.Consumer<GetRequestConfiguration> requestConfiguration) {
        final RequestInformation requestInfo = toGetRequestInformation(requestConfiguration);
        final HashMap<String, ParsableFactory<? extends Parsable>> errorMapping = new HashMap<String, ParsableFactory<? extends Parsable>>();
        errorMapping.put("400", BadRequest::createFromDiscriminatorValue);
        errorMapping.put("404", NotFound::createFromDiscriminatorValue);
        errorMapping.put("500", ServerError::createFromDiscriminatorValue);
        return this.requestAdapter.sendCollection(requestInfo, errorMapping, VideoSequence::createFromDiscriminatorValue);
    }
    /**
     * Create a video sequence
     * @param body The request body
     * @return a {@link VideoSequence}
     * @throws BadRequest When receiving a 400 status code
     * @throws Unauthorized When receiving a 401 status code
     * @throws NotFound When receiving a 404 status code
     * @throws ServerError When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public VideoSequence post(@jakarta.annotation.Nonnull final VideoSequenceCreate body) {
        return post(body, null);
    }
    /**
     * Create a video sequence
     * @param body The request body
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link VideoSequence}
     * @throws BadRequest When receiving a 400 status code
     * @throws Unauthorized When receiving a 401 status code
     * @throws NotFound When receiving a 404 status code
     * @throws ServerError When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public VideoSequence post(@jakarta.annotation.Nonnull final VideoSequenceCreate body, @jakarta.annotation.Nullable final java.util.function.Consumer<PostRequestConfiguration> requestConfiguration) {
        Objects.requireNonNull(body);
        final RequestInformation requestInfo = toPostRequestInformation(body, requestConfiguration);
        final HashMap<String, ParsableFactory<? extends Parsable>> errorMapping = new HashMap<String, ParsableFactory<? extends Parsable>>();
        errorMapping.put("400", BadRequest::createFromDiscriminatorValue);
        errorMapping.put("401", Unauthorized::createFromDiscriminatorValue);
        errorMapping.put("404", NotFound::createFromDiscriminatorValue);
        errorMapping.put("500", ServerError::createFromDiscriminatorValue);
        return this.requestAdapter.send(requestInfo, errorMapping, VideoSequence::createFromDiscriminatorValue);
    }
    /**
     * Find all video sequences
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toGetRequestInformation() {
        return toGetRequestInformation(null);
    }
    /**
     * Find all video sequences
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
     * Create a video sequence
     * @param body The request body
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPostRequestInformation(@jakarta.annotation.Nonnull final VideoSequenceCreate body) {
        return toPostRequestInformation(body, null);
    }
    /**
     * Create a video sequence
     * @param body The request body
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPostRequestInformation(@jakarta.annotation.Nonnull final VideoSequenceCreate body, @jakarta.annotation.Nullable final java.util.function.Consumer<PostRequestConfiguration> requestConfiguration) {
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
     * @return a {@link VideosequencesRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public VideosequencesRequestBuilder withUrl(@jakarta.annotation.Nonnull final String rawUrl) {
        Objects.requireNonNull(rawUrl);
        return new VideosequencesRequestBuilder(rawUrl, requestAdapter);
    }
    /**
     * Find all video sequences
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
