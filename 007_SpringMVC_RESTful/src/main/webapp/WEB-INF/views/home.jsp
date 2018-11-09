<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2> PERSONEL</h2>         
  <table class="table">
    <thead>
      <tr>
        <th>Adı</th>
        <th>Şehir</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${adSoyad}</td>
        <td>${sehir}</td>
        <td>${email}</td>
      </tr>
   
    </tbody>
  </table>
</div>

</body>
</html>
