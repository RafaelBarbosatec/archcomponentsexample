package com.barbosa.rafael.archcomponentsexample.data.network

import com.barbosa.rafael.archcomponentsexample.domain.CoinDomain.model.Coin
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by rafael on 22/10/18.
 */
interface CoinApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("ticker/")
    fun getCoins(@Query("convert") convert:String, @Query("limit") limit:String): Observable<ArrayList<Coin>>
}