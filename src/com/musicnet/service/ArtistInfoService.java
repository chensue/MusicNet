package com.musicnet.service;

import java.sql.SQLException;
import java.util.List;

import com.musicnet.bean.ArtistInfo;
import com.musicnet.dao.ArtistInfoDao;
import com.musicnet.dao.impl.ArtistInfoDaoImpl;
import com.musicnet.pager.Expression;
import com.musicnet.pager.PageBean;

public class ArtistInfoService
{
    private ArtistInfoDao dao = new ArtistInfoDaoImpl();
    public List<ArtistInfo> findArtistInfos() throws Exception
    {
        String sql = "SELECT * FROM ArtistInfo";
        return dao.findRecords(sql, null, ArtistInfo.class);
    }
    
    /**
     * 通用的查询方法
     */
    public PageBean<ArtistInfo> findByCriteria(List<Expression> expList,int pc) throws SQLException
    {
        return dao.findByCriteria(expList, pc);
    }
    
    public static void main(String[] args)
    {
        ArtistInfoService service = new ArtistInfoService();
        try
        {
            List<ArtistInfo> list = service.findArtistInfos();
            for(ArtistInfo info:list)
            {
                System.out.println(info);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
