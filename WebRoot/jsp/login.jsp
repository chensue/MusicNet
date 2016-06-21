<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" language="java"%>
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
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!----webfonts
<link href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
--->
<!---//webfonts--->  
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
</head>
<body id="login">
  <div class="login-logo">
    <a href="index.jsp"><img src="images/logo.png" alt=""/></a>
  </div>
  <h2 class="form-heading">login</h2>
  <div class="app-cam">
	  <form method="post">
	  	<input type="hidden" name="basepath" value="<%=request.getContextPath()%>" />
		<input id="uname" name="uname" type="text" class="text" value="" placeholder="请输入用户名">
		<input id="pwd" name="pwd" type="password" value="" placeholder="请输入密码" >
		<div class="submit"><input type="submit" onclick="login();" value="Login"></div>
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
function login()
{
	var uname = document.getElementById("uname").value;
	var pwd = document.getElementById("pwd").value;
	if(uname==null||""==uname)
	{
		alert("用户名不能为空!");
		return false;
	}
	if(pwd==null||""==pwd)
	{
		alert("密码不能为空!");
		return false;
	}
	
	var url = document.forms[0].basepath.value+"/servlet/LoginServlet";
	document.forms[0].action = url;
	document.forms[0].submit();
}
</script>
</html>
