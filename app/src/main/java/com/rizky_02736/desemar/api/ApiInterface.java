package com.rizky_02736.desemar.api;

import com.rizky_02736.desemar.model.login.Login;
import com.rizky_02736.desemar.model.register.Register;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login.php")
    Call<Login> loginResponse(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("register.php")
    Call<Register> registerResponse(
            @Field("username") String username,
            @Field("password") String password,
            @Field("nama") String nama,
            @Field("email") String email,
            @Field("id_user_level") String id_user_level
    );
}
