<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "C"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix= "fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工修改信息界面re</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/empC" method="post">
		<input type="hidden" name="_method" value="PUT" />
		<h2>修改员工信息</h2>
		<input type="hidden" name="eid" value="${empOne.eid }" />
		部门：
			<select style="width: 140px" name="did">
				<C:forEach items="${depAll }" var="d">
					<option value="${d.did }" ${empOne.did == d.did?'selected':'' } >${d.dname }</option>
				</C:forEach>
			</select><br /><br />
		姓名：<input type="text" name="ename" value="${empOne.ename }"/><br /><br />
		性别：
			<input type="radio" name="esex" value="男" ${empOne.esex == "男"?'checked':''}>男
		    <input type="radio" name="esex" value="女" ${empOne.esex == "女"?'checked':''}>女<br /><br />
		    
		年龄：<input type="text" name="eage" value="${empOne.eage }" /><br /><br />
		
		<fmt:formatDate value="${empOne.edate }" pattern="yyyy-MM-dd" var="edt"/>
		时间：<input type="date" name="edate" value="${edt }" /><br /><br />
		
		<input type="submit" value="添加" />
	</form>
</body>
</html>