package com.example.gejun.mvpdemo.view;

import com.example.gejun.mvpdemo.bean.User;

/**
 * Created by gejun on 2016/12/27.
 */

public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
