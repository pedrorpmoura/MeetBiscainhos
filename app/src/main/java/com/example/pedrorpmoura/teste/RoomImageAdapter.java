package com.example.pedrorpmoura.teste;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class RoomImageAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mImages;


    RoomImageAdapter(Context context, int[] images) {
        this.mContext = context;
        this.mImages = images;
    }

    @Override
    public int getCount() {

        return mImages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {

        return view == obj;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(mImages[position]);
        container.addView(imageView, 0);

        return imageView;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object obj) {
        container.removeView((ImageView) obj);
    }
}
