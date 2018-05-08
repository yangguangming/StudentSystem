<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" 
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="./js/jquery-3.1.1.min.js"></script>
<body>
<div style="margin-left:500px">
<h3>修改学生数据</h3>
	<form action="UpdateServlet" method="post" >
		编号：<input type="text" name="id" value="${stu.id}" ><br><br>
		姓名：<input type="text" name="name" value="${stu.name}" ><br><br>
		生日：<input type="text" name="birthday" value="${stu.birthday}" ><br><br>
		备注：<input type="text" name="description" value="${stu.description}" ><br><br>
		分数：<input type="text" name="avgscore" value="${stu.avgscore}" ><br><br>
			<input type="submit" value="修改" style="margin-left:70px" onclick="Alter()">
	</form>
	</div>
</body>
<script type="text/javascript">
function Alter(){
	 location.href = "${pageContext.request.contextPath}/UpdateServlet";
}
</script>
</html>