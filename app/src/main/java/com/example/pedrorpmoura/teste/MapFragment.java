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
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements View.OnTouchListener {

    private FragmentTransaction mFragmentTransaction;

    private List<MRoom> rooms = new CreateRooms().getRooms();

    private Button piso;

    private Button visitarSala;

    private TextView currentRoom;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View root_view = inflater.inflate(R.layout.fragment_map, container, false);

        final ImageView iv = (ImageView) root_view.findViewById (R.id.image);
        final ImageView iv2 = (ImageView) root_view.findViewById (R.id.image_areas);

        currentRoom = (TextView) root_view.findViewById (R.id.curentRoom);

        visitarSala = (Button) root_view.findViewById (R.id.visitarSala);

        visitarSala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoomFragment room_fragment = new RoomFragment();
                for(MRoom r : rooms) {
                    if(r.getName().equals(currentRoom.getText().toString())) {
                        room_fragment.setRoom(r);
                        createFragment(room_fragment, r.getName());
                        break;
                    }
                }
            }
        });

        if (iv != null) {
            iv.setOnTouchListener (this);
        }

        piso = (Button) root_view.findViewById(R.id.piso);

        piso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = piso.getText().toString();
                if(currentText.equals("2º Piso")){
                    iv.setImageResource(R.drawable.piso2);
                    iv2.setImageResource(R.drawable.piso2_picker);      //mudar isto
                    piso.setText("1º Piso");
                }else{
                    iv.setImageResource(R.drawable.piso1);
                    iv2.setImageResource(R.drawable.piso1_picker);
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
                String pisoAtual = piso.getText().toString();

                if (ct.closeMatch (Color.RED, touchColor, tolerance)){
                    if(pisoAtual.equals("2º Piso")) {
                        currentRoom.setText("Sala de Entrada");
                        currentRoom.setVisibility(View.VISIBLE);
                        visitarSala.setVisibility(View.VISIBLE);
                    }else{
                        currentRoom.setText("Salão Nobre");
                        currentRoom.setVisibility(View.VISIBLE);
                        visitarSala.setVisibility(View.VISIBLE);
                    }
                }

                else if (ct.closeMatch (Color.MAGENTA, touchColor, tolerance)){
                    currentRoom.setText("Cozinha");
                    currentRoom.setVisibility(View.VISIBLE);
                    visitarSala.setVisibility(View.VISIBLE);

                }

                else if (ct.closeMatch (Color.YELLOW, touchColor, tolerance)){

                    if(pisoAtual.equals("2º Piso")) {
                        currentRoom.setText("Cavalariças");
                        currentRoom.setVisibility(View.VISIBLE);
                        visitarSala.setVisibility(View.VISIBLE);
                    }else{
                        currentRoom.setText("Sala de Jantar");
                        currentRoom.setVisibility(View.VISIBLE);
                        visitarSala.setVisibility(View.VISIBLE);
                    }

                }

                else if (ct.closeMatch (Color.GREEN, touchColor, tolerance)){
                    currentRoom.setText("Jardins");
                    currentRoom.setVisibility(View.VISIBLE);
                    visitarSala.setVisibility(View.VISIBLE);

                }

                else if (ct.closeMatch (Color.DKGRAY, touchColor, tolerance)){
                    currentRoom.setText("Escadaria");
                    currentRoom.setVisibility(View.VISIBLE);
                    visitarSala.setVisibility(View.INVISIBLE);
                }

                else if (ct.closeMatch (Color.CYAN, touchColor, tolerance)){

                    if(pisoAtual.equals("2º Piso")) {
                        currentRoom.setText("Casas de Banho");
                        currentRoom.setVisibility(View.VISIBLE);
                        visitarSala.setVisibility(View.INVISIBLE);
                    }else{
                        currentRoom.setText("Salão de Música e do Jogo");
                        currentRoom.setVisibility(View.VISIBLE);
                        visitarSala.setVisibility(View.VISIBLE);
                    }
                }

                else if (ct.closeMatch (Color.BLUE, touchColor, tolerance)){

                    if(pisoAtual.equals("2º Piso")) {
                        currentRoom.setText("Receção");
                        currentRoom.setVisibility(View.VISIBLE);
                        visitarSala.setVisibility(View.INVISIBLE);
                    }else{
                        currentRoom.setText("Sala de Entrada");
                        currentRoom.setVisibility(View.VISIBLE);
                        visitarSala.setVisibility(View.VISIBLE);
                    }
                }

                else if (ct.closeMatch (getResources().getColor(R.color.teal), touchColor, tolerance)){
                    currentRoom.setText("Oratório");
                    currentRoom.setVisibility(View.VISIBLE);
                    visitarSala.setVisibility(View.VISIBLE);
                }

                else if (ct.closeMatch (getResources().getColor(R.color.navy), touchColor, tolerance)){
                    currentRoom.setText("Gabinete");
                    currentRoom.setVisibility(View.VISIBLE);
                    visitarSala.setVisibility(View.VISIBLE);
                }

                else if (ct.closeMatch (getResources().getColor(R.color.purple), touchColor, tolerance)){
                    currentRoom.setText("Sala do Estrado");
                    currentRoom.setVisibility(View.VISIBLE);
                    visitarSala.setVisibility(View.VISIBLE);
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
