<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 추가</title>
<%@ include file="../include/include.jsp"%>
<link rel="stylesheet" href="${path }/resources/css/stcss.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap"
	rel="stylesheet" />
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnList").click(function() {
			location.href = "${path}/empList"
		});

		$("#btnCreate").click(function() {
			if (confirm("등록하시겠습니까?")) {
				var empId = $("#emp_id").val();
				var empName = $("#emp_name").val();
				var empDepartment = $("#emp_department").val();
				var empPosition = $("#emp_position").val();
				var empHiredate = $("#emp_hiredate").val();
				var empProfit = $("#emp_profit").val();
				var empSalary = $("#emp_salary").val();

				if (empId == "") {
					alert("해당 사원의 사번을 입력하세요.");
					$("#emp_id").focus();
					return;
				}
				if (empName == "") {
					alert("해당 사원의 이름을 입력하세요.");
					$("#emp_name").focus();
					return;
				}
				if (empDepartment == "") {
					alert("해당 사원의 부서를 입력하세요.");
					$("#emp_department").focus();
					return;
				}
				if (empPosition == "") {
					alert("해당 사원의 직책을 입력하세요.");
					$("#emp_position").focus();
					return;
				}
				if (empHiredate == "") {
					alert("해당 사원의 입사일을 입력하세요.");
					$("#emp_hiredate").focus();
					return;
				}
				if (empProfit == "") {
					alert("해당 사원의 실적을 입력하세요.");
					$("#emp_profit").focus();
					return;
				}
				if (empSalary == "") {
					alert("해당 사원의 급여를 입력하세요.");
					$("#emp_salary").focus();
					return;
				}
				document.detailForm.action = "${path}/empCreate";
				document.detailForm.submit();

			}
		});

	});
</script>
</head>
<body>
	<header>
		<%@ include file="../include/header.jsp"%>
	</header>
	<div id="root">
		<header>
			<h1>사원 등록</h1>
		</header>
		<hr />

		<section id="container">
			<form role="form" id="detailForm" class="emp__info__form" name="detailForm" method="post">
				<table class="emp__info__table">
					<tbody>
						<tr>
							<td><label for="emp_id">사원 번호</label> <input type="text" id="emp_id" class="e__i__t__type"
									name="emp_id" /></td>
						</tr>
						<tr>
							<td><label for="emp_name">사원 이름</label> <input type="text" id="emp_name" class="e__i__t__type"
									name="emp_name" /></td>
						</tr>
						<tr>
							<td><label for="emp_department">사원 부서</label> <input type="text" class="e__i__t__type"
									id="emp_department" name="emp_department" /></td>
						</tr>
						<tr>
							<td><label for="emp_position">사원 직책</label> <input type="text" class="e__i__t__type"
									id="emp_position" name="emp_position" /></td>
						</tr>
						<tr>
							<td><label for="emp_hiredate">입사일자</label> <input type="date" min="2010-07-01" 
									max="2025-06-30" name="emp_hiredate"> <%-- <fmt:formatDate value="${empVO.emp_hiredate}" pattern="yyyy-MM-dd" /></td> --%>
						</tr>
						<tr>
							<td><label for="emp_profit">업무 실적</label> <input type="text" id="emp_profit" class="e__i__t__type"
									name="emp_profit" /></td>
						</tr>
						<tr>
							<td><label for="emp_salary">사원 급여</label> <input type="text" id="emp_salary" class="e__i__t__type"
									name="emp_salary" /></td>
						</tr>

					</tbody>
				</table>
				<input type="button" id="btnCreate" class="emp__info__button" value="등록완료" />
				<input type="button" id="btnList" class="emp__info__button" value="목록" />
			</form>
		</section>
		<hr />
	</div>

</body>
</html>