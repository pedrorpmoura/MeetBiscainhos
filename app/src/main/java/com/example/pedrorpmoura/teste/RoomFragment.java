package com.example.pedrorpmoura.teste;

import android.content.res.Resources;
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

import com.example.pedrorpmoura.teste.databinding.RoomLayoutBinding;

public class RoomFragment extends Fragment {

    private MRoom room;
    private ViewPager mViewPager;
    private RoomImageAdapter mAdapter;
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

        mViewPager = (ViewPager) view.findViewById(R.id.room_view_pager);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(mViewPager, true);
        //mAdapter = new RoomImageAdapter(getActivity(), room.getRoomPics());
        mAdapter = new RoomImageAdapter(getActivity(), room.getRoomPics());
        mViewPager.setAdapter(mAdapter);

        sound = MediaPlayer.create(getActivity(), room.getSound());
        final Button playSound = (Button) view.findViewById(R.id.sound_button);

        playSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = playSound.getText().toString();
                playSound.setText(currentText.equals("Começar áudio-guia") ? "Pausar áudio-guia" : "Começar áudio-guia");

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
                playSound.setText("Começar áudio-guia");
            }

        });

        return view;
    }

    public void onPause(){
        super.onPause();
        sound.stop();

    }

}
