package com.example.pedrorpmoura.teste;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;

import java.util.ArrayList;
import java.util.List;

public class ObjectsPicsFragment2 extends Fragment {

    private List<MObject> room_objects;
    private ViewPager mObjectPicsViewPager;
    private RoomImageAdapter mPicsAdapter;
    private RoomObjectPicsAdapter mObjectPicsAdapter;

    public ObjectsPicsFragment2() {
        this.room_objects = new ArrayList<MObject>();
    }

    public void setRoom_objects(List<MObject> room_objects) {
        this.room_objects = room_objects;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root_view = (View) inflater.inflate(R.layout.room_objects_pics_2,
                container, false);


        mObjectPicsViewPager = (ViewPager) root_view.findViewById(R.id.object_pics_view_pager);
        TabLayout tabLayout1 = (TabLayout) root_view.findViewById(R.id.tabDots);
        mObjectPicsAdapter= new RoomObjectPicsAdapter(getActivity(), this.room_objects);
        mObjectPicsViewPager.setAdapter(mObjectPicsAdapter);
        tabLayout1.setupWithViewPager(mObjectPicsViewPager, true);


        return root_view;
    }
}
