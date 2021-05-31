package com.example.practical6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

TouchScreen tc;
LinearLayout ll;
Spinner sp;
Button bt;
Canvas canvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tc=new TouchScreen(this,null);

        ll=findViewById(R.id.screen);
        sp=findViewById(R.id.spin);
        bt=findViewById(R.id.btn_clear);

        ll.addView(tc);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    tc.clearCanvas();
            }
        });
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tc.changeColor(String.valueOf(sp.getSelectedItem()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

