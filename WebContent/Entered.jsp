<%@page import="Converter.converter"%>
<%@page import="Controller.login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Hirlevel</title>
</head>
<body>
<center>
<h2>Üdvözöllek:<br> <%= login.UserName %></h2>

<br>
<form action="Sima.jsp">
    <input type="submit" value="Egy E-mail küldése!" />
</form>
<br>
<br>
<form action="Csoportos.jsp">
    <input type="submit" value="Csoportos E-mail küldése!" />
</form>
<br>







	</body>
</html>
