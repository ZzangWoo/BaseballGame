package com.zzangwoo.whdlw.baseballgame.SelectActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zzangwoo.whdlw.baseballgame.R;
import com.zzangwoo.whdlw.baseballgame.gameStart;
import com.zzangwoo.whdlw.baseballgame.gameStart_five;
import com.zzangwoo.whdlw.baseballgame.gameStart_four;

public class selectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.7), (int) (height * 0.65));

        Button three = (Button) findViewById(R.id.threeLineNum);
        Button four = (Button) findViewById(R.id.fourLineNum);
        Button five = (Button) findViewById(R.id.fiveLineNum);

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), gameStart.class);
                startActivity(intent);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), gameStart_four.class);
                startActivity(intent);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(getApplicationContext(), gameStart_five.class);
                startActivity(intent5);
            }
        });
    }
}
