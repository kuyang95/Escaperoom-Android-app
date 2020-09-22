package com.example.onebyone;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    TextView t1;
    Intent i1;
    String name;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        mp = MediaPlayer.create(this,R.raw.over);
        mp.setLooping(true);
        mp.start();
        t1 = (TextView) findViewById(R.id.got1);
        /*i1 = getIntent();

        name = i1.getExtras().getString("result");

        if(name.equals("stage1"))
            t1.setText("아.. 왜 열었을까;");*/

    }

    public void onClick(View v){
        i1 =  new Intent(this,intro.class);
        mp.stop();
        startActivity(i1);

    }



}
