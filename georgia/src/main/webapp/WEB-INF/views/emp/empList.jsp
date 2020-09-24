<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<head>
<meta charset="UTF-8">
<title>사원 관리</title>
</head>
<body>
	<button>사원 추가</button>
	<table>
		<thead>
			<tr>
				<th>사원번호</th>
				<th>사원명</th>
				<th>부서</th>
				<th>직책</th>
				<th>입사일자</th>

				<th>실적</th>
				<th>급여</th>
				<th>재직여부</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList}" var="empList">
				<tr>
					<td>${empList.emp_id}</td>
					<td>${empList.emp_name}</td>
					<td>${empList.emp_department}</td>
					<td>${empList.emp_position}</td>
					<td>${empList.emp_hiredate}</td>

					<td>${empList.emp_profit}</td>
					<td>${empList.emp_salary}</td>
					<td>${empList.emp_state}</td>
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
		<li class="active"><span><%=i%></span></li>
		<%
			} else {
		%>
		<li><a href="empList?page=<%=i%>"> <span><%=i%></span>
		</a></li>
		<%
			}
			}
		%>
	</ul>
</body>
</html>