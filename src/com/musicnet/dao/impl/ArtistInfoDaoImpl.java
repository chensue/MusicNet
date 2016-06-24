package com.musicnet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.musicnet.bean.ArtistInfo;
import com.musicnet.dao.ArtistInfoDao;
import com.musicnet.db.DBUtil;
import com.musicnet.pager.Expression;
import com.musicnet.pager.PageBean;
import com.musicnet.pager.PageConstant;

public class ArtistInfoDaoImpl extends BaseDaoImpl implements ArtistInfoDao
{
    
    /**
     * 通用的查询方法
     */
    public PageBean<ArtistInfo> findByCriteria(List<Expression> expList,int pc) throws SQLException
    {
        /**
         * 1.得到ps,每页记录数
         */
        int ps = PageConstant.ARTIST_PAGE_SIZE;
        /**
         * 2.通过expList生成where语句
         */
        StringBuilder whereSql = new StringBuilder();
        List<Object> params = new ArrayList<Object>();
        for (Expression exp:expList) {
            whereSql.append(" and ").append(exp.getName())
                .append(" ").append(exp.getOperator()).append(" ");
            if(!exp.getOperator().equals("is null"))
            {
                whereSql.append("?");
                params.add(exp.getValue());
            }
        }
        /*
         * 3. 总记录数 
         */
        String sql = "select count(*) from ArtistInfo where 1=1" + whereSql;
        if(conn==null)
        {
            conn = DBUtil.getConnection();
            System.out.println("=====>>>>>>ArtistInfoDaoImpl findByCriteria 中获取conn为null!");
        }
        
        PreparedStatement pStatement = conn.prepareStatement(sql);
        int pSize = params.size();
        for (int i = 1; i <= pSize; i++)
        {
            pStatement.setObject(i, params.get(i-1));
        }
        ResultSet rs = pStatement.executeQuery();
        rs.next();
        int tr = rs.getInt(1);//得到了总记录数
        /*
         * 4. 得到beanList，即当前页记录
         */
//        sql = "select RID,RNAME,PRICE,CURRPRICE,DISCOUNT,CID,IMAGE_W,IMAGE_B,STATUS,HAVECOMPUTER,HAVEBREAKFAST,DESCRIPTION from " +
//                "(select t_room.*,rownum n from t_room" +
//                " where rownum<?"+whereSql+")where n>=?";
        //第一个问号为从第几列开始找起但不包含这列，如为0，则从1开始，第二个问号为找多少条
        sql = "select * from ArtistInfo" + whereSql + " order by artistId limit ?,?";
        PreparedStatement pStatement2 = conn.prepareStatement(sql);
        for (int i = 0; i < pSize; i++)
        {
            pStatement2.setObject(i+1, params.get(i));
        }
        int start = (pc-1)*ps;
        pStatement2.setObject(pSize+1,start);//当前页首行记录的下标
        pStatement2.setObject(pSize+2,ps);//一共查询几行，就是每页记录数
        ResultSet rs2 = pStatement2.executeQuery();
        List<ArtistInfo> beanList = toArtistInfo(rs2);
        /*
         * 5. 创建PageBean，设置参数
         */
        PageBean<ArtistInfo> pb = new PageBean<ArtistInfo>();
        /*
         * 其中PageBean没有url，这个任务由Servlet完成
         */
        pb.setBeanList(beanList);
        pb.setPc(pc);
        pb.setPs(ps);
        pb.setTr(tr);
        
        return pb;
    }
    
    private List<ArtistInfo> toArtistInfo(ResultSet rs) throws SQLException
    {
        List<ArtistInfo> lists = new ArrayList<ArtistInfo>();
        while(rs.next()) {
            ArtistInfo info = new ArtistInfo();
            info.setArtistId(rs.getInt("artistId"));
            info.setArtistname(rs.getString("artistname"));
            //info.setPhoto(rs.getBytes("photo"));
            info.setSex(rs.getInt("sex"));
//            String sql = "SELECT * FROM t_category WHERE cid=?";
//            PreparedStatement pStatement = con.prepareStatement(sql);
//            pStatement.setString(1, rs.getString("CID"));
//            ResultSet rSet = pStatement.executeQuery();
//            if (rSet.next()) {
//                Category c = new Category();
//                c.setCid(rSet.getString("CID"));
//                c.setCname(rSet.getString("CNAME"));
//                c.setDescription(rSet.getString("DESCRIPTION"));
//                room.setCategory(c);
//            }
//            room.setImage_w(rs.getString("IMAGE_W"));
//            room.setImage_b(rs.getString("IMAGE_B"));
//            room.setStatus(rs.getString("STATUS"));
//            room.setHaveBreakfast(rs.getString("HAVEBREAKFAST"));
//            room.setHaveComputer(rs.getString("HAVECOMPUTER"));
//            room.setDescription(rs.getString("DESCRIPTION"));
            lists.add(info);
        }
        return lists;
    }
    
    public static void main(String[] args)
    {
        ArtistInfoDaoImpl dao = new ArtistInfoDaoImpl();
//        String sql = "SELECT * FROM ArtistInfo";
        try
        {
//            ArtistInfo info = dao.findFirstRecord(sql, null, ArtistInfo.class);
//            if(info!=null)
//            {
//                System.out.println(info);
//            }
            List<Expression> exps = new ArrayList<Expression>();
            //exps.add(new Expression("artistname","like","%"+artistname+"%"));
            //exps.add(new Expression("sex","=",sex));
            PageBean<ArtistInfo> pb = dao.findByCriteria(exps, 1);
            if(pb!=null)
            {
                List<ArtistInfo> lists = pb.getBeanList();
                if(lists!=null&&!lists.isEmpty())
                {
                    for (ArtistInfo info:lists)
                    {
                        System.out.println(info);
                    }
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
