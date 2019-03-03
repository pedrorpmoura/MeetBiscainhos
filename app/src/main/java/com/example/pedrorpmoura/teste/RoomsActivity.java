package com.example.pedrorpmoura.teste;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class RoomsActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mNavigationView;

    private ListView mListView;
    String listOfRooms[] = {"Sala 1", "Sala 2", "Sala 3", "Sala 4", "Sala 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_rooms);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        Intent intent;
                        switch(id) {
                            case R.id.home_page:
                                intent = new Intent(RoomsActivity.this,
                                        MainActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.rooms:
                                intent = new Intent(RoomsActivity.this,
                                        RoomsActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.interactive_map:
                                intent = new Intent(RoomsActivity.this,
                                        MapActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.quiz:
                                intent = new Intent(RoomsActivity.this,
                                        QuizActivity.class);
                                startActivity(intent);
                                return true;
                        }
                        return false;
                    }
                }
        );


        ListAdapter mListAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_expandable_list_item_1, listOfRooms);

        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setAdapter(mListAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
