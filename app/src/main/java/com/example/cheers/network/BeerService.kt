package com.example.cheers.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl("https://api.openbrewerydb.org/")
        .build()

interface BeerService {
    @GET("breweries")
    suspend fun getBreweries(@Query("by_city") city: String) : List<Brewery>
}

// do this so the object is only made once
object BeerServiceApi {
    val service: BeerService by lazy {
        retrofit.create(BeerService::class.java)
    }
}