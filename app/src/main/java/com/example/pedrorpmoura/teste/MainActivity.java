package com.example.pedrorpmoura.teste;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
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
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        Intent intent;
                        switch(id) {
                            case R.id.home_page:
                                intent = new Intent(MainActivity.this,
                                        MainActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.rooms:
                                intent = new Intent(MainActivity.this,
                                        RoomsActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.interactive_map:
                                intent = new Intent(MainActivity.this,
                                        MapActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.quiz:
                                intent = new Intent(MainActivity.this,
                                        QuizActivity.class);
                                startActivity(intent);
                                return true;
                            default:
                                break;
                        }
                        return false;
                    }
                }
        );
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
