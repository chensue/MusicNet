package com.musicnet.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;

import com.musicnet.bean.UserInfo;
import com.musicnet.db.DBUtil;

public class BaseDao
{
    private Connection conn;
    
    public BaseDao()
    {
        conn = DBUtil.connect();
    }
    
    /**
     * ���ҷ��������ĵ�һ����¼
     * @param sql
     * @param params
     * @return
     * AdministratorJun 15, 201610:02:29 AM
     * @throws IllegalAccessException 
     * @throws Exception 
     */
    public <T> T findFirstRecord(String sql,List<Object> params,Class<T> clazz) throws Exception
    {
        if(conn!=null)
        {
            T t = clazz.newInstance();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            if(params!=null&&!params.isEmpty())
            {
                for(int i=0;i<params.size();i++)
                {
                    pstmt.setObject(i, params.get(i));
                }
            }
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next())
            {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int len = metaData.getColumnCount();
                for (int j = 0; j < len; j++)
                {
                    //���ݿ��д�1��ʼ
                    String columnName = metaData.getColumnName(j+1);
                    Object columnValue = resultSet.getObject(columnName);
                    Field field = clazz.getDeclaredField(columnName);
                    //����˽�б����ɷ���
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        }
        return null;
    }
    
    /**
     * �ر����ݿ�����
     * AdministratorJun 15, 20162:56:43 PM
     */
    public void closeConn()
    {
        DBUtil.closeConn(conn);
    }
    
    public static void main(String[] args)
    {
        BaseDao dao = new BaseDao();
        String sql = "SELECT * FROM  userinfo";
        try
        {
            UserInfo userInfo = dao.findFirstRecord(sql, null, UserInfo.class);
            System.out.println(userInfo);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
