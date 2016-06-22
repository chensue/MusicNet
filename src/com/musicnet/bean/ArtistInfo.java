package com.musicnet.bean;

import java.util.Arrays;

/**
 * 歌手
 * @author Administrator
 *
 */
public class ArtistInfo
{
    /**
     * 歌手id
     */
    private int artistId;
    /**
     * 歌手名称
     */
    private String artistname;
    /**
     * 性别 0为男性 1为女性
     */
    private int sex;
    /**
     * 头像
     */
    private byte[] photo;
    public int getArtistId()
    {
        return artistId;
    }
    public void setArtistId(int artistId)
    {
        this.artistId = artistId;
    }
    public String getArtistname()
    {
        return artistname;
    }
    public void setArtistname(String artistname)
    {
        this.artistname = artistname;
    }
    public int getSex()
    {
        return sex;
    }
    public void setSex(int sex)
    {
        this.sex = sex;
    }
    public byte[] getPhoto()
    {
        return photo;
    }
    public void setPhoto(byte[] photo)
    {
        this.photo = photo;
    }
    @Override
    public String toString()
    {
        return "ArtistInfo [artistId=" + artistId + ", artistname=" + artistname + ", sex=" + sex + ", photo=" + Arrays.toString(photo)
                + "]";
    }
    
}
