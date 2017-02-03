package com.fnfh.mvp.login.view;

import com.fnfh.mvp.login.bean.UserBean;

/**
 * 1. 作用
 * 2. 作者 侯永亮
 * 3. 时间 2016/12/14.
 */

public interface ILoginView {
    void loginSuccess(UserBean user);
    void loginFail(String errMsg);
}
