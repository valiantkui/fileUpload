<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./js/jquery-3.2.1.js"></script>
<script src="./js/jquery.form.js"></script>
<title>Insert title here</title>

<script>
	
	function dosubmit(){
		alert("即将提交");
		alert($("#form1").serialize());
		$("#form1").ajaxSubmit({
			success: function(result){
				alert(result);
			}
			
		});
	}
	


</script>
</head>
<body>
	<!-- 将文件上传到数据库中 -->
	
	<form id="form1" action="uploadservlet_db" enctype="multipart/form-data"  method="post">  
		<p><input type="file" name="file"></p>
		<p><input type="text" name="name"></p>
		<p><input type="button" onclick="dosubmit();" value="上传"></p>
	
	</form>
</body>
</html>