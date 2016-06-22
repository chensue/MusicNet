package com.musicnet.dao.impl;

import com.musicnet.bean.ArtistInfo;
import com.musicnet.dao.ArtistInfoDao;

public class ArtistInfoDaoImpl extends BaseDaoImpl implements ArtistInfoDao
{
    public static void main(String[] args)
    {
        ArtistInfoDaoImpl dao = new ArtistInfoDaoImpl();
        String sql = "SELECT * FROM ArtistInfo";
        try
        {
            ArtistInfo info = dao.findFirstRecord(sql, null, ArtistInfo.class);
            if(info!=null)
            {
                System.out.println(info);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
