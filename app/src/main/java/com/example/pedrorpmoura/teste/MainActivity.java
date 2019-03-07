package com.example.pedrorpmoura.teste;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mNavigationView;
    private FragmentTransaction mFragmentTransaction;

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

        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        mDrawerLayout.closeDrawers();
                        item.setChecked(true);
                        switch(item.getItemId()) {
                            case R.id.home_page:
                                mFragmentTransaction = getSupportFragmentManager().beginTransaction();
                                mFragmentTransaction.replace(R.id.main_container, new HomeFragment());
                                mFragmentTransaction.commit();
                                getSupportActionBar().setTitle("Home Fragment");
                                break;
                            case R.id.rooms:
                                mFragmentTransaction = getSupportFragmentManager().beginTransaction();
                                //mFragmentTransaction.replace(R.id.main_container, new RoomsFragment());
                                mFragmentTransaction.replace(R.id.main_container, new RoomsFragmentTest());
                                mFragmentTransaction.addToBackStack(null);
                                mFragmentTransaction.commit();
                                getSupportActionBar().setTitle("Salas");
                                break;
                            case R.id.interactive_map:
                                mFragmentTransaction = getSupportFragmentManager().beginTransaction();
                                mFragmentTransaction.replace(R.id.main_container, new MapFragment());
                                mFragmentTransaction.commit();
                                getSupportActionBar().setTitle("Mapa Interativo");
                                break;
                            case R.id.quiz:
                                mFragmentTransaction = getSupportFragmentManager().beginTransaction();
                                mFragmentTransaction.replace(R.id.main_container, new QuizFragment());
                                mFragmentTransaction.commit();
                                getSupportActionBar().setTitle("Quiz");
                                break;

                        }
                        return true;
                    }
                }
        );

        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.add(R.id.main_container, new HomeFragment());
        mFragmentTransaction.commit();
        getSupportActionBar().setTitle("Home Fragment");
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
}
