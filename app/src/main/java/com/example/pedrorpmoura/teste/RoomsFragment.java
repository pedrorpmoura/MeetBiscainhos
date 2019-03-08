package com.example.pedrorpmoura.teste;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

public class RoomsFragment extends Fragment {

    private ListView mListView;
    private ArrayList<MRoom> rooms = new ArrayList<>();
    private RoomsAdapter mAdapter;
    private RoomFragment room_fragment;

    public RoomsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View root_view = inflater.inflate(R.layout.fragment_rooms_layout,
                container, false);
        mListView = (ListView) root_view.findViewById(R.id.list_of_rooms);

        rooms.add(new MRoom(1,"Oratório","Isto é o oratório.",
                new int[] {R.drawable.oratorio1,
                           R.drawable.oratorio2,
                           R.drawable.oratorio3,
                           R.drawable.oratorio4}));
        rooms.add(new MRoom(2,"Sala de Jogos", "Isto é a sala de jogos.",
                new int[] {}));
        rooms.add(new MRoom(3,"Sala de Mosaicos", "Esta é a sala dos " +
                "mosaicos.", new int[] {}));
        rooms.add(new MRoom(4,"Jardim", "Isto é o jardim.",
                new int[] {}));
        rooms.add(new MRoom(5,"Random", "cenas random.",
                new int[] {}));

        mAdapter = new RoomsAdapter(getActivity(), rooms);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                room_fragment = new RoomFragment();
                room_fragment.setRoom(rooms.get(position));
                replaceFragment(room_fragment);

                // para evitar duplicar a lista aquando de refresh
                rooms.clear();
            }
        });


        return root_view;
    }


    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
