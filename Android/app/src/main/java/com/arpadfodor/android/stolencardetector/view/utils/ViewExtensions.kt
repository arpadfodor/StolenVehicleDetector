package com.arpadfodor.android.stolencardetector.view.utils

import android.os.Build
import android.view.DisplayCutout
import android.view.View
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import com.arpadfodor.android.stolencardetector.R

/**
 * Simulate a button click, including a small delay while it is being pressed to trigger the
 * appropriate animations.
 */
fun ImageButton.simulateClick(delay: Long = resources.getInteger(R.integer.ANIMATION_FAST_MILLIS).toLong()) {

    performClick()
    isPressed = true
    invalidate()

    postDelayed({
        invalidate()
        isPressed = false
    }, delay)

}

/**
 * Pad this view with the insets provided by the device cutout (i.e. notch)
 */
@RequiresApi(Build.VERSION_CODES.P)
fun View.padWithDisplayCutout() {

    /**
     * Helper method that applies padding from cutout's safe insets
     */
    fun doPadding(cutout: DisplayCutout) = setPadding(
        cutout.safeInsetLeft,
        cutout.safeInsetTop,
        cutout.safeInsetRight,
        cutout.safeInsetBottom)

    // Apply padding using the display cutout designated "safe area"
    rootWindowInsets?.displayCutout?.let { doPadding(it) }

    // Set a listener for window insets since view.rootWindowInsets may not be ready yet
    setOnApplyWindowInsetsListener { _, insets ->
        insets.displayCutout?.let { doPadding(it) }
        insets
    }
}