package com.viviane.spotifyviviane;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView voltar, play, passar, img;
    private MediaPlayer player;
    private int i =0, ax=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voltar = findViewById(R.id.voltar);
        play = findViewById(R.id.play);
        img = findViewById(R.id.img);
        passar = findViewById(R.id.passar);


        img.setImageResource(R.drawable.img_um);

        passar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i==0){
                    player.stop();
                    img.setImageResource(R.drawable.img_dois);
                    player = MediaPlayer.create(getApplicationContext(), R.raw.som_dois);
                    i=1;
                }else if (i==1){
                    player.stop();
                    img.setImageResource(R.drawable.img_tres);
                    player = MediaPlayer.create(getApplicationContext(), R.raw.som_tres);
                    i=2;
                }else{
                    player.stop();
                    img.setImageResource(R.drawable.img_um);
                    player = MediaPlayer.create(getApplicationContext(), R.raw.som_um);
                    i=0;
                }
                play.setImageResource(R.drawable.ic_baseline_pause_24);
                player.start();
                ax=1;
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ax==1){
                    play.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                    player.pause();
                    ax=0;
                }else{
                    if (player==null){
                        if (i ==0){
                            img.setImageResource(R.drawable.img_um);
                            player = MediaPlayer.create(getApplicationContext(), R.raw.som_um);
                        }if (i ==1){
                            img.setImageResource(R.drawable.img_dois);
                            player = MediaPlayer.create(getApplicationContext(), R.raw.som_dois);
                        }if (i ==2){
                            img.setImageResource(R.drawable.img_tres);
                            player = MediaPlayer.create(getApplicationContext(), R.raw.som_tres);
                        }
                    }
                    play.setImageResource(R.drawable.ic_baseline_pause_24);
                    player.start();
                    ax=1;
                }
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i ==0){
                    player.stop();
                    img.setImageResource(R.drawable.img_tres);
                    player = MediaPlayer.create(getApplicationContext(), R.raw.som_tres);
                    i=2;
                }else if (i ==1){
                    player.stop();
                    img.setImageResource(R.drawable.img_um);
                    player = MediaPlayer.create(getApplicationContext(), R.raw.som_um);
                    i=0;
                }else{
                    player.stop();
                    img.setImageResource(R.drawable.img_dois);
                    player = MediaPlayer.create(getApplicationContext(), R.raw.som_dois);
                    i=1;
                }
                play.setImageResource(R.drawable.ic_baseline_pause_24);
                player.start();
                ax=1;
            }
        });
    }
}