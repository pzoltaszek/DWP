<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<c:choose>

	<c:when test="${sessionScope.kolor eq 'grey'}">
		<link rel="stylesheet" href="grey.css">
	</c:when>

	<c:when test="${sessionScope.kolor eq 'black'}">
		<link rel="stylesheet" href="black.css">
	</c:when>

	<c:when test="${sessionScope.kolor eq 'blue'}">
		<link rel="stylesheet" href="blue.css">
	</c:when>

	<c:otherwise>
		<link rel="stylesheet" href="grey.css">
	</c:otherwise>
</c:choose>
<!-- <link rel="stylesheet" href="grey.css"> -->
<title>Tytuł strony</title>
</head>


<table id="tabela">
	<tr>
		<td align="left"><a target="glowna" id="home" href="index.jsp">
				Home </a></td>

		<td align="right">Witaj ${u.loginp}
			<form action="/Strona/witaj" method="POST">
				<input type="hidden" name="logout"> <input name="logout"
					type=submit value="Wyloguj">
			</form>
		</td>
	</tr>
</table>


<nav>
	<ul>
		<li><a href="pierwsza.jsp"> Pierwsza </a></li>
		<li><a href="druga.jsp"> Druga </a></li>
		<li><a href="trzecia.jsp"> Trzecia </a></li>
		<li><a href="czwarta.jsp"> komentarz </a></li>
	</ul>
</nav>


<fieldset>
	<legend>Trzecia</legend>



	<p>Dzisiejsza data: ${d.data}</p>
	<br>
	<hr />
	<br>

	<p>Anti-stress button</p>
	<form action="/Strona/drugi" method="POST">
		<input type="hidden" name="aaa" /> <input name="antistrB" type=submit
			value="Click me" />
	</form>

	Licznik: ${sessionScope.licznikS}
	<%-- 22. ${licznikS} --%>
	<br> <br>
	<c:if test="${licznikS > 3}">
Zobacz co będzie przy 10!
</c:if>
	<br>
	<c:if test="${licznikS > 9}">
Brawo, jeszcze 100 000 000 i wygrałeś!
</c:if>
	<%-- 2.${aa}
3.${sessionScope.aa}
6.${sessionScope.adres} --%>
	<br>
	<br>
	<hr />
	<!-- <p>Applet</p> -->
	<br>
	<br>
	<!-- <applet code="ZegarB" width=250 height=300 > </applet>  -->
</fieldset>

<table id="pole"></table>
<table id="tabelaf">
	<tr>
		<td align="left">Licznik odwiedzin: ${lo.licznikOdwiedzin}</td>
		<td align="right">Status:</td>

		<td width="20px" align="right">
			<div Status: id="kolko"></div>
		</td>
	</tr>
</table>


</body>
</html>