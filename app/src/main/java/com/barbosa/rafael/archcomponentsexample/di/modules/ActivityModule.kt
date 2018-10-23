package com.barbosa.rafael.archcomponentsexample.di.modules

import com.barbosa.rafael.archcomponentsexample.view.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by rafael on 22/10/18.
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): HomeActivity

    // Add bindings for other sub-components here
}