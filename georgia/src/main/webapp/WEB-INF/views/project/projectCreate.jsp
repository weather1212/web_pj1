<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 추가</title>
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

		$("#btnCreate").click(function() {
			if (confirm("등록하시겠습니까?")) {
				var projectId = $("#project_id").val();
				var projectName = $("#project_name").val();
				var projectContent = $("#project_content").val();
				var projectStart = $("#project_start").val();
				var projectEnd = $("#project_end").val();
				var projectState = $("#project_state").val();

				if (projectId == "") {
					alert("해당 프로젝트의 번호를 입력하세요.");
					$("#project_id").focus();
					return;
				}
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
									id="project_id" class="e__d__t__type" name="p_id" /></td>
						</tr>
						<tr>
							<td><label for="project_name">프로젝트명</label> <input type="text"
									id="project_name" class="e__d__t__type" name="p_name" /></td>
						</tr>
						<tr>
							<td><label for="project_content">프로젝트 내용</label> <textarea rows="10" cols="50"
									id="project_content" name="p_content"></textarea></td>
						</tr>
						<tr>
							<td><label for="project_start">시작 날짜</label> <input type="date" name="pStart" id="projectStart" min="2010-07-01"
							max="2025-06-30" class="s__pro" >
						</tr>
						<tr>
							<td><label for="project_end">종료 날짜</label> <input type="date" name="pEnd" id="projectEnd" min="2010-07-01"
							max="2025-06-30" class="s__pro" >
						</tr>
						<tr>
							<td><label for="project_state">프로젝트 상태</label> <input type="text"
									class="e__d__t__type" id="project_state" name="p_state" /></td>
						</tr>
					</tbody>
				</table>
				<input type="button" id="btnCreate" class="project__detail__button" value="등록완료" />
				<input type="button" id="btnList" class="project__detail__button" value="목록" />
			</form>
		</section>
		<hr />
	</div>

</body>
</html>