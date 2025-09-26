package org.mbari.vars.vampiresquid.sdk.r1;

import java.net.URI;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.HexFormat;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import org.mbari.vars.vampiresquid.sdk.VampireSquidFactory;
import org.mbari.vars.vampiresquid.sdk.kiota.VampireSquid;
import org.mbari.vars.vampiresquid.sdk.kiota.models.NotFound;
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

    public VampireSquidKiotaClient(URI baseUri) {
        this(VampireSquidFactory.create(baseUri.toString()));
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
        return findOneOrNull(() ->
                vampireSquid.v1()
                        .media()
                        .videoreference()
                        .byVideoReferenceUuid(uuid)
                        .get())
                .thenApply(Media::fromKiota);
    }

    @Override
    public CompletableFuture<Media> findBySha512(byte[] sha512) {
        var hexSha256 = HexFormat.of().formatHex(sha512);
        return findOneOrNull(() ->
                vampireSquid.v1()
                        .media()
                        .sha512()
                        .bySha512(hexSha256)
                        .get()
        ).thenApply(Media::fromKiota);
    }

    @Override
    public CompletableFuture<Media> findByUri(URI uri) {
        return findOneOrNull(() ->
                vampireSquid.v1()
                        .media()
                        .uri()
                        .byUri(uri.toString())
                        .get()
        ).thenApply(Media::fromKiota);

    }

    @Override
    public CompletableFuture<List<Media>> findByVideoSequenceName(String videoSequenceName) {
        return findMany(() ->
                vampireSquid.v1()
                        .media()
                        .videosequence()
                        .byName(videoSequenceName)
                        .get()
        ).thenApply(list -> list.stream()
                .map(Media::fromKiota)
                .toList());

    }

    @Override
    public CompletableFuture<List<Media>> findByVideoName(String videoName) {
        return findMany(() ->
                vampireSquid.v1()
                        .media()
                        .video()
                        .byName(videoName)
                        .get()

        ).thenApply(list -> list.stream()
                .map(Media::fromKiota)
                .toList());

    }

    @Override
    public CompletableFuture<List<String>> findAllVideoSequenceNames() {
        return findMany(() ->
                vampireSquid.v1()
                        .videosequences()
                        .names()
                        .get());
    }


    @Override
    public CompletableFuture<List<Media>> findByCameraIdAndTimestamp(String cameraId, Instant timestamp) {
        return findMany(() ->
                vampireSquid.v1()
                        .media()
                        .camera()
                        .byCameraId(cameraId)
                        .byDatetimeId(timestamp.toString())
                        .get()
        ).thenApply(list -> list.stream()
                .map(Media::fromKiota)
                .toList());
    }

    @Override
    public CompletableFuture<List<Media>> findByCameraIdAndDate(String cameraId, Instant startTimestamp,
                                                                Instant endTimestamp) {
        return findMany(() ->
                vampireSquid.v1()
                        .media()
                        .camera()
                        .byCameraId(cameraId)
                        .byDatetimeId(startTimestamp.toString())
                        .byEndTimestamp(endTimestamp.toString())
                        .get()
        ).thenApply(list -> list.stream()
                .map(Media::fromKiota)
                .toList());
    }

    @Override
    public CompletableFuture<List<Media>> findByVideoSequenceNameAndTimestamp(String videoSequenceName,
                                                                              Instant timestamp) {
        throw new UnsupportedOperationException("Not implemented. We haven't used this yet");
    }

    @Override
    public CompletableFuture<List<String>> findAllCameraIds() {
        return findMany(() ->
                vampireSquid.v1()
                        .videosequences()
                        .cameras()
                        .get()
        );
    }

    @Override
    public CompletableFuture<List<URI>> findAllURIs() {
        return findMany(() ->
                vampireSquid.v1()
                        .videoreferences()
                        .uris()
                        .get()
        ).thenApply(uriStrings ->
                uriStrings.stream()
                        .map(URI::create)
                        .toList()
        );
    }

    @Override
    public CompletableFuture<List<Media>> findConcurrentByVideoReferenceUuid(UUID uuid) {
        return findMany(() ->
                vampireSquid.v1()
                        .media()
                        .concurrent()
                        .byVideoReferenceUuid(uuid)
                        .get()
        ).thenApply(response ->
                response.stream()
                        .map(Media::fromKiota)
                        .toList()
        );

    }

    @Override
    public CompletableFuture<List<Media>> findByFilename(String filename) {
        return findMany(() ->
                vampireSquid.v1()
                        .media()
                        .videoreference()
                        .filename()
                        .byFilename(filename)
                        .get()
        ).thenApply(response ->
                response.stream()
                        .map(Media::fromKiota)
                        .toList()
        );
    }

    @Override
    public CompletableFuture<LastUpdate> findLastVideoSequenceUpdate(UUID uuid) {
        return findOne(() ->
                vampireSquid.v1()
                        .videosequences()
                        .lastupdate()
                        .byUuid(uuid)
                        .get()
        ).thenApply(response ->
                response.map(LastUpdate::fromKiota).orElse(null)
        );

    }

    @Override
    public CompletableFuture<LastUpdate> findLastVideoUpdate(UUID uuid) {
        return findOne(() ->
                vampireSquid.v1()
                        .videos()
                        .lastupdate()
                        .byUuid(uuid)
                        .get()
        ).thenApply(response ->
                response.map(LastUpdate::fromKiota).orElse(null)
        );
    }

    @Override
    public CompletableFuture<LastUpdate> findLastVideoReferenceUpdate(UUID uuid) {
        return findOne(() ->
                vampireSquid.v1()
                        .videoreferences()
                        .lastupdate()
                        .byUuid(uuid)
                        .get()
        ).thenApply(response ->
                response.map(LastUpdate::fromKiota).orElse(null)
        );
    }

    @Override
    public CompletableFuture<List<String>> findVideoSequenceNamesByCameraId(String cameraId) {
        return findMany(() ->
                vampireSquid.v1()
                        .videosequences()
                        .names()
                        .camera()
                        .byCameraid(cameraId)
                        .get()
        );
    }

    @Override
    public CompletableFuture<List<String>> findVideoNamesByVideoSequenceName(String videoSequenceName) {
        return findMany(() ->
                vampireSquid.v1()
                        .videos()
                        .names()
                        .videosequence()
                        .byVideoSequenceName(videoSequenceName)
                        .get()
        );

    }


    private <A> CompletableFuture<Optional<A>> findOne(Supplier<A> supplier) {
        return findOneOrNull(supplier).thenApply(Optional::ofNullable);
    }

    private <A> CompletableFuture<A> findOneOrNull(Supplier<A> supplier) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return supplier.get();
            } catch (NotFound e) {
                return null;
            }
        }, executor);
    }

    private <A> CompletableFuture<List<A>> findMany(Supplier<List<A>> supplier) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return supplier.get();
            } catch (NotFound e) {
                return List.of();
            }
        }, executor);
    }

    /**
     * Lists video sequences with pagination. Be aware that the pagination is for the video sequences, not the media.
     * So if a video sequence has many media items, they will all be returned in the response.
     *
     * @param pageNumber The page number (1-based)
     * @param pageSize The number of items per page
     * @return A CompletableFuture containing a list of Media objects representing all media in a video sequences
     */
    @Override
    public CompletableFuture<List<Media>> listVideoSequences(int pageNumber, int pageSize) {
        var limit = pageSize;
        var offset = (pageNumber - 1) * pageSize;
        return findMany(() -> {
            var response = vampireSquid.v1()
                    .videosequences()
                    .get(requestConfig -> {
                        requestConfig.queryParameters.limit = limit;
                        requestConfig.queryParameters.offset = offset;
                    });

            return response.stream()
                    .flatMap(xs -> Media.fromKiota(xs).stream())
                    .toList();

        });
    }


}
