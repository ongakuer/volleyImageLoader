package me.relex;

import me.relex.imageloader.ImageLoaderManager;
import me.relex.volley.toolbox.NetworkImageView;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(new ItemAdapter());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    class ItemAdapter extends BaseAdapter {

        //        private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

        private class ViewHolder {

            public NetworkImageView image;
        }

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = convertView;
            final ViewHolder holder;
            if (convertView == null) {
                view = getLayoutInflater().inflate(R.layout.item_list_image, parent, false);
                holder = new ViewHolder();
                holder.image = (NetworkImageView) view.findViewById(R.id.image);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            //Adds display image task to execution pool. Image will be set to ImageView when it's turn.
            //            imageLoader.displayImage(imageUrls[position], holder.image, options,
            //                    animateFirstListener);

            //            Glide.load(IMAGES[position]).animate(R.anim.fade_in).into(holder.image);
            holder.image.setImageUrl(IMAGES[position], ImageLoaderManager.getInstance()
                    .getImageLoader());

            return view;
        }
    }

    public final String[] IMAGES = new String[] {
            // Heavy images
            "http://m.i.ppsrc.com/d/03nejUERolHHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/GuBh0_HddAXHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/T_NRgP_ickDHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/jZ_W64Oo0CvHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/HpZZ01or_EPHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/55P2ISnXosPHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/OILKNnc0KcjHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/RVDNQKiLYrbHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/YWc2dxjym37HFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/YO6JhkUvUivHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/zrdZMY41tbzHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/WB5JBleaPJ7HFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/zw1XU0HlH8PHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/dcSh_A17y23HFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/BVVMUhmLiJjHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/-vZ3gHWkpDLHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/qql5uS7uuS3HFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/Ix45BvCItn3HFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/_qrp8i92FdbHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/uaOi6LXdYavHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/bbsRw2vgfoLHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/jHoT51VoPKHHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/jel1N_F8lwnHFCEJTB-wgQ/w-640_h-640_t-webp",
            "http://m.i.ppsrc.com/d/WB5JBleaPJ7HFCEJTB-wgQ/w-640_h-640_t-webp", };
}
