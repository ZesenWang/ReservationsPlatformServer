<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="jq/main2.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){    
    $("li").mouseover(function(){	
        $(this).stop().animate({	
    	width: "152px",	}, 500 );
    }); 
    $("li").mouseout(function(){
        $(this).stop().animate({	
   		width: "52px",}, 500 );
    }); 
});
</script>
<style type="text/css">
#menudiv {
	width:100px;
	float:left;
	overflow:hidden;
}
ul{
    margin:0;
    padding:0;
}
li {
	width:52px;
	float:right;
	margin-top:20px;
	height:52px;
	background-color:#d4e8e7;
	position:relative;
	list-style:none;
	color:#ef7a1a;
	font-size:18px;
}
</style>
</head>
<body>
<div id="menudiv">
<ul>
	<li><a href="registration.jsp"><img src="img/Home.png" alt="" width="50" height="50" border="0"/></a>
 
挂号</li>
	<li><a href="register.jsp"><img src="img/portfolio.png" alt="" width="50" height="50" border="0"/></a>
 
注册</li>
	<li><a href="#"><img src="img/about.png" alt="" width="50" height="50" border="0"/></a>
 
退出</li>
	<li><a href="#"><img src="img/contact.png" alt="" width="50" height="50" border="0"/></a>
 
</li>
</ul>
</div>

</body>
</html>