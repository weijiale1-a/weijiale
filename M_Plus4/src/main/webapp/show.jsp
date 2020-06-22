<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix= "fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工信息显示界面</title>
<script type="text/javascript">
	function deleteOper(obj,id){
		if(confirm("是否确认删除该员工?")){
			document.myform.action="${pageContext.request.contextPath }/empC/"+id;
			document.myform.submit();
		}
	}
</script>
</head>
<body>

	<form name="myform" action="" method="post">
		<input type="hidden" name="_method" value="DELETE" />
	</form>

	<table border="2" style="width: 50%" align="center" cellspacing="0" >
		<tr>
			<th colspan="7">员工信息表 <a href="${pageContext.request.contextPath }/empC"><input type="button" value="添加新用户" /></a></th>
		</tr>
		<tr>
			<th>编号</th>
			<th>部门</th>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>时间</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${empAll.records }" var="e">
			<tr>
				<td>${e.eid }</td>
				<td>
					<c:forEach items="${depAll }" var="d">
						${e.did eq d.did?d.dname:'' }
					</c:forEach>
				</td>
				<td>${e.ename }</td>
				<td>${e.esex }</td>
				<td>${e.eage }</td>
				<td>
					<fmt:formatDate value="${e.edate }" pattern="yyyy-MM-dd" var="edt"/>
					${edt }
				</td>
				<td>
					<span><a href="${pageContext.request.contextPath }/empC/changeBeFore/${e.eid }">修改</a></span>
	   				<span><a style="cursor: pointer;" onclick="deleteOper(this,'${e.eid }')">删除</a></span>
	   			</td>
			</tr>
		</c:forEach>
		
		<td colspan="7" align="center">
			第${empAll.current }/${empAll.pages }页&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath }/empC/select/1" >首页</a>&nbsp;
			<a href="${pageContext.request.contextPath }/empC/select/${empAll.current>1?empAll.current-1:1}" >上一页</a>&nbsp;
			<a href="${pageContext.request.contextPath }/empC/select/${empAll.current<empAll.pages?empAll.current+1:empAll.pages}" >下一页</a>&nbsp;
			<a href="${pageContext.request.contextPath }/empC/select/${empAll.pages }" >尾页</a>
			共有${empAll.total }条数据&nbsp;&nbsp;
		</td>
		
	</table>
</body>
</html>