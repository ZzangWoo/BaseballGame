package com.zzangwoo.whdlw.baseballgame.SelectActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.zzangwoo.whdlw.baseballgame.R;

public class gamemodeselectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamemodeselect);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.7), (int) (height * 0.65));

        Button normal_gameButton = (Button) findViewById(R.id.normal_gameButton);
        Button time_attackButton = (Button) findViewById(R.id.time_attackButton);

        ///////////////////////////// 일반게임 버튼 누를 때 ///////////////////////////////////
        normal_gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), selectActivity.class);
                startActivity(intent);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////// 타임어택 버튼 누를 때 ///////////////////////////////////
        time_attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), time_attackSelectActivity.class);
                startActivity(intent);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////
    }
}
