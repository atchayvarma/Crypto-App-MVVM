package com.tamilanapps.cryptoapp.api

import com.tamilanapps.cryptoapp.data.model.CryptoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApi {

    @GET("/api/v3/coins/markets")
    suspend fun getCryptos(

        @Query("vs_currency")
        vs_currency:String = "inr",

        @Query("order")
        order:String = "market_cap_desc",

        @Query("sparkline")
        sparkline:Boolean = false

    ):Response<CryptoResponse>
}