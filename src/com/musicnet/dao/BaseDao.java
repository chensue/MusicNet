package com.musicnet.dao;

import java.util.List;

public interface BaseDao
{
    /**
     * 添加一条数据
     * 
     * @param sql
     * @param params
     * @param clazz
     * @return AdministratorJun 20, 20165:26:06 PM
     * @throws Exception 
     */
    <T> T add(String sql, List<Object> params, Class<T> clazz) throws Exception;
    
    /**
     * 更新
     * @param sql
     * @param params
     * @return
     * @throws Exception
     * AdministratorJun 21, 201610:08:44 AM
     */
    boolean update(String sql, List<Object> params) throws Exception;
    
    /**
     * 删除
     * @param sql
     * @param params
     * @return true 删除成功 false 删除失败
     * AdministratorJun 21, 201610:12:40 AM
     */
    boolean delete(String sql,List<Object> params)throws Exception;
    
    /**
     * 查找符合条件的第一条记录
     * 
     * @param sql
     * @param params
     * @return AdministratorJun 15, 201610:02:29 AM
     * @throws IllegalAccessException
     * @throws Exception
     */
    <T> T findFirstRecord(String sql, List<Object> params, Class<T> clazz) throws Exception;
    
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
    <T> List<T> findRecords(String sql, List<Object> params, Class<T> clazz) throws Exception;
    
    /**
     * 关闭数据库连接 AdministratorJun 15, 20162:56:43 PM
     */
    void closeConn();
}
