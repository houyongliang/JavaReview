package com.fnfh.mvp.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fnfh.mvp.R;
import com.fnfh.mvp.login.bean.UserBean;
import com.fnfh.mvp.login.presenter.LoginPresenter;
import com.fnfh.mvp.login.view.ILoginView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener,ILoginView {

    private Button login;
    private TextView name;
    private TextView pwd;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        login = (Button) findViewById(R.id.login);
        name = (TextView) findViewById(R.id.name);
        pwd = (TextView) findViewById(R.id.pwd);
        login.setOnClickListener(this);

        loginPresenter = new LoginPresenter(this);

    }

    @Override
    public void onClick(View view) {
//        if(TextUtils.isEmpty(name.getText().toString().trim())||TextUtils.isEmpty(pwd.toString().trim())){
//            Toast.makeText(this, "密码和用户名不能为空", Toast.LENGTH_SHORT).show();
//
//        }else   if(name.equals("hyl")&&pwd.equals("123456")){
//            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(this, "用户名和密码不正确，登陆失败", Toast.LENGTH_SHORT).show();
//        }
        loginPresenter.login(name.getText().toString(),pwd.getText().toString());

    }

    @Override
    public void loginSuccess(UserBean user) {
        System.out.println("登陆成功，根据情况做相应处理");
        Toast.makeText(this, user+"登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail(String errMsg) {
        Toast.makeText(this,errMsg,Toast.LENGTH_SHORT).show();
    }
}
