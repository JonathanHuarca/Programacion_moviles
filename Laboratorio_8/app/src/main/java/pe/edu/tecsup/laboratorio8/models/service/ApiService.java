package pe.edu.tecsup.laboratorio8.models.service;


import pe.edu.tecsup.laboratorio8.models.MarcadorMap;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {


    @GET("nearbysearch/json")
    Call<MarcadorMap> getDataMarkers(
            @Query("location")String location,
            @Query("radius")String radius,
            @Query("type")String type,
            @Query("keyword")String kerword,
            @Query("key") String key
    );

}
