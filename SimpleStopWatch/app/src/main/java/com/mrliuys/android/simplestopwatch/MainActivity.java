package com.mrliuys.android.simplestopwatch;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    private Button startBtn;
    private Button stopBtn;
    private Button resetBtn;
    private TextView numberTV;

    private Timer mTimer = null;
    private TimerTask mTimerTask = null;

    private static int count = 0;
    private boolean isStop = true;
    private static int delay = 100;  //1s
    private static int period = 100;  //1s
    private static final int UPDATE_TEXTVIEW = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.btn_start);
        stopBtn = (Button) findViewById(R.id.btn_stop);
        resetBtn = (Button) findViewById(R.id.btn_reset);
        numberTV = (TextView) findViewById(R.id.tv_number);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTimer();
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });


    }


    private void updateTextView() {
        numberTV.setText(String.valueOf(count++ / 10.0));
    }

    void startTimer() {

        if (isStop == false) {

            return;
        }

        isStop = false;

        if (mTimer == null) {

            mTimer = new Timer();
        }

        if (mTimerTask == null) {

            mTimerTask = new TimerTask() {
                @Override
                public void run() {

                    Log.i("tag", count + "");

                    sendMessage(UPDATE_TEXTVIEW);

                }
            };
        }

        if (mTimer != null && mTimerTask != null) {

            mTimer.schedule(mTimerTask, delay, period);

        }

    }

    void stopTimer() {

        isStop = true;

        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }

        if (mTimerTask != null) {
            mTimerTask.cancel();
            mTimerTask = null;
        }

    }

    void resetTimer() {

        stopTimer();
        count = 0;

        updateTextView();
    }


    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {

                updateTextView();
            }
            super.handleMessage(msg);
        }
    };


    public void sendMessage(int id) {

        Message message = new Message();
        message.what = 1;
        handler.sendMessage(message);

    }

}
