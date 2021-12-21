package com.example.cheers.network

import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openbrewerydb.org/")
        .build()

val service: BeerService = retrofit.create(BeerService::class.java)

interface BeerService {

    @GET("breweries")
    suspend fun getBreweries(@Query("by_city") city: String) : List<JSONObject>

}