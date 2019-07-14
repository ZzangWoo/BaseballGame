package com.zzangwoo.whdlw.baseballgame;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class rankingSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_select);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.9), (int) (height * 0.85));

        Button three = (Button) findViewById(R.id.rankingThreeLineNum);
        Button four = (Button) findViewById(R.id.rankingFourLineNum);

        Drawable alpha = ((ImageView)findViewById(R.id.rankingSelectBackground)).getBackground();
        alpha.setAlpha(80);

        /*
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), rankingActivity.class);
                startActivity(intent);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), rankingActivity.class);
                startActivity(intent);
            }
        });
        */
    }
}
