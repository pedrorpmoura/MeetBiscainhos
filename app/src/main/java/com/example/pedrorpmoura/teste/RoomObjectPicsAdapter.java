package com.example.pedrorpmoura.teste;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class RoomObjectPicsAdapter extends PagerAdapter {

    private Context mContext;
    private List<MObject> mObjects;

    RoomObjectPicsAdapter(Context context, List<MObject> objects) {
        this.mContext = context;
        this.mObjects = objects;
    }

    @Override
    public int getCount() {

        return mObjects.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(mObjects.get(position).getPic());
        container.addView(imageView, 0);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = ((FragmentActivity)mContext).getSupportFragmentManager();
                ObjectFragment df = new ObjectFragment();
                df.setObject(mObjects.get(position));
                df.show(fm, "Object fragment");
            }
        });

        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }
}
