package com.jay.bottomsheetplayer.util

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import androidx.annotation.Dimension
import androidx.annotation.Px
import kotlin.math.roundToInt

object DimensionConverter {
    private var screenWidth = 0
    private var screenHeight = 0
    @Px
    fun toPx(@Dimension(unit = Dimension.DP) dp: Float): Int {
        return toPx(null, dp)
    }

    @Px
    fun toPx(context: Context?, @Dimension(unit = Dimension.DP) dp: Float): Int {
        val displayMetrics = Resources.getSystem().displayMetrics
        return (dp * displayMetrics.density + 0.5).toInt()
    }

    @Dimension(unit = Dimension.DP)
    fun toDp(@Px px: Int): Int {
        return toDp(null, px)
    }

    @Dimension(unit = Dimension.DP)
    fun toDp(context: Context?, @Px px: Int): Int {
        val displayMetrics = Resources.getSystem().displayMetrics
        return (px / displayMetrics.density + 0.5).roundToInt()
    }
}