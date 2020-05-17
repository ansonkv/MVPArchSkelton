package app.whoknows.android.ui.splash

import android.os.Bundle
import android.view.WindowManager
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
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.splash_layout)
    }
}