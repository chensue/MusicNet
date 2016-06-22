package com.musicnet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.musicnet.service.LoginService;

/**
 * 登录
 * @author yu
 *
 */
public class LoginServlet extends HttpServlet {

	/**
     * 
     */
    private static final long serialVersionUID = -4775317767453010987L;

    /**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return;
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String uname = (String)request.getParameter("uname");
		String pwd = (String)request.getParameter("pwd");
		LoginService service = new LoginService();
		try
        {
            int result = service.login(uname, pwd);
            switch (result) {
            case 0:
                //登录成功
                //TODO 将用户信息保存到session域中
                response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
                break;
            case 1:
                //用户名不存在
                request.setAttribute("msg", "用户名不存在!");
                request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
                break;
            case 2:
                //密码错误
                request.setAttribute("msg", "密码错误!"); 
                request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
                break;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
