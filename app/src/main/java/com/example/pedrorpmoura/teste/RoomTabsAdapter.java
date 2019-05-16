package com.example.pedrorpmoura.teste;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class RoomTabsAdapter extends FragmentStatePagerAdapter {

    private int num_of_tabs;
    private MRoom room;

    public RoomTabsAdapter(FragmentManager fm, int num_of_tabs, MRoom room) {
        super(fm);
        this.num_of_tabs = num_of_tabs;
        this.room = room;
    }

    @Override
    public Fragment getItem(int position) {

        switch(position) {
            case 0:
                DescriptionFragment desc_frag = new DescriptionFragment();
                desc_frag.setDescription(this.room.getDescription());
                return desc_frag;
            case 1:
                //ObjectsPicsFragment obj_pics_frag = new ObjectsPicsFragment();
                //obj_pics_frag.setObjects_pics(this.room.getRoom_objects());

                ObjectsPicsFragment2 obj_pics_frag = new ObjectsPicsFragment2();
                obj_pics_frag.setRoom_objects(this.room.getRoom_objects());
                return obj_pics_frag;
            default:
                desc_frag = new DescriptionFragment();
                desc_frag.setDescription(this.room.getDescription());
                return desc_frag;
        }
    }

    @Override
    public int getCount() {
        return this.num_of_tabs;
    }
}
