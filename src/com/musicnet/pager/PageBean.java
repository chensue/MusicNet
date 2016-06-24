package com.musicnet.pager;

import java.util.List;

/**
 * 分页Bean，它会在各层之间传递
 * @author Administrator
 *
 * @param <T>
 */
public class PageBean<T>
{
    /**
     * 当前页码
     */
    private int pc;
    /**
     * 总记录数
     */
    private int tr;
    /**
     * 每页记录数
     */
    private int ps;
    /**
     * 最大页数
     */
    private int tp;
    /**
     * 访问链接
     */
    private String url;
    
    private List<T> beanList;
    
    /**
     * 当前页码
     */
    public int getPc()
    {
        return pc;
    }
    
    /**
     * 当前页码
     */
    public void setPc(int pc)
    {
        this.pc = pc;
    }
    
    /**
     * 总记录数
     */
    public int getTr()
    {
        return tr;
    }
    
    /**
     * 总记录数
     */
    public void setTr(int tr)
    {
        this.tr = tr;
    }
    
    /**
     * 每页记录数
     */
    public int getPs()
    {
        return ps;
    }
    
    /**
     * 每页记录数
     */
    public void setPs(int ps)
    {
        this.ps = ps;
    }
    
    /**
     * 最大页数
     */
    public int getTp()
    {
        return tp;
    }
    
    /**
     * 最大页数
     */
    public void setTp(int tp)
    {
        this.tp = tp;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public List<T> getBeanList()
    {
        return beanList;
    }

    public void setBeanList(List<T> beanList)
    {
        this.beanList = beanList;
    }

    @Override
    public String toString()
    {
        return "PageBean [pc=" + pc + ", tr=" + tr + ", ps=" + ps + ", tp=" + tp + ", url=" + url + ", beanList=" + beanList + "]";
    }
    
}
