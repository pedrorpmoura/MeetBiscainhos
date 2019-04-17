package com.example.pedrorpmoura.teste;

import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mNavigationView;
    private FragmentTransaction mFragmentTransaction;

    ExpandableListAdapter mMenuAdapter;
    ExpandableListView expandableList;
    List<ExpandedMenuModel> mlistDataHeader;
    HashMap<ExpandedMenuModel, List<String>> mlistDataChild;


    private List<MRoom> rooms = new CreateRooms().getRooms();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        expandableList = (ExpandableListView) findViewById(R.id.nav_menu);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);

        prepareListData();
        mMenuAdapter = new ExpandableListAdapter(this, mlistDataHeader,
                mlistDataChild, expandableList);

        // setting list adapter
        expandableList.setAdapter(mMenuAdapter);

        expandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view,
                                        int groupPosition, int childPosition, long l) {
                if(groupPosition == 1) {
                    mDrawerLayout.closeDrawers();

                    MRoom selected_room = rooms.get(childPosition);
                    RoomFragment room_fragment = new RoomFragment();
                    room_fragment.setRoom(selected_room);
                    createFragment(room_fragment, selected_room.getName());
                }

                return false;
            }
        });

        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView,
                                        View view, int groupPosition, long l) {
                switch(groupPosition) {
                    case 0:
                        mDrawerLayout.closeDrawers();
                        createFragment(new HomeFragment(), "Página Inicial");
                        break;
                    case 1:
                        return false;
                    case 2:
                        mDrawerLayout.closeDrawers();
                        createFragment(new MapFragment(), "Mapa interativo");
                        break;
                    case 3:
                        mDrawerLayout.closeDrawers();
                        createFragment(new QuizFragment(), "Quiz");
                }

                return true;
            }
        });

        createFragment(new HomeFragment(), "Página Inicial");
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    public void createFragment(Fragment fragment, String title) {
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.main_container, fragment);
        mFragmentTransaction.commit();
        getSupportActionBar().setTitle(title);
    }




    private void prepareListData() {

        mlistDataHeader = new ArrayList<ExpandedMenuModel>();
        mlistDataChild = new HashMap<ExpandedMenuModel, List<String>>();

        // HomePage item
        ExpandedMenuModel home_page_item = new ExpandedMenuModel();
        home_page_item.setIconName("Página Inicial");
        mlistDataHeader.add(home_page_item);


        // Rooms item
        ExpandedMenuModel rooms_item = new ExpandedMenuModel();
        rooms_item.setIconName("Áreas do Museu");
        mlistDataHeader.add(rooms_item);

            // Adding child data
            List<String> rooms_list = new ArrayList<String>();
            for(MRoom r : rooms) {
                rooms_list.add(r.getName());
            }



        // Interactive Map item
        ExpandedMenuModel interactive_map_item = new ExpandedMenuModel();
        interactive_map_item.setIconName("Mapa Interativo");
        mlistDataHeader.add(interactive_map_item);


        // Quiz item
        ExpandedMenuModel quiz_item = new ExpandedMenuModel();
        quiz_item.setIconName("Quiz");
        mlistDataHeader.add(quiz_item);

        mlistDataChild.put(mlistDataHeader.get(1), rooms_list);

    }
}
