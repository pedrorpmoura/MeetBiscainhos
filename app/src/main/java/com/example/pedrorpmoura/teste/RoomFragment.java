package com.example.pedrorpmoura.teste;

import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.pedrorpmoura.teste.databinding.RoomLayoutBinding;

public class RoomFragment extends Fragment {

    private MRoom room;
    private ViewPager mPicsViewPager;
    private RoomImageAdapter mPicsAdapter;
    private TabLayout tabLayout;
    private WrappingViewPager mTabsViewPager;
    private RoomTabsAdapter mTabsAdapter;
    static MediaPlayer sound;


    public RoomFragment() {

    }

    public void setRoom(MRoom room) {
        this.room = room;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RoomLayoutBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.room_layout, container, false);

        View view = binding.getRoot();
        binding.setRoom(this.room);


        mPicsViewPager = (ViewPager) view.findViewById(R.id.room_view_pager);
        TabLayout tabLayout1 = (TabLayout) view.findViewById(R.id.tabDots);
        tabLayout1.setupWithViewPager(mPicsViewPager, true);
        mPicsAdapter = new RoomImageAdapter(getActivity(), room.getRoomPics());
        mPicsViewPager.setAdapter(mPicsAdapter);



        mTabsViewPager = (WrappingViewPager) view.findViewById(R.id.room_tabs_view_pager);

        mTabsViewPager.setAdapter(new WrappingFragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        DescriptionFragment desc_frag = new DescriptionFragment();
                        desc_frag.setDescription(room.getDescription());
                        return desc_frag;
                    case 1:
                        ObjectsPicsFragment2 obj_pics_frag = new ObjectsPicsFragment2();
                        obj_pics_frag.setRoom_objects(room.getRoom_objects());
                        return obj_pics_frag;
                    default:
                        desc_frag = new DescriptionFragment();
                        desc_frag.setDescription(room.getDescription());
                        return desc_frag;
                }
            }
            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "Descrição";
                    case 1:
                        return "Peças";
                    default:
                        return "Peças";
                }
            }


        });

        tabLayout = (TabLayout) view.findViewById(R.id.tabItems);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(mTabsViewPager);
        }






        sound = MediaPlayer.create(getActivity(), room.getSound());
        final Button playSound = (Button) view.findViewById(R.id.sound_button);

        playSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = playSound.getText().toString();
                playSound.setText(currentText.equals("Ouvir áudio-guia")
                        ? "Pausar áudio-guia" : "Ouvir áudio-guia");

                if(sound.isPlaying()){
                    sound.pause();
                }else {
                    sound.start();
                }
            }
        });

        sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer sound) {
                playSound.setText("Ouvir áudio-guia");
            }

        });

        return view;
    }

    public void onPause(){
        super.onPause();
        sound.stop();

    }

}
