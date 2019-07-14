package com.zzangwoo.whdlw.baseballgame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.zzangwoo.whdlw.baseballgame.NormalActivity.MainActivity;

import java.util.Random;

import static com.zzangwoo.whdlw.baseballgame.R.drawable;
import static com.zzangwoo.whdlw.baseballgame.R.id;

//////////////// 타이머에 타이머에 필요한 코드 ///////////////////
import android.os.Handler;
import android.os.Message;
//////////////////////////////////////////////////////////////

public class gameStart_five extends AppCompatActivity implements View.OnClickListener {

    int n10000, n1000, n100, n10, n1; // 랜덤변수로 만들어질 숫자들
    int numResult; // 랜덤변수 세자리 숫자
    int insertResult; // 입력된 세자리 숫자
    int insertCount = 0; // 숫자 버튼 누른 횟수 카운트해주기
    int confirmCount = 0; // 입력 횟수
    int ifTimeStart = 0; // 시작 버튼이 눌리기 전에 어떤 버튼도 눌리지 않게 해주기 위한 변수
    // 0 : 시작버튼이 눌리기 전, 1 : 시작버튼이 눌린 후

    //////////////// 타이머에 필요한 코드 ////////////////////////
    private TextView mTimeTextView;
    private Thread timeThread = null;
    private Boolean isRunning = true;
    ///////////////////////////////////////////////////////

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start_five);

        ////////////////////// 타이머에 필요한 코드 ///////////////////////////////////
        mTimeTextView = (TextView) findViewById(id.timer);
        ///////////////////////////////////////////////////////////////////////

        //////////////////////// 광고넣기 ////////////////////////////
        MobileAds.initialize(this, "ca-app-pub-2958953596451309~2610469246");

        mAdView = findViewById(id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        /////////////////////////////////////////////////////////////

/* 혹시모르니까 살려둠
        TextView num_100 = (TextView) findViewById(R.id.showNumber_100);
        TextView num_10 = (TextView) findViewById(R.id.showNumber_10);
        TextView num_1 = (TextView) findViewById(R.id.showNumber_1);
*/

        final TextView error1000 = (TextView) findViewById(id.show_error1000);
        final TextView error100 = (TextView) findViewById(id.show_error100);
        final TextView error10 = (TextView) findViewById(id.show_error10);
        final TextView error1 = (TextView) findViewById(id.show_error1);

        Button backButton = (Button) findViewById(id.backButton); // 뒤로가기 버튼
        Button confirmButton = (Button) findViewById(id.confirmButton); // 확인 버튼
        Button deleteButton = (Button) findViewById(id.deleteButton); // 삭제 버튼
        final Button timer_startButton = (Button) findViewById(id.timer_startButton);
        // Button windowDeleteButton = (Button) findViewById(R.id.windowDeleteButton); -> 입력창 지우기 버튼 봉인

        ////////////// 숫자 버튼 생성 //////////////////////
        Button zero = (Button) findViewById(id.zeroButton);
        Button one = (Button) findViewById(id.oneButton);
        Button two = (Button) findViewById(id.twoButton);
        Button three = (Button) findViewById(id.threeButton);
        Button four = (Button) findViewById(id.fourButton);
        Button five = (Button) findViewById(id.fiveButton);
        Button six = (Button) findViewById(id.sixButton);
        Button seven = (Button) findViewById(id.sevenButton);
        Button eight = (Button) findViewById(id.eightButton);
        Button nine = (Button) findViewById(id.nineButton);
        /////////////////////////////////////////////////

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);

        while (numResult == 0) { // 랜덤숫자가 0이 안되게 만들어주는 while문
            setNumber(); // 랜덤숫자 만들기
        }

        /*//////////////////////////// 테스트 //////////////////////////////////
        TextView testNum = (TextView) findViewById(id.testNumber);
        testNum.setText(Integer.toString(numResult));
        //////////////////////////////////////////////////////////////////////*/

        /////////////////////////////////////// 시작 버튼 누르기 /////////////////////////////////////
        timer_startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ifTimeStart++; // 1이 되면서 이제 다른 버튼도 눌릴 수 있다
                ////////////////////// 타이머에 필요한 코드 ///////////////////////////////////
                timeThread = new Thread(new timeThread());
                timeThread.start();
                ///////////////////////////////////////////////////////////////////////
                timer_startButton.setVisibility(View.INVISIBLE);
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////// 뒤로가기 버튼 클릭 //////////////////////////////////////
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(gameStart_five.this, "맞춰야 할 숫자가 초기화 되었습니다.", Toast.LENGTH_SHORT).show();
                isRunning = false;
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
        ////////////////////////////////////////////////////////////////////////////////////////////////////

        //////////////////////////////////////////////// 숫자입력 버튼 클릭 ///////////////////////////////////////
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ifTimeStart == 0){
                    Toast.makeText(gameStart_five.this, "시작 버튼을 먼저 눌러주세요", Toast.LENGTH_SHORT).show();
                } else {
                    TextView num_10000 = (TextView) findViewById(id.showNumber_10000);
                    TextView num_1000 = (TextView) findViewById(id.showNumber_1000);
                    TextView num_100 = (TextView) findViewById(id.showNumber_100);
                    TextView num_10 = (TextView) findViewById(id.showNumber_10);
                    TextView num_1 = (TextView) findViewById(id.showNumber_1);

                    if (num_1.getText().toString().equals("") || num_10.getText().toString().equals("")
                            || num_100.getText().toString().equals("") || num_1000.getText().toString().equals("")
                            || num_10000.getText().toString().equals("")) {
                        Toast.makeText(gameStart_five.this, "숫자를 다섯자리 모두 입력해주세요.", Toast.LENGTH_SHORT).show();
                    } else {
                        int num10000 = 1;
                        int num1000 = 2;
                        int num100 = 3;
                        int num10 = 4;
                        int num1 = 5;

                        TextView textView = (TextView) findViewById(id.window_insertNum); // 입력창에 있는 입력숫자 TextView

                        num10000 = stringToint(num10000);
                        num1000 = stringToint(num1000);
                        num100 = stringToint(num100);
                        num10 = stringToint(num10);
                        num1 = stringToint(num1);

                        insertResult = num10000 * 10000 + num1000 * 1000 + num100 * 100 + num10 * 10 + num1;

                        classificationNum(); // 랜덤 자리 숫자랑 비교

                        if (confirmCount == 1) {
                            textView.setText(Integer.toString(insertResult));
                        } else {
                            textView.setText(textView.getText().toString() + "\n" + Integer.toString(insertResult));
                        }

                        insertCount = 0;
                    }

                    //////////////////////////////// 입력된 최신 숫자 자동으로 보이게 해주는 역할 //////////////////////
                    final ScrollView scrollView = (ScrollView) findViewById(id.window_scroll);

                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                        }
                    });
                    ///////////////////////////////////////////////////////////////////////////////////////////////////
                }
            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////// 숫자지우기 버튼 클릭 ///////////////////////////////////
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ifTimeStart == 0){
                    Toast.makeText(gameStart_five.this, "시작 버튼을 먼저 눌러주세요", Toast.LENGTH_SHORT).show();
                } else{
                    if (insertCount == 0) {
                        Toast.makeText(gameStart_five.this, "지울 숫자가 없습니다.", Toast.LENGTH_SHORT).show();
                    } else if (insertCount == 1) { // 만의자리숫자가 입력된 상태
                        if (error1000.getText().toString() != "") {
                            error1000.setText("");
                            reset10000();
                            insertCount--;
                        } else {
                            reset10000();
                            insertCount--;
                        }
                    } else if (insertCount == 2) { // 천의자리숫자가 입력된 상태
                        if (error100.getText().toString() != "") {
                            error100.setText("");
                            reset1000();
                            insertCount--;
                        } else {
                            reset1000();
                            insertCount--;
                        }
                    } else if (insertCount == 3) { // 백의자리숫자가 입력된 상태
                        if (error10.getText().toString() != "") {
                            error10.setText("");
                            reset100();
                            insertCount--;
                        } else {
                            reset100();
                            insertCount--;
                        }
                    } else if (insertCount == 4) { // 십의자리숫자가 입력된 상태
                        if (error1.getText().toString() != "") {
                            error1.setText("");
                            reset10();
                            insertCount--;
                        } else {
                            reset10();
                            insertCount--;
                        }

                    } else {
                        reset1();
                        insertCount--;
                    }
                }
            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////////////

        /* 스크롤 부분 해결했으니까 봉인!!!!
        ////////////////////////// 입력창 지우기 버튼 ///////////////////////////////////////////////
        windowDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.window_insertNum);
                TextView windowStrike = (TextView) findViewById(R.id.window_strike);
                TextView windowBall = (TextView) findViewById(R.id.window_ball);
                TextView windowCount = (TextView) findViewById(R.id.window_count);

                window_insertNum_Reset();
                window_strike_Reset();
                window_ball_Reset();
                window_count_Reset();
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////////
        */
    }

    @Override
    public void onBackPressed() {
        isRunning = false;
        super.onBackPressed();
    }

    ///////////////////////////////////////////// 타이머에 필요한 코드 //////////////////////////////////
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            int mSec = msg.arg1 % 100;
            int sec = (msg.arg1 / 100) % 60;
            int min = (msg.arg1 / 100) / 60;
            int hour = (msg.arg1 / 100) / 360;
            // 1000이 1초 1000*60 은 1분 1000*60*10은 10분 1000*60*60은 한시간

            @SuppressLint("DefaultLocale")
            String result = String.format("%02d:%02d:%02d:%02d", hour, min, sec, mSec);

            mTimeTextView.setText(result);
        }
    };

    public class timeThread implements Runnable {
        public void run() {
            int i = 0;

            while (true) {
                while (isRunning) {
                    Message msg = new Message();
                    msg.arg1 = i++;
                    handler.sendMessage(msg);

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mTimeTextView.setText("");
                                mTimeTextView.setText("00:00:00:00");
                            }
                        });
                        return;
                    }
                }
            }
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////

    private void window_count_Reset() {
        TextView windowCount = (TextView) findViewById(id.window_count);

        windowCount.setText("");
    }

    private void window_ball_Reset() {
        TextView windowBall = (TextView) findViewById(id.window_ball);

        windowBall.setText("");
    }

    private void window_strike_Reset() {
        TextView windowStrike = (TextView) findViewById(id.window_strike);

        windowStrike.setText("");
    }

    private void window_insertNum_Reset() {
        TextView textView = (TextView) findViewById(id.window_insertNum);

        textView.setText("");
    }

    public void reset10000() {
        TextView num_10000 = (TextView) findViewById(id.showNumber_10000);

        num_10000.setText("");
    }

    public void reset1000() {
        TextView num_1000 = (TextView) findViewById(id.showNumber_1000);

        num_1000.setText("");
    }

    public void reset100() {
        TextView num_100 = (TextView) findViewById(id.showNumber_100);

        num_100.setText("");
    }

    public void reset10() {
        TextView num_10 = (TextView) findViewById(id.showNumber_10);

        num_10.setText("");
    }

    public void reset1() {
        TextView num_1 = (TextView) findViewById(id.showNumber_1);

        num_1.setText("");
    }

    private void classificationNum() {
        int ballCount = 0; // 볼 카운트
        int strikeCount = 0; // 스트라이크 카운트

        TextView windowStrike = (TextView) findViewById(id.window_strike);
        TextView windowBall = (TextView) findViewById(id.window_ball);
        TextView windowCount = (TextView) findViewById(id.window_count);

        ImageView imageView = (ImageView) findViewById(id.finishImage);

        ///////////// 만의자리 숫자 체크 ///////////////////////
        if (numResult / 10000 == insertResult / 10000) {
            strikeCount++;
        } else if ((numResult % 10000) / 1000 == insertResult / 10000
                || (numResult % 1000) / 100 == insertResult / 10000
                || (numResult % 100) / 10 == insertResult / 10000
                || numResult % 10 == insertResult / 10000) {
            ballCount++;
        }
        ////////////////////////////////////////////////////////

        ///////////// 천의자리 숫자 체크 //////////////////////
        if ((numResult % 10000) / 1000 == (insertResult % 10000) / 1000) {
            strikeCount++;
        } else if (numResult / 10000 == (insertResult % 10000) / 1000
                || (numResult % 1000) / 100 == (insertResult % 10000) / 1000
                || (numResult % 100) / 10 == (insertResult % 10000) / 1000
                || numResult % 10 == (insertResult % 10000) / 1000) {
            ballCount++;
        }
        ////////////////////////////////////////////////////////

        //////////// 백의자리 숫자 체크 //////////////////////
        if ((numResult % 1000) / 100 == (insertResult % 1000) / 100) {
            strikeCount++;
        } else if (numResult / 10000 == (insertResult % 1000) / 100
                || (numResult % 10000) / 1000 == (insertResult % 1000) / 100
                || (numResult % 100) / 10 == (insertResult % 1000) / 100
                || numResult % 10 == (insertResult % 1000) / 100) {
            ballCount++;
        }
        //////////////////////////////////////////////////////

        ///////////// 십의자리 숫자 체크 ////////////////////
        if ((numResult % 100) / 10 == (insertResult % 100) / 10) {
            strikeCount++;
        } else if (numResult / 10000 == (insertResult % 100) / 10
                || (numResult % 10000) / 1000 == (insertResult % 100) / 10
                || (numResult % 1000) / 100 == (insertResult % 100) / 10
                || numResult % 10 == (insertResult % 100) / 10) {
            ballCount++;
        }
        ///////////////////////////////////////////////////////

        ///////////// 일의자리 숫자 체크 //////////////////////
        if (numResult % 10 == insertResult % 10) {
            strikeCount++;
        } else if (numResult / 10000 == insertResult % 10
                || (numResult % 10000) / 1000 == insertResult % 10
                || (numResult % 1000) / 100 == insertResult % 10
                || (numResult % 100) / 10 == insertResult % 10) {
            ballCount++;
        }
        ///////////////////////////////////////////////////////

        confirmCount++;

        if (confirmCount == 1) {
            windowStrike.setText(Integer.toString(strikeCount));
            windowBall.setText(Integer.toString(ballCount));
            windowCount.setText(Integer.toString(confirmCount) + "회");
        } else {
            windowStrike.setText(windowStrike.getText().toString() + "\n" + Integer.toString(strikeCount));
            windowBall.setText(windowBall.getText().toString() + "\n" + Integer.toString(ballCount));
            windowCount.setText(windowCount.getText().toString() + "\n" + Integer.toString(confirmCount) + "회");
        }


        ///////// 숫자 입력창 초기화 ////////////
        reset1();
        reset10();
        reset100();
        reset1000();
        reset10000();
        //////////////////////////////////////////

        ////////////// 숫자 다 맞췄을 경우 ////////////////////
        final Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        if (strikeCount == 5) {

            imageView.setImageResource(drawable.finish);
            vibrator.vibrate(2000); // 진동 2초
            isRunning = !isRunning;
            // Activity 초기화 하는 방법 알아낼 때까지 봉인!!!
            Intent intent = new Intent(getApplicationContext(), finishSelect.class);

            intent.putExtra("record", mTimeTextView.getText().toString());
            intent.putExtra("count", confirmCount);

            startActivity(intent);
            //
        }
        //////////////////////////////////////////////////////
    }

    ////////////////////// 랜덤 숫자 만들어주는 함수 /////////////////////////////
    private void setNumber() {
        Random random = new Random();

        n10000 = random.nextInt(10);
        n1000 = random.nextInt(10);
        n100 = random.nextInt(10);
        n10 = random.nextInt(10);
        n1 = random.nextInt(10);

        if (n10000 == 0) {
            n10000 = random.nextInt(10);
        } else {
            if (n10000 == n1000) {
                n1000 = random.nextInt(10);
            } else {
                if (n10000 == n100 || n1000 == n100) {
                    n100 = random.nextInt(10);
                } else {
                    if (n10000 == n10 || n1000 == n10 || n100 == n10) {
                        n10 = random.nextInt(10);
                    } else {
                        if (n10000 == n1 || n1000 == n1 || n100 == n1 || n10 == n1) {
                            n1 = random.nextInt(10);
                        } else {
                            numResult = n10000 * 10000 + n1000 * 1000 + n100 * 100 + n10 * 10 + n1;
                        }
                    }
                }
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////// TextView에 있는 String을 Int형태로 바꿔주는 함수들 ///////////////////////
    private int stringToint(int classification) {
        if (classification == 1) {
            return stringToint_num10000();
        } else if (classification == 2) {
            return stringToint_num1000();
        } else if (classification == 3) {
            return stringToint_num100();
        } else if (classification == 4) {
            return stringToint_num10();
        } else {
            return stringToint_num1();
        }
    }

    private int stringToint_num1() {
        TextView num_1 = (TextView) findViewById(id.showNumber_1);

        if (num_1.getText().toString().equals("" + 0)) {
            return 0;
        } else if (num_1.getText().toString().equals("" + 1)) {
            return 1;
        } else if (num_1.getText().toString().equals("" + 2)) {
            return 2;
        } else if (num_1.getText().toString().equals("" + 3)) {
            return 3;
        } else if (num_1.getText().toString().equals("" + 4)) {
            return 4;
        } else if (num_1.getText().toString().equals("" + 5)) {
            return 5;
        } else if (num_1.getText().toString().equals("" + 6)) {
            return 6;
        } else if (num_1.getText().toString().equals("" + 7)) {
            return 7;
        } else if (num_1.getText().toString().equals("" + 8)) {
            return 8;
        } else {
            return 9;
        }
    }

    private int stringToint_num10() {
        TextView num_10 = (TextView) findViewById(id.showNumber_10);

        if (num_10.getText().toString().equals("" + 0)) {
            return 0;
        } else if (num_10.getText().toString().equals("" + 1)) {
            return 1;
        } else if (num_10.getText().toString().equals("" + 2)) {
            return 2;
        } else if (num_10.getText().toString().equals("" + 3)) {
            return 3;
        } else if (num_10.getText().toString().equals("" + 4)) {
            return 4;
        } else if (num_10.getText().toString().equals("" + 5)) {
            return 5;
        } else if (num_10.getText().toString().equals("" + 6)) {
            return 6;
        } else if (num_10.getText().toString().equals("" + 7)) {
            return 7;
        } else if (num_10.getText().toString().equals("" + 8)) {
            return 8;
        } else {
            return 9;
        }
    }

    private int stringToint_num100() {
        TextView num_100 = (TextView) findViewById(id.showNumber_100);

        if (num_100.getText().toString().equals("" + 0)) {
            return 0;
        } else if (num_100.getText().toString().equals("" + 1)) {
            return 1;
        } else if (num_100.getText().toString().equals("" + 2)) {
            return 2;
        } else if (num_100.getText().toString().equals("" + 3)) {
            return 3;
        } else if (num_100.getText().toString().equals("" + 4)) {
            return 4;
        } else if (num_100.getText().toString().equals("" + 5)) {
            return 5;
        } else if (num_100.getText().toString().equals("" + 6)) {
            return 6;
        } else if (num_100.getText().toString().equals("" + 7)) {
            return 7;
        } else if (num_100.getText().toString().equals("" + 8)) {
            return 8;
        } else {
            return 9;
        }
    }

    private int stringToint_num1000() {
        TextView num_1000 = (TextView) findViewById(id.showNumber_1000);

        if (num_1000.getText().toString().equals("" + 0)) {
            return 0;
        } else if (num_1000.getText().toString().equals("" + 1)) {
            return 1;
        } else if (num_1000.getText().toString().equals("" + 2)) {
            return 2;
        } else if (num_1000.getText().toString().equals("" + 3)) {
            return 3;
        } else if (num_1000.getText().toString().equals("" + 4)) {
            return 4;
        } else if (num_1000.getText().toString().equals("" + 5)) {
            return 5;
        } else if (num_1000.getText().toString().equals("" + 6)) {
            return 6;
        } else if (num_1000.getText().toString().equals("" + 7)) {
            return 7;
        } else if (num_1000.getText().toString().equals("" + 8)) {
            return 8;
        } else {
            return 9;
        }
    }

    private int stringToint_num10000() {
        TextView num_10000 = (TextView) findViewById(id.showNumber_10000);

        if (num_10000.getText().toString().equals("" + 0)) {
            return 0;
        } else if (num_10000.getText().toString().equals("" + 1)) {
            return 1;
        } else if (num_10000.getText().toString().equals("" + 2)) {
            return 2;
        } else if (num_10000.getText().toString().equals("" + 3)) {
            return 3;
        } else if (num_10000.getText().toString().equals("" + 4)) {
            return 4;
        } else if (num_10000.getText().toString().equals("" + 5)) {
            return 5;
        } else if (num_10000.getText().toString().equals("" + 6)) {
            return 6;
        } else if (num_10000.getText().toString().equals("" + 7)) {
            return 7;
        } else if (num_10000.getText().toString().equals("" + 8)) {
            return 8;
        } else {
            return 9;
        }
    }
    //////////////////////////////////////////////////////////////////////////////////

    /////////////////////// 버튼 누르는거 관리해주는 함수 ////////////////////////////
    public void onClick(View v) {
        insertCount++; // 버튼 누를 때마다 카운트함
        switch (v.getId()) {
            case id.zeroButton:
                num(0);
                break;

            case id.oneButton:
                num(1);
                break;

            case id.twoButton:
                num(2);
                break;

            case id.threeButton:
                num(3);
                break;

            case id.fourButton:
                num(4);
                break;

            case id.fiveButton:
                num(5);
                break;

            case id.sixButton:
                num(6);
                break;

            case id.sevenButton:
                num(7);
                break;

            case id.eightButton:
                num(8);
                break;

            case id.nineButton:
                num(9);
                break;
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////// 버튼 누르면 TextView에 숫자 입력해주는 함수 /////////////////////////////
    public void num(int insert_num) {
        TextView num_10000 = (TextView) findViewById(id.showNumber_10000);
        TextView num_1000 = (TextView) findViewById(id.showNumber_1000);
        TextView num_100 = (TextView) findViewById(id.showNumber_100);
        TextView num_10 = (TextView) findViewById(id.showNumber_10);
        TextView num_1 = (TextView) findViewById(id.showNumber_1);

        TextView error10000 = (TextView) findViewById(id.show_error10000);
        TextView error1000 = (TextView) findViewById(id.show_error1000);
        TextView error100 = (TextView) findViewById(id.show_error100);
        TextView error10 = (TextView) findViewById(id.show_error10);
        TextView error1 = (TextView) findViewById(id.show_error1);

        if (num_10000.getText().toString().equals("")) { // 만의자리숫자 부분이 공백이면
            if (insert_num == 0) {
                error10000.setText("0은 입력불가");
                insertCount--;
            } else {
                error10000.setText("");
                num_10000.setText("" + insert_num); // setText 안에는 string 형태로 들어가야해서 ""를 추가해준거
            }
        } else { // 만의자리숫자 부분이 입력되면
            //// 천의자리숫자 입력부분 ////
            if (num_1000.getText().toString().equals("")) {
                if (num_10000.getText().toString().equals("" + insert_num)) {
                    error1000.setText("앞의 숫자와\n중복");
                    insertCount--;
                } else {
                    error1000.setText("");
                    num_1000.setText("" + insert_num);
                }
            } else { // 천의자리숫자 부분이 입력되면
                //// 백의자리숫자 입력부분 ////
                if (num_100.getText().toString().equals("")) {
                    if (num_10000.getText().toString().equals("" + insert_num) || num_1000.getText().toString().equals("" + insert_num)) {
                        error100.setText("앞의 숫자와\n중복");
                        insertCount--;
                    } else {
                        error100.setText("");
                        num_100.setText("" + insert_num);
                    }
                } else { // 백의자리숫자 부분이 입력되면
                    //// 십의자리숫자 입력부분 ////
                    if (num_10.getText().toString().equals("")) {
                        if (num_10000.getText().toString().equals("" + insert_num) || num_1000.getText().toString().equals("" + insert_num)
                                || num_100.getText().toString().equals("" + insert_num)) {
                            error10.setText("앞의 숫자와\n중복");
                            insertCount--;
                        } else {
                            error10.setText("");
                            num_10.setText("" + insert_num);
                        }
                    } else { // 십의자리숫자 부분이 입력되면
                        ////// 일의자리숫자 입력부분 //////
                        if (num_10000.getText().toString().equals("" + insert_num) || num_1000.getText().toString().equals("" + insert_num)
                                || num_100.getText().toString().equals("" + insert_num)
                                || num_10.getText().toString().equals("" + insert_num)) {
                            error1.setText("앞의 숫자와\n중복");
                            insertCount--;
                        } else {
                            error1.setText("");
                            num_1.setText("" + insert_num);
                        }
                    }
                }
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
}


