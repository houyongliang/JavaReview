package com.hyl.java_reciew;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.text.RelativeDateTimeFormatter.Direction.THIS;
import static com.hyl.java_reciew.JavaTest.count;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG="MainActivity";
    private int count=0;
    private TextView startS,startBS,stopBS,stopS;

//    private ServerConnect sc;
    private ServiceConnection myConn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startS = (TextView) findViewById(R.id.tv_startService);
        stopS = (TextView) findViewById(R.id.tv_stopService);
        startBS = (TextView) findViewById(R.id.tv_startBdService);
        stopBS = (TextView) findViewById(R.id.tv_stopBdService);
        startS.setOnClickListener(this);
        stopS.setOnClickListener(this);
        startBS.setOnClickListener(this);
        stopBS.setOnClickListener(this);
        count++;
        Log.e(TAG, "onCreate:count "+count);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.tv_startService:
                startService(new Intent(this,MyService.class));
            break;
            case R.id.tv_stopService:
                stopService(new Intent(this,MyService.class));
            break;
            case R.id.tv_startBdService:
                myConn = new ServiceConnection(){

                    @Override
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        Log.e(TAG, "onServiceConnected: "+ "开始");
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName componentName) {
                        Log.e(TAG, "onServiceDisconnected: "+"结束" );
                    }
                };
                bindService(new Intent(this,MyService.class), myConn,BIND_AUTO_CREATE);

                break;
            case R.id.tv_stopBdService:
//                stopService(new Intent(this,MyService.class));
                unbindService(myConn);
                break;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart:count "+count);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop:count "+count);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(count>0)
            count--;
        Log.e(TAG, "onDestroy:count "+count);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart:count "+count);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause:count "+count);
    }



    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume:count "+count);
    }
//    class MyConn implements ServiceConnection {
//        // onServiceConnected 当服务连接的时候
////IBinder 服务返回的IBinder对象
//        public void onServiceConnected(ComponentName name, IBinder service) {
////            sc= (ServerConnect) service;
//            Log.e(TAG, "onServiceConnected: "+ "开始");
//        }
//        // onServiceDisconnected 当服务断开的时候调用
//        public void onServiceDisconnected(ComponentName name) {
//            Log.e(TAG, "onServiceDisconnected: "+"结束" );
//        }
//    }
}
