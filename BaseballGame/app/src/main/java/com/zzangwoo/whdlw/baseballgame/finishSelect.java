package com.zzangwoo.whdlw.baseballgame;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zzangwoo.whdlw.baseballgame.NormalActivity.MainActivity;
import com.zzangwoo.whdlw.baseballgame.SelectActivity.selectActivity;

public class finishSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_select);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.6), (int) (height * 0.45));

        Drawable alpha = findViewById(R.id.finish_background).getBackground();
        alpha.setAlpha(80);

        Button yesButton = (Button) findViewById(R.id.yesButton);
        Button noButton = (Button) findViewById(R.id.noButton);

        ///////////////////////////// 게임 화면에서 데이터 가져오기 ///////////////////////
        TextView record = (TextView) findViewById(R.id.record);
        final TextView count = (TextView) findViewById(R.id.count);

        Intent intent = getIntent();

        final String record_text = intent.getExtras().getString("record");
        final int count_text = intent.getExtras().getInt("count");
        final double game_time = intent.getExtras().getDouble("game_time");

        record.setText(record_text);
        count.setText(Integer.toString(count_text) + "회");

        this.setFinishOnTouchOutside(false); // 액티비티 밖을 클릭해도 종료안됨
        ///////////////////////////////////////////////////////////////////////////////

       // Fragment fragment = new countFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("count", count_text);
        //fragment.setArguments(bundle);

        ///////////////////// 예 버튼 누를 때 /////////////////////////////////
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), selectActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // 현재 액티비티에서 어느 액티비티로 이동하는데, 스택 중간에 있었던 액티비티들을 지우는 역할
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                // 띄우려는 액티비티가 스택 맨위에 이미 실행 중이라면 재사용하겠다
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////////////////////////////

        /////////////////// 아니오 버튼 누를 때 ////////////////////////////////////
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // 현재 액티비티에서 어느 액티비티로 이동하는데, 스택 중간에 있었던 액티비티들을 지우는 역할
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                // 띄우려는 액티비티가 스택 맨위에 이미 실행 중이라면 재사용하겠다
                startActivity(intent);
            }
        });
        /////////////////////////////////////////////////////////////////////////
    }
}
