package com.mashup.feelring.oauth2;

import com.mashup.feelring.model.OAuthToken;
import com.mashup.feelring.model.OAuthUser;

public interface OAuthClient {
    default OAuthToken requestAccessToken(String code) {
        return null;
    }

    default OAuthToken renewAccessToken(OAuthToken oAuthToken) {
        return null;
    }

    default OAuthUser requestUserInfo(OAuthToken oAuthToken) {
        return null;
    }
}
