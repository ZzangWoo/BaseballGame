package com.zzangwoo.whdlw.baseballgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class time_attack_FailActivity extends AppCompatActivity {

    private InterstitialAd fullAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_attack__fail);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.6), (int) (height * 0.45));

        Button fail_homeButton = (Button) findViewById(R.id.fail_homeButton);

        MobileAds.initialize(this,"ca-app-pub-2958953596451309~2610469246");

        fullAd = new InterstitialAd(this);
        fullAd.setAdUnitId("ca-app-pub-2958953596451309/6432191967");

        fullAd.loadAd(new AdRequest.Builder().build());

        fail_homeButton.setOnClickListener(new View.OnClickListener() {
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
                if(fullAd.isLoaded()){
                    fullAd.show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
