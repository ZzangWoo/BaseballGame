package com.zzangwoo.whdlw.baseballgame;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /////////////////////////////////////////// Firebase 푸시알림 ///////////////////////////////////////////////////
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel =
                    new NotificationChannel("MyNotifications", "MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ////////////// 배경이미지 반투명 //////////////
        Drawable alpha = ((ImageView)findViewById(R.id.firstBackground)).getBackground();
        alpha.setAlpha(80);
        /////////////////////////////////////////////

        Button startButton = (Button) findViewById(R.id.startButton);
        Button exitButton = (Button) findViewById(R.id.exitButton);
        Button howtoButton = (Button) findViewById(R.id.howtoButton);
        Button rankingButton = (Button) findViewById(R.id.rankingButton);


        ///////////////////////// 게임시작 버튼 누를 때 //////////////////////////////////
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), gamemodeselectActivity.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////////////////////////////////////////

        /////////////////////////// 게임방법 버튼 누를 때 ///////////////////////////////
        howtoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), howtoActivity.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////////////////////////////////////////

        ////////////////////////// 랭킹 버튼 누를 때 //////////////////////////////////////
        rankingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), rankingSelect.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////////////////////////////////////////

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
