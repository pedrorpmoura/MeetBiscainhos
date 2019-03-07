package com.example.pedrorpmoura.teste;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pedrorpmoura.teste.databinding.RoomLayoutBinding;

public class RoomFragment extends Fragment {

    private MRoom room;

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

        return view;
    }
}
