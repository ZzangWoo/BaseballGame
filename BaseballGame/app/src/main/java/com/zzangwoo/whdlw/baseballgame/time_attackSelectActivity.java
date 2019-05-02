package com.zzangwoo.whdlw.baseballgame;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class time_attackSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_attack_select);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.75));

        Button time_attackButton3 = (Button) findViewById(R.id.time_attackButton3);
        Button time_attackButton4 = (Button) findViewById(R.id.time_attackButton4);
        Button time_attackButton5 = (Button) findViewById(R.id.time_attackButton5);

        ////////////////////////////////// 타임어택 3자리 수 버튼 ///////////////////////////////
        time_attackButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), time_attack_ThreeNum.class);
                startActivity(intent);
            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////// 타임어택 4자리 수 버튼 ///////////////////////////////
        time_attackButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), time_attack_FourNum.class);
                startActivity(intent);
            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////// 타임어택 5자리 수 버튼 ///////////////////////////////
        time_attackButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), time_attack_FiveNum.class);
                startActivity(intent);
            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////
    }
}
