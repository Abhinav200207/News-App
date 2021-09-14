package com.example.news_app

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://newsapi.org/";
const val API_KEY = "cea8fa533b6645298b44881aa5267a10";

interface NewsInterface {
    @GET("/v2/top-headlines?apiKey=$API_KEY")
    fun getHeadLines(@Query("country")country : String ,@Query("page")page : Int):Call<News>
}

object NewsService{
    val  newsInstances : NewsInterface
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstances = retrofit.create(NewsInterface::class.java)
    }
}