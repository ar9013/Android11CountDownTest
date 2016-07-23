package com.javaclass.anima.android11countdowntest;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private View start, cancel;
    private TextView tv;
    private MyCountDownTask mytask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tvShow);
        start = findViewById(R.id.start);
        cancel = findViewById(R.id.cancel);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCountDown();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopCountDown();
            }
        });
    }

    private void startCountDown(){
        mytask = new MyCountDownTask(20000,1000);
        mytask.start();

    }

    private void stopCountDown(){

        if(mytask != null){
            mytask.cancel();
            tv.setText("提早結束");
        }

    }

    public class MyCountDownTask extends CountDownTimer{

        public MyCountDownTask(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval); // 傳入
        }

        @Override
        public void onTick(long millisUntilFinished) {
            tv.setText("剩下秒數 ： "+millisUntilFinished/1000);
        }

        @Override
        public void onFinish() {
            tv.setText("時間到");
        }
    }
}
