package com.fnfh.mvp.login.model;

import android.text.TextUtils;
import android.widget.Toast;

import com.fnfh.mvp.login.bean.ICallBack;
import com.fnfh.mvp.login.bean.UserBean;

import static android.R.attr.name;

/**
 * 1. 作用
 * 2. 作者 侯永亮
 * 3. 时间 2016/12/14.
 */

public class LoginBean implements ILoginBean {
    @Override
    public void login(String username, String password, ICallBack callBack) {
        try {
            System.out.println("网络请求中。。");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(username)) {
            callBack.fail("密码和用户名不能为空");

        } else if (username.equals("hyl") && password.equals("123456")) {
            callBack.success(new UserBean());
        } else {
            callBack.fail("密码和用户名不正确，请重新输入");
        }
    }
}
