<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 상세조회</title>
<%@ include file="../include/include.jsp"%>
<link rel="stylesheet" href="${path }/resources/css/stcss.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap"
	rel="stylesheet" />
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnList").click(function() {
			location.href = "${path}/projectList"
		});

		$("#btnDelete").click(function() {
			if (confirm("삭제하시겠습니까?")) {
				document.detailForm.action = "${path}/projectDeleteAction";
				document.detailForm.submit();
			}
		});

		$("#btnUpdate").click(function() {
			if (confirm("수정하시겠습니까?")) {
				var projectName = $("#project_name").val();
				var projectContent = $("#project_content").val();
				var projectStart = $("#project_start").val();
				var projectEnd = $("#project_end").val();
				var projectState = $("#project_state").val();

				if (projectName == "") {
					alert("해당 프로젝트명을 입력하세요.");
					$("#project_name").focus();
					return;
				}
				if (projectContent == "") {
					alert("해당 프로젝트의 내용을 입력하세요.");
					$("#project_content").focus();
					return;
				}
				if (projectStart == "") {
					alert("해당 프로젝트의 시작일을 입력하세요.");
					$("#project_start").focus();
					return;
				}
				// 				if (projectEnd == "") {
				// 					alert("해당 프로젝트의 종료일을 입력하세요.");
				// 					$("#project_end").focus();
				// 					return;
				// 				}
				if (projectState == "") {
					alert("해당 프로젝트의 상태를 입력하세요.");
					$("#project_state").focus();
					return;
				}
				document.detailForm.action = "${path}/projectUpdateAction";
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
			<h1>프로젝트 정보 상세 관리</h1>
		</header>
		<hr />

		<section id="container">
			<form role="form" id="detailForm" class="project__detail__form" name="detailForm"
				method="post">
				<table class="project__detail__table">
					<tbody>
						<tr>
							<td><label for="project_id">프로젝트 번호</label> <input type="text"
									id="project_id" class="e__d__t__type" name="project_id"
									value="${projectVO.p_id}" readonly="readonly" /></td>
						</tr>
						<tr>
							<td><label for="project_name">프로젝트명</label> <input type="text"
									id="project_name" class="e__d__t__type" name="project_name"
									value="${projectVO.p_name}" /></td>
						</tr>
						<tr>
							<td><label for="project_content">프로젝트 내용</label> <textarea rows="30" cols="30"
									id="project_content" name="project_content">${projectVO.p_content}</textarea></td>
						</tr>
						<tr>
							<td><label for="project_state">프로젝트 상태</label> <input type="text"
									class="e__d__t__type" id="project_state" name="project_state"
									value="${projectVO.p_state}" /></td>
						</tr>
						<tr>
							<td><label for="project_start">시작 날짜</label> <input type="date" name="projectStart" id="projectStart" min="2010-07-01"
							max="2025-06-30" class="s__pro" value="${projectVO.p_start}" >
						</tr>
						<tr>
							<td><label for="project_end">종료 날짜</label> <input type="date" name="projectEnd" id="projectEnd" min="2010-07-01"
							max="2025-06-30" class="s__pro" value="${projectVO.p_end}" >
						</tr>
					</tbody>
				</table>
				<input type="button" id="btnUpdate" class="project__detail__button" value="수정" />
				<input type="button" id="btnDelete" class="project__detail__button" value="삭제" />
				<input type="button" id="btnList" class="project__detail__button" value="목록" />
			</form>
		</section>
		<hr />
	</div>

</body>
</html>