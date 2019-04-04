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
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements View.OnTouchListener {

    private FragmentTransaction mFragmentTransaction;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root_view = inflater.inflate(R.layout.fragment_map, container, false);

        ImageView iv = (ImageView) root_view.findViewById (R.id.image);
        if (iv != null) {
            iv.setOnTouchListener (this);
        }

        return root_view;
    }

    public boolean onTouch (View v, MotionEvent ev)
    {
        MRoom entrada = new MRoom(1,"Sala de Entrada","Inserir descrição", new int[] {}, R.raw.sound_sample);
        MRoom cavalaricas = new MRoom(8,"Cavalariças", "Inserir descrição",
                new int[] {}, R.raw.sound_sample);
        MRoom cozinha = new MRoom(9,"Cozinha", "Inserir descrição",
                new int[] {}, R.raw.sound_sample);

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

            case MotionEvent.ACTION_UP :
                int touchColor = getHotspotColor (R.id.image_areas, evX, evY);

                ColorTool ct = new ColorTool ();
                int tolerance = 25;

                if (ct.closeMatch (Color.RED, touchColor, tolerance)){
                    RoomFragment room_fragment = new RoomFragment();
                    room_fragment.setRoom(entrada);
                    createFragment(room_fragment, entrada.getName());
                }

                else if (ct.closeMatch (Color.MAGENTA, touchColor, tolerance)){
                    RoomFragment room_fragment = new RoomFragment();
                    room_fragment.setRoom(cozinha);
                    createFragment(room_fragment, cozinha.getName());
                }

                else if (ct.closeMatch (Color.YELLOW, touchColor, tolerance)){
                    RoomFragment room_fragment = new RoomFragment();
                    room_fragment.setRoom(cavalaricas);
                    createFragment(room_fragment, cavalaricas.getName());
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
