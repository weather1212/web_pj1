<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 상세조회</title>
<%@ include file="../include/include.jsp"%>
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
			<form role="form" id="detailForm" class="pro__info__form" name="detailForm"
				method="post">
				<table class="pro__info__table">
					<tbody>
						<tr>
							<td><label for="project_id" class="p__i__t__label">프로젝트 번호</label> <input
									type="text" id="project_id" class="p__i__t__type" name="p_id"
									value="${projectVO.p_id}" readonly="readonly" /></td>
						</tr>
						<tr>
							<td><label for="project_name" class="p__i__t__label">프로젝트명</label> <input
									type="text" id="project_name" class="p__i__t__type" name="p_name"
									value="${projectVO.p_name}" /></td>
						</tr>
						<tr>
							<td><label for="project_content" class="p__i__t__label">프로젝트 내용</label> <textarea
									rows="10" cols="50" id="project_content" class="p__i__t__content"
									name="p_content">${projectVO.p_content}</textarea></td>
						</tr>
						<tr>
							<td><label for="project_start" class="p__i__t__label">시작 날짜</label> <input
									type="date" name="p_start" id="projectStart" min="2010-07-01" max="2025-06-30"
									class="p__i__t__date" value="${projectVO.p_start}">
						</tr>
						<tr>
							<td><label for="project_end" class="p__i__t__label">종료 날짜</label> <input
									type="date" name="p_end" id="projectEnd" min="2010-07-01" max="2025-06-30"
									class="p__i__t__date" value="${projectVO.p_end}">
						</tr>
						<tr>
							<td><label for="project_state" class="p__i__t__label">프로젝트 상태</label>
							<%--  <input
									type="text" class="p__i__t__type" id="project_state" name="p_state"
									value="${projectVO.p_state}" /> --%>
								<select name="p_state" id="project_state" class="s__pro">
									<c:if test="${projectVO.p_state == '시작 전'}">
										<option value="시작 전" selected>시작 전</option>
										<option value="진행 중">진행 중</option>
										<option value="종료">종료</option>
										<option value="취소">취소</option>
									</c:if>
									<c:if test="${projectVO.p_state == '진행 중'}">
										<option value="시작 전">시작 전</option>
										<option value="진행 중" selected>진행 중</option>
										<option value="종료">종료</option>
										<option value="취소">취소</option>
									</c:if>
									<c:if test="${projectVO.p_state == '종료'}">
										<option value="시작 전">시작 전</option>
										<option value="진행 중">진행 중</option>
										<option value="종료" selected>종료</option>
										<option value="취소">취소</option>
									</c:if>
									<c:if test="${projectVO.p_state == '취소'}">
										<option value="시작 전">시작 전</option>
										<option value="진행 중">진행 중</option>
										<option value="종료">종료</option>
										<option value="취소" selected>취소</option>
									</c:if>
							</select></td>
						</tr>

					</tbody>
				</table>
				<input type="button" id="btnUpdate" class="pro__info__button" value="수정" />
				<input type="button" id="btnDelete" class="pro__info__button" value="삭제" />
				<input type="button" id="btnList" class="pro__info__button" value="목록" />
			</form>
		</section>
		<hr />
	</div>

</body>
</html>