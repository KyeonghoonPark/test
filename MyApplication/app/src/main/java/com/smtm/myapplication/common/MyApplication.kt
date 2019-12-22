package com.smtm.myapplication.common

import android.app.Application
import com.smtm.myapplication.di.myDiModule
import org.koin.android.ext.android.startKoin

/*
 * Created by pk on 2019-12-18.
 *
 */
class MyApplication : Application() {

    companion object {
        lateinit var myApplication : MyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        myApplication = this
        startKoin(applicationContext, myDiModule)
    }
}