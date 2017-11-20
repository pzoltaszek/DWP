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


	<legend>Komentarz</legend>
	<br>
	<font color="red"> ${requestScope.wpisDodany} ${requestScope.bladWpisu}</font>
	<br>
	<table border="1" frame="void" cellpadding="10">
		<tr>
			<td>

				<table border="1" frame="void" cellpadding="10">
					<c:forEach var="listaNickow" items="${wpisy.nickL}">
						<tr>
							<td width="10%" height="50"><b>${listaNickow}</b> napisał
								dnia :</td>
						</tr>
					</c:forEach>
				</table>
			</td>

			<td>
				<table border="1" frame="void" cellpadding="10">
					<c:forEach var="listaDat" items="${wpisy.dataL}">
						<tr>
							<td height="50"><b>${listaDat}</b></td>
						</tr>
					</c:forEach>
				</table>
			</td>

			<td>
				<table border="1" frame="void" cellpadding="10">
					<c:forEach var="listaTresci" items="${wpisy.trescL}">
						<tr>
							<td height="50">${listaTresci}</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
	<%-- <table border="1" frame="void" cellpadding="10">
<tr>
<c:forEach var = "listaNickow" items="${wpisy.nickL}">
<tr><b>${listaNickow}</b> napisał dnia :<br></tr>
</c:forEach>

<td>
<c:forEach var = "listaDat" items="${wpisy.dataL}">
<tr><b>${listaDat}</b></tr>
</c:forEach></td>

<td>
<c:forEach var = "listaTresci" items="${wpisy.trescL}">
<tr>${listaTresci}</tr>
</c:forEach></td>

</tr>
</table> --%>
	<hr>
	<p>
		<b>Pozostaw komentarz</b>
	</p>
	<p>Podaj nick:</p>
	<form name="komentarz" id="komentarz" method="POST"
		action="/Strona/wpis">
		<input type=textbox size=25 name="nick">
		<p>Napisz wiadomość:
		<p />
		<textarea cols="50" rows="12" name="tresc"></textarea>
		<br>
		<br> <input type=submit value="Potwierdź">
	</form>
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