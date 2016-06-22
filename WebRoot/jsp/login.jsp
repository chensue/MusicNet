<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" language="java"%>
<%
String msg = (String)request.getAttribute("msg");	
%>
<!DOCTYPE HTML>
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="<%=request.getContextPath()%>/jsp/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="<%=request.getContextPath()%>/jsp/css/style.css" rel='stylesheet' type='text/css' />
<link href="<%=request.getContextPath()%>/jsp/css/font-awesome.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/jsp/css/toastr.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/jsp/css/toastCenter.css" rel="stylesheet">
<!-- jQuery -->
<script src="<%=request.getContextPath()%>/jsp/js/jquery.min.js"></script>
<!----webfonts
<link href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
--->
<!---//webfonts--->  
<!-- Bootstrap Core JavaScript -->
<script src="<%=request.getContextPath()%>/jsp/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/jsp/js/toastr.min.js"></script>
</head>
<body id="login" onload="showMsg()">
  <div class="login-logo">
    <a href="index.jsp"><img src="<%=request.getContextPath()%>/jsp/images/logo.png" alt=""/></a>
  </div>
  <h2 class="form-heading">login</h2>
  <div class="app-cam">
	  <form method="post" onsubmit="return login();">
	  	<input type="hidden" name="basepath" value="<%=request.getContextPath()%>" />
		<input id="uname" name="uname" type="text"  value="" placeholder="请输入用户名"
			>
		<input id="pwd" name="pwd" type="password" value="" placeholder="请输入密码"
			>
		<div class="submit"><input type="submit"  value="Login"></div>
		<div class="login-social-link">
          <a href="index.html" class="facebook">
              Facebook
          </a>
          <a href="index.html" class="twitter">
              Twitter
          </a>
        </div>
		<ul class="new">
			<li class="new_left"><p><a href="#">Forgot Password ?</a></p></li>
			<li class="new_right"><p class="sign">New here ?<a href="register.html"> Sign Up</a></p></li>
			<div class="clearfix"></div>
		</ul>
	</form>
  </div>
   <div class="copy_layout login">
      <p>Copyright &copy; 2015.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title=""></a> - Collect from <a href="http://www.cssmoban.com/" title="" target="_blank"></a></p>
   </div>
</body>
<script type="text/javascript">
//初始化 toastr确定位置 q
toastr.options.positionClass = 'toast-center-center';
//设置显示时长
toastr.options.timeOut="1000";
function showMsg()
{
	<%
	if(msg!=null&&!"".equals(msg))
	{
	%>
		toastr.warning("<%=msg%>");
	<%
	}
	%>
}

function login()
{
	var uname = document.getElementById("uname").value;
	var pwd = document.getElementById("pwd").value;
	if(uname==null||""==uname)
	{
		toastr.warning("用户名不能为空!");
		document.getElementById("uname").focus();
		return false;
	}
	if(pwd==null||""==pwd)
	{
		toastr.warning("密码不能为空!");
		document.getElementById("pwd").focus();
		return false;
	}
	
	var url = document.forms[0].basepath.value+"/servlet/LoginServlet";
	document.forms[0].action = url;
	//document.forms[0].submit();
}
</script>
</html>
