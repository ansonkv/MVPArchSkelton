package app.whoknows.android.util

import android.content.Context
import android.text.Editable
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import app.whoknows.android.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
//import com.zaki.app.util.expandable.ExpandableAnimation

//internal fun Animator.applyInterpolator(liftAnimation: ExpandableAnimation) {
//    when (liftAnimation) {
//        ExpandableAnimation.NORMAL -> this.interpolator = LinearInterpolator()
//        ExpandableAnimation.ACCELERATE -> this.interpolator = AccelerateInterpolator()
//        ExpandableAnimation.BOUNCE -> this.interpolator = BounceInterpolator()
//        ExpandableAnimation.OVERSHOOT -> this.interpolator = OvershootInterpolator()
//    }
//}

fun ImageView.loadImg(imageUrl: String) {

    if (imageUrl.isEmpty()) {

        setImageResource(R.mipmap.ic_launcher)

    } else {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL)
        Glide.with(this.context).load(imageUrl).apply(requestOptions).into(this)
    }


}
/**
 * Visibility modifiers and check functions
 */

fun View.isVisibile(): Boolean = visibility == View.VISIBLE

fun View.isGone(): Boolean = visibility == View.GONE

fun View.isInvisible(): Boolean = visibility == View.INVISIBLE


fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeGone() {
    visibility = View.GONE
}

fun View.makeInvisible() {
    visibility = View.INVISIBLE
}


/**
 * Hides the soft input keyboard from the screen
 */
fun View.hideKeyboard(context: Context?) {
    val inputMethodManager =
        context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
}

fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)
