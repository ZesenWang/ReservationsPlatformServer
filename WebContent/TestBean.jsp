<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="data" class="com.jason.bean.WaitInformation" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:getProperty name="data" property="peopleCount"/><br>
	<jsp:getProperty property="waitTime" name="data"/><br>
	<jsp:getProperty property="succeed" name="data"/>
</body>
</html>