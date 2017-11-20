<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <c:choose>
         
         <c:when test = "${sessionScope.kolor eq 'grey'}">
            <link rel="stylesheet" href="grey.css">
         </c:when>
         
         <c:when test = "${sessionScope.kolor eq 'black'}">
            <link rel="stylesheet" href="black.css">
         </c:when>
         
          <c:when test = "${sessionScope.kolor eq 'blue'}">
            <link rel="stylesheet" href="blue.css">
         </c:when>
         
         
         <c:otherwise>
            <link rel="stylesheet" href="grey.css">
         </c:otherwise>
      </c:choose>

<!-- <link rel="stylesheet" href="grey.css"> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tytuł</title>
</head>
<body>
<jsp:useBean id = "uzyt" class = "pz.strona.Bean.User" scope="session"/> 

<table id="tabela">
<tr>
<td align="left">
<a id="home" href="index.jsp"> Home </a>
</td>

<td align="right">
Witaj ${u.loginp} <form action="/Strona/witaj" method="POST">
<input type="hidden" name="logout">
<input name="logout" type=submit value="Wyloguj"></form>
</td>
</tr>
</table>


<nav>
<ul>
<li> <a  href="pierwsza.jsp" > Pierwsza </a></li>
<li> <a  href="druga.jsp"> Druga </a></li>
<li> <a  href="trzecia.jsp"> Trzecia </a></li>
<li> <a  href="czwarta.jsp"> komentarz </a></li>
</ul>
</nav>

<fieldset>
<legend>O mnie</legend>
<p>${u.loginp}</p>

<table border="1" frame="void" cellpadding="10">
<tr><td align="center"><b> ID </b></td> <td align="center"><b> nazwa </b></td> <td align="center"><b> od kiedy</b> </td> </tr>
<tr><td>${sessionScope.idzDB}</td> <td> ${sessionScope.loginzDB}</td> <td>${sessionScope.datazDB}</td> </tr>
</table>
<br><br>
<hr /> Wybrałeś wygląd: ${param.kolor} 2. ${cookie.imieCookie.value} 3. ${cookie.kolorCookie.value} 4. ${sessionScope.kolor}
<br><br>
<form name="wyglad" action="/Strona/pierszy" method= "GET">

<B>Wybierz wygląd strony:</B>
<select name="kolor" size="1">
<option value = "grey"> Szary (domyślny) </option>
<option value = "black"> Czarny </option>
<option value = "blue"> Niebieski </option>
</select>

<br><br>
<input type=submit value="ZmianaKoloru">
</form>
<br><br>
<hr />
<br><br>

</fieldset>

<table id="pole"></table>
<table id="tabelaf">
<tr>
<td align="left">
Licznik odwiedzin: ${lo.licznikOdwiedzin}
</td>
<td align="right">Status:</td>

<td width="20px" align="right">
<div id="kolko"> </div>
</td>
</tr>
</table>


</body>
</html>