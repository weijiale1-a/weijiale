<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "C"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加新用户界面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/empC" method="post">
		<h2>添加新员工</h2>
		部门：
			<select style="width: 140px" name="did">
				<C:forEach items="${depAll }" var="d">
					<option value="${d.did }">${d.dname }</option>
				</C:forEach>
			</select><br /><br />
		姓名：<input type="text" name="ename" /><br /><br />
		性别：
			<input type="radio" name="esex" value="男" checked="checked" />男
			<input type="radio" name="esex" value="女"/>女<br /><br />
		年龄：<input type="text" name="eage" /><br /><br />
		时间：<input type="date" name="edate" /><br /><br />
		<input type="submit" value="添加" />
	</form>
</body>
</html>