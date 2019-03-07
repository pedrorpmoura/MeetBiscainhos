package com.example.pedrorpmoura.teste;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;


public class RoomsAdapter extends ArrayAdapter<MRoom> {

    private Context context;
    private List<MRoom> rooms = new ArrayList<>();

    public RoomsAdapter(Context context, ArrayList<MRoom> rooms) {
        super(context, 0, rooms);
        this.context = context;
        this.rooms = rooms;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View list_item = convertView;

        if(list_item == null) {
            list_item = LayoutInflater.from(context).inflate(R.layout.room_list_item,
                    parent, false);
        }

        MRoom current_room = rooms.get(position);

        TextView tv_name = (TextView) list_item.findViewById(R.id.tv_name);
        TextView tv_ala = (TextView) list_item.findViewById(R.id.tv_ala);

        tv_name.setText(current_room.getName());

        String ala_text = "Ala " + current_room.getAla();
        tv_ala.setText(ala_text);

        return list_item;
    }
}
