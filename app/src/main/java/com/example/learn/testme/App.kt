package com.example.learn.testme

import android.app.Application

import org.rewedigital.katana.Component
import org.rewedigital.katana.Katana
import org.rewedigital.katana.android.AndroidKatanaLogger
import org.rewedigital.katana.android.environment.AndroidEnvironmentContext
import org.rewedigital.katana.android.modules.createApplicationModule
import timber.log.Timber

class App : Application() {

    companion object {
        lateinit var appComponent: Component
    }

    override fun onCreate() {
        super.onCreate()
        initLogger()
        initDependencies()

    }

    private fun initLogger() {
        if (!BuildConfig.DEBUG) {
            Katana.logger = AndroidKatanaLogger
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initDependencies() {
        Katana.environmentContext = AndroidEnvironmentContext()
        appComponent = Component(
            createApplicationModule(this)

        )
    }


}
