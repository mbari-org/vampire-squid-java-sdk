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

    @Test
    public void testFindByUri_NotFound() {
        var client = new VampireSquidKiotaClient(URI.create("https://gehenna.shore.mbari.org/vam"));
        var camera = client.findByUri(URI.create("urn:mbari:vars:camera:nonexistent")).join();
        assertNull(camera);
    }

    @Test
    public void testFindByUri() {
        var client = new VampireSquidKiotaClient(URI.create("https://gehenna.shore.mbari.org/vam"));
        var uri = URI.create("https://m3.shore.mbari.org/videos/t_M3/mezzanine/DocRicketts/2019/12/1234/D1234_20191216T143703Z_h264.mp4");
        var camera = client.findByUri(uri).join();
        assertNotNull(camera);
        assertEquals(uri, camera.getUri());
    }

}