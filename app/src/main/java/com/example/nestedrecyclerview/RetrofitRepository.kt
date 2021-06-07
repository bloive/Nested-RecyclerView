package com.example.nestedrecyclerview

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitRepository {
    @GET("d531f5f5-180d-4364-bae7-791dae87f732?fbclid=IwAR0Qhj1NaWXUnQGC-QyTsYXLjrp4FJ4MJCSToe0BseT0HSj5XWIsRR5XvTY")
    suspend fun getFields(): Response<MutableList<MutableList<FieldData>>>
}