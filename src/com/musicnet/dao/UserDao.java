package com.musicnet.dao;

public interface UserDao extends BaseDao
{
    /**
     * 登录，成功返回0，用户名不存在返回1，密码错误返回2
     * @param uname
     * @param pwd
     * @return
     * @throws Exception
     * AdministratorJun 22, 20162:55:29 PM
     */
    int login(String uname,String pwd) throws Exception;
}
