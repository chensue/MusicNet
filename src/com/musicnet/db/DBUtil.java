package com.musicnet.db;

import java.sql.Connection;
import java.sql.SQLException;

public final class DBUtil
{
    // private static String driver;
    // private static String url;
    // private static String username;
    // private static String password;

    // static{
    // Properties p = new Properties();
    // try {
    // p.load(DBUtil.class.getResourceAsStream("/DB.properties"));
    // driver = (String)p.get("driver");
    // url = (String)p.get("url");
    // username = (String)p.get("username");
    // password = (String)p.get("password");
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }

    private DBUtil()
    {
    }

    /**
     * 获取数据库连接
     * 
     * @return AdministratorJun 15, 20169:37:55 AM
     */
    public static Connection getConnection()
    {
        Connection conn = null;
        // Class.forName(driver);
        // conn = DriverManager.getConnection(url, username, password);
        conn = C3P0Util.getConnection();
        return conn;
    }

    /**
     * 关闭sql Connection
     * 
     * @param conn
     *            AdministratorJun 15, 20169:37:39 AM
     */
    public static void close(Connection conn)
    {
        try
        {
            if (conn != null)
            {
                conn.close();
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Connection conn = DBUtil.getConnection();
        if (conn != null)
        {
            System.out.println("get True");
        }
    }

}
