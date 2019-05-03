<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

* {
	box-sizing: border-box;
}
body {
	margin:0px;
	padding:0px;
	font-weight:bold;
}

header {
	position: fixed;
	top:0;
	width:70%;
	padding:20px;
	margin: 0px auto;
	background-color: #f5b335;	
}
nav {
	display: flex;
	align-items: flex-end;
	justify-content: space-between;
	transition:align-items 0.2s;
	font-size:15pt;
	font-weight:bold;
}
.logo {
	font-size:2rem; 
	display: inline-block;
	color:#fff;
	transition: all 0.2s;
	position:absolute;
	left:40px;
	bottom:0px;
}

ul {
	display: flex;
	margin:50px 50px 0 0;
	padding:0;
	list-style-type : none;
}

li a {
	display: block;
	padding: 10px 20px;
	text-decoration: none;
	color:black;
}

li a:hover {
	background-color: #ddd;
}

.main {
	display: block;
	padding:0 20px;
	width:70%;
	font-size:15pt;
}


.scroll {
	box-shadow : 0 7px 0 0 rgba(0,0,0,0.1);
}

.scroll .logo {
	font-size:1.5rem;
}


.scroll nav {
	align-items: center;
}

.scroll .logo,
.scroll ul {
	margin:0px;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
$(function(){
	
	var hHeight = $("header").outerHeight()
	$(".main").css("padding-top",hHeight)
	
	$(window).scroll(function(e){
		if( $(window).scrollTop() > 150) {
			$("header").addClass("scroll")
		} else {
			$("header").removeClass("scroll")
		}
	})
	

})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/main_menu.jspf" %>
<section class="main">
	<article id="body">
		<c:if test="${BODY == 'BBS_LIST' }">
			<%@ include file="/WEB-INF/views/body/bbs_list.jsp" %>
		</c:if>
		<c:if test="${BODY == 'BBS_WRITE' }">
			<%@ include file="/WEB-INF/views/body/bbs_form.jsp" %>
		</c:if>
		<c:if test="${BODY == 'BBS_VIEW' }">
			<%@ include file="/WEB-INF/views/body/bbs_view.jsp" %>
		</c:if>


	</article>
</section>
</body>
</html>