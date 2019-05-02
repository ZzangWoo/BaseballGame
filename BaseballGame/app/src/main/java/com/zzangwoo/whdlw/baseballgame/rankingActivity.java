package com.zzangwoo.whdlw.baseballgame;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class rankingActivity extends AppCompatActivity {
    Fragment fr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        Button rankingBackButton = (Button) findViewById(R.id.rankingBackButton);
        Button rankingCountButton = (Button) findViewById(R.id.rankingCountButton);
        Button rankingTimeButton = (Button) findViewById(R.id.rankingTimeButton);

        TextView test = (TextView) findViewById(R.id.testTextView);




        fr = new countFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rankingBackground, fr);
        fragmentTransaction.commit();

        rankingTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fr = new timeFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.rankingBackground, fr);
                fragmentTransaction.commit();
            }
        });

        rankingCountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fr = new countFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.rankingBackground, fr);
                fragmentTransaction.commit();
            }
        });

        rankingBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///////////////////////////맨 처음 화면으로 넘어가기 위한 코드////////////////////////////////////
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // 현재 액티비티에서 어느 액티비티로 이동하는데, 스택 중간에 있었던 액티비티들을 지우는 역할
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                // 띄우려는 액티비티가 스택 맨위에 이미 실행 중이라면 재사용하겠다
                startActivity(intent);
                ////////////////////////////////////////////////////////////////////////////////////////////////////
            }
        });
    }

}
