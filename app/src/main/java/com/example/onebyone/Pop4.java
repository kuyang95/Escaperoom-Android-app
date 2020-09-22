package com.example.onebyone;

import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Pop4 extends Activity implements View.OnClickListener{

    Button check_button,escape_button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop4);

        findViewById(R.id.CloseButton4).setOnClickListener(this);

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int) (width*.8),(int) (height*.6));
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.CloseButton4:
                this.finish();
                break;
        }
    }

    public void moveActivity4 (View v) {
        Intent it = new Intent(this, GameOver.class);
        startActivity(it);
    }
}