package com.example.news_app.retrofit

import com.example.news_app.models.NewsData
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("news")
    suspend fun getData(@Query("access_key") access_key:String,
                        @Query("languages") languages:String,
                        @Query("categories") categories:String,
                        @Query("sort") sort: String
    ): NewsData

}