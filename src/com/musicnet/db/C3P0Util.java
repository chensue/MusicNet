package com.musicnet.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ���ӳ�����
 * @author Administrator
 *
 */
public final class C3P0Util
{
    static ComboPooledDataSource cpds=null;
    
    static{
        //�����и��ŵ㣬д�������ļ����뻻���ݿ⣬��  
        //cpds = new ComboPooledDataSource("oracle");//����oracle���ݿ�  
        cpds = new ComboPooledDataSource("mysql");//����mysql���ݿ�  
    }
    
    private C3P0Util(){}
    
    /** 
     * ������ݿ����� 
     * @return   Connection 
     */  
    public static Connection getConnection(){  
        try {  
            return cpds.getConnection();  
        } catch (SQLException e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
      
    /** 
     * ���ݿ�رղ��� 
     * @param conn   
     * @param st     
     * @param pst 
     * @param rs 
     */  
    public static void close(Connection conn,PreparedStatement pst,ResultSet rs){  
        if(rs!=null){  
            try {  
                rs.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
        if(pst!=null){  
            try {  
                pst.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
  
        if(conn!=null){  
            try {  
                conn.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
    /** 
     * ����DBUtil�� 
     * @param args 
     */  
    public static void main(String[] args) 
    {  
        Connection conn=getConnection();
        System.out.println(conn.getClass().getName());  
        close(conn,null,null);  
    }
    
}
