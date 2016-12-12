package com.hyl.java_reciew;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;
import static android.icu.text.RelativeDateTimeFormatter.Direction.THIS;

public class MyService extends Service {
    public static final  String TAG="MyService";
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(), "绑定服务", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onBind: "+"绑定服务");
        return null;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(), "创建服务", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onCreate: "+"创建服务");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(getApplicationContext(), "开启服务", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onStart: "+"开启服务");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(), "开启服务命令", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onStartCommand: "+"开启服务命令");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Toast.makeText(getApplicationContext(), "onRebind+重新绑定服务", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onRebind: "+"重新绑定服务");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(getApplicationContext(), "解除服务绑定", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onUnbind: "+"解除服务绑定");
        return super.onUnbind(intent);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "销毁服务", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onDestroy: "+"销毁服务");
    }

//    private void getNet() { Toast.makeText(getApplicationContext(),"获取网络资源。。。", Toast.LENGTH_SHORT).show();}
//
//    class MyBinder extends Binder implements ServerConnect { public void getOneNet() {getNet();} }

}
//interface ServerConnect { void getOneNet();}




