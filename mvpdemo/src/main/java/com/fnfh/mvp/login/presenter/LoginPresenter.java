package com.fnfh.mvp.login.presenter;

import com.fnfh.mvp.login.bean.ICallBack;
import com.fnfh.mvp.login.bean.UserBean;
import com.fnfh.mvp.login.model.LoginBean;
import com.fnfh.mvp.login.view.ILoginView;

/**
 * 1. 作用
 * 2. 作者 侯永亮
 * 3. 时间 2016/12/14.
 */

public class LoginPresenter implements  ILoginPresenter{
    private ILoginView mLoginView;
    private  LoginBean loginBean;

    public LoginPresenter(ILoginView mLoginView){
        this.mLoginView=mLoginView;
        loginBean = new LoginBean();
    }
    @Override
    public void login(String username, String password) {
        if(username.trim().length()==0){
            mLoginView.loginFail("用户名不能为空");
            return;
        }
        if(password.trim().length()!=6){
            mLoginView.loginFail("密码必须为 6位");
            return;
        }
        loginBean.login(username, password, new ICallBack() {
            @Override
            public void success(UserBean user) {
                mLoginView.loginSuccess(user);
            }

            @Override
            public void fail(String errMsg) {
                mLoginView.loginFail(errMsg);
            }
        });
    }
}
