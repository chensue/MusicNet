package com.musicnet.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.musicnet.bean.UserInfo;
import com.musicnet.dao.UserDao;

public class UserDaoImpl extends BaseDaoImpl implements UserDao
{
    /**
     * 登录，成功返回0，用户名不存在返回1，密码错误返回2
     * @return
     * AdministratorJun 22, 20162:46:39 PM
     * @throws Exception 
     */
    public int login(String uname,String pwd) throws Exception
    {
        String sql1 = "SELECT * FROM userinfo u WHERE u.uname=?";
        List<Object> param1 = new ArrayList<Object>();
        param1.add(uname);
        UserInfo userInfo1 = findFirstRecord(sql1, param1, UserInfo.class);
        if(userInfo1==null)
        {
            //用户名不存在
            return 1;
        }
        String sql2 = "SELECT * FROM userinfo u WHERE u.uname=? AND u.pwd=?";
        param1.add(pwd);
        UserInfo userInfo2 = findFirstRecord(sql2, param1, UserInfo.class);
        if(userInfo2==null)
        {
            //密码错误
            return 2;
        }
        return 0;
    }
}
