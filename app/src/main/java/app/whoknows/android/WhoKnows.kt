package app.whoknows.android

import android.app.Application
import app.whoknows.android.business.database.AppDataBase
import app.whoknows.android.business.di.AppComponent
import app.whoknows.android.business.di.DaggerAppComponent
import app.whoknows.android.business.preference.AppPref

class WhoKnows : Application() {
    companion object {
        private lateinit var appComponent: AppComponent

        public lateinit var appContext: WhoKnows

        private lateinit var db: AppDataBase

        fun getInstance(): WhoKnows {
            return appContext
        }

        fun getAppComponent(): AppComponent {
            return appComponent
        }

        private lateinit var appPref: AppPref
    }

    override fun onCreate() {
        super.onCreate()
        appContext=this
        appComponent=initDagger(this)
        appPref= AppPref(this)
    }
    private fun initDagger(application: WhoKnows): AppComponent {
        return DaggerAppComponent.builder().application(application).build()
    }

    fun getAppPref(): AppPref {
        return appPref
    }
}