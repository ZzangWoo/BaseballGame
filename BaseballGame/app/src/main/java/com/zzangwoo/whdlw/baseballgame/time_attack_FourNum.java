package com.zzangwoo.whdlw.baseballgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Button;

import com.zzangwoo.whdlw.baseballgame.NormalActivity.MainActivity;
import com.zzangwoo.whdlw.baseballgame.SelectActivity.time_attackSelectActivity;

public class time_attack_FourNum extends AppCompatActivity implements View.OnClickListener {

    ////////////////////////// 버튼 안의 Text 바꿔줄 재료들 //////////////////////////////
    String s = "성공";
    String s1 = "1단계";
    String s2 = "2단계";
    String s3 = "3단계";
    String s4 = "4단계";
    String s5 = "5단계";
    String s6 = "6단계";
    String s7 = "7단계";
    String s8 = "8단계";
    String s9 = "9단계";
    /////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////// 스테이지 클리어했는지 구별해주는 변수 ///////////////////////
    int stage1 = 0;
    int stage2 = 0;
    int stage3 = 0;
    int stage4 = 0;
    int stage5 = 0;
    int stage6 = 0;
    int stage7 = 0;
    int stage8 = 0;
    int stage9 = 0;
    ////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////// SharedPreferences에 필요한 코드 ///////////////////////////
    public final String PREFERENCE = "pref";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    /////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_attack__four_num);

        Button fournum_stageButton1 = (Button) findViewById(R.id.fournum_stageButton1);
        Button fournum_stageButton2 = (Button) findViewById(R.id.fournum_stageButton2);
        Button fournum_stageButton3 = (Button) findViewById(R.id.fournum_stageButton3);
        Button fournum_stageButton4 = (Button) findViewById(R.id.fournum_stageButton4);
        Button fournum_stageButton5 = (Button) findViewById(R.id.fournum_stageButton5);
        Button fournum_stageButton6 = (Button) findViewById(R.id.fournum_stageButton6);
        Button fournum_stageButton7 = (Button) findViewById(R.id.fournum_stageButton7);
        Button fournum_stageButton8 = (Button) findViewById(R.id.fournum_stageButton8);
        Button fournum_stageButton9 = (Button) findViewById(R.id.fournum_stageButton9);

        Button time_attack_four_homeButton = (Button) findViewById(R.id.time_attack_four_homeButton);
        Button time_attack_four_preButton = (Button) findViewById(R.id.time_attack_four_preButton);

        fournum_stageButton1.setOnClickListener(this);
        fournum_stageButton2.setOnClickListener(this);
        fournum_stageButton3.setOnClickListener(this);
        fournum_stageButton4.setOnClickListener(this);
        fournum_stageButton5.setOnClickListener(this);
        fournum_stageButton6.setOnClickListener(this);
        fournum_stageButton7.setOnClickListener(this);
        fournum_stageButton8.setOnClickListener(this);
        fournum_stageButton9.setOnClickListener(this);

        fournum_stageButton1.setText(s1);
        fournum_stageButton2.setText(s2);
        fournum_stageButton3.setText(s3);
        fournum_stageButton4.setText(s4);
        fournum_stageButton5.setText(s5);
        fournum_stageButton6.setText(s6);
        fournum_stageButton7.setText(s7);
        fournum_stageButton8.setText(s8);
        fournum_stageButton9.setText(s9);

        /////////////////////////////////// 클리어 한 스테이지 버튼 텍스트 바꿔주는 부분 ///////////////////////////////////

        //********************************** 버튼 텍스트 바꿔주기 위한 Spannable 부분 ***********************************//
        int s_length = s.length();
        int s1_length = s1.length();
        int s2_length = s2.length();
        int s3_length = s3.length();
        int s4_length = s4.length();
        int s5_length = s5.length();
        int s6_length = s6.length();
        int s7_length = s7.length();
        int s8_length = s8.length();
        int s9_length = s9.length();

        Spannable span1 = new SpannableString(s1 + "\n" + s);
        Spannable span2 = new SpannableString(s2 + "\n" + s);
        Spannable span3 = new SpannableString(s3 + "\n" + s);
        Spannable span4 = new SpannableString(s4 + "\n" + s);
        Spannable span5 = new SpannableString(s5 + "\n" + s);
        Spannable span6 = new SpannableString(s6 + "\n" + s);
        Spannable span7 = new SpannableString(s7 + "\n" + s);
        Spannable span8 = new SpannableString(s8 + "\n" + s);
        Spannable span9 = new SpannableString(s9 + "\n" + s);

        //span1.setSpan(new AbsoluteSizeSpan(25), 0, s1_length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span1.setSpan(new RelativeSizeSpan(0.5f), s1_length, (s1_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span1.setSpan(new ForegroundColorSpan(Color.RED), s1_length, (s1_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //span2.setSpan(new AbsoluteSizeSpan(25), 0, s2_length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span2.setSpan(new RelativeSizeSpan(0.5f), s2_length, (s2_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span2.setSpan(new ForegroundColorSpan(Color.RED), s2_length, (s2_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //span3.setSpan(new AbsoluteSizeSpan(25), 0, s3_length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span3.setSpan(new RelativeSizeSpan(0.5f), s3_length, (s3_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span3.setSpan(new ForegroundColorSpan(Color.RED), s3_length, (s3_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //span4.setSpan(new AbsoluteSizeSpan(25), 0, s4_length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span4.setSpan(new RelativeSizeSpan(0.5f), s4_length, (s4_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span4.setSpan(new ForegroundColorSpan(Color.RED), s4_length, (s4_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //span5.setSpan(new AbsoluteSizeSpan(25), 0, s5_length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span5.setSpan(new RelativeSizeSpan(0.5f), s5_length, (s5_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span5.setSpan(new ForegroundColorSpan(Color.RED), s5_length, (s5_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //span6.setSpan(new AbsoluteSizeSpan(25), 0, s6_length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span6.setSpan(new RelativeSizeSpan(0.5f), s6_length, (s6_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span6.setSpan(new ForegroundColorSpan(Color.RED), s6_length, (s6_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //span7.setSpan(new AbsoluteSizeSpan(25), 0, s7_length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span7.setSpan(new RelativeSizeSpan(0.5f), s7_length, (s7_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span7.setSpan(new ForegroundColorSpan(Color.RED), s7_length, (s7_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //span8.setSpan(new AbsoluteSizeSpan(25), 0, s8_length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span8.setSpan(new RelativeSizeSpan(0.5f), s8_length, (s8_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span8.setSpan(new ForegroundColorSpan(Color.RED), s8_length, (s8_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //span9.setSpan(new AbsoluteSizeSpan(25), 0, s9_length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span9.setSpan(new RelativeSizeSpan(0.5f), s9_length, (s9_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span9.setSpan(new ForegroundColorSpan(Color.RED), s9_length, (s9_length + s_length + 1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //****************************************************************************************************************//

        pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        //**************************** 스테이지 클리어했는지 안했는지 판별해주는 부분 *************************************//
        stage1 = pref.getInt("game4_1",0); // 클리어 했으면 1전달 안했으면 걍 0
        stage2 = pref.getInt("game4_2",0);
        stage3 = pref.getInt("game4_3",0);
        stage4 = pref.getInt("game4_4",0);
        stage5 = pref.getInt("game4_5",0);
        stage6 = pref.getInt("game4_6",0);
        stage7 = pref.getInt("game4_7",0);
        stage8 = pref.getInt("game4_8",0);
        stage9 = pref.getInt("game4_9",0);
        //****************************************************************************************************************//

        if(stage1 == 1){
            fournum_stageButton1.setText(span1);
        }
        if(stage2 == 1){
            fournum_stageButton2.setText(span2);
        }
        if(stage3 == 1){
            fournum_stageButton3.setText(span3);
        }
        if(stage4 == 1){
            fournum_stageButton4.setText(span4);
        }
        if(stage5 == 1){
            fournum_stageButton5.setText(span5);
        }
        if(stage6 == 1){
            fournum_stageButton6.setText(span6);
        }
        if(stage7 == 1){
            fournum_stageButton7.setText(span7);
        }
        if(stage8 == 1){
            fournum_stageButton8.setText(span8);
        }
        if(stage9 == 1){
            fournum_stageButton9.setText(span9);
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////// 홈으로 버튼 클릭 /////////////////////////////////////////////////////
        time_attack_four_homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///////////////////////////맨 처음 화면으로 넘어가기 위한 코드////////////////////////////////////
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // 현재 액티비티에서 어느 액티비티로 이동하는데, 스택 중간에 있었던 액티비티들을 지우는 역할
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                // 띄우려는 액티비티가 스택 맨위에 이미 실행 중이라면 재사용하겠다
                startActivity(intent);
                ////////////////////////////////////////////////////////////////////////////////////////////
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////// 이전으로 버튼 클릭 /////////////////////////////////////////////////////
        time_attack_four_preButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///////////////////////////맨 처음 화면으로 넘어가기 위한 코드////////////////////////////////////
                Intent intent = new Intent(getApplicationContext(), time_attackSelectActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // 현재 액티비티에서 어느 액티비티로 이동하는데, 스택 중간에 있었던 액티비티들을 지우는 역할
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                // 띄우려는 액티비티가 스택 맨위에 이미 실행 중이라면 재사용하겠다
                startActivity(intent);
                ////////////////////////////////////////////////////////////////////////////////////////////
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.fournum_stageButton1:
                Intent intent1 = new Intent(getApplicationContext(), time_attack_FourGame.class);
                intent1.putExtra("time",12000); // 타임어택 시간 (60초 -> 1분)
                intent1.putExtra("stage",1); // 스테이지 고유 이름, 값
                startActivity(intent1);
                break;

            case R.id.fournum_stageButton2:
                Intent intent2 = new Intent(getApplicationContext(), time_attack_FourGame.class);
                intent2.putExtra("time",10000);
                intent2.putExtra("stage",2);
                startActivity(intent2);
                break;

            case R.id.fournum_stageButton3:
                Intent intent3 = new Intent(getApplicationContext(), time_attack_FourGame.class);
                intent3.putExtra("time",9000);
                intent3.putExtra("stage",3);
                startActivity(intent3);
                break;

            case R.id.fournum_stageButton4:
                Intent intent4 = new Intent(getApplicationContext(), time_attack_FourGame.class);
                intent4.putExtra("time",7000);
                intent4.putExtra("stage",4);
                startActivity(intent4);
                break;

            case R.id.fournum_stageButton5:
                Intent intent5 = new Intent(getApplicationContext(), time_attack_FourGame.class);
                intent5.putExtra("time",6000);
                intent5.putExtra("stage",5);
                startActivity(intent5);
                break;

            case R.id.fournum_stageButton6:
                Intent intent6 = new Intent(getApplicationContext(), time_attack_FourGame.class);
                intent6.putExtra("time",5000);
                intent6.putExtra("stage",6);
                startActivity(intent6);
                break;

            case R.id.fournum_stageButton7:
                Intent intent7 = new Intent(getApplicationContext(), time_attack_FourGame.class);
                intent7.putExtra("time",4500);
                intent7.putExtra("stage",7);
                startActivity(intent7);
                break;

            case R.id.fournum_stageButton8:
                Intent intent8 = new Intent(getApplicationContext(), time_attack_FourGame.class);
                intent8.putExtra("time",4000);
                intent8.putExtra("stage",8);
                startActivity(intent8);
                break;

            case R.id.fournum_stageButton9:
                Intent intent9 = new Intent(getApplicationContext(), time_attack_FourGame.class);
                intent9.putExtra("time",2500);
                intent9.putExtra("stage",9);
                startActivity(intent9);
                break;
        }
    }
}
