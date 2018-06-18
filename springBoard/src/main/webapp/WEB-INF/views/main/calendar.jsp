<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link href='${pageContext.request.contextPath}/js/calendar/fullcalendar.min.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath}/js/calendar/lib/moment.min.js'></script>
<script src='${pageContext.request.contextPath}/js/calendar/lib/jquery.min.js'></script>
<script src='${pageContext.request.contextPath}/js/calendar/fullcalendar.min.js'></script>
<script>
var dataset = [

               <c:forEach var="list" items="${calList}" varStatus="status">
                       {"id":'<c:out value="${list.cal_id}" />'
                       ,"title":'<c:out value="${list.cal_title}" />'
                       ,
                       "start":'<c:out value="${list.cal_start_time}"/>'
                       <c:if test="${list.cal_end_time != ''}">
                           ,"end":'<c:out value="${list.cal_end_time}"/>'
                       } <c:if test="${!status.last}">,</c:if>
                   </c:if>
               </c:forEach>
           ];

	$(document).ready(function() {
		
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,basicWeek,basicDay'
			},
			defaultDate: new Date,
			navLinks: true, // can click day/week names to navigate views
			editable: true,
			eventLimit: true, // allow "more" link when too many events
			events: dataset
		});
	
	});

</script>
<style>

	body {
		margin: 40px 10px;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		max-width: 900px;
		margin: 0 auto;
	}

</style>
</head>
<body>



	<div id='calendar'></div>
	<form action="${pageContext.request.contextPath }/main/setCalendar">
		<div id='choice'>
		<select name='time'>
			<option value="7">7일 이용권</option>
			<option value="15">15일 이용권</option>
			<option value="30">30일 이용권</option>
		</select>
	</div>
	<input type="submit" value="등록">
	</form>
</body>
</html>
