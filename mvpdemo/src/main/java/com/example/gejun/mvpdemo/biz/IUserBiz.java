package com.example.gejun.mvpdemo.biz;

/**
 * Created by gejun on 2016/12/27.
 */

public interface IUserBiz {
    public void login(String username, String password, OnLoginListener loginListener);
}
