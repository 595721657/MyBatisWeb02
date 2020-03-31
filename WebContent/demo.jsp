<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回帖展示</title>
<style type="text/css">
  *{margin: 0px auto;padding: 0;}
  h2{text-align: center;}
</style>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/bootstrap.js"></script>
</head>
<body>
<h2>回帖信息列表</h2>
<div class="container">
   <form action="Invitation?op=find" method="post">
	 <table class="table table-hover table-striped">
	  <tr>
	    <td colspan="4" style="text-align: center;"><a href="add_reply.jsp">添加回复</a>||<a onclick="javascript :history.back(-1);" style="cursor:pointer">返回帖子列表</a></td>
	  </tr>
	  <tr>
	   <th>序号</th>
	   <th>回复内容</th>
	   <th>回复昵称</th>
	   <th>发布时间</th>
	  </tr>
	  <c:forEach items="${reply }" var="r" varStatus ="status">
	   <tr>
	     <td><c:out value="${status.count}"></c:out></td>
	     <td>${r.content }</td>
	     <td>${r.author }</td>
	     <td><fmt:formatDate value="${r.createdate }" pattern="YYYY-MM-dd"/></td>
	   </tr>
	  </c:forEach>
	 </table>	 
   </form>
</div>
</body>
</html>