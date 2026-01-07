# vampire-squid-java-sdk

A Java client SDK for interacting with the [vampire-squid](https://github.com/mbari-org/vampire-squid) microservice, which provides video metadata management services. The SDK is primarily auto-generated using [Microsoft Kiota](https://learn.microsoft.com/en-us/openapi/kiota/overview) from an OpenAPI specification.

## Features

- **Two API Styles**: Choose between Kiota's fluent API or the MediaService convenience interface
- **Async Operations**: All methods return `CompletableFuture` for non-blocking operations
- **Virtual Threads**: Uses Java 21 virtual threads for efficient I/O
- **JWT Authentication**: Automatic token management with API key authentication
- **Type-Safe**: Strongly-typed models and request builders
- **Graceful Error Handling**: MediaService API converts 404s to null/empty lists

## Requirements

- Java 21 or higher
- Maven 3.6+

## Installation

Add the dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.mbari.vars</groupId>
    <artifactId>vampire-squid-java-sdk</artifactId>
    <version>0.0.13</version>
</dependency>
```

## Usage

### Quick Start

```java
import org.mbari.vars.vampiresquid.sdk.VampireSquidFactory;
import org.mbari.vars.vampiresquid.sdk.r1.VampireSquidKiotaClient;
import java.net.URI;

var baseUrl = "http://localhost/vam/v1"; // Substitute your service URL
var apiKey  = "foobar";                   // Substitute your service API key
```

### Option 1: Kiota Fluent API

Direct, type-safe access to all REST endpoints:

```java
// Create client with authentication
var vampireSquid = VampireSquidFactory.create(baseUrl, apiKey);

// Fluent API calls
List<String> cameraIds = vampireSquid.v1()
        .videosequences()
        .cameras()
        .get();

// Find media by SHA-512 checksum
var media = vampireSquid.v1()
        .media()
        .sha512()
        .bySha512(hexChecksum)
        .get();
```

### Option 2: MediaService API

Business-friendly interface with async operations:

```java
// Create MediaService client
var mediaService = new VampireSquidKiotaClient(URI.create(baseUrl), apiKey);

// All operations return CompletableFuture
CompletableFuture<List<String>> cameraIds = mediaService.findAllCameraIds();

// Find media by URI (returns null if not found, no exception)
CompletableFuture<Media> media = mediaService.findByUri(
    URI.create("http://example.com/video.mp4")
);

// Find by video sequence name
CompletableFuture<List<Media>> videos = mediaService.findByVideoSequenceName("dive-123");

// Create new media entry
var newMedia = mediaService.create(
    "dive-123",           // video sequence name
    "camera-001",         // camera ID
    "video-001.mp4",     // video name
    URI.create("http://example.com/video.mp4"),
    Instant.now()         // start timestamp
);
```

### Read-Only Access

For read-only operations, authentication is optional:

```java
// Create client without authentication
var vampireSquid = VampireSquidFactory.create(baseUrl);
var mediaService = new VampireSquidKiotaClient(URI.create(baseUrl));
```

## Building

```bash
# Build the project
mvn clean install

# Run tests (unit tests only)
mvn test

# Run integration tests (requires live service)
mvn verify

# Generate Javadocs
mvn javadoc:javadoc
```

## Regenerating the SDK

When the vampire-squid OpenAPI specification is updated, you can regenerate the SDK:

### Prerequisites

Install the Kiota CLI tool:
```bash
# Using .NET tool
dotnet tool install -g Microsoft.OpenApi.Kiota

# Or using Homebrew (macOS)
brew install kiota
```

### Steps

1. **Copy the OpenAPI specification** into the project:
   ```bash
   cp /path/to/openapi.yaml src/main/resources/docs.yaml
   ```

2. **Modify the specification** (required workarounds):

   a. Change OpenAPI version to 3.0.0 if needed (Kiota doesn't support 3.1.0):
   ```yaml
   openapi: 3.0.0  # Change from 3.1.0
   ```

   b. Remove `format: binary` from all sha512 fields (Kiota assumes base64, but we use hex strings):
   ```yaml
   sha512:
     type: string
     # format: binary  # REMOVE THIS LINE
   ```

3. **Run the Kiota generator** from the project root:
   ```bash
   kiota generate -l java \
     -c VampireSquid \
     -n org.mbari.vars.vampiresquid.sdk.kiota \
     -d ./src/main/resources/docs.yaml \
     -o ./src/main/java/org/mbari/vars/vampiresquid/sdk/kiota \
     --exclude-backward-compatible
   ```

4. **Review the generated code**:
   - Check model classes in `sdk.kiota.models/`
   - Verify sha512 fields are treated as strings
   - Update `Media.fromKiota()` and `Media.toKiota()` if model changes affect conversions

**Important**: Do not manually edit files in `src/main/java/org/mbari/vars/vampiresquid/sdk/kiota/` as they will be overwritten on regeneration.

## License

Licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)

## Links

- [vampire-squid microservice](https://github.com/mbari-org/vampire-squid)
- [Microsoft Kiota](https://learn.microsoft.com/en-us/openapi/kiota/overview)
- [MBARI](https://www.mbari.org)
