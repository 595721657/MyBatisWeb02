<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>帖子展示</title>
<style type="text/css">
  *{margin: 0px auto;padding: 0;}
  h2{text-align: center;}
</style>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/bootstrap.js"></script>
</head>
<body>
<h2>帖子列表</h2>
<div class="container">
   <form action="Invitation?op=find" method="post">
	 <table class="table table-hover table-striped">
	  <tr>
	    <td colspan="6" style="text-align: center;">帖子标题：<input type="text" name="title" value=""/><button type="submit">搜索</button></td>
	  </tr>
	  <tr>
	   <th>序号</th>
	   <th>标题</th>
	   <th>内容摘要</th>
	   <th>作者</th>
	   <th>发布时间</th>
	   <th>操作</th>
	  </tr>
	  <c:forEach items="${invitation }" var="in" varStatus = "status">
	   <tr>
	     <td><c:out value="${status.count}"></c:out></td>
	     <td>${in.title }</td>
	     <td>${in.summary }</td>
	     <td>${in.author }</td>
	     <td><fmt:formatDate value="${in.createdate }" pattern="YYYY-MM-dd"/></td>
	     <td><a href="Reply?op=find&invid=${in.id }">查看回复</a>||<a onclick="del('${in.id}')">删除</a></td>
	   </tr>
	  </c:forEach>
	 </table>	 
   </form>
</div>
<script type="text/javascript">
function del(id){
	var r=confirm("是否删除");
	if(r==true){
		//使用Ajax来进行后台请求
			$(function(){
				$.post({
				url:"Invitation?op=del",//请求的servelt名称
				type:"post",
				data:"id="+id,//传递的参数值
				dataType:"text",//后台响应的数据类型
				success:function(text){
					//处理成功时响应数据的方法
					if(text.trim()=="true"){
						window.location.reload();
						alert("删除成功！！");
					}else{
						alert("删除失败！！");
					}
				}
			 });
			})
	}
}
</script>
</body>
</html>