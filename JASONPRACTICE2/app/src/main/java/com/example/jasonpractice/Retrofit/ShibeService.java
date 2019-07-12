package com.example.jasonpractice.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShibeService {

    @GET("shibes")
    Call<List<String>>loadShibes(@Query("count") int count);
//    RETURN-TYPE            METHOD NAME        METHOD-PAREMETERS
}
