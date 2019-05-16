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
    private HeightWrappingViewPager mTabsViewPager;
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

        TabLayout tabLayout2 = (TabLayout) view.findViewById(R.id.tabItems);
        mTabsViewPager = (HeightWrappingViewPager) view.findViewById(R.id.room_tabs_view_pager);
        mTabsAdapter = new RoomTabsAdapter(getChildFragmentManager(),
                tabLayout2.getTabCount(), this.room);
        mTabsViewPager.setAdapter(mTabsAdapter);
        mTabsViewPager.measure(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        mTabsViewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout2));
        tabLayout2.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mTabsViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

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
