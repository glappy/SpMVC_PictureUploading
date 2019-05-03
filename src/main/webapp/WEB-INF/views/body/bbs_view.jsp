<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<style>
.view-box {
	width:70%;
	border:1px solid blue;
	padding:.5rem;
	margin: 10px;
}

b {
	color:blue;
}

</style>

<article class="view-box">
	<p><b>작성자 ID: </b> ${bbsVO.b_userid}
	<p><b>작성일자: </b> ${bbsVO.b_date }
	<p><b>작성시각: </b> ${bbsVO.b_time}
	<p><b>제목: </b> ${bbsVO.b_subject}
	<p><b>내용: </b> ${bbsVO.b_content}
	<p><b>파일: </b> <img src="${rootPath}/files/${bbsVO.b_image}" />
	
	<p><button id="btn-update">편집</button>
	<button id="btn-delete">삭제</button>
</article>
<script>
$(function(){
	$("#btn-update").click(function(){
			location.replace("<c:url value='/bbs/update' />"
								+"?id=" + ${bbsVO.id}) 
	})

	$("#btn-delete").click(function(){
		if(confirm("정말 삭제할까요")) {
			location.replace("<c:url value='/bbs/delete' />" 
							+ "?id=" + ${bbsVO.id})
		}		
	})
})
</script>