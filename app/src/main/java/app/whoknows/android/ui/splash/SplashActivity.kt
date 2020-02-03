package app.whoknows.android.ui.splash

import android.os.Bundle
import app.whoknows.android.R
import app.whoknows.android.WhoKnows
import app.whoknows.android.ui.base.BaseActivity
import javax.inject.Inject

class SplashActivity:BaseActivity(),SplashView {
    @Inject
    lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WhoKnows.getAppComponent().inject(this)
        presenter.attachView(this)
        setContentView(R.layout.splash_layout)
    }
}