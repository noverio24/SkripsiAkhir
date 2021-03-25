package com.codetalenta.eclass.helper;

import com.codetalenta.eclass.service.AuthService;

public class UrlApi {
    public static String BASE_URL = "http://192.168.1.13:8000/api/v1/";

    public static AuthService getAuthService(){
        return RetrofitClient.getClient(BASE_URL).create(AuthService.class);
    }
}
