package com.example.onebyone;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;


public class stage2 extends AppCompatActivity {
    Intent i1;
    String stage2 = "*      아래의 숫자들 중, 나머지 숫자들과*      규칙이 다른 하나는 무엇일까요?**"
            ,plus = "         8226   3465   7371   2718\n         1089   7902   2945   9171"
            , showing = "",intro = "\n      그 녀석이 날 쫒아온다. 앞에\n" +
            "      교무실이 보인다. 들어가야겠다\n" +
            "      생각할때 자물쇠가 보였다. 다행히\n"+
            "      답에 대한 힌트가 위에 적혀있다."
           ;
    char c;
    int butt = 0;
    TimerTask tt;
    Timer mTimer;
    TextView mTvTimer;
    static int i = 0;
    AbsoluteLayout ab;
    SoundPool sp;    // 음질 - 기본값:0
    int soundID;
    SoundPool wall;    // 음질 - 기본값:0
    int wsoundID;

    Button.OnClickListener t = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            TextView text= (TextView)findViewById(R.id.t2);
            Button b=(Button)findViewById(v.getId());
            StringBuilder str = new StringBuilder();
            switch (v.getId()){
                case R.id.b1:
                    str.append(b.getText().toString());
                    text.append(str);
                    break;
                case R.id.b2:
                    str.append(b.getText().toString());
                    text.append(str);
                    break;
                case R.id.b3:
                    str.append(b.getText().toString());
                    text.append(str);
                    break;
                case R.id.b4:
                    str.append(b.getText().toString());
                    text.append(str);
                    break;
                case R.id.b5:
                    str.append(b.getText().toString());
                    text.append(str);
                    break;
                case R.id.b6:
                    str.append(b.getText().toString());
                    text.append(str);
                    break;
                case R.id.b7:
                    str.append(b.getText().toString());
                    text.append(str);
                    break;
                case R.id.b8:
                    str.append(b.getText().toString());
                    text.append(str);
                    break;
                case R.id.b9:
                    str.append(b.getText().toString());
                    text.append(str);
                    break;
                case R.id.b0:
                    str.append(b.getText().toString());
                    text.append(str);
                    break;
                case R.id.bx:
                    text.setText("");
                    break;
                case R.id.bo:
                    if(text.getText().toString().equals("2945")) {
                        i1 = new Intent(getApplicationContext(), stage3_intro.class);
                        tt.cancel();
                        butt = 0;
                        startActivity(i1);
                    }
                    else {
                        i1 = new Intent(getApplicationContext(), GameOver.class);
                        tt.cancel();
                        butt = 0;
                        startActivity(i1);
                    }
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage2);

        sp = new SoundPool(1,
                AudioManager.STREAM_MUSIC,
                0);
        soundID = sp.load(this,
                R.raw.ccc,                         // 사운드 파일
                1);

        wall = new SoundPool(1,
                AudioManager.STREAM_MUSIC,
                0);
        wsoundID = wall.load(this,
                R.raw.dooropen,                         // 사운드 파일
                1);
        wall.play(wsoundID,1,1,0,0,1);

        mTvTimer = (TextView) findViewById(R.id.stage2Text);
        mTimer = new Timer();
        ab = (AbsoluteLayout) findViewById(R.id.ab);

        mTvTimer.setText(intro);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (butt == 0) {
                    butt = 1;
                    showing = "";
                    i = 0;
                    tt = timerTaskMaker();
                    mTimer.schedule(tt, 0, 100);
                } else {
                    showing = "";
                    i = 0;
                    tt.cancel();
                    tt = timerTaskMaker();
                    mTimer.schedule(tt, 0, 100);
                }
            }
        }, 10000);
        findViewById(R.id.b1).setOnClickListener(t);
        findViewById(R.id.b2).setOnClickListener(t);
        findViewById(R.id.b3).setOnClickListener(t);
        findViewById(R.id.b4).setOnClickListener(t);
        findViewById(R.id.b5).setOnClickListener(t);
        findViewById(R.id.b6).setOnClickListener(t);
        findViewById(R.id.b7).setOnClickListener(t);
        findViewById(R.id.b8).setOnClickListener(t);
        findViewById(R.id.b9).setOnClickListener(t);
        findViewById(R.id.b0).setOnClickListener(t);
        findViewById(R.id.bx).setOnClickListener(t);
        findViewById(R.id.bo).setOnClickListener(t);


    }

    public TimerTask timerTaskMaker(){
        TimerTask tempTask = new TimerTask() {
            @Override
            public void run() {
                stage2.this.runOnUiThread(new Runnable() {
                    public void run() {
                        if(i<stage2.length()) {
                            if((c = stage2.charAt(i++)) == '*')
                                c = '\n';
                            showing += c;
                            mTvTimer.setText(showing);
                            sp.play(soundID,1,1,0,0,1);
                        }
                        else if(i==stage2.length()) {
                            ab.setVisibility(View.VISIBLE);
                            mTvTimer.setText(showing+plus);


                        }

                    }
                });
            }
        };
        return tempTask;
    }

}

