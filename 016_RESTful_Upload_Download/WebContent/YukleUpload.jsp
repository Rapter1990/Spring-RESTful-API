<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="rest/file/upload" method="post" enctype="multipart/form-data">
		<p> Yüklenecek bir şey seçiniz : <input type="file" name="file" size="60"></p>
		<input type="submit" value="Yükle Upload">
	</form>
	
	
</body>
</html>