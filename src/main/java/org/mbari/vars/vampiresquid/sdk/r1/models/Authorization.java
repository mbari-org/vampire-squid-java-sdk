package org.mbari.vars.vampiresquid.sdk.r1.models;

/**
 * Authorization model class
 * @author Brian Schlining
 * @since 2017-05-23T10:16:00
 */
public class Authorization {
    private String tokenType;
    private String accessToken;

    /**
     * Constructor
     * @param tokenType
     * @param accessToken
     */
    public Authorization(String tokenType, String accessToken) {
        this.tokenType = tokenType;
        this.accessToken = accessToken;
    }

    /**
     * Get the token type
     * @return the token type
     */
    public String getTokenType() {
        return tokenType;
    }

    /**
     * Get the access token
     * @return the access token
     */
    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public String toString() {
        return tokenType + " " + accessToken;
    }
}
