package com.zzangwoo.whdlw.baseballgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class howtoActivity extends AppCompatActivity {

    int buttonCount = 0; // 이전, 다음 버튼 누른 횟수 카운트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howto);

        Button preButton = (Button) findViewById(R.id.preButton);
        Button nextButton = (Button) findViewById(R.id.nextButton);
        Button homeButton = (Button) findViewById(R.id.homeButton);

        final ImageView howtoImage = (ImageView) findViewById(R.id.howtoImage);

        howtoImage.setImageResource(R.drawable.howtoplay1);

        ////////////////////////////// 홈 버튼 누를 때 ////////////////////////////////////////////
        homeButton.setOnClickListener(new View.OnClickListener() {
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
        ///////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////// 이전 버튼 누를 때 //////////////////////////////////////////
        preButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonCount == 0){ // 1페이지일 때
                    Toast.makeText(howtoActivity.this, "첫 페이지입니다.", Toast.LENGTH_SHORT).show();
                } else if(buttonCount == 1){ // 2페이지일 때
                    howtoImage.setImageResource(R.drawable.howtoplay1);
                    buttonCount --;
                } else{ // 3페이지일 때
                    howtoImage.setImageResource(R.drawable.howtoplay2);
                    buttonCount --;
                }
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////// 다음 버튼 누를 때 //////////////////////////////////////////
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonCount == 0){ // 1페이지일 때
                    howtoImage.setImageResource(R.drawable.howtoplay2);
                    buttonCount ++;
                } else if(buttonCount == 1){ // 2페이지일 때
                    howtoImage.setImageResource(R.drawable.howtoplay3);
                    buttonCount ++;
                } else{ // 3페이지일 때
                    Toast.makeText(howtoActivity.this, "마지막 페이지입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
    }
}
