package org.mbari.vars.vampiresquid.sdk.r1;

import java.net.URI;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.HexFormat;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.mbari.vars.vampiresquid.sdk.VampireSquidFactory;
import org.mbari.vars.vampiresquid.sdk.kiota.VampireSquid;
import org.mbari.vars.vampiresquid.sdk.r1.models.LastUpdate;
import org.mbari.vars.vampiresquid.sdk.r1.models.Media;

public class VampireSquidKiotaClient implements MediaService {

    private final VampireSquid vampireSquid;
    protected final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

    public VampireSquidKiotaClient(VampireSquid vampireSquid) {
        this.vampireSquid = vampireSquid;
    }

    public VampireSquidKiotaClient(URI baseUri, String apiKey) {
        this(VampireSquidFactory.create(baseUri.toString(), apiKey));
    }

    @Override
    public CompletableFuture<Media> create(Media media) {
        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                .media()
                .post(media.toKiota());

            return Media.fromKiota(response);
        }, executor);
    }

    @Override
    public CompletableFuture<Media> create(String videoSequenceName, String cameraId, String videoName, URI uri,
            Instant startTimestamp) {
        
        var kMedia = new org.mbari.vars.vampiresquid.sdk.kiota.models.Media();
        kMedia.setVideoSequenceName(videoSequenceName);
        kMedia.setCameraId(cameraId);
        kMedia.setVideoName(videoName);
        kMedia.setUri(uri.toString());
        if (startTimestamp != null) {
            var offsetTimestamp = startTimestamp.atOffset(ZoneOffset.UTC);
            kMedia.setStartTimestamp(offsetTimestamp);
        }

        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                .media()
                .post(kMedia);

            return Media.fromKiota(response);
        }, executor);

    }

    @Override
    public CompletableFuture<Media> update(UUID videoReferenceUuid, Instant startTimestamp, Duration duration) {
        var kMedia = new org.mbari.vars.vampiresquid.sdk.kiota.models.Media();
        kMedia.setStartTimestamp(startTimestamp.atOffset(ZoneOffset.UTC));
        kMedia.setDurationMillis(duration.toMillis());

        // TODO Auto-generated method stub
        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                .media()
                .byVideoReferenceUuid(videoReferenceUuid)
                .put(kMedia);

            return Media.fromKiota(response);
        }, executor);
    }

    @Override
    public CompletableFuture<Media> update(Media media) {
        var kMedia = media.toKiota();
        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                .media()
                .byVideoReferenceUuid(media.getVideoReferenceUuid())
                .put(kMedia);

            return Media.fromKiota(response);
        }, executor);
    
    }

    @Override
    public CompletableFuture<Boolean> delete(UUID videoReferenceUuid) {
        return CompletableFuture.supplyAsync(() -> {
            vampireSquid.v1()
                .videoreferences()
                .byUuid(videoReferenceUuid)
                .delete();

            return true;
        }, executor);
    }

    @Override
    public CompletableFuture<Media> findByUuid(UUID uuid) {
        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                .media()
                .videoreference()
                .byVideoReferenceUuid(uuid)
                .get();

            return Media.fromKiota(response);
        }, executor);
        
    }

    @Override
    public CompletableFuture<Media> findBySha512(byte[] sha512) {
        var hexSha256 = HexFormat.of().formatHex(sha512);
        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                .media()
                .sha512()
                .bySha512(hexSha256)
                .get();

            return Media.fromKiota(response);
        }, executor);
        
    }

    @Override
    public CompletableFuture<Media> findByUri(URI uri) {
        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                .media()
                .uri()
                .byUri(uri.toString())
                .get();

            return Media.fromKiota(response);
        }, executor);
    }

    @Override
    public CompletableFuture<List<Media>> findByVideoSequenceName(String videoSequenceName) {
        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                .media()
                .videosequence()
                .byName(videoSequenceName)
                .get();

            return response.stream()
                .map(Media::fromKiota)
                .toList();
        }, executor);
        
    }

    @Override
    public CompletableFuture<List<Media>> findByVideoName(String videoName) {
        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                .media()
                .video()
                .byName(videoName)
                .get();

            return response.stream()
                .map(Media::fromKiota)
                .toList();
        }, executor);
        
    }

    @Override
    public CompletableFuture<List<String>> findAllVideoSequenceNames() {
        return CompletableFuture.supplyAsync(() -> {
            return vampireSquid.v1()
                .videosequences()
                .names()
                .get();

        }, executor);
        
    }

    @Override
    public CompletableFuture<List<Media>> findByCameraIdAndTimestamp(String cameraId, Instant timestamp) {
        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                .media()
                .camera()
                .byCameraId(cameraId)
                .byDatetimeId(timestamp.toString())
                .get();

            return response.stream()
                .map(Media::fromKiota)
                .toList();
        }, executor);
    }

    @Override
    public CompletableFuture<List<Media>> findByCameraIdAndDate(String cameraId, Instant startTimestamp,
            Instant endTimestamp) {
        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                .media()
                .camera()
                .byCameraId(cameraId)
                .byDatetimeId(startTimestamp.toString())
                .byEndTimestamp(endTimestamp.toString())
                .get();

            return response.stream()
                .map(Media::fromKiota)
                .toList();
        }, executor);
    }

    @Override
    public CompletableFuture<List<Media>> findByVideoSequenceNameAndTimestamp(String videoSequenceName,
            Instant timestamp) {
        throw new UnsupportedOperationException("Not implemented. We haven't used this yet");
    }

    @Override
    public CompletableFuture<List<String>> findAllCameraIds() {
        return CompletableFuture.supplyAsync(() -> {
            return vampireSquid.v1()
                .videosequences()
                .cameras()
                .get();
        }, executor);
    }

    @Override
    public CompletableFuture<List<URI>> findAllURIs() {
        return CompletableFuture.supplyAsync(() -> {
            var uriStrings = vampireSquid.v1()
                .videoreferences()
                .uris()
                .get();

            return uriStrings.stream()
                .map(URI::create)
                .toList();
        }, executor);
    }

    @Override
    public CompletableFuture<List<Media>> findConcurrentByVideoReferenceUuid(UUID uuid) {
        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                .media()
                .concurrent()
                .byVideoReferenceUuid(uuid)
                .get();

            return response.stream()
                .map(Media::fromKiota)
                .toList();
        }, executor);
        
    }

    @Override
    public CompletableFuture<List<Media>> findByFilename(String filename) {
        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                .media()
                .videoreference()
                .filename()
                .byFilename(filename)
                .get();

            return response.stream()
                .map(Media::fromKiota)
                .toList();
        }, executor);
    }

    @Override
    public CompletableFuture<LastUpdate> findLastVideoSequenceUpdate(UUID uuid) {
        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                .videosequences()
                .lastupdate()
                .byUuid(uuid)
                .get();

            return LastUpdate.fromKiota(response);
        }, executor);
        
    }

    @Override
    public CompletableFuture<LastUpdate> findLastVideoUpdate(UUID uuid) {
        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                .videos()
                .lastupdate()
                .byUuid(uuid)
                .get();

            return LastUpdate.fromKiota(response);
        }, executor);
    }

    @Override
    public CompletableFuture<LastUpdate> findLastVideoReferenceUpdate(UUID uuid) {
        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                .videoreferences()
                .lastupdate()
                .byUuid(uuid)
                .get();

            return LastUpdate.fromKiota(response);
        }, executor);
    }

    @Override
    public CompletableFuture<List<String>> findVideoSequenceNamesByCameraId(String cameraId) {
        return CompletableFuture.supplyAsync(() -> {
            return vampireSquid.v1()
                .videosequences()
                .names()
                .camera()
                .byCameraid(cameraId)
                .get();
        }, executor);
    }

    @Override
    public CompletableFuture<List<String>> findVideoNamesByVideoSequenceName(String videoSequenceName) {
        return CompletableFuture.supplyAsync(() -> {
            return vampireSquid.v1()
                .videos()
                .names()
                .videosequence()
                .byVideoSequenceName(videoSequenceName)
                .get();
        }, executor);
        
    }
    
}
