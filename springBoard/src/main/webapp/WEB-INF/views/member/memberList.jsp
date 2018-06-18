<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
th{
		border:1px solid black;
		padding : 7px;
		text-align:center;
	}
	
	td{
		border:1px solid black;
		padding : 7px;
		text-align:center;
	}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>이름</th>
				<th>id</th>
				<th>별명</th>
				<th>생일</th>
				<th>주소(주소1 + 주소2)</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${memberList}" var="member">
				<tr>
					<td>${member.mem_name}</td>
					<td>${member.mem_id}</td>
					<td>${member.mem_alias}</td>
					<td><fmt:formatDate value="${member.mem_bir}" type="date" pattern="yyyy-MM-dd"/></td>
					<td>${member.mem_add1} ${member.mem_add2}</td>
				</tr>
			</c:forEach>	
		</tbody>
	</table>
</body>
</html>