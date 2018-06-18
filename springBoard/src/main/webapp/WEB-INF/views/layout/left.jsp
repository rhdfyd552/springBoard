<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/include/jquery.jsp" %>
<form action="${pageContext.request.contextPath}/notice/boardList" name="frm">
<div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
          	<li><a href="${pageContext.request.contextPath }/notice/noticeList?page=1&pageSize=10">게시판 관리</a></li>
          	<c:forEach items="${noticeList }" var="notice">
           		<li><a href="${pageContext.request.contextPath }/board/boardList?no_seq=${notice.no_seq}&page=1&pageSize=10">${notice.no_name }</a></li>
           </c:forEach>
          </ul>
          
        </div>
 </form>