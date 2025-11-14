# vampire-squid-java-sdk

This is a client SDK for interacting with the [vampire-squid](https://github.com/mbari-org/vampire-squid) microservice. It's mostly auto-generated using [Kiota](https://learn.microsoft.com/en-us/openapi/kiota/overview).

## Usage

```xml
<dependency>
    <groupId>org.mbari.vars</groupId>
    <artifactId>vampire-squid-java-sdk</artifactId>
    <version>0.0.1</version>
</dependency>
```

```java
var baseUrl = "http://localhost/vam/v1" // Substitute yoru services URL
var apiKey  = "foobar"                   // Substitute your services API KEY


// -- Kiota API
var vampireSquid = VampireSquidFactory.create(baseUrl, apiKey)

// Use the service! Some examples.
List<String> cameraIds = vampireSquid.v1()
                .videosequences()
                .cameras()
                .get();

// -- MediaService API
var mediaService = new VampireSquidKiotaClient(URI.create(baseUrl), apiKey);
List<String> cameraIds = mediaService.findAllCameraIds();
```

## To regenerate the SDK

1. Copy the open api yaml file into each project's src/main/resources folder as docs.yaml
2. Some may need the openapi version changed to 3.0.0 as kiota does not support 3.1.0
3. Remove the `format: binary` from all sha512 blocks. Kiota assumes it's base64 encoded but we actually have been encoding as hex. This change will make Kiota treat them as strings:
```y
        sha512:
          type: string
          #format: binary # kiota will generat
```
4. Run the following command in the project's root directory

```shell
kiota generate -l java -c VampireSquid -n org.mbari.vars.vampiresquid.sdk.kiota -d ./src/main/resources/docs.yaml -o ./src/main/java/org/mbari/vars/vampiresquid/sdk/kiota --exclude-backward-compatible
```
