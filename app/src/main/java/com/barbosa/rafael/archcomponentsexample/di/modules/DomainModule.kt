package com.barbosa.rafael.archcomponentsexample.di.modules

import com.barbosa.rafael.archcomponentsexample.data.network.CoinApi
import com.barbosa.rafael.archcomponentsexample.domain.CoinDomain.CoinDomain
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by rafael on 23/10/18.
 */
@Module
object DomainModule{

    @Singleton
    @Provides
    @JvmStatic
    internal fun getCoinDomain(coinApi: CoinApi): CoinDomain {
        return CoinDomain(coinApi)
    }
}