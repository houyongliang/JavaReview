package com.fnfh.mvp.login.model;

import com.fnfh.mvp.login.bean.ICallBack;

/**
 * 1. 作用
 * 2. 作者 侯永亮
 * 3. 时间 2016/12/14.
 */

public interface ILoginBean {
    void login(String username, String password, ICallBack callBack);
}
