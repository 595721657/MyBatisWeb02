<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加博客</title>
</head>
<body>
<h2 style="text-align: center;">添加评论</h2>
  <form action="Reply?op=add" method="post">
     <table style="margin: 0px auto;padding: 0;">
     <tr>
       <th>回复昵称：</th>
       <td><input type="text" name="author" value=""/></td>
     </tr>
     <tr>
      <th>内容：</th>
      <td>
        <div id="editor">
       </div>
       <textarea style="display: none;" name="content" id="text"></textarea>
      </td>
     </tr>
     <tr>
      <th>&nbsp;</th>
      <td style="text-align: center;"><button type="submit" >提交</button>||<button formaction="Reply?op=find&invid=${invid }">返回</button></td>
     </tr>
   </table>
  </form>
  <!-- 引入js文件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/wangEditor.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.js"></script>
      <script type="text/javascript">
      var E =window.wangEditor;//获得一个富文本编辑器对象
      var editor=new  E("#editor");
     // 上传图片到服务器
      editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/upload';
   	// 隐藏“网络图片”tab
      editor.customConfig.showLinkImg = false;
   	// 将图片大小限制为 3M
      editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
   	// 限制一次最多能传几张图片，默认为 10000 张（即不限制），需要限制可自己配置
  	// 限制一次最多上传 5 张图片
  	editor.customConfig.uploadImgMaxLength = 5;
   	// 监听函数，可使用监听函数在上传图片的不同阶段做相应处理
   	editor.customConfig.uploadImgHooks = {
  		// 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
      	// （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
      	// 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
      	customInsert: function (insertImg, result, editor) {
          	// insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果
          	// 举例：假如上传图片成功后，服务器端返回的是 [url,url,...] 这种格式，即可这样插入图片：
          	for(var i in result){// result 必须是一个 JSON 格式字符串！！！否则报错
          		insertImg('${pageContext.request.contextPath}/file/'+result[i]);
          	}
      	}
      }	
    //创建出编辑器
    editor.customConfig.onchange = function (html) {
        // 监控变化，同步更新到 textarea
  	  document.getElementById("text").value=html;
    }
      editor.create();
      </script>
</body>
</html>