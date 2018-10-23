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

    private val loading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    private var page = 0

    init {
        loadCoins()
    }

    fun loadCoins() {

        page = 0
        loading.value = true
        coinDomain.loadCoins(page,"20",
                {
                    loading.value = false
                    coins.value = it
                },
                {
                    loading.value = false
                    Log.i("LOG","resp: ERROR: ${it.message}")
                }
        )

    }

    fun nextPage(){

        if (loading.value == false){

            loading.value = true

            page ++

            coinDomain.loadCoins(page,"20",
                    {
                        loading.value = false

                        val list = coins.value
                        list?.addAll(it)
                        coins.value = list
                    },
                    {
                        loading.value = false
                        Log.i("LOG","resp: nextPage ERROR: ${it.message}")
                    }
            )
        }

    }

    fun getCoins(): LiveData<ArrayList<Coin>>? {
        return this.coins
    }
    fun getProgresControl():LiveData<Boolean>?{
        return this.loading
    }
}