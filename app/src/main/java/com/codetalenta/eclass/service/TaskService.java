package com.codetalenta.eclass.service;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface TaskService {

    @GET("getAll")
    Call<ResponseBody> getAll( );

    @POST("store")
    @FormUrlEncoded
    Call<ResponseBody> store(@Field("subject_id") int subject_id, @Field("taskName") String taskName, @Field("dateStart") String dateStart,
                             @Field("deadline") String deadline, @Field("description") String description );
    @POST("storeFoto")
    @Multipart
    Call<ResponseBody> storeFoto(
            @Part MultipartBody.Part photo,
            @PartMap Map<String, RequestBody> text);



    @PUT("update")
    @FormUrlEncoded
    Call<ResponseBody> update(@Field("subject_id") int subject_id, @Field("taskName") String taskName, @Field("dateStart") String dateStart,
                             @Field("deadline") String deadline, @Field("description") String description );

    @DELETE("delete")
    Call<ResponseBody> delete(@Field("id") int id);

    @GET("getData")
    Call<ResponseBody> getData( );
}
