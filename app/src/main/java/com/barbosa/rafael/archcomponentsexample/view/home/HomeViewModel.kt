package com.barbosa.rafael.archcomponentsexample.view.home

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.barbosa.rafael.archcomponentsexample.domain.coinDomain.model.Coin
import com.barbosa.rafael.archcomponentsexample.view.home.dataProvider.HomeDataProviderContract
import javax.inject.Inject


/**
 * Created by rafael on 22/10/18.
 */
class HomeViewModel @Inject constructor(private val homeDataProvider: HomeDataProviderContract) : ViewModel() {

    private val coins: MutableLiveData<ArrayList<Coin>> by lazy {
        MutableLiveData<ArrayList<Coin>>()
    }

    private val loading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    private var page = 0
    private val limit = 20

    init {
        loadCoins()
    }

    fun loadCoins() {

        page = 0
        loading.value = true
        homeDataProvider.loadCoins(page,limit.toString(),
                {
                    loading.postValue(false)
                    coins.postValue(it)
                },
                {
                    loading.postValue(false)
                    Log.i("LOG","resp: ERROR: ${it.message}")
                }
        )

    }

    fun nextPage(){

        if (loading.value == false){

            loading.value = true

            page ++

            homeDataProvider.loadCoins((page*limit),limit.toString(),
                    {
                        loading.postValue(false)
                        val list = coins.value
                        list?.addAll(it)
                        coins.postValue(list)
                    },
                    {
                        loading.postValue(false)
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