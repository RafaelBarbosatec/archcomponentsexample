package com.barbosa.rafael.archcomponentsexample.di.modules

import com.barbosa.rafael.archcomponentsexample.domain.coinDomain.CoinDomain
import com.barbosa.rafael.archcomponentsexample.view.home.dataProvider.HomeDataProvider
import com.barbosa.rafael.archcomponentsexample.view.home.dataProvider.HomeDataProviderContract
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by rafael on 23/10/18.
 */
@Module
object DataProviderModule {

    @Singleton
    @Provides
    @JvmStatic
    internal fun getHomeDataProvider(coinDomain: CoinDomain): HomeDataProviderContract {
        return HomeDataProvider(coinDomain)
    }
}