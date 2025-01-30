package org.mbari.vars.vampiresquid.sdk.r1.models;

import java.time.Instant;
import java.time.ZoneOffset;

import org.mbari.vars.vampiresquid.sdk.kiota.models.LastUpdatedTime;

/**
 * @author Brian Schlining
 * @since 2019-01-31T14:36:00
 */
public class LastUpdate {
    private Instant timestamp;

    public LastUpdate() {
    }

    public LastUpdate(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public LastUpdatedTime toKiota() {
        LastUpdatedTime lastUpdatedTime = new LastUpdatedTime();
        var offsetTimestamp = timestamp.atOffset(ZoneOffset.UTC);
        lastUpdatedTime.setTimestamp(offsetTimestamp);
        return lastUpdatedTime;
    }

    public static LastUpdate fromKiota(LastUpdatedTime lastUpdatedTime) {
        var offsetTimestamp = lastUpdatedTime.getTimestamp().toInstant();
        return new LastUpdate(offsetTimestamp);
    }
}
