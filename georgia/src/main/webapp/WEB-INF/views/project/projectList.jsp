<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<head>
<meta charset="UTF-8">
<title>프로젝트 관리</title>
</head>
<body>
<button>프로젝트 추가</button>
<table>
	<thead>
		<tr>
			<th>프로젝트번호</th>
			<th>프로젝트명</th>
			<th>시작날짜</th>
			<th>종료날짜</th>
			<th>상태</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${projectList}" var="projectList">
			<tr>
				<td>${projectList.p_id}</td>
				<td>${projectList.p_name}</td>
				<td>${projectList.p_start}</td>
				<td>${projectList.p_end}</td>
				<td>${projectList.p_state}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<ul>
<%
int cnt = Integer.parseInt(String.valueOf(request.getAttribute("pageCnt")));
int cur = Integer.parseInt(String.valueOf(request.getAttribute("page")));
%>
<%
for (int i = 1; i <= cnt; i++) {
	if (i == cur) {
	%>
	<li class="active">
	<span><%=i%></span>
	</li>
	<%
	} else {
	%>
	<li><a href="projectList?page=<%=i%>">
	<span><%=i%></span>
	</a></li>
	<%
	}
	}
	%>
</ul>
</body>
</html>