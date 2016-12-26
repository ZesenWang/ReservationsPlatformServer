<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- 设置页面不能缓存保护信息 -->
	<% 
		response.setHeader("Cache-Control","no-store"); 
		response.setDateHeader("Expires",0); 
		response.setHeader("Pragma","No-cache");
        
	%> 	
<title>职工登陆</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" href="css/bootstrap.min.css">  
	<link rel="stylesheet" href="css/mycss.css"> 
	<script src="jq/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/myjs.js"></script>
</head>
<style>
.body{
	background-image:url(bambooTexture.jpeg);
}
.table{
	border-width:medium;
	border-color:#fff;
}
div{
	
}
</style>
<% 
	String mess = (String)session.getAttribute("mess");
	if(mess == null)
		mess = "";
%>
<body id="index" class="body">
<h1 align="center">欢迎使用</h1>
<h3 align="center">浙江名中医馆挂号平台（内部使用）</h3>
<form name="form1" method="post" action="LoginServlet">
 <div id ="outdiv">
 <div id = "mydiv">
 <%=mess %>
<table  class = "table table-bordered" class="table">
    <tr id = "text-style">
      <td >用户名：</td>
      <td ><input type = "text" name = "userName" id = "userName" ></td>
    </tr>
    
    <tr id = "text-style">
      <td >密码：</td>
      <td ><input type = "password" name = "password" id = "password" ></td>
    </tr>
    
    <tr id = "text-style">
      <td colspan = 1 ><input type = "submit" value = "登陆" id = "submit"></td>
      <td colspan = 1 ><input type="reset" value="重置"/></td>
    </tr>
</table>
</div>
</div>
</form>
</body>
</html>