package com.musicnet.dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.musicnet.dao.BaseDao;
import com.musicnet.db.DBUtil;

public class BaseDaoImpl implements BaseDao
{
    private Connection conn;

    public BaseDaoImpl()
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
            int row = pstmt.executeUpdate();
            if(row>0)
            {
                pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM userinfo i WHERE i.uid=(SELECT LAST_INSERT_ID() AS id)");
                resultSet = pstmt.executeQuery();
            }
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
                if(pstmt!=null)
                {
                    pstmt.close();
                }
                return t;
            }
            if(pstmt!=null)
            {
                pstmt.close();
            }
        }
        // 添加失败
        return null;
    }
    
    /**
     * 更新
     * @param sql
     * @param params
     * @return
     * @throws Exception
     * AdministratorJun 21, 201610:08:44 AM
     */
    public boolean update(String sql, List<Object> params) throws Exception
    {
        boolean flag = false;
        if(conn!=null)
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            if (params != null && !params.isEmpty())
            {
                for (int i = 0; i < params.size(); i++)
                {
                    pstmt.setObject(i+1, params.get(i));
                }
            }
            int row = pstmt.executeUpdate();
            if(row>0)
            {
                flag = true;
            }
        }
        return flag;
    }
    
    /**
     * 删除
     * @param sql
     * @param params
     * @return true 删除成功 false 删除失败
     * AdministratorJun 21, 201610:12:40 AM
     */
    public boolean delete(String sql,List<Object> params)throws Exception
    {
        boolean flag = false;
        if(conn!=null)
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            if(params!=null&&!params.isEmpty())
            {
                for (int i = 0; i < params.size(); i++)
                {
                    pstmt.setObject(i+1, params.get(i));
                }
            }
            int row = pstmt.executeUpdate();
            if(row>0)
            {
                flag = true;
            }
        }
        return flag;
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
//        BaseDao dao = new BaseDao();
        //String sql = "INSERT INTO userinfo(uname,email,pwd,phone) VALUES(?,?,?,?)";
        //String sql = "update userinfo set uname='222' where uid=11";
//        String sql = "delete from userinfo where uid=11";
//        List<Object> params = null;//new ArrayList<Object>();
//        params.add("111");
//        params.add("111@qq.com");
//        params.add("123456");
//        params.add(110);
//        try
//        {
//            UserInfo userInfo = dao.add(sql, params, UserInfo.class);
//            System.out.println(userInfo);
            //boolean b = dao.update(sql, params);
//            boolean b = dao.delete(sql, params);
//            System.out.println("-->update result:"+b);
            //List<UserInfo> userInfo2 = dao.findRecords(sql, null, UserInfo.class);
            //System.out.println(userInfo2);
//            dao.closeConn();
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//        }
    }
}
