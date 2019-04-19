package com.example.pedrorpmoura.teste;


import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements View.OnTouchListener {

    private FragmentTransaction mFragmentTransaction;

    private List<MRoom> rooms = new CreateRooms().getRooms();

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View root_view = inflater.inflate(R.layout.fragment_map, container, false);

        final ImageView iv = (ImageView) root_view.findViewById (R.id.image);
        final ImageView iv2 = (ImageView) root_view.findViewById (R.id.image_areas);

        if (iv != null) {
            iv.setOnTouchListener (this);
        }

        final Button piso = (Button) root_view.findViewById(R.id.piso);

        piso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = piso.getText().toString();
                if(currentText.equals("2º Piso")){
                    iv.setImageResource(R.drawable.oratorio1);       //mudar isto
                    iv2.setImageResource(R.drawable.oratorio1);      //mudar isto
                    piso.setText("1º Piso");
                }else{
                    iv.setImageResource(R.drawable.original2);
                    iv2.setImageResource(R.drawable.colored2);
                    piso.setText("2º Piso");
                }

            }
        });


        return root_view;
    }

    public boolean onTouch (View v, MotionEvent ev)
    {

        final int action = ev.getAction();

        final int evX = (int) ev.getX();
        final int evY = (int) ev.getY();

        ImageView imageView = (ImageView) v.findViewById (R.id.image);
        if (imageView == null) return false;

        switch (action) {
            /*
            case MotionEvent.ACTION_DOWN :
                if (currentResource == R.drawable.original2) {
                    nextImage = R.drawable.p2_ship_pressed;
                    handledHere = true;

                } else handledHere = true;
                break;

            */

            case MotionEvent.ACTION_UP:

                int touchColor = getHotspotColor (R.id.image_areas, evX, evY);

                ColorTool ct = new ColorTool ();
                int tolerance = 25;

                if (ct.closeMatch (Color.RED, touchColor, tolerance)){
                    RoomFragment room_fragment = new RoomFragment();
                    for(MRoom r : rooms) {
                        if(r.getName().equals("Sala de Entrada")) {
                            room_fragment.setRoom(r);
                            createFragment(room_fragment, r.getName());
                            break;
                        }
                    }
                }

                else if (ct.closeMatch (Color.MAGENTA, touchColor, tolerance)){
                    RoomFragment room_fragment = new RoomFragment();
                    for(MRoom r : rooms) {
                        if(r.getName().equals("Cozinha")) {
                            room_fragment.setRoom(r);
                            createFragment(room_fragment, r.getName());
                            break;
                        }
                    }
                }

                else if (ct.closeMatch (Color.YELLOW, touchColor, tolerance)){
                    RoomFragment room_fragment = new RoomFragment();
                    for(MRoom r : rooms) {
                        if(r.getName().equals("Cavalariças")) {
                            room_fragment.setRoom(r);
                            createFragment(room_fragment, r.getName());
                            break;
                        }
                    }
                }

                else if (ct.closeMatch (Color.GREEN, touchColor, tolerance)){
                    RoomFragment room_fragment = new RoomFragment();
                    for(MRoom r : rooms) {
                        if(r.getName().equals("Jardins")) {
                            room_fragment.setRoom(r);
                            createFragment(room_fragment, r.getName());
                            break;
                        }
                    }
                }

                v.performClick();

                break;

            default:
                break;

        }

        return true;
    }

    public int getHotspotColor (int hotspotId, int x, int y) {

        ImageView img = (ImageView) getView().findViewById (hotspotId);
        img.setDrawingCacheEnabled(true);
        Bitmap hotspots = Bitmap.createBitmap(img.getDrawingCache());
        img.setDrawingCacheEnabled(false);
        return hotspots.getPixel(x, y);
    }

    public void createFragment(Fragment fragment, String title) {
        mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.main_container, fragment);
        mFragmentTransaction.commit();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
    }


}
