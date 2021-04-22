package com.printfulapp.app

import android.app.Activity
import android.app.Application
import com.printfulapp.app.dependencyinjection.repoModule
import com.printfulapp.app.dependencyinjection.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PrintfulApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PrintfulApplication)
            modules(listOf(repoModule, viewModelModules))
        }
    }

    companion object{
        @JvmStatic
        var mActivity: Activity? = null
        var activity: Activity?
            get() = mActivity
            set(activity) {
                mActivity = activity
            }
    }
}