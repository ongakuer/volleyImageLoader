package me.relex.imageloader;

import me.relex.volley.toolbox.ImageLoader.ImageCache;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * Basic LRU Memory cache.
 * 
 * @author Trey Robinson
 * 
 */
public class BitmapLruImageCache extends LruCache<String, Bitmap> implements ImageCache {

    public BitmapLruImageCache(int maxSize) {
        super(maxSize);
    }

    @Override
    protected int sizeOf(String key, Bitmap value) {
        return value.getRowBytes() * value.getHeight();
    }

    @Override
    public Bitmap getBitmap(String url) {
        return get(createKey(url));
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        put(createKey(url), bitmap);
    }

    private String createKey(String url) {
        return String.valueOf(url.hashCode());
    }
}
