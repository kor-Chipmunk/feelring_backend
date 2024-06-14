package com.mashup.feelring.oauth2.twitter;

import com.mashup.feelring.model.OAuthToken;
import com.mashup.feelring.model.OAuthUser;
import com.mashup.feelring.oauth2.OAuthClient;

public class TwitterClient implements OAuthClient {
    @Override
    public OAuthToken requestAccessToken(String code) {
        return OAuthClient.super.requestAccessToken(code);
    }

    @Override
    public OAuthToken renewAccessToken(OAuthToken oAuthToken) {
        return OAuthClient.super.renewAccessToken(oAuthToken);
    }

    @Override
    public OAuthUser requestUserInfo(OAuthToken oAuthToken) {
        return OAuthClient.super.requestUserInfo(oAuthToken);
    }
}
