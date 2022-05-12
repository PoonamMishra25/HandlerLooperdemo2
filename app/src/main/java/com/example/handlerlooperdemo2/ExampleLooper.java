package com.example.handlerlooperdemo2;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

public class ExampleLooper extends Thread{
    private static final String TAG = "ExampleLooper";
    Handler myHandler;
    public Looper myLooper;

    @Override
    public void run() {
        Looper.prepare();

        myLooper=Looper.myLooper();
        myHandler=new Handler();

        Looper.loop();

        Log.d(TAG, "run: Thread terminated!");
    }
}
