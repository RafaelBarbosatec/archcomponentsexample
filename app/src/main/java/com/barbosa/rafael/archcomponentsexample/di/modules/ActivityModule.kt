package com.barbosa.rafael.archcomponentsexample.di.modules

import com.barbosa.rafael.archcomponentsexample.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by rafael on 22/10/18.
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity

    // Add bindings for other sub-components here
}