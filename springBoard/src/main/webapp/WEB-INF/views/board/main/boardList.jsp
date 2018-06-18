<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

    <script>
    	$(function(){
    		
    		
    		$('#boardList tr').click(function(){
    			var board_seq = $(this).find("td:eq(1)").text();
    			var category_seq = $(this).find("td:eq(0)").text();
    			var del_yn = $(this).find("td:eq(2)").attr('class');
    			
    			if(del_yn == 'Y'){
    				return false;
    			}
    			
    			$('#board_seq').val(board_seq);
    			$('#category_seq').val(category_seq);
				if($(this).find('td').attr('class')=="Y"){
    				return false;
    			}
				 
				$('#frm').attr('action',"${pageContext.request.contextPath }/board/getBoard" );
				 
    			$('#frm').submit();
    			 	

    				
    		})
    		$('#boardReg').click(function(){
    			$('#frm').attr('action','${pageContext.request.contextPath }/board/formBoard');
    			$('#frm').submit();
    		})
    		
    		//$('#join').on('click',function(){
			//console.log($('#ff').serialize());
			
			/* $.ajax({
				url : '/board/MemberJoin',
				type : 'post',
				data : $('#ff').serialize(),
				dataType : 'json',
				success : function(res){
					$('#join-span').html(res.flag).css('color','red');
				},
				error : function(e){
					alert(e.status);
				}
			})  */
		
    	})
    </script>
    <style>
    	.Y{
    		color: #c91010;
    	}
    
    </style>
  </head>

  <body>

<%--    <%@ include file="/WEB-INF/views/layout/header.jsp" %>
 --%>  <form id="frm">
  	<input type="hidden" name="board_seq" id="board_seq">
  	<input type="hidden" name="category_seq" id="category_seq">
  </form>
    <div class="container-fluid">
      <div class="row">
<%--         <%@ include file="/WEB-INF/views/layout/left.jsp" %>
 --%>			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">게시글 목록</h1>

				<div class="table-responsive">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>번호</th>
								<th>게시글 이름</th>
								<th>작성자</th>
								<th>등록 일시</th>
							</tr>
						</thead>
						<tbody id="boardList">
							<c:forEach items="${boardList }" var="vo">
								<tr>
									<td hidden>${vo.category_seq}</td>
									<td>${vo.board_seq }</td>
									<c:choose>
										<c:when test="${vo.del_yn == 'Y'}">
											<td class="Y" >삭제된 게시글 입니다</td>
										</c:when>
										<c:otherwise>
											<td class="N">${vo.title }</td>
										</c:otherwise>

									</c:choose>
									<td>${vo.reg_id }</td>
									<td><fmt:formatDate value="${vo.reg_dt }" pattern="yyyy-MM-dd" /></td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<button id="boardReg" type="button" class="btn btn-default">게시글 쓰기</button>						
					${pageNav }

				
			</div>
		</div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
