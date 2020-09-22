package com.example.onebyone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class stage3 extends AppCompatActivity {

    Button check_button, escape_button;
    Button check_button2, escape_button2;
    Button check_button3, escape_button3;
    Button check_button4, escape_button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage3);

        Button b = (Button) findViewById(R.id.popup_button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(stage3.this, Pop.class));
            }
        });
        Button b2 = (Button) findViewById(R.id.popup_button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(stage3.this, Pop2.class));
            }
        });
        Button b3 = (Button) findViewById(R.id.popup_button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(stage3.this, Pop3.class));
            }
        });
        Button b4 = (Button) findViewById(R.id.popup_button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(stage3.this, Pop4.class));
            }
        });

    }
}
