package com.example.handlerlooperdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ExampleLooper exampleLooper = new ExampleLooper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = findViewById(R.id.button);
        Button stop = findViewById(R.id.button2);
        Button taskA = findViewById(R.id.button3);
        Button taskB = findViewById(R.id.button4);

        start.setOnClickListener(view -> {
            exampleLooper.start();
        });
        taskA.setOnClickListener(view -> {
            exampleLooper.myHandler.post(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 5; i++) {
                        Log.d(TAG, "onCreate: "+i);
                        SystemClock.sleep(1000);
                    }
                }
            });

        });
        //
        stop.setOnClickListener(view -> {
//            exampleLooper.myHandler.getLooper().quitSafely();
            exampleLooper.myLooper.quit();
        });
    }
}