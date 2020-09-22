package com.example.onebyone;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.*;

public class finish extends AppCompatActivity {

    String finish = "*      꾸..꿈이였다.*" +
            "      끔찍함이 온 몸에 땀으로 느껴졌다..*"
            , showing = "";
    char c;
    int butt = 0;
    TimerTask tt;
    Timer mTimer;
    TextView mTvTimer;
    int i = 0;
    Button goStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        mTvTimer = (TextView) findViewById(R.id.finalText1);
        mTimer = new Timer();

        goStart = (Button) findViewById(R.id.goStart);
        goStart.setVisibility(View.INVISIBLE);

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
                finish.this.runOnUiThread(new Runnable() {
                    public void run() {
                        if(i<finish.length()) {
                            if((c = finish.charAt(i++)) == '*')
                                c = '\n';
                            showing += c;
                            mTvTimer.setText(showing);
                        }
                        else if(i==finish.length()) {
                            goStart.setVisibility(View.VISIBLE);
                        }

                    }
                });
            }
        };
        return tempTask;
    }

    public void goStart (View v) {
        goStart = (Button) findViewById(R.id.goStart);
        goStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), intro.class);
                butt = 0;
                tt.cancel();

                startActivity(intent);
            }
        });
    }





}



