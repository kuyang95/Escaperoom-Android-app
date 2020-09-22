package com.example.onebyone;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class stage3_intro extends AppCompatActivity {
   String intro = "\n      여기서 학교 후문으로 나가는 문\n" +
            "      으로 나가야한다. 근데 또 문에도 잠금\n" +
            "      이 있다. 교무실 안에서 답을 찾아야겠다\n"
    ;

   TextView t1;
   Intent i1;
    SoundPool wall;    // 음질 - 기본값:0
    int wsoundID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage3_intro);

        t1 = (TextView) findViewById(R.id.introText);
        t1.setText(intro);

        wall = new SoundPool(1,
                AudioManager.STREAM_MUSIC,
                0);
        wsoundID = wall.load(this,
                R.raw.dooropen,                         // 사운드 파일
                1);
        wall.play(wsoundID,1,1,0,0,1);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                i1 = new Intent(getApplicationContext(), stage3.class);
                startActivity(i1);
            }
        }, 10000);

    }
}
