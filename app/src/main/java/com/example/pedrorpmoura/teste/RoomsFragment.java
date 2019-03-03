package com.example.pedrorpmoura.teste;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RoomsFragment extends Fragment {

    private ListView mListView;
    private SearchView mSearchView;

    ArrayAdapter<String> mAdapter;
    String[] salas = {"Sala1", "Sala2", "Sala3"};


    public RoomsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View mView = inflater.inflate(R.layout.fragment_rooms, container, false);
        mListView = (ListView) mView.findViewById(R.id.RoomsView);
        mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, salas);
        mListView.setAdapter(mAdapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(getActivity(), Room1.class);
                    startActivity(intent);
                }
            }
        });
        return mView;
    }

}
