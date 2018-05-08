<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" 
           uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>listStudent</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="./js/jquery-3.1.1.min.js"></script>
	</head>
	<body>
		<div id="wrap" style="z-index:1; position:absolute">
				<div id="content" align="center" style="margin-left:200px;">
					<p id="whereami">
					</p>
					<h1>
						学生管理系统
					</h1>
					<input type="button" value="添加学生"style="margin-left:930px" onclick="showPopup(0)">
					<br>
					<table id="studentTable" class="table" border="1" style="text-align: center" width="1000px">
						<tr class="table_header" >
							<td >
								学生编号
							</td>
							<td>
								Id
							</td>
							<td>
								姓名
							</td>
							<td>
								生日
							</td>
							<td>
								介绍
							</td>
							<td>
							平均分
							</td>
							<td>
							操作							
							</td>
						</tr>
						<c:forEach var="stu" items="${list}" varStatus="abc">
						<tr id="select">
						<td>${abc.count}</td>
						<td>${stu.id}</td>
						<td>${stu.name}</td>
						<td>${stu.birthday}</td>
						<td>${stu.description}</td>
						<td>${stu.avgscore}</td>
						<td><input type="button" value="修改" name="update"  onclick="method('${stu.id}')">
						<input type="button"value="删除" name="delete" onclick="Deleteq('${stu.id}')">
						</td>
						</tr>
						</c:forEach>
				<tr>
                    <td colspan="5">
                       <%--  <c:if test="${!(page==1)}">
                            <a href="ShowServlet?page=${page-1 }">上一页</a>
                        </c:if>

                        <c:forEach var="p" begin="1" end="${pages}">
                            <a href="ShowServlet?page=${p}">第${p}页</a>
                        </c:forEach>

                        <c:if test="${!(page==pages)}">
                            <a href="ShowServlet?page=${page+1 }">下一页</a>
                        </c:if>
 --%>					<a href="${pageContext.request.contextPath}/ShowServlet?p=1">首页</a>
 					<c:forEach begin="1" end="${count}" var="c">
 						<a href="${pageContext.request.contextPath}/ShowServlet?p=${c}">${c}</a>
 					</c:forEach>
 					    <a href="${pageContext.request.contextPath}/ShowServlet?p=${count}">尾页</a>
                    </td>
                </tr>
					</table>
					<br>
					

				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				</div>
			</div>
			<!-- 分页数据 -->
			<div>
			
			
			
			</div>
		<!-- 添加弹出窗口 -->
		<!-- 弹出窗口 -->
	<div id="popup_content" style="z-index: 9527;
		padding: 20px;
		background: #fff;
		position: absolute;
		display: none;
		border-radius: 3px;">
	<!-- 标题 -->
	<h3 style="margin-left:200px">添加学生</h3>
	<!-- 表单 -->
	<div class="rs_content" style="margin-left:200px">
	<form id="address-form" method="post" action="">
		<!--学生数据-->
		<p style="height:10px">Id</p><input type="text" name="id" id="id" >
		<p style="height:10px">姓名:</p>	<input type="text" name="name" id="name"/>
		<p style="height:10px">生日:</p><input type="text" name="birthday" id="birthday"/>
		<p style="height:10px">备注:</p><input type="text" name="description" id="description"/>
		<p style="height:10px">平均分:</p><input type="text" name="avgscore" id="avgscore"/><br><br>
		<input type="button" value="确定"  onclick="Update()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="取消" onclick="dismissPopup()">
		</form>
		</div>
		</div>
		<div id="mask" style="z-index: 9000;
		background: #000;
		position: absolute;
		display: none;
		left: 0;
		top: 0;
		opacity: 0.3;
		-moz-opacity: 0.3;"></div>
	</body>
		<script type="text/javascript">
	// ===== 弹出窗口 =====
	// 显示弹出窗口
	function showPopup(id) {
		var title = 
			id == 0 ? "添加学生数据" : "修改学生数据";
		$("#popup_content h3").html(title);
		// 设置弹出区域的尺寸
		var popupWidth = 600;
		var popupHeight = 400;
		// 获取窗口尺寸
		var windowWidth = $(window).width();
		var windowHeight = $(window).height();
		// 弹出mask
		$("#mask").css({
			"width": windowWidth,
			"height": $(document).height(),
		});
		$("#mask").show();
		// 弹出popup
		$("#popup_content").css({
			"width": popupWidth,
			"height": popupHeight,
			"left":500,
			"top": 120,
		});
		$("#popup_content").show();
	}
		// 隐藏弹出窗口
		function dismissPopup() {
			// 隐藏mask
			$("#mask").hide();
			// 隐藏popup
			$("#popup_content").hide();
		}
		function Update(){
		$.post("${pageContext.request.contextPath}/AddStudent",
				$("#address-form").serialize() ,
				  function(data){
				   alert("添加数据成功！")
				   location.href = "${pageContext.request.contextPath}/ShowServlet";
				  });
	}
		function Deleteq(id){
			if(confirm("确定删除吗")){
				location.href="${pageContext.request.contextPath}/DeleteServlet?id="+id;
			}
		}
		function method(id){
			location.href="${pageContext.request.contextPath}/SelectServlet?id="+id;
		}			
		
	</script>
</html>
