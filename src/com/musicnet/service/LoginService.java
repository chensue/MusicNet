package com.musicnet.service;

import com.musicnet.dao.UserDao;
import com.musicnet.dao.impl.UserDaoImpl;

public class LoginService
{
    private UserDao userDao = new UserDaoImpl();
    /**
     * 登录，成功返回0，用户名不存在返回1，密码错误返回2
     * @return
     * AdministratorJun 22, 20162:40:49 PM
     * @throws Exception 
     */
    public int login(String uname,String pwd) throws Exception
    {
        return userDao.login(uname, pwd);
    }
}
