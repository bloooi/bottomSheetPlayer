package com.jay.bottomsheetplayer.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import androidx.annotation.Dimension;
import androidx.annotation.Px;

public class DimensionConverter {
    private static int screenWidth = 0;
    private static int screenHeight = 0;

    @Px
    public static int toPx(@Dimension(unit = Dimension.DP) float dp) {
        return toPx(null, dp);
    }

    @Px
    public static int toPx(Context context, @Dimension(unit = Dimension.DP) float dp) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return (int) ((dp * displayMetrics.density) + 0.5);
    }

    @Dimension(unit = Dimension.DP)
    public static int toDp(@Px int px) {
        return toDp(null, px);
    }

    @Dimension(unit = Dimension.DP)
    public static int toDp(Context context, @Px int px) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return (int) Math.round((px / displayMetrics.density) + 0.5);
    }

    public static int getScreenWidth(Activity activity) {
        if (screenWidth == 0) {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            screenWidth = displaymetrics.widthPixels;
        }

        return screenWidth;
    }

    public static int getScreenWidth() {
        if(screenWidth == 0) {
            throw new IllegalStateException("you must call getScreenWidth(Activity) first.");
        }

        return screenWidth;
    }

    public static int getScreenHeight(Activity activity) {
        if (screenHeight == 0) {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            screenHeight = displaymetrics.heightPixels;
        }

        return screenHeight;
    }

    public static int getScreenHeight() {
        if(screenHeight == 0) {
            throw new IllegalStateException("you must call getScreenHeight(Activity) first.");
        }

        return screenHeight;
    }
}
