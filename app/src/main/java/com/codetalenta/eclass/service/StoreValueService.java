package com.codetalenta.eclass.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface StoreValueService {

    @GET("getAll")
    Call<ResponseBody> getAll( );

    @POST("store")
    @FormUrlEncoded
    Call<ResponseBody> store();


    @PUT("update")
    Call<ResponseBody> update();

    @DELETE("delete")
    Call<ResponseBody> delete(@Field("id") int id);

    @GET("getData")
    Call<ResponseBody> getData( );
}
