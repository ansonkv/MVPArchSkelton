package app.whoknows.android.business.di

import app.whoknows.android.WhoKnows
import app.whoknows.android.business.di.modules.AppModule
import app.whoknows.android.business.di.modules.NetworkModule
import app.whoknows.android.ui.splash.SplashActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class,NetworkModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: WhoKnows): Builder

        fun build(): AppComponent
    }

    fun inject(splashActivity: SplashActivity)

}