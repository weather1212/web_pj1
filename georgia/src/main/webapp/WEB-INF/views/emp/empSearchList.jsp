<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 관리</title>
<%@ include file="../include/include.jsp"%>
</head>
<body>
	<header>
		<%@ include file="../include/header.jsp"%>
	</header>
	<a href="empCreatePage"><button class="emp__add">사원 추가</button></a>
	<form action="empSearch">
		<table id="emp__search__table">
			<thead>
				<tr>
					<td>사원 번호</td>
					<td>사원명</td>
					<td>부서</td>
					<td>직책</td>
					<td>입사일자</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="empId" id="empId" value="${searchEmpId }"
							class="s__emp"></td>
					<td><input type="text" name="empName" id="empName" value="${searchEmpName }"
							class="s__emp"></td>
					<td><input type="text" name="empDepartment" id="empDepartment"
							value="${searchEmpDepartment }" class="s__emp"></td>
					<td><input type="text" name="empPosition" id="empPosition"
							value="${searchEmpPosition }" class="s__emp"></td>
					<td><input type="date" name="empHiredate" id="empHiredate" min="2010-07-01"
							max="2025-06-30" value="${searchEmpHiredate }" class="s__emp"></td>
					<td><input type="submit" class="search__btn" value="검색"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<table id="emp__table">
		<thead>
			<tr>
				<th>사원번호</th>
				<th>사원명</th>
				<th>부서</th>
				<th>직책</th>
				<th>입사일자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList}" var="empList">
				<tr>
					<td>${empList.emp_id}</td>
					<td><a href="empDetail?empId=${empList.emp_id}">${empList.emp_name}</a></td>
					<td>${empList.emp_department}</td>
					<td>${empList.emp_position}</td>
					<td>${empList.emp_hiredate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul class="content__count">
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
		<li><a
			href="empSearch?page=<%=i%>&empId=${searchEmpId }&empName=${searchEmpName }&empDepartment=${searchEmpDepartment }&empPosition=${searchEmpPosition }&empHiredate=${searchEmpHiredate }">
				<span><%=i%></span>
		</a></li>
		<%
			}
			}
		%>
	</ul>
</body>

</html>