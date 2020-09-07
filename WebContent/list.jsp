<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
    <script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
	<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
	<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
$(function(){
    $("a").addClass("btn btn-default btn-xs");
     
});
</script>
<body>
<table style="width:500px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>
	<tr>
		<td>id</td>
        <td>name</td>
        <td>delete</td>
        <td>edit</td>
	</tr>
	<c:forEach items="${depts}" var="dept" >
        <tr>
            <td>${dept.id}</td>
            <td>${dept.name}</td>
            <td><a href="delete?id=${dept.id}">delete</a></td>
            <td><a href="Edit?id=${dept.id}">edit</a></td>
        </tr>
    </c:forEach>
</table>
 <nav>
          <ul class="pager">
    	<li><a href="deptlist?start=0">首页</a></li>
    	<li><a href="deptlist?start=${pre}">上一页</a></li>
    	<li><a href="deptlist?start=${next}">下一页</a></li>
    	<li><a href="deptlist?start=${last}">末页</a></li>
    </nav>
 <div style="margin:50px auto; width:300px">
<form action="adddept" method="post">
userName:<input name="user" type="text">
 <input type="submit" value="提交">
</form>
 </div>   
</body>
</html>