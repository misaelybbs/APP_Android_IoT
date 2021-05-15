package com.amse.tt_2019_b087.iot.utils;

import android.util.Base64;
import android.util.Log;

import com.amse.tt_2019_b087.iot.model.JWTBody;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

public class JWTUtils {
    public static JWTBody decoded(String JWTEncoded) throws Exception {
        JWTBody jwtBody = null;
        try {
            String[] split = JWTEncoded.split("\\.");
            jwtBody = JWTUtils.getJWTBody(getJson(split[1]));
            Log.d("JWT_DECODED", "Header: " + getJson(split[0]));
            Log.d("JWT_DECODED", "Body: " + jwtBody);

        } catch (UnsupportedEncodingException e) {
            //Error
        }
        return jwtBody;
    }

    private static String getJson(String strEncoded) throws UnsupportedEncodingException {
        byte[] decodedBytes = Base64.decode(strEncoded, Base64.URL_SAFE);
        return new String(decodedBytes, "UTF-8");
    }

    private static JWTBody getJWTBody(String jsonBody) {
        Gson gson = new Gson();
        return gson.fromJson(jsonBody, JWTBody.class);
    }
}
