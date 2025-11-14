package org.mbari.vars.vampiresquid.sdk.r1;

import java.net.URI;
import java.util.HexFormat;

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
        var uri = URI.create("https://m3.shore.mbari.org/videos/M3/mezzanine/DocRicketts/2019/12/1234/D1234_20191216T143703Z_h264.mp4");
        var camera = client.findByUri(uri).join();
        assertNotNull(camera);
        assertEquals(uri, camera.getUri());
    }

    @Test
    public void testFindByUuid() {
        var client = new VampireSquidKiotaClient(URI.create("https://gehenna.shore.mbari.org/vam"));
        var uuid = java.util.UUID.fromString("c2be3d5e-558f-48e4-a8d1-0d48ac493640");
        var camera = client.findByUuid(uuid).join();
        assertNotNull(camera);
        assertEquals(uuid, camera.getVideoReferenceUuid());
        var expectedSha512 = "e304d90f97d641c201de15faf791c040b88ef37d137a911d37362b24bdde7538e3d24aa125c65880061970a65afa579d034e5b5b387024e0b828aa0b2fde73fc";
        var actualSha512 = HexFormat.of().formatHex(camera.getSha512());
        assertEquals(expectedSha512, actualSha512);

    }

    @Test
    public void testFindByFilename_NotFound() {
        var client = new VampireSquidKiotaClient(URI.create("https://gehenna.shore.mbari.org/vam"));
        var camera = client.findByFilename("nonexistent.mp4").join();
        assertNotNull(camera);
        assertTrue(camera.isEmpty());
    }


    @Test
    public void testFindByFilename() {
        var client = new VampireSquidKiotaClient(URI.create("https://gehenna.shore.mbari.org/vam"));
        var camera = client.findByFilename("D1234_20191216T143703Z_h264.mp4").join();
        assertNotNull(camera);
        assertFalse(camera.isEmpty());
    }

    @Test
    public void testListVideoSequences() {
        var client = new VampireSquidKiotaClient(URI.create("https://gehenna.shore.mbari.org/vam"));
        var seqs = client.listVideoSequences(1, 10).join();
        assertNotNull(seqs);
        assertFalse(seqs.isEmpty());
    }

}