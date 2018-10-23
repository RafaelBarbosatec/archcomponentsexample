package com.barbosa.rafael.archcomponentsexample.domain.CoinDomain

import android.util.Log
import com.barbosa.rafael.archcomponentsexample.data.network.CoinApi
import com.barbosa.rafael.archcomponentsexample.domain.CoinDomain.model.Coin
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by rafael on 22/10/18.
 */
class CoinDomain@Inject constructor(private val coinApi: CoinApi){


    fun loadCoins(page:Int,limite:String, onNext:(ArrayList<Coin>) -> Unit, onError:(Throwable) -> Unit ){

        coinApi.getCoins("BRL",limite,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext,onError)

    }

}