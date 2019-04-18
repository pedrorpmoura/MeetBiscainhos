package com.example.pedrorpmoura.teste;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class ObjectsPicsFragment extends Fragment {

    private int[] objects_pics;

    public ObjectsPicsFragment() {
        this.objects_pics = new int[] {};
    }

    public void setObjects_pics(int[] objects_pics) {
        this.objects_pics = objects_pics;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root_view = (View) inflater.inflate(R.layout.room_objects_pics,
                container, false);

        for(int image_id : this.objects_pics) {
            ImageView image_view = new ImageView(getActivity());
            image_view.setImageResource(image_id);
            image_view.setAdjustViewBounds(true);
            image_view.setScaleType(ImageView.ScaleType.CENTER_CROP);

            LinearLayout my_layout = root_view.findViewById(R.id.room_objects_pics);
            my_layout.addView(image_view);
        }

        return root_view;
    }
}
