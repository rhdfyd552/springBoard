<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<title>Insert title here</title>

<link rel="shortcut icon" href="favicon.ico" />

<!-- jQuery -->
<!-- <script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery-ui.min.js"></script>-->
<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link href="${pageContext.request.contextPath }/dashboard.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script src="${pageContext.request.contextPath}/js/jQuery.MultiFile.min.js"></script>

<script src="${pageContext.request.contextPath}/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">


</script>
<style>
	form{
		margin-top: 50px;
		margin-left: 30%;
	}
	#title {
		width: 650px;
	}
</style>
</head>
<body>
<h1>formBoard</h1>
    <div class="container-fluid">
      <div class="row">
			<div class="container-fluid">
		<div class="row">

		<form action="${pageContext.request.contextPath }/notice/insertNotice" id="frm" enctype="multipart/form-data">
 			<input type="hidden" name="no_mem_id" value="${loginUser }">
			<div class="form-group">
				<label class="col-sm-1 control-label">게시판 이름</label>
				<input type="text" id="no_name" name="no_name">
			</div>
			<input type="submit" id="savebutton" value="게시판 등록" />
		</form>
		</div>
	</div>
</div>
</div>
</body>
</html>