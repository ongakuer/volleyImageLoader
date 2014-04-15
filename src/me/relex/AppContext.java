package me.relex;

import android.content.Context;

public class AppContext {

    private static Context sContext;

    public static Context getContext() {
        return sContext;
    }

    public static void setContext(Context context) {
        sContext = context;
    }

}
