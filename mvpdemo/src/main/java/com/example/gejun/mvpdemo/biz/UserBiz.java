package com.example.gejun.mvpdemo.biz;

import com.example.gejun.mvpdemo.bean.User;

/**
 * Created by gejun on 2016/12/27.
 */

public class UserBiz implements IUserBiz{
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("gejun".equals(username) && "123456".equals(password))
                {
                    User user = new User();
                    user.setName(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else
                {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
