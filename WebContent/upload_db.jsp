<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 将文件上传到数据库中 -->
	
	<form action="uploadservlet_db" enctype="multipart/form-data"  method="post">  
		<p><input type="file" name="file"></p>
		<p><input type="submit" value="上传"></p>
	
	</form>
</body>
</html>