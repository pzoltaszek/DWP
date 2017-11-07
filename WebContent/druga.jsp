<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<c:choose>
         
         <c:when test = "${param.kolor eq 'grey'}">
            <link rel="stylesheet" href="grey.css">
         </c:when>
         
         <c:when test = "${param.kolor eq 'black'}">
            <link rel="stylesheet" href="black.css">
         </c:when>
         
          <c:when test = "${param.kolor eq 'blue'}">
            <link rel="stylesheet" href="blue.css">
         </c:when>
         
         <c:otherwise>
            <link rel="stylesheet" href="grey.css">
         </c:otherwise>
      </c:choose>
<!-- <link rel="stylesheet" href="grey.css"> -->
<title> Tytuł</title>
</head>


<table id="tabela">
<tr>
<td align="left">
<a target="glowna" id="home" href="index.jsp"> Home </a>
</td>

<td align="right">
Witaj  ${u.loginp} 
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
<legend>Druga</legend>



<p>Tresc strony 2</p>
<br>
<p> Zobacz liste wszystkich użytkwników</p>


<form name="lista" id="lista" method="get">
<input name="listaB" type=submit value="Zobacz liste">
<br><br>
</form>

<table border="1" frame="void" cellpadding="10">
<tr><td align="center"><b> ID </b></td> <td align="center"><b> nazwa </b></td> <td align="center"><b> od kiedy </b> </td> </tr>
<tr><td> ID usera </td> <td> nazwa usera </td> <td> od kiedy jest z nami </td> </tr>
</table>
</fieldset>

<table id="pole"></table>
<table id="tabelaf">
<tr>
<td align="left">
Licznik odwiedzin: 10
</td>
<td align="right">Status:</td>

<td width="20px" align="right">
<div Status: id="kolko"> </div>
</td>
</tr>
</table>


</body>
</html>