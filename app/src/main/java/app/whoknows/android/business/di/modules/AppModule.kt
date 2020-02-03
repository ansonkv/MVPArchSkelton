package app.whoknows.android.business.di.modules

import android.content.Context
import app.whoknows.android.WhoKnows
import app.whoknows.android.business.di.LocalPreference
import app.whoknows.android.business.preference.AppPref
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    @LocalPreference
    internal fun provideLocalPreferenceDataSource(context: Context): AppPref {
        return AppPref(context)
    }

    @Singleton
    @Provides
    internal fun provideContext(application: WhoKnows): Context {
        return application.applicationContext
    }
}