package com.codetalenta.eclass.service;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface AuthService {
    @POST("login")
    @FormUrlEncoded
    Call<ResponseBody> login(@Field("email") String email, @Field("password") String password);

    @POST("mahasiswa/register")
    @Multipart
    Call<ResponseBody> registerMahasiswa(
            @Part MultipartBody.Part photo,
            @PartMap Map<String, RequestBody> text);
}
