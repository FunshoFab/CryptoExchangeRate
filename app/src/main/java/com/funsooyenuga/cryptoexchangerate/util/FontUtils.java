package com.funsooyenuga.cryptoexchangerate.util;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by FAB THE GREAT on 19/10/2017.
 */

public class FontUtils {

    public static Typeface getOpenSansRegular(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Regular.ttf");
    }

    public static Typeface getOpenSansSemiBold(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Semibold.ttf");
    }

    public static Typeface getArialRegular(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/arial.ttf");
    }

}
