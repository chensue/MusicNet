package com.musicnet.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.musicnet.bean.ArtistInfo;
import com.musicnet.pager.Expression;
import com.musicnet.pager.PageBean;
import com.musicnet.service.ArtistInfoService;

public class ArtistInfoServlet extends HttpServlet
{

    /**
     * 
     */
    private static final long serialVersionUID = 2234893076273867826L;

    /**
     * Constructor of the object.
     */
    public ArtistInfoServlet()
    {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy()
    {
        super.destroy();
    }
    
    private String getUrl(HttpServletRequest request)
    {
        String url = request.getRequestURI()+"?"+request.getQueryString();
        /*
         * 如果url中存在pc参数，截取掉，如果不存在那就不用截取。
         */
        int index = url.lastIndexOf("&pc=");
        if(index != -1) 
        {
            url = url.substring(0, index);
        }
        return url;
    }
    
    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     * 
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setContentType("text/html;charset=UTF-8");
        
        List<Expression> exps = new ArrayList<Expression>();
        //得到URL;
        String url = getUrl(request);
        //当前页码
        int pc=0;
        if(request.getParameter("pc")!=null)
        {
            pc = Integer.parseInt(request.getParameter("pc"));
        }
        if(pc==0)
        {
            pc=1;
        }
        String artistname = request.getParameter("artistname");
        //歌手名称 模糊查询
        if (artistname!=null)
        {
            exps.add(new Expression("artistname","like","%"+artistname+"%"));
        }
        //性别 0 男性 1 女性
        String sex = request.getParameter("sex");
        if(sex!=null)
        {
            exps.add(new Expression("sex","=",sex));
        }
        
        ArtistInfoService service = new ArtistInfoService();
        try
        {
            PageBean<ArtistInfo> pbBean = service.findByCriteria(exps, pc);
            pbBean.setUrl(url);
            request.setAttribute("pbBean", pbBean);
            request.getRequestDispatcher("/jsp/artistList.jsp").forward(request, response);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
            return;
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//        out.println("<HTML>");
//        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//        out.println("  <BODY>");
//        out.print("    This is ");
//        out.print(this.getClass());
//        out.println(", using the POST method");
//        out.println("  </BODY>");
//        out.println("</HTML>");
//        out.flush();
//        out.close();
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException
    {
        // Put your code here
    }

}
