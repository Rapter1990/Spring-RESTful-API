<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="rest/uye/login" method="post">
		<table>
			<tr>  <td>Kullanıcı</td>	<td><input type="text" name="kullaniciAdi"></td>        </tr>
		    <tr>  <td>Parola</td>	    <td><input type="password" name="kullaniciParola"></td>		</tr>	
		    <tr>  <td></td>	            <td><input type="submit" value="Gönder"></td>		    </tr>	
		</table>	
	</form>
	
	<form action="rest/uye/ekle" method="POST">
		<table>
			<tr>  <td>Adı</td>	<td><input type="text" name="personelAdi"></td>        </tr>
		    <tr>  <td>Ülke</td>	<td><input type="text" name="personelUlke"></td>		</tr>	
		    <tr>  <td></td>	            <td><input type="submit" value="Ekle"></td>		    </tr>	
		</table>	
	</form>
	
</body>
</html>