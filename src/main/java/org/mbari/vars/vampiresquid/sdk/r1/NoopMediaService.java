package org.mbari.vars.vampiresquid.sdk.r1;

import java.net.URI;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.mbari.vars.vampiresquid.sdk.r1.models.LastUpdate;
import org.mbari.vars.vampiresquid.sdk.r1.models.Media;

public class NoopMediaService implements MediaService {

    @Override
    public java.util.concurrent.CompletableFuture<Media> create(Media media) {
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`create` is not implemented"));
    }

    @Override
    public java.util.concurrent.CompletableFuture<Media> create(String videoSequenceName, String cameraId,
            String videoName, java.net.URI uri, java.time.Instant startTimestamp) {
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`create` is not implemented"));
    }

    @Override
    public CompletableFuture<Media> update(UUID videoReferenceUuid, Instant startTimestamp, Duration duration) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`update` is not implemented"));
    }

    @Override
    public CompletableFuture<Media> update(Media media) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`update` is not implemented"));
    }

    @Override
    public CompletableFuture<Boolean> delete(UUID videoReferenceUuid) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`delete` is not implemented"));
    }

    @Override
    public CompletableFuture<Media> findByUuid(UUID uuid) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findByUuid` is not implemented"));
    }

    @Override
    public CompletableFuture<Media> findBySha512(byte[] sha512) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findBySha512` is not implemented"));
    }

    @Override
    public CompletableFuture<Media> findByUri(URI uri) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findByUri` is not implemented"));
    }

    @Override
    public CompletableFuture<List<Media>> findByVideoSequenceName(String videoSequenceName) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findByVideoSequenceName` is not implemented"));
    }

    @Override
    public CompletableFuture<List<Media>> findByVideoName(String videoName) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findByVideoName` is not implemented"));
    }

    @Override
    public CompletableFuture<List<String>> findAllVideoSequenceNames() {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findAllVideoSequenceNames` is not implemented"));
    }

    @Override
    public CompletableFuture<List<Media>> findByCameraIdAndTimestamp(String cameraId, Instant timestamp) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findByCameraIdAndTimestamp` is not implemented"));
    }

    @Override
    public CompletableFuture<List<Media>> findByCameraIdAndDate(String cameraId, Instant startTimestamp,
            Instant endTimestamp) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findByCameraIdAndDate` is not implemented"));
    }

    @Override
    public CompletableFuture<List<Media>> findByVideoSequenceNameAndTimestamp(String videoSequenceName,
            Instant timestamp) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findByVideoSequenceNameAndTimestamp` is not implemented"));
    }

    @Override
    public CompletableFuture<List<String>> findAllCameraIds() {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findAllCameraIds` is not implemented"));
    }

    @Override
    public CompletableFuture<List<URI>> findAllURIs() {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findAllURIs` is not implemented"));
    }

    @Override
    public CompletableFuture<List<Media>> findConcurrentByVideoReferenceUuid(UUID uuid) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findConcurrentByVideoReferenceUuid` is not implemented"));
    }

    @Override
    public CompletableFuture<List<Media>> findByFilename(String filename) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findByFilename` is not implemented"));
    }

    @Override
    public CompletableFuture<LastUpdate> findLastVideoSequenceUpdate(UUID uuid) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findLastVideoSequenceUpdate` is not implemented"));
    }

    @Override
    public CompletableFuture<LastUpdate> findLastVideoUpdate(UUID uuid) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findLastVideoUpdate` is not implemented"));
    }

    @Override
    public CompletableFuture<LastUpdate> findLastVideoReferenceUpdate(UUID uuid) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findLastVideoReferenceUpdate` is not implemented"));
    }

    @Override
    public CompletableFuture<List<String>> findVideoSequenceNamesByCameraId(String cameraId) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findVideoSequenceNamesByCameraId` is not implemented"));
    }

    @Override
    public CompletableFuture<List<String>> findVideoNamesByVideoSequenceName(String videoSequenceName) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`findVideoNamesByVideoSequenceName` is not implemented"));
    }

    @Override
    public CompletableFuture<List<Media>> listVideoSequences(int pageNumber, int pageSize) {
        // TODO Auto-generated method stub
        return CompletableFuture.failedFuture(new UnsupportedOperationException("`listVideoSequences` is not implemented"));
    }
    
}
