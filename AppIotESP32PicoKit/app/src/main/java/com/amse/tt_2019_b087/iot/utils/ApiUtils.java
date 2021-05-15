package com.amse.tt_2019_b087.iot.utils;

import com.amse.tt_2019_b087.iot.service.UserInterface;

public class ApiUtils {

    private ApiUtils() {
    }

    public static final String BASE_URL = "http://192.168.1.74:8761/api/register/";

    public static UserInterface getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(UserInterface.class);
    }
}
