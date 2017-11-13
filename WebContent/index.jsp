<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tytuł</title>
</head>
<body>

<table id="tabela">
<tr>
<td align="left">
<a id="home" href="index.jsp"> Home </a>
</td>

<td align="right">
Witaj ${u.loginp}
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
<legend>Powitanie</legend>
<br>

<br>

<p> ${u.loginp}, witaj na stronie.</p>
<p>Dzisiejsza data: ${d.data}

 <%-- Skryplet - nie uzywac:
       <%  Date dNow = new Date( );
         SimpleDateFormat ft = 
         new SimpleDateFormat ("yyyy.MM.dd");
         out.print(ft.format(dNow)); %> 
      --%>
</p>
<p>Twój login: "${u.loginp}"...</p>
<p>...składa sie z  ${fn:length(u.loginp)} znaków</p>

<%-- <p>...zapisany od tyłu: <%= request.getParameter("s2")%></p> --%>

<br><br>
<hr></hr>
<br><br>
<p> Twoj adres: ${sessionScope.adres} </p>
<p>.</p>
  

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