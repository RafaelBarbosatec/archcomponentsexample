package com.barbosa.rafael.archcomponentsexample.view.home

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.barbosa.rafael.archcomponentsexample.data.network.CoinApi
import com.barbosa.rafael.archcomponentsexample.domain.CoinDomain.CoinDomain
import com.barbosa.rafael.archcomponentsexample.domain.CoinDomain.model.Coin
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by rafael on 22/10/18.
 */
class HomeViewModel @Inject constructor(private val coinDomain: CoinDomain) : ViewModel() {

    private val coins: MutableLiveData<ArrayList<Coin>> by lazy {
        MutableLiveData<ArrayList<Coin>>()
    }

    init {
        loadCoins()
    }

    private fun loadCoins() {

        coinDomain.loadCoins("10",
                {
                    Log.i("LOG","resp HomeViewModel")
                    coins.value = it
                },
                {
                    Log.i("LOG","resp: ERROR: ${it.message}")
                }
        )

    }

    fun getCoins(): LiveData<ArrayList<Coin>>? {
        return this.coins
    }
}