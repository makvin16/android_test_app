package com.zm.testapp.common;

import android.content.res.Resources;

public class General {

    public static int convertDpToPixel(int value) {
        return (int) (value * Resources.getSystem().getDisplayMetrics().density + 0.5f);
    }
}
