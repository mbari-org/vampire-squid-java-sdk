package org.mbari.vars.vampiresquid.sdk.kiota.v1.media;

import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.BaseRequestConfiguration;
import com.microsoft.kiota.HttpMethod;
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
import org.mbari.vars.vampiresquid.sdk.kiota.models.Media;
import org.mbari.vars.vampiresquid.sdk.kiota.models.NotFound;
import org.mbari.vars.vampiresquid.sdk.kiota.models.ServerError;
import org.mbari.vars.vampiresquid.sdk.kiota.models.Unauthorized;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.media.camera.CameraRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.media.concurrent.ConcurrentRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.media.item.WithVideoReferenceUuItemRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.media.move.MoveRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.media.sha512.Sha512RequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.media.uri.UriRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.media.video.VideoRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.media.videoreference.VideoreferenceRequestBuilder;
import org.mbari.vars.vampiresquid.sdk.kiota.v1.media.videosequence.VideosequenceRequestBuilder;
/**
 * Builds and executes requests for operations under /v1/media
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class MediaRequestBuilder extends BaseRequestBuilder {
    /**
     * The camera property
     * @return a {@link CameraRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public CameraRequestBuilder camera() {
        return new CameraRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The concurrent property
     * @return a {@link ConcurrentRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public ConcurrentRequestBuilder concurrent() {
        return new ConcurrentRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The move property
     * @return a {@link MoveRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public MoveRequestBuilder move() {
        return new MoveRequestBuilder(pathParameters, requestAdapter);
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
     * The video property
     * @return a {@link VideoRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public VideoRequestBuilder video() {
        return new VideoRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The videoreference property
     * @return a {@link VideoreferenceRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public VideoreferenceRequestBuilder videoreference() {
        return new VideoreferenceRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The videosequence property
     * @return a {@link VideosequenceRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public VideosequenceRequestBuilder videosequence() {
        return new VideosequenceRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * Gets an item from the org.mbari.vars.vampiresquid.sdk.kiota.v1.media.item collection
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
     * Instantiates a new {@link MediaRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public MediaRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/media", pathParameters);
    }
    /**
     * Instantiates a new {@link MediaRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public MediaRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/v1/media", rawUrl);
    }
    /**
     * Create a new media.(The `uuid` param will be ignored if present.)
     * @param body The request body
     * @return a {@link Media}
     * @throws BadRequest When receiving a 400 status code
     * @throws Unauthorized When receiving a 401 status code
     * @throws NotFound When receiving a 404 status code
     * @throws ServerError When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public Media post(@jakarta.annotation.Nonnull final Media body) {
        return post(body, null);
    }
    /**
     * Create a new media.(The `uuid` param will be ignored if present.)
     * @param body The request body
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link Media}
     * @throws BadRequest When receiving a 400 status code
     * @throws Unauthorized When receiving a 401 status code
     * @throws NotFound When receiving a 404 status code
     * @throws ServerError When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public Media post(@jakarta.annotation.Nonnull final Media body, @jakarta.annotation.Nullable final java.util.function.Consumer<PostRequestConfiguration> requestConfiguration) {
        Objects.requireNonNull(body);
        final RequestInformation requestInfo = toPostRequestInformation(body, requestConfiguration);
        final HashMap<String, ParsableFactory<? extends Parsable>> errorMapping = new HashMap<String, ParsableFactory<? extends Parsable>>();
        errorMapping.put("400", BadRequest::createFromDiscriminatorValue);
        errorMapping.put("401", Unauthorized::createFromDiscriminatorValue);
        errorMapping.put("404", NotFound::createFromDiscriminatorValue);
        errorMapping.put("500", ServerError::createFromDiscriminatorValue);
        return this.requestAdapter.send(requestInfo, errorMapping, Media::createFromDiscriminatorValue);
    }
    /**
     * Update an existing media. (All uuid params will be ignored if present.)
     * @param body The request body
     * @return a {@link Media}
     * @throws BadRequest When receiving a 400 status code
     * @throws Unauthorized When receiving a 401 status code
     * @throws NotFound When receiving a 404 status code
     * @throws ServerError When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public Media put(@jakarta.annotation.Nonnull final Media body) {
        return put(body, null);
    }
    /**
     * Update an existing media. (All uuid params will be ignored if present.)
     * @param body The request body
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link Media}
     * @throws BadRequest When receiving a 400 status code
     * @throws Unauthorized When receiving a 401 status code
     * @throws NotFound When receiving a 404 status code
     * @throws ServerError When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public Media put(@jakarta.annotation.Nonnull final Media body, @jakarta.annotation.Nullable final java.util.function.Consumer<PutRequestConfiguration> requestConfiguration) {
        Objects.requireNonNull(body);
        final RequestInformation requestInfo = toPutRequestInformation(body, requestConfiguration);
        final HashMap<String, ParsableFactory<? extends Parsable>> errorMapping = new HashMap<String, ParsableFactory<? extends Parsable>>();
        errorMapping.put("400", BadRequest::createFromDiscriminatorValue);
        errorMapping.put("401", Unauthorized::createFromDiscriminatorValue);
        errorMapping.put("404", NotFound::createFromDiscriminatorValue);
        errorMapping.put("500", ServerError::createFromDiscriminatorValue);
        return this.requestAdapter.send(requestInfo, errorMapping, Media::createFromDiscriminatorValue);
    }
    /**
     * Create a new media.(The `uuid` param will be ignored if present.)
     * @param body The request body
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPostRequestInformation(@jakarta.annotation.Nonnull final Media body) {
        return toPostRequestInformation(body, null);
    }
    /**
     * Create a new media.(The `uuid` param will be ignored if present.)
     * @param body The request body
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPostRequestInformation(@jakarta.annotation.Nonnull final Media body, @jakarta.annotation.Nullable final java.util.function.Consumer<PostRequestConfiguration> requestConfiguration) {
        Objects.requireNonNull(body);
        final RequestInformation requestInfo = new RequestInformation(HttpMethod.POST, urlTemplate, pathParameters);
        requestInfo.configure(requestConfiguration, PostRequestConfiguration::new);
        requestInfo.headers.tryAdd("Accept", "application/json");
        requestInfo.setContentFromParsable(requestAdapter, "application/json", body);
        return requestInfo;
    }
    /**
     * Update an existing media. (All uuid params will be ignored if present.)
     * @param body The request body
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPutRequestInformation(@jakarta.annotation.Nonnull final Media body) {
        return toPutRequestInformation(body, null);
    }
    /**
     * Update an existing media. (All uuid params will be ignored if present.)
     * @param body The request body
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPutRequestInformation(@jakarta.annotation.Nonnull final Media body, @jakarta.annotation.Nullable final java.util.function.Consumer<PutRequestConfiguration> requestConfiguration) {
        Objects.requireNonNull(body);
        final RequestInformation requestInfo = new RequestInformation(HttpMethod.PUT, urlTemplate, pathParameters);
        requestInfo.configure(requestConfiguration, PutRequestConfiguration::new);
        requestInfo.headers.tryAdd("Accept", "application/json");
        requestInfo.setContentFromParsable(requestAdapter, "application/json", body);
        return requestInfo;
    }
    /**
     * Returns a request builder with the provided arbitrary URL. Using this method means any other path or query parameters are ignored.
     * @param rawUrl The raw URL to use for the request builder.
     * @return a {@link MediaRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public MediaRequestBuilder withUrl(@jakarta.annotation.Nonnull final String rawUrl) {
        Objects.requireNonNull(rawUrl);
        return new MediaRequestBuilder(rawUrl, requestAdapter);
    }
    /**
     * Configuration for the request such as headers, query parameters, and middleware options.
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public class PostRequestConfiguration extends BaseRequestConfiguration {
    }
    /**
     * Configuration for the request such as headers, query parameters, and middleware options.
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public class PutRequestConfiguration extends BaseRequestConfiguration {
    }
}
