package com.git.party.di.modules

import android.app.Application
import android.content.Context
import com.git.party.di.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context {
        return application
    }

    @Provides
    fun provideApplication(): Application {
        return application
    }

}