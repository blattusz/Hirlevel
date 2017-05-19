
<%@page import="Controller.GroupSend"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Csoportos Hírlevél</title>
</head>
<body>

<center>
<br>
<form action="Entered.jsp">
    <input type="submit" value="Go to Back" />
</form>
<br>
<div class="container">
  <form class="form-horizontal" action="http://localhost:8080/WildFlyHirlevel/GroupSend" method="post">
	<div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Címek:(Mail címeket Enterrel válaszd el!):</label>
      <div class="col-sm-10">          
        <textarea class="form-control" rows="7" cols="30" name="Cimek"></textarea>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Tárgy:</label>
      <div class="col-sm-10">          
       <input name="Targy" class="form-control" value=""><br>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Email Szövege vagy HTML kód:</label>
      <div class="col-sm-10">          
        <textarea name="Szoveg" class="form-control" rows="10" cols="100" value=""></textarea>
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Elküld</button>
      </div>
    </div>
  </form>
</div>

  <h2>
<%= GroupSend.grouptatus %><br></br></h2>
</body>
</html>