package com.example.pedrorpmoura.teste;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pedrorpmoura.teste.databinding.RoomDescriptionBinding;

public class DescriptionFragment extends Fragment {

    private String description;

    public DescriptionFragment() {

    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        RoomDescriptionBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.room_description, container, false);

        View view = binding.getRoot();
        binding.setRoomDescription(this.description);


        return view;
    }
}
