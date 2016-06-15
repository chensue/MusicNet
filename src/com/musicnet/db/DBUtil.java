package com.musicnet.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil
{
    /**
     * ��ȡ���ݿ�����
     * @return
     * AdministratorJun 15, 20169:37:55 AM
     */
    public static Connection connect()
    {
        Properties properties = new Properties();
        String driver = null;
        String url = null;
        String username = null;
        String password = null;
        InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("DB.properties");
        try
        {
            properties.load(inputStream);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            Class.forName(driver);
            System.out.println("--->>mysql�������سɹ�!");
            Connection conn = DriverManager.getConnection(url, username,password);
            return conn;
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            System.out.println("mysql��������ʧ��!");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * �ر�sql Connection
     * @param conn
     * AdministratorJun 15, 20169:37:39 AM
     */
    public static void closeConn(Connection conn)
    {
        if(conn!=null)
        {
            try
            {
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args)
    {
        Connection conn = DBUtil.connect();
        System.out.println("--->>��ȡ���ݿ����ӳɹ�!");
        DBUtil.closeConn(conn);
        System.out.println("--->>�ر����ݿ����ӳɹ�!");
        
    }
    
}
