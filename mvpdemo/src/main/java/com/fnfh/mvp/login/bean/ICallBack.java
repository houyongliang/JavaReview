package com.fnfh.mvp.login.bean;

/**
 * 1. 作用
 * 2. 作者 侯永亮
 * 3. 时间 2016/12/14.
 */

public interface ICallBack {
    void success(UserBean user);
    void fail(String errMsg);

}
