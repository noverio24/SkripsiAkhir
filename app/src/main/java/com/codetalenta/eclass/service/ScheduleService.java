package com.codetalenta.eclass.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ScheduleService {

    @GET("getAll")
    Call<ResponseBody> getAll();

    @POST("store")
    @FormUrlEncoded
    Call<ResponseBody> store(@Field("subject_id") int subject_id,@Field("time") String time,@Field("day") String day);


    @PUT("update")
    @FormUrlEncoded
    Call<ResponseBody> update(@Field("subject_id") int subject_id,@Field("time") String time,@Field("day") String day);


    @DELETE("delete")
    Call<ResponseBody> delete(@Field("id") int id);

    @GET("getData")
    Call<ResponseBody> getData();

}
