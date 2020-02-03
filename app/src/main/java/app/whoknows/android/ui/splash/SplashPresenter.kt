package app.whoknows.android.ui.splash

import app.whoknows.android.ui.base.BasePresenter
import javax.inject.Inject

class SplashPresenter @Inject constructor() : BasePresenter<SplashView>() {

    @Inject
    fun provideSplashBusiness(splashBusiness: SplashBusiness) {
        baseBusiness = splashBusiness
    }
}