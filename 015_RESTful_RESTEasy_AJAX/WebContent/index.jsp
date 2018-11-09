<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">


<script lang="javascript" src="./rest-js"></script>

<script>

function uyeKontrolFrom() {

	var gelenAdi = document.getElementById("adi").value;
	var gelenSoyadi = document.getElementById("soyadi").value;
	
	var verilecekMesaj = UyeServis.uyeKontrol({adi:gelenAdi   ,  soyadi:gelenSoyadi });
	
	document.getElementById("hata").innerHTML = "<h2>" + verilecekMesaj + "</h2>";
	
	//alert(verilecekMesaj);
}


</script>



<title>RESTful AJAX Client</title>
</head>
<body>

<h1>RESTful AJAX Client</h1>


<!--  
 http:localhost:8080/_015_RESTfulRESTEasy-AJAX/rest/uye/ekle
 -->

	<form method="POST" action="rest/uye/ekle">
           <table>
            <tr> <td>ADI:</td>     <td> <input type="text" name="adi"  id="adi" value=""> </td>  </tr>
		    <tr> <td>SOYADI:</td>     <td> <input type="text" name="soyadi"  id="soyadi" value=""> </td>  </tr>
		    
		    <tr> <td></td>     
		    <td> 
		    
		    <input type="submit" value="submit action">  <br>
		    <input type="button" value="button action">  <br>
		    <input type="submit" value="submit onclick" onclick="uyeKontrolFrom()"> <br>
		    <input type="button" value="button onclick" onclick="uyeKontrolFrom()"> 
		    
		    </td>  </tr>
           </table>
     </form>


<div id="hata"></div>

</body>
</html>