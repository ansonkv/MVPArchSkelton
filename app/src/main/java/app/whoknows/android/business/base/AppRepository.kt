package app.whoknows.android.business.base

import android.content.Context
import app.whoknows.android.business.di.LocalPreference
import app.whoknows.android.business.preference.AppPref
import co.findood.app.business.network.APIDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject internal constructor(private val context: Context,
                                                 private val remote:APIDataSource,
                                                 @param:LocalPreference private val preference:AppPref){

}