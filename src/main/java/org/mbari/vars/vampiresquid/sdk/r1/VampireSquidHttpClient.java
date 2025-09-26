package org.mbari.vars.vampiresquid.sdk.r1;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.mbari.vars.vampiresquid.sdk.r1.etc.gson.DurationConverter;
import org.mbari.vars.vampiresquid.sdk.r1.etc.gson.InstantConverter;
import org.mbari.vars.vampiresquid.sdk.r1.models.Authorization;
import org.mbari.vars.vampiresquid.sdk.r1.models.LastUpdate;
import org.mbari.vars.vampiresquid.sdk.r1.models.Media;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class VampireSquidHttpClient extends BaseHttpClient implements MediaService {

    private final JwtHttpClient jwtHttpClient;
    private final Type TYPE_LIST_STRING = new TypeToken<ArrayList<String>>(){}.getType();
    private final Type TYPE_LIST_UUID = new TypeToken<ArrayList<UUID>>(){}.getType();
    private final Type TYPE_LIST_MEDIA = new TypeToken<ArrayList<Media>>(){}.getType();

    private final Gson gson = newGson();

    public VampireSquidHttpClient(HttpClient client, URI baseUri, String apiKey) {
        super(client, baseUri);
        this.jwtHttpClient = new JwtHttpClient(client,
                buildUri("/auth"),
                "Authorization", "APIKEY " + apiKey,
                body -> gson.fromJson(body, Authorization.class));
    }

    public VampireSquidHttpClient(String baseUri, Duration timeout, String apikey) {
        this(newHttpClient(timeout), URI.create(baseUri), apikey);
    }

    public static Gson newGson() {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                .registerTypeAdapter(Duration.class, new DurationConverter())
                .registerTypeAdapter(Instant.class, new InstantConverter());

        return gsonBuilder.create();
    }

    private Authorization authorizeIfNeeded() {
        return jwtHttpClient.authorizeIfNeeded();
    }

    @Override
    public CompletableFuture<Media> create(Media media) {
        var json = gson.toJson(media);
        var uri = buildUri("/media");
        var auth = authorizeIfNeeded();
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public CompletableFuture<Media> create(String videoSequenceName, String cameraId, String videoName, URI uri,
            Instant startTimestamp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public CompletableFuture<Media> update(UUID videoReferenceUuid, Instant startTimestamp, Duration duration) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public CompletableFuture<Media> update(Media media) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public CompletableFuture<Boolean> delete(UUID videoReferenceUuid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public CompletableFuture<Media> findByUuid(UUID uuid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUuid'");
    }

    @Override
    public CompletableFuture<Media> findBySha512(byte[] sha512) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBySha512'");
    }

    @Override
    public CompletableFuture<Media> findByUri(URI uri) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUri'");
    }

    @Override
    public CompletableFuture<List<Media>> findByVideoSequenceName(String videoSequenceName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByVideoSequenceName'");
    }

    @Override
    public CompletableFuture<List<Media>> findByVideoName(String videoName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByVideoName'");
    }

    @Override
    public CompletableFuture<List<String>> findAllVideoSequenceNames() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllVideoSequenceNames'");
    }

    @Override
    public CompletableFuture<List<Media>> findByCameraIdAndTimestamp(String cameraId, Instant timestamp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCameraIdAndTimestamp'");
    }

    @Override
    public CompletableFuture<List<Media>> findByCameraIdAndDate(String cameraId, Instant startTimestamp,
            Instant endTimestamp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCameraIdAndDate'");
    }

    @Override
    public CompletableFuture<List<Media>> findByVideoSequenceNameAndTimestamp(String videoSequenceName,
            Instant timestamp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByVideoSequenceNameAndTimestamp'");
    }

    @Override
    public CompletableFuture<List<String>> findAllCameraIds() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllCameraIds'");
    }

    @Override
    public CompletableFuture<List<URI>> findAllURIs() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllURIs'");
    }

    @Override
    public CompletableFuture<List<Media>> findConcurrentByVideoReferenceUuid(UUID uuid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findConcurrentByVideoReferenceUuid'");
    }

    @Override
    public CompletableFuture<List<Media>> findByFilename(String filename) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByFilename'");
    }

    @Override
    public CompletableFuture<LastUpdate> findLastVideoSequenceUpdate(UUID uuid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findLastVideoSequenceUpdate'");
    }

    @Override
    public CompletableFuture<LastUpdate> findLastVideoUpdate(UUID uuid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findLastVideoUpdate'");
    }

    @Override
    public CompletableFuture<LastUpdate> findLastVideoReferenceUpdate(UUID uuid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findLastVideoReferenceUpdate'");
    }

    @Override
    public CompletableFuture<List<String>> findVideoSequenceNamesByCameraId(String cameraId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findVideoSequenceNamesByCameraId'");
    }

    @Override
    public CompletableFuture<List<String>> findVideoNamesByVideoSequenceName(String videoSequenceName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findVideoNamesByVideoSequenceName'");
    }

    @Override
    public CompletableFuture<List<Media>> listVideoSequences(int pageNumber, int pageSize) {
        throw new UnsupportedOperationException("Unimplemented method 'listVideoSequences'");
    }
    
}
