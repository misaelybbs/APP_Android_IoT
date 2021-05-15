package com.amse.tt_2019_b087.iot.service;

import com.amse.tt_2019_b087.iot.model.login.Login;
import com.amse.tt_2019_b087.iot.model.login.User;
import com.amse.tt_2019_b087.iot.model.pines1.Pines1;
import com.amse.tt_2019_b087.iot.model.pines1.ResponsePines1;
import com.amse.tt_2019_b087.iot.model.pines2.Pines2;
import com.amse.tt_2019_b087.iot.model.registro.Registro;
import com.amse.tt_2019_b087.iot.model.registro.RegistroUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserInterface {
    @POST("login/authenticate")
    Call<User> login(@Body Login login);

    @POST("register/newUser")
    Call<RegistroUser> savePost(@Body Registro registro);

    @GET(".")
    Call<ResponsePines1> pines1(@Body Pines1 pines1);

    @POST("")
    Call<Pines2> pines2(@Body Pines2 pines2);

}
