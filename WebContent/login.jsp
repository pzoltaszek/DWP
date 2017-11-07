<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="login.css">
<title>Logowanie</title>
</head>
<body>

<p align="center"> <b>Logowanie</b> <p>
<div>
<table id="tabelka_form" >
<form action="/Strona/witaj" method="POST">
<tr align="center">
<td width="50"><B>login: </B></td>
<td width="50"><input name="loginp"></td>
</tr>

<tr align="center">
<td width="50"><b> password: </b> </td> 
<td width="50"><input type="textbox" name="passwordp"></td>
</tr>
<tr align="center"><td colspan="2">
<input type=submit value="Wyślij">
</td></tr>
</form>
</table>
</div>
<p>${sessionScope.logg}</p>
<a target="glowna" href="rejestracja.jsp" > Rejestracja </a>

<table id="pole"></table>
<table id="tabelaf">
<tr>
<td align="left">

</td>
<td align="right">Status:</td>

<td width="20px" align="right">
<div id="kolko"> </div>
</td>
</tr>
</table>
</body>
</html>