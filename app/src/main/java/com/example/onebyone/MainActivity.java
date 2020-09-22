package com.example.onebyone;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    String intro = "*      누군가 문을 두드린다.*" +
            "      내가 괴롭히던 녀석인데..*" +
            "      정신이 나간 얼굴로 날 노려보고 있다.", showing = "";
    char c;
    int butt = 0;
    TimerTask tt;
    Timer mTimer;
    TextView mTvTimer;
    static int i = 0;
    Button st1b1;
    Button st1b2;

    SoundPool sp;    // 음질 - 기본값:0
    int soundID;    // 재생 우선순위
     MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = new SoundPool(1,
                AudioManager.STREAM_MUSIC,
                0);
        soundID = sp.load(this,
                R.raw.ccc,                         // 사운드 파일
                1); // 재생 우선순위
        mp = MediaPlayer.create(this,R.raw.bgm);
        mp.setLooping(true);
        mp.start();

        mTvTimer = (TextView) findViewById(R.id.introText1);
        mTimer = new Timer();

        st1b1 = (Button) findViewById(R.id.st1b1);
        st1b2 = (Button) findViewById(R.id.st1b2);

        st1b1.setVisibility(View.INVISIBLE);
        st1b2.setVisibility(View.INVISIBLE);

        if (butt == 0) {
            butt = 1;
            showing = "";
            i = 0;
            tt = timerTaskMaker();
            mTimer.schedule(tt, 0, 80);

        } else {
            showing = "";
            i = 0;
            tt.cancel();
            tt = timerTaskMaker();
            mTimer.schedule(tt, 0, 80);
        }


    }

    public TimerTask timerTaskMaker(){
        TimerTask tempTask = new TimerTask() {
            @Override
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        if(i<intro.length()) {
                            if((c = intro.charAt(i++)) == '*')
                                c = '\n';
                                showing += c;
                               sp.play(soundID,1,1,0,0,1);
                                mTvTimer.setText(showing);
                        }
                        else if(i==intro.length()) {
                            st1b1.setVisibility(View.VISIBLE);
                            st1b2.setVisibility(View.VISIBLE);
                        }

                    }
                });
            }
        };
    return tempTask;
    }

    public void goGameOver (View v) {
        st1b1 = (Button) findViewById(R.id.st1b1);
        st1b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameOver.class);
                butt = 0;
                tt.cancel();
                intent.putExtra("result", "stage1");
                mp.stop();
                startActivity(intent);
            }
        });
    }

    public void goNext1 (View v) {
        st1b2 = (Button) findViewById(R.id.st1b2);
        st1b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), stage2.class);
                butt = 0;
                tt.cancel();
                startActivity(intent2);
            }
        });
    }


}



