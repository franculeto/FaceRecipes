package com.example.franc.facerecipes.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by franc on 11/4/2017.
 */

public interface RecipeService {

    @GET("search")
    Call<RecipeServiceResponse> search(@Query("key") String key,
                                       @Query("sort") String sort,
                                       @Query("count") int count,
                                       @Query("page") int page);
}
