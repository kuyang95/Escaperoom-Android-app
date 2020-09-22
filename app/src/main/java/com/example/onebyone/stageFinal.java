package com.example.onebyone;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class stageFinal extends AppCompatActivity {
    int i = 0;
    Intent in;
    SoundPool wall;    // 음질 - 기본값:0
    int wsoundID;
    SoundPool sp;    // 음질 - 기본값:0
    int soundID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_final);

        in = new Intent(this, finish.class);
        wall = new SoundPool(1,
                AudioManager.STREAM_MUSIC,
                0);
        wsoundID = wall.load(this,
                R.raw.dooropen,                         // 사운드 파일
                1);
        wall.play(wsoundID,1,1,0,0,1);

        sp = new SoundPool(1,
                AudioManager.STREAM_MUSIC,
                0);
        soundID = sp.load(this,
                R.raw.wallhit,                         // 사운드 파일
                1);

    }
    public void b1(View v) {
        Button b1 = (Button) findViewById(R.id.i1);
        ImageView image = (ImageView) findViewById(R.id.im1);
        i++;
        sp.play(soundID,1,1,0,0,1);
        if (i == 30) {
            image.setVisibility(View.VISIBLE);


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    startActivity(in);
                }
            }, 5000);

        }
    }
}