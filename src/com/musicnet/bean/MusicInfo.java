package com.musicnet.bean;

/**
 * 歌曲信息
 * @author Administrator
 *
 */
public class MusicInfo
{
    /**
     * 歌曲id
     */
    private int mid;
    /**
     * 歌曲名称
     */
    private String musicname;
    /**
     * 歌曲存放路径
     */
    private String musicpath;
    /**
     * 歌曲时长
     */
    private String duration;
    /**
     * 歌手id
     */
    private int artistId;
    public int getMid()
    {
        return mid;
    }
    public void setMid(int mid)
    {
        this.mid = mid;
    }
    public String getMusicname()
    {
        return musicname;
    }
    public void setMusicname(String musicname)
    {
        this.musicname = musicname;
    }
    public String getMusicpath()
    {
        return musicpath;
    }
    public void setMusicpath(String musicpath)
    {
        this.musicpath = musicpath;
    }
    public String getDuration()
    {
        return duration;
    }
    public void setDuration(String duration)
    {
        this.duration = duration;
    }
    public int getArtistId()
    {
        return artistId;
    }
    public void setArtistId(int artistId)
    {
        this.artistId = artistId;
    }
    @Override
    public String toString()
    {
        return "MusicInfo [mid=" + mid + ", musicname=" + musicname + ", musicpath=" + musicpath + ", duration=" + duration + ", artistId="
                + artistId + "]";
    }
    
    
}
