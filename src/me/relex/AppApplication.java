package me.relex;

import me.relex.imageloader.ImageLoaderManager;
import android.app.Application;

public class AppApplication extends Application {

    static {
        System.loadLibrary("webp");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.setContext(this.getApplicationContext());

        ImageLoaderManager.getInstance();
    }
}
