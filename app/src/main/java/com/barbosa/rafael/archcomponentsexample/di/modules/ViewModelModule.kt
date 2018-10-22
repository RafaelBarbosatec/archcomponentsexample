package com.barbosa.rafael.archcomponentsexample.di.modules

import android.arch.lifecycle.ViewModel
import com.barbosa.rafael.archcomponentsexample.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import android.arch.lifecycle.ViewModelProvider
import com.barbosa.rafael.archcomponentsexample.util.ViewModelFactory
import com.barbosa.rafael.archcomponentsexample.view.home.HomeViewModel


/**
 * Created by rafael on 22/10/18.
 */
@Module
internal abstract class ViewModelModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(PasswordViewModel::class)
//    abstract fun bindPasswordViewModel(viewModel : PasswordViewModel) : ViewModel
//
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindMainViewModel(viewModel : HomeViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}