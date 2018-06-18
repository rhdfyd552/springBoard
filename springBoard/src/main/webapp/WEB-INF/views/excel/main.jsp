<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/jquery.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	$(function(){
		$("#down").click(function(){
			$("#frm").attr("action","${pageContext.request.contextPath }/excel/test");
		})
		
		$("#insert").click(function(){
			$("#frm").attr("action","${pageContext.request.contextPath }/excel/insert");
		})
	})

</script>
</head>
<body>
<form id="frm" action="${pageContext.request.contextPath }/excel/test" method="post" enctype="multipart/form-data">	
		<input type="submit" id="down" value="엑셀다운"><br>
		<input type="file" name="file"><br>
		<input type="submit" id="insert" value="엑셀파일 등록">
	</form>
</body>
</html>