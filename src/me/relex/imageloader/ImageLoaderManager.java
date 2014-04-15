package me.relex.imageloader;

import me.relex.AppContext;
import me.relex.volley.RequestQueue;
import me.relex.volley.toolbox.ImageLoader;
import me.relex.volley.toolbox.ImageLoader.ImageCache;
import me.relex.volley.toolbox.ImageLoader.ImageListener;
import me.relex.volley.toolbox.Volley;
import android.graphics.Bitmap;

public class ImageLoaderManager {

    private volatile static ImageLoaderManager mInstance;

    private ImageLoader mImageLoader;

    private RequestQueue mRequestQueue;

    private ImageCache mMemoryCache;

    private static int CACHE_SIZE = 1024 * 1024 * 30;

    public static ImageLoaderManager getInstance() {

        if (mInstance == null) {
            synchronized (ImageLoaderManager.class) {
                mInstance = new ImageLoaderManager();
            }
        }
        return mInstance;
    }

    private ImageLoaderManager() {
        mMemoryCache = new BitmapLruImageCache(CACHE_SIZE);
        mRequestQueue = Volley.newRequestQueue(AppContext.getContext());
        mImageLoader = new ImageLoader(mRequestQueue, mMemoryCache);
    }

    public Bitmap getBitmap(String url) {
        return mMemoryCache.getBitmap(url);
    }

    public void putBitmap(String url, Bitmap bitmap) {
        mMemoryCache.putBitmap(url, bitmap);
    }

    public void getImage(String url, ImageListener listener) {
        mImageLoader.get(url, listener);
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

}
