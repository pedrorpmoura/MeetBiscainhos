package com.example.pedrorpmoura.teste;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class Room1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room1);

        ViewPager viewPager =  findViewById(R.id.viewPager1);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);
    }
}
