package com.hyl.eventbuddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn2= (Button) findViewById(R.id.main2_btn);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bean bean = new Bean();
                bean.name="hyl";
                bean.password="1234";
                EventBus.getDefault().post(bean);
                finish();
            }
        });
    }
}
