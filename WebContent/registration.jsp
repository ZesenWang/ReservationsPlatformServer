<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript">
function checkForm(){
    alert("提交成功！");  
    return true;
   }
</script>
<style type="text/css">
*{
	margin:0px;
	padding:0px;
	}
table{
	width:700px;
	height:200px;
	background:#ECE9D8;
	}
table tr td{
	font-size:12px;
	color:#00C;
	}
table tr td input{
	width:140px;
	}
</style>
</head>
<body>
<form action="SignUpServlet" method=="post" onsubmit="return beforeSubmit(this)">
<table>
<tr align="center">
<td width="52">就诊卡号:</td>
<td width="160"><input type="text" name="sInsuranceId" value=""/></td>
<td width="45">单位住址</td>
<td width="138"><input type="text" name="address" value="" /></td>
<td width="138">费用类型:</td>
<td width="139"><input type="text" name="meony" value="自费" /></td>
</tr>
<tr align="center">
<td>身份证:</td>
<td><input type="text" name="sId" value=""/></td>
<td>病人姓名</td>
<td><input type="text" name="sName" /></td>
<td>年龄:</td>
<td><input type="text" name="age" value="" /></td>
</tr>
<tr align="center">
<td height="42">性别:</td>
<td>
<input type="radio" name="genderCode" value="man"/>男
<input type="radio" name="genderCode" value="woman"/>女
</td>
<td>医保类型：</td>
<td>
<select id="insuranceCode" name="insuranceCode">
	<option value="0">省医保</option>
	<option value="1">市医保</option>
	<option value="2">市民卡</option>
	<option value="3">农保</option>
</select>
</td>
</tr>
<tr align="center" id = "text-style">
	<td height="44"></td><td></td><td></td><td></td>
      <td colspan = 1><input type = "submit" value = "注册" id = "submit"></td>
      <td colspan = 1><input type="reset" value="重置"/></td>
</tr>
</table>
</form>

</body>
</html>