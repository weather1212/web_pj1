<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 상세조회</title>
<%@ include file="../include/include.jsp"%>
<link rel="stylesheet" href="${path }/resources/css/stcss.css" />
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap"
      rel="stylesheet" />
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnList").click(function() {
			location.href = "${path}/empList"
		});

		$("#btnDelete").click(function() {
			if (confirm("삭제하시겠습니까?")) {
				document.detailForm.action = "${path}/empDeleteAction";
				document.detailForm.submit();
			}
		});

		$("#btnUpdate").click(function() {
			if (confirm("수정하시겠습니까?")) {
				var empDepartment = $("#emp_department").val();
				var empPosition = $("#emp_position").val();
				var empProfit = $("#emp_profit").val();
				var empSalary = $("#emp_salary").val();

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
				document.detailForm.action = "${path}/empUpdateAction";
				document.detailForm.submit();

			}
		});

	});
</script>
</head>
<body>
	<nav id="navbar">
      <div class="navbar__name">오뉴이노베이션</div>
        <ul class="navbar__menu">
          <li class="navbar__menu__item">인사시스템</li>
          <li class="navbar__menu__item">업무시스템</li>
        </ul>
    </nav>
    
	<div id="root">
		<header>
			<h1>사원 정보 상세 관리</h1>
		</header>
		<hr />

		<section id="container">
			<form role="form" id="detailForm" class="emp__detail__form" name="detailForm" method="post">
				<table class="emp__detail__table" >
					<tbody>
						<tr>
							<td><label for="emp_id" >사원 번호</label> <input type="text" id="emp_id" class="e__d__t__type"
									name="emp_id" value="${empVO.emp_id}" readonly="readonly" /></td>
						</tr>
						<tr>
							<td><label for="emp_name">사원 이름</label> <input type="text" id="emp_name" class="e__d__t__type"
									name="emp_name" value="${empVO.emp_name}" readonly="readonly"/></td>
						</tr>
						<tr>
							<td><label for="emp_department">사원 부서</label> <input type="text" class="e__d__t__type"
									id="emp_department" name="emp_department" value="${empVO.emp_department}" /></td>
						</tr>
						<tr>
							<td><label for="emp_position">사원 직책</label> <input type="text" class="e__d__t__type"
									id="emp_position" name="emp_position" value="${empVO.emp_position}" /></td>
						</tr>
						<tr>
							<td><label for="emp_hiredate">입사일자</label> ${empVO.emp_hiredate} <%-- <fmt:formatDate value="${empVO.emp_hiredate}"
									pattern="yyyy-MM-dd" /></td> --%>
						</tr>
						<tr>
							<td><label for="emp_profit">업무 실적</label> <input type="text" class="e__d__t__type"
									id="emp_profit" name="emp_profit" value="${empVO.emp_profit}" /></td>
						</tr>
						<tr>
							<td><label for="emp_salary">사원 급여</label> <input type="text" class="e__d__t__type"
									id="emp_salary" name="emp_salary" value="${empVO.emp_salary}" /></td>
						</tr>
						<tr>
							<td><label for="emp_state">재직 여부</label> <input type="text" class="e__d__t__type"
									id="emp_state" name="emp_state" value="${empVO.emp_state}" readonly="readonly"/></td>
						</tr>
						
					</tbody>
				</table>
				<input type="button" id="btnUpdate" class="emp__detail__button" value="수정" />
				<input type="button" id="btnDelete" class="emp__detail__button" value="삭제" />
				<input type="button" id="btnList" class="emp__detail__button" value="목록" />
			</form>
		</section>
		<hr />
	</div>

</body>
</html>