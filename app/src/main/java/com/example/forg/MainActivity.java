package com.example.forg;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String num = "numKey";
    SharedPreferences sp;
    SharedPreferences.Editor ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        ed = sp.edit();

        ImageButton btn = findViewById(R.id.froggy);
        TextView tv = findViewById(R.id.texty);

        tv.setText(sp.getString(num, "0"));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count_str = tv.getText().toString();
                int count = Integer.parseInt(count_str);
                count++;
                ed.putString(num, String.valueOf(count));
                ed.commit();
                tv.setText(String.valueOf(count));
            }
        });

        Button reset = findViewById(R.id.resset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count_str = tv.getText().toString();
                int count = Integer.parseInt(count_str);
                count = 0;
                ed.putString(num, String.valueOf(count));
                ed.commit();
                tv.setText(String.valueOf(count));
            }
        });

    }
}