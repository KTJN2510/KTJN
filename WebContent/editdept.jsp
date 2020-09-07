<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div style="margin:50px auto; width:300px">
<form action="updatedept" method="post">
userName:<input type="text" name="user" value="${dept.name }">
<input type="hidden" name = "id" value="${dept.id}">
<input type="submit" value="提交">
</form>
</div>
</body>
</html>