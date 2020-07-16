package app.whoknows.android.util

import app.whoknows.android.WhoKnows
import app.whoknows.android.business.data.UserData

class LoggedUser {

    companion object {
        private var loggedUser: LoggedUser? = null

        fun getInstance(): LoggedUser {
           if (loggedUser == null) {
                loggedUser = LoggedUser()
            }
            return loggedUser!!
        }
    }

    private var userProfileModel: UserData? = null

    fun getAccount(): UserData? {
        return if (userProfileModel != null)
            userProfileModel
        else
            WhoKnows.getInstance().getAppPref().loadObject(
                AppConstants.PREF_ACCOUNT,
                UserData::class.java) as UserData?
    }

    fun setAccount(accountDetails: UserData) {
        WhoKnows.getInstance().getAppPref().saveBoolean(AppConstants.KEY_IS_USER_LOGGED_IN, true)
        WhoKnows.getInstance().getAppPref().saveObject(AppConstants.PREF_ACCOUNT, accountDetails)
        this@LoggedUser.userProfileModel = accountDetails
    }

    fun logout() {
        WhoKnows.getInstance().getAppPref().saveBoolean(AppConstants.KEY_IS_USER_LOGGED_IN, false)
        WhoKnows.getInstance().getAppPref().removeSharedPref(AppConstants.PREF_ACCOUNT)
    }

    fun isUserLoggedIn(): Boolean {
        return WhoKnows.getInstance().getAppPref().getBoolean(AppConstants.KEY_IS_USER_LOGGED_IN, false)
    }
}