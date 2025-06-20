package org.mbari.vars.vampiresquid.sdk.r1;

import java.net.URI;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VampireSquidKiotaClientIT {

    @Test
    public void testAuth() {
        var client = new VampireSquidKiotaClient(URI.create("https://gehenna.shore.mbari.org/vam"), "foofoo");
        var cameraIds = client.findAllCameraIds().join();
        assertNotNull(cameraIds);
        assertFalse(cameraIds.isEmpty());

    }

    @Test
    public void testNoAuth() {
        var client = new VampireSquidKiotaClient(URI.create("https://gehenna.shore.mbari.org/vam"));
        var cameraIds = client.findAllCameraIds().join();
        assertNotNull(cameraIds);
        assertFalse(cameraIds.isEmpty());
    }

}