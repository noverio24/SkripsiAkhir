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
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

public interface CreateSubjectService {

    @GET("getAll")
    Call<ResponseBody> getAll( );

    @POST("store")
    @FormUrlEncoded
    Call<ResponseBody> store(@Field("dosen_id") int dosen_id, @Field("name") String name ,@Field("code") String code,
                             @Field("description") String description, @Field("schedule") String schedule, @Field("notedWeek") String notedWeek,
                             @Field("time") String time, @Field("namaMatkul") String namaMatkul, @Field("nilaiPresent") int nilaiPresent );


    @PUT("update")
    @FormUrlEncoded
    Call<ResponseBody> update(@Field("dosen_id") int dosen_id, @Field("name") String name ,@Field("code") String code,
                             @Field("description") String description, @Field("schedule") String schedule, @Field("notedWeek") String notedWeek,
                             @Field("time") String time, @Field("namaMatkul") String namaMatkul, @Field("nilaiPresent") int nilaiPresent );

    @DELETE("delete")
   Call<ResponseBody> delete(@Field("id") int id);

    @GET("getData")
    Call<ResponseBody> getData(@Query());

}
