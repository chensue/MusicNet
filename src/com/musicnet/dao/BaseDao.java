package com.musicnet.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.musicnet.bean.UserInfo;
import com.musicnet.db.DBUtil;

public class BaseDao
{
    private Connection conn;

    public BaseDao()
    {
        conn = DBUtil.getConnection();
    }

    /**
     * 添加一条数据
     * 
     * @param sql
     * @param params
     * @param clazz
     * @return AdministratorJun 20, 20165:26:06 PM
     * @throws Exception 
     */
    public <T> T add(String sql, List<Object> params, Class<T> clazz) throws Exception
    {
        if (conn != null)
        {

            T t = clazz.newInstance();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            if (params != null && !params.isEmpty())
            {
                for (int i = 0; i < params.size(); i++)
                {
                    pstmt.setObject(i+1, params.get(i));
                }
            }
            ResultSet resultSet = null;
                    pstmt.executeUpdate();
            if (resultSet!=null&&resultSet.next())
            {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int len = metaData.getColumnCount();
                for (int j = 0; j < len; j++)
                {
                    // 数据库列从1开始
                    String columnName = metaData.getColumnName(j + 1);
                    Object columnValue = resultSet.getObject(columnName);
                    if (columnValue == null)
                    {
                        columnValue = "";
                    }
                    Field field = clazz.getDeclaredField(columnName);
                    // 设置私有变量可访问
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        }
        // 添加失败
        return null;
    }

    /**
     * 查找符合条件的第一条记录
     * 
     * @param sql
     * @param params
     * @return AdministratorJun 15, 201610:02:29 AM
     * @throws IllegalAccessException
     * @throws Exception
     */
    public <T> T findFirstRecord(String sql, List<Object> params, Class<T> clazz) throws Exception
    {
        if (conn != null)
        {
            T t = clazz.newInstance();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            if (params != null && !params.isEmpty())
            {
                for (int i = 0; i < params.size(); i++)
                {
                    pstmt.setObject(i+1, params.get(i));
                }
            }
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next())
            {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int len = metaData.getColumnCount();
                for (int j = 0; j < len; j++)
                {
                    // 数据库列从1开始
                    String columnName = metaData.getColumnName(j + 1);
                    Object columnValue = resultSet.getObject(columnName);
                    if (columnValue == null)
                    {
                        columnValue = "";
                    }
                    Field field = clazz.getDeclaredField(columnName);
                    // 设置私有变量可访问
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        }
        return null;
    }

    /**
     * 查找多条记录
     * 
     * @param sql
     * @param params
     * @param clazz
     * @return
     * @throws Exception
     *             AdministratorJun 20, 20165:23:42 PM
     */
    public <T> List<T> findRecords(String sql, List<Object> params, Class<T> clazz) throws Exception
    {
        List<T> list = null;
        if (conn != null)
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            if (params != null && !params.isEmpty())
            {
                for (int i = 0; i < params.size(); i++)
                {
                    pstmt.setObject(i+1, params.get(i));
                }
            }
            ResultSet resultSet = pstmt.executeQuery();
            list = new ArrayList<T>();
            while (resultSet.next())
            {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int len = metaData.getColumnCount();
                T t = clazz.newInstance();
                for (int j = 0; j < len; j++)
                {
                    String columnName = metaData.getColumnName(j + 1);
                    Object columnValue = resultSet.getObject(columnName);
                    if (columnValue == null)
                    {
                        columnValue = "";
                    }
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
        }
        return list;
    }

    /**
     * 关闭数据库连接 AdministratorJun 15, 20162:56:43 PM
     */
    @SuppressWarnings("deprecation")
    public void closeConn()
    {
        try
        {
            if (conn != null && !conn.isClosed())
            {
                DBUtil.close(conn);
                System.out.println(new Date().toLocaleString() + "关闭数据库连接成功...");
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("关闭数据库连接失败：" + e.getMessage());
        }

    }

    public static void main(String[] args)
    {
        BaseDao dao = new BaseDao();
        String sql = "INSERT INTO userinfo(uname,email,pwd,phone) VALUES(?,?,?,?)";
        List<Object> params = new ArrayList<Object>();
        params.add("111");
        params.add("111@qq.com");
        params.add("123456");
        params.add(110);
        try
        {
            UserInfo userInfo = dao.add(sql, params, UserInfo.class);
            System.out.println(userInfo);
            //List<UserInfo> userInfo2 = dao.findRecords(sql, null, UserInfo.class);
            //System.out.println(userInfo2);
            dao.closeConn();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
