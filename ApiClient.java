package com.example.project1;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://api.calorieninjas.com/";
    private static Retrofit retrofit;

    private ApiClient() {
 
    }

    public static synchronized Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(createOkHttpClient())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient createOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(ApiClient::intercept)
                .build();
    }

    private static Response intercept(Interceptor.Chain chain) throws IOException {
        Request original = chain.request();

     
        Request request = original.newBuilder()
                .header("X-Api-Key", ApiKeyManager.getInstance().getApiKey())
                .build();

        return chain.proceed(request);
    }
}
