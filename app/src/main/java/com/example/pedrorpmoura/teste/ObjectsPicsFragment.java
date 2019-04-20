package com.example.pedrorpmoura.teste;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;

import java.util.ArrayList;
import java.util.List;


public class ObjectsPicsFragment extends Fragment {

    //private int[] objects_pics;
    private List<MObject> room_objects;

    public ObjectsPicsFragment() {
        this.room_objects = new ArrayList<MObject>();
    }

    public void setObjects_pics(List<MObject> room_objects) {
        this.room_objects = room_objects;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root_view = (View) inflater.inflate(R.layout.room_objects_pics,
                container, false);

        for(final MObject obj : this.room_objects) {
            ImageView image_view = new ImageView(getActivity());
            image_view.setImageResource(obj.getPic());
            image_view.setAdjustViewBounds(true);
            image_view.setScaleType(ImageView.ScaleType.CENTER_CROP);

            image_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fm = getFragmentManager();
                    ObjectFragment df = new ObjectFragment();
                    df.setObject(obj);
                    df.show(fm, "Object fragment");
                }
            });

            LinearLayout my_layout = root_view.findViewById(R.id.room_objects_pics);
            my_layout.addView(image_view);
        }

        Space space_view = new Space(getActivity());
        space_view.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                170
        ));

        LinearLayout my_layout = root_view.findViewById(R.id.room_objects_pics);
        my_layout.addView(space_view);

        return root_view;
    }
}
