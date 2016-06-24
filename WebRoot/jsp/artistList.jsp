<%@ page isELIgnored="false" contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="com.musicnet.bean.ArtistInfo,java.util.*"%>
<%@ page import="com.musicnet.pager.PageBean"%>
<%
	PageBean<ArtistInfo> pbBean = (PageBean<ArtistInfo>)request.getAttribute("pbBean");
	List<ArtistInfo> artistInfos = pbBean.getBeanList();
%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="js/jquery.min.js" ></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        .toast-center-center {
            top: 50%;
            left: 50%;
            margin-top: -25px;
            margin-left: -150px;
        }
        .imgSize {
            width: 90px;
            height: 90px;
        }
        .aStyle{
            color: #000000;
        }
    </style>
</head>
<body onload="">
<div class="container" style>
	<%
		int size = artistInfos.size();
		if(artistInfos!=null&&size>0)
		{
		%>
    <div class="row" style="margin-top: 20px;">
    <%
			for(int i=0;i<size;i++)
			{
				ArtistInfo info = artistInfos.get(i);
				if(i!=0&&i%4==0)
				{
				%>
				</div>
				<div class="row" style="margin-top: 20px;">
				<%
				}
	 %>
        <div class="col-lg-3">
           <img src="<%=request.getContextPath()%>/servlet/ImageServlet?ArtistId=<%=info.getArtistId()%>" class="imgSize">
            <p><a class="aStyle" href="#"><%=info.getArtistname()%></a></p>
        </div>
    <%
    		}
    		%>
    		</div>
    		<%
    	}
     %>
</div>

</body>
</html>