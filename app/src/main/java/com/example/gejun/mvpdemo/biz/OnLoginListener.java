package com.example.gejun.mvpdemo.biz;

import com.example.gejun.mvpdemo.bean.User;

/**
 * Created by gejun on 2016/12/27.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
