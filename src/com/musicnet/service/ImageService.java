package com.musicnet.service;

import java.util.ArrayList;
import java.util.List;

import com.musicnet.bean.ArtistInfo;
import com.musicnet.dao.ArtistInfoDao;
import com.musicnet.dao.impl.ArtistInfoDaoImpl;

public class ImageService
{
    public byte[] getByArtistId(int id) throws Exception
    {
        ArtistInfoDao dao = new ArtistInfoDaoImpl();
        String sql = "SELECT * FROM ArtistInfo f WHERE f.artistId=?";
        List<Object> params = new ArrayList<Object>();
        params.add(id);
        ArtistInfo info = dao.findFirstRecord(sql, params, ArtistInfo.class);
        byte[] photo = null;
        if(info!=null)
        {
            photo = info.getPhoto();
        }
        return photo;
    }
}
