package com.musicnet.dao;

import java.sql.SQLException;
import java.util.List;

import com.musicnet.bean.ArtistInfo;
import com.musicnet.pager.Expression;
import com.musicnet.pager.PageBean;

public interface ArtistInfoDao extends BaseDao
{
    PageBean<ArtistInfo> findByCriteria(List<Expression> expList,int pc) throws SQLException;
}
