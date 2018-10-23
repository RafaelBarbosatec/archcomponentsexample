package com.barbosa.rafael.archcomponentsexample.di

import android.app.Application
import com.barbosa.rafael.archcomponentsexample.MyApplication
import com.barbosa.rafael.archcomponentsexample.di.modules.ActivityModule
import com.barbosa.rafael.archcomponentsexample.di.modules.AppModule
import com.barbosa.rafael.archcomponentsexample.di.modules.DomainModule
import com.barbosa.rafael.archcomponentsexample.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by rafael on 22/10/18.
 */
@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        DomainModule::class))
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MyApplication)
}