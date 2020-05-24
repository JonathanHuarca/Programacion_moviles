package pe.edu.tecsup.laboratorio8.models.service;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

public  class ApiServiceGenerator {

    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/";

    private static Retrofit.Builder builder=
           new Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(GsonConverterFactory.create());


    private static Retrofit retrofit = builder.build();
    private static HttpLoggingInterceptor Logging =
            new HttLoggingInterceptor()
            .setLevel(HttploggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();

    private static <S> S createService(
            Class<S> serviceClass){
        if(!httpClient.interceptors().contains(Logging)){
            httpClient.addInterceptor(Logging);
            builder.client(httpClient.build());
            retrofit = builder.build();
        }
        return retrofit.create(serviceClass);
    }

}