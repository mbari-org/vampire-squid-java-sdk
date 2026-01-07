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

/**
 * Implementation of {@link MediaService} that wraps the Kiota-generated VampireSquid API client.
 * <p>
 * This class provides a convenient, business-friendly interface for interacting with the
 * vampire-squid microservice. It handles common scenarios like 404 errors gracefully and
 * uses virtual threads for efficient asynchronous operations.
 * <p>
 * Key features:
 * <ul>
 *   <li>All operations return {@link CompletableFuture} for non-blocking async execution</li>
 *   <li>Uses Java 21 virtual threads via {@link Executors#newVirtualThreadPerTaskExecutor()}</li>
 *   <li>Handles {@link NotFound} exceptions gracefully (returns null or empty lists)</li>
 *   <li>Converts between Kiota-generated models and hand-written convenience models</li>
 *   <li>SHA512 checksums are handled as hex-encoded strings (not base64)</li>
 * </ul>
 * <p>
 * Example usage:
 * <pre>{@code
 * // With authentication
 * var client = new VampireSquidKiotaClient(
 *     URI.create("https://example.com/vam"),
 *     "your-api-key"
 * );
 *
 * // Find media by UUID
 * Media media = client.findByUuid(uuid).join();
 *
 * // Create new media
 * Media newMedia = client.create(
 *     "MySequence",
 *     "camera-123",
 *     "video-001",
 *     URI.create("file:///path/to/video.mp4"),
 *     Instant.now()
 * ).join();
 * }</pre>
 *
 * @see MediaService
 * @see VampireSquidFactory
 */
public class VampireSquidKiotaClient implements MediaService {

    private final VampireSquid vampireSquid;
    protected final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

    /**
     * Creates a new client with a pre-configured VampireSquid instance.
     * <p>
     * Use this constructor when you need full control over the VampireSquid
     * client configuration. For most use cases, prefer the convenience constructors.
     * </p>
     *
     * @param vampireSquid the configured Kiota client instance
     * @see #VampireSquidKiotaClient(URI, String)
     * @see #VampireSquidKiotaClient(URI)
     */
    public VampireSquidKiotaClient(VampireSquid vampireSquid) {
        this.vampireSquid = vampireSquid;
    }

    /**
     * Creates a new authenticated client for the given base URI and API key.
     * <p>
     * This constructor is suitable for operations that require authentication
     * (create, update, delete). The API key will be used to obtain JWT tokens
     * for authenticated requests.
     * </p>
     *
     * @param baseUri the base URI of the vampire-squid service
     * @param apiKey the API key for authentication
     */
    public VampireSquidKiotaClient(URI baseUri, String apiKey) {
        this(VampireSquidFactory.create(baseUri.toString(), apiKey));
    }

    /**
     * Creates a new anonymous client for the given base URI.
     * <p>
     * This constructor is suitable for read-only operations that do not
     * require authentication. Write operations (create, update, delete)
     * will fail with authorization errors.
     * </p>
     *
     * @param baseUri the base URI of the vampire-squid service
     */
    public VampireSquidKiotaClient(URI baseUri) {
        this(VampireSquidFactory.create(baseUri.toString()));
    }

    /**
     * Creates a new media record from a Media object.
     * <p>
     * Requires authentication. The media object will be converted to the Kiota
     * model format and posted to the service. A new UUID will be assigned.
     * </p>
     *
     * @param media the media object to create
     * @return a CompletableFuture containing the created media with assigned UUID
     */
    @Override
    public CompletableFuture<Media> create(Media media) {
        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                    .media()
                    .post(media.toKiota());

            return Media.fromKiota(response);
        }, executor);
    }

    /**
     * Creates a new media record with individual parameters.
     * <p>
     * Convenience method for creating media without constructing a full Media object.
     * Requires authentication.
     * </p>
     *
     * @param videoSequenceName the name of the video sequence (deployment/dive)
     * @param cameraId the identifier of the camera/platform
     * @param videoName the name of the video
     * @param uri the URI where the video file is located
     * @param startTimestamp the start timestamp of the video (nullable, will be converted to UTC)
     * @return a CompletableFuture containing the created media with assigned UUID
     */
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

    /**
     * Updates the start timestamp and duration of an existing media record.
     * <p>
     * Requires authentication. Only the specified fields will be updated;
     * other fields remain unchanged.
     * </p>
     *
     * @param videoReferenceUuid the UUID of the media to update
     * @param startTimestamp the new start timestamp (converted to UTC)
     * @param duration the new duration
     * @return a CompletableFuture containing the updated media
     */
    @Override
    public CompletableFuture<Media> update(UUID videoReferenceUuid, Instant startTimestamp, Duration duration) {
        var kMedia = new org.mbari.vars.vampiresquid.sdk.kiota.models.Media();
        kMedia.setStartTimestamp(startTimestamp.atOffset(ZoneOffset.UTC));
        kMedia.setDurationMillis(duration.toMillis());

        return CompletableFuture.supplyAsync(() -> {
            var response = vampireSquid.v1()
                    .media()
                    .byVideoReferenceUuid(videoReferenceUuid)
                    .put(kMedia);

            return Media.fromKiota(response);
        }, executor);
    }

    /**
     * Updates an existing media record with all fields from the provided Media object.
     * <p>
     * Requires authentication. The media's UUID is used to identify which record
     * to update.
     * </p>
     *
     * @param media the media object containing updated values
     * @return a CompletableFuture containing the updated media
     */
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

    /**
     * Deletes a video reference by UUID.
     * <p>
     * Requires authentication. This operation is permanent and cannot be undone.
     * </p>
     *
     * @param videoReferenceUuid the UUID of the video reference to delete
     * @return a CompletableFuture containing true if the deletion was successful
     */
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

    /**
     * Finds a media record by its video reference UUID.
     * <p>
     * Returns null if no media is found with the given UUID (404 errors are handled gracefully).
     * </p>
     *
     * @param uuid the video reference UUID to search for
     * @return a CompletableFuture containing the media, or null if not found
     */
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

    /**
     * Finds a media record by its SHA-512 checksum.
     * <p>
     * The SHA-512 checksum is provided as a byte array and will be converted to
     * hex-encoded string format for the query. Returns null if no media is found
     * with the given checksum.
     * </p>
     *
     * @param sha512 the SHA-512 checksum as a byte array
     * @return a CompletableFuture containing the media, or null if not found
     */
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

    /**
     * Finds a media record by its URI.
     * <p>
     * Returns null if no media is found with the given URI.
     * </p>
     *
     * @param uri the URI of the video file
     * @return a CompletableFuture containing the media, or null if not found
     */
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

    /**
     * Finds all media records in a video sequence.
     * <p>
     * Returns an empty list if the video sequence is not found or has no media.
     * </p>
     *
     * @param videoSequenceName the name of the video sequence (deployment/dive)
     * @return a CompletableFuture containing a list of media in the sequence
     */
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

    /**
     * Finds all media records with a specific video name.
     * <p>
     * Returns an empty list if no media is found with the given video name.
     * </p>
     *
     * @param videoName the name of the video
     * @return a CompletableFuture containing a list of matching media
     */
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

    /**
     * Retrieves all video sequence names in the database.
     * <p>
     * Returns an empty list if no video sequences exist.
     * </p>
     *
     * @return a CompletableFuture containing a list of all video sequence names
     */
    @Override
    public CompletableFuture<List<String>> findAllVideoSequenceNames() {
        return findMany(() ->
                vampireSquid.v1()
                        .videosequences()
                        .names()
                        .get());
    }


    /**
     * Finds media recorded by a specific camera at a specific timestamp.
     * <p>
     * Returns media where the timestamp falls within the video's time range.
     * Returns an empty list if no matching media is found.
     * </p>
     *
     * @param cameraId the camera identifier
     * @param timestamp the timestamp to search for
     * @return a CompletableFuture containing a list of matching media
     */
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

    /**
     * Finds media recorded by a specific camera within a date range.
     * <p>
     * Returns media where the start timestamp falls within the specified range.
     * Returns an empty list if no matching media is found.
     * </p>
     *
     * @param cameraId the camera identifier
     * @param startTimestamp the start of the time range
     * @param endTimestamp the end of the time range
     * @return a CompletableFuture containing a list of matching media
     */
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

    /**
     * Finds media in a video sequence at a specific timestamp.
     * <p>
     * <strong>Note:</strong> This method is not yet implemented and will throw
     * an {@link UnsupportedOperationException}.
     * </p>
     *
     * @param videoSequenceName the name of the video sequence
     * @param timestamp the timestamp to search for
     * @return not implemented
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    public CompletableFuture<List<Media>> findByVideoSequenceNameAndTimestamp(String videoSequenceName,
                                                                              Instant timestamp) {
        throw new UnsupportedOperationException("Not implemented. We haven't used this yet");
    }

    /**
     * Retrieves all camera IDs present in the database.
     * <p>
     * Returns an empty list if no cameras exist.
     * </p>
     *
     * @return a CompletableFuture containing a list of all camera IDs
     */
    @Override
    public CompletableFuture<List<String>> findAllCameraIds() {
        return findMany(() ->
                vampireSquid.v1()
                        .videosequences()
                        .cameras()
                        .get()
        );
    }

    /**
     * Retrieves all video URIs present in the database.
     * <p>
     * Returns an empty list if no video references exist.
     * </p>
     *
     * @return a CompletableFuture containing a list of all video URIs
     */
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

    /**
     * Finds media that were recorded concurrently with the given video reference.
     * <p>
     * Concurrent media are videos that overlap in time with the specified video
     * (e.g., different camera angles of the same event). Returns an empty list if
     * no concurrent media is found.
     * </p>
     *
     * @param uuid the video reference UUID
     * @return a CompletableFuture containing a list of concurrent media
     */
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

    /**
     * Finds media by filename (extracted from the URI path).
     * <p>
     * Returns an empty list if no media is found with the given filename.
     * </p>
     *
     * @param filename the filename to search for
     * @return a CompletableFuture containing a list of matching media
     */
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

    /**
     * Finds the timestamp of the last update to any entity in a video sequence.
     * <p>
     * This is useful for synchronization and change detection. Returns null if
     * the video sequence is not found.
     * </p>
     *
     * @param uuid the video sequence UUID
     * @return a CompletableFuture containing the last update timestamp, or null if not found
     */
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

    /**
     * Finds the timestamp of the last update to a video entity.
     * <p>
     * This is useful for synchronization and change detection. Returns null if
     * the video is not found.
     * </p>
     *
     * @param uuid the video UUID
     * @return a CompletableFuture containing the last update timestamp, or null if not found
     */
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

    /**
     * Finds the timestamp of the last update to a video reference entity.
     * <p>
     * This is useful for synchronization and change detection. Returns null if
     * the video reference is not found.
     * </p>
     *
     * @param uuid the video reference UUID
     * @return a CompletableFuture containing the last update timestamp, or null if not found
     */
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

    /**
     * Finds all video sequence names associated with a specific camera.
     * <p>
     * Returns an empty list if the camera has no associated video sequences.
     * </p>
     *
     * @param cameraId the camera identifier
     * @return a CompletableFuture containing a list of video sequence names
     */
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

    /**
     * Finds all video names within a specific video sequence.
     * <p>
     * Returns an empty list if the video sequence has no videos.
     * </p>
     *
     * @param videoSequenceName the name of the video sequence
     * @return a CompletableFuture containing a list of video names
     */
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


    /**
     * Helper method that executes a supplier and wraps the result in an Optional.
     * <p>
     * Handles {@link NotFound} exceptions by returning an empty Optional instead
     * of propagating the exception. Executes asynchronously using virtual threads.
     * </p>
     *
     * @param <A> the type of the result
     * @param supplier the supplier to execute
     * @return a CompletableFuture containing an Optional with the result, or empty if not found
     */
    private <A> CompletableFuture<Optional<A>> findOne(Supplier<A> supplier) {
        return findOneOrNull(supplier).thenApply(Optional::ofNullable);
    }

    /**
     * Helper method that executes a supplier and returns null on NotFound.
     * <p>
     * Handles {@link NotFound} exceptions by returning null instead of propagating
     * the exception. This simplifies error handling for callers who expect nullable
     * results. Executes asynchronously using virtual threads.
     * </p>
     *
     * @param <A> the type of the result
     * @param supplier the supplier to execute
     * @return a CompletableFuture containing the result, or null if not found
     */
    private <A> CompletableFuture<A> findOneOrNull(Supplier<A> supplier) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return supplier.get();
            } catch (NotFound e) {
                return null;
            }
        }, executor);
    }

    /**
     * Helper method that executes a supplier and returns an empty list on NotFound.
     * <p>
     * Handles {@link NotFound} exceptions by returning an empty list instead of
     * propagating the exception. This simplifies error handling for callers who
     * expect list results. Executes asynchronously using virtual threads.
     * </p>
     *
     * @param <A> the type of elements in the result list
     * @param supplier the supplier to execute
     * @return a CompletableFuture containing the result list, or an empty list if not found
     */
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
