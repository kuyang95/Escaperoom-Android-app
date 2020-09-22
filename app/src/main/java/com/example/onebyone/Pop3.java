package com.example.onebyone;

import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pop3 extends Activity implements View.OnClickListener{

    Button check_button,escape_button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop3);

        findViewById(R.id.CloseButton3).setOnClickListener(this);

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int) (width*.8),(int) (height*.6));
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.CloseButton3:
                this.finish();
                break;
        }
    }

    public void moveActivity3 (View v) {
        Intent it = new Intent(this, GameOver.class);
        startActivity(it);
    }
}