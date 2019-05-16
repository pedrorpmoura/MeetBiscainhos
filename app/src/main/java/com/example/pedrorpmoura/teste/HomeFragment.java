package com.example.pedrorpmoura.teste;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ViewFlipper v_flipper;
    static MediaPlayer sound;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root_view = inflater.inflate(R.layout.fragment_home, container, false);
        int carousel[] = {R.drawable.home1,
                R.drawable.home2,
                R.drawable.home3,
                R.drawable.home4};
        v_flipper = (ViewFlipper) root_view.findViewById(R.id.v_flipper);

        for(int image: carousel){
            flipperImages(image);
        }

        sound = MediaPlayer.create(getActivity(), R.raw.introducao);
        final Button playSound = (Button) root_view.findViewById(R.id.sound_button);

        playSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = playSound.getText().toString();
                playSound.setText(currentText.equals("Ouvir áudio")
                        ? "Pausar áudio" : "Ouvir áudio");

                if(sound.isPlaying()){
                    sound.pause();
                }else {
                    sound.start();
                }
            }
        });

        sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer sound) {
                playSound.setText("Ouvir áudio");
            }

        });

        return root_view;
    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(getActivity(), android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(getActivity(), android.R.anim.slide_out_right);

    }

    public void onPause(){
        super.onPause();
        sound.stop();

    }

}
