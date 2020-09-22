package com.example.onebyone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }
    public void onClick1(View v){
        Intent i1;

        switch (v.getId()){
            case R.id.start:
                i1 = new Intent(this,MainActivity.class);
                startActivity(i1);
                break;
            case R.id.end:
                finish();
        }
    }


}

