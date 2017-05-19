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
<br>




<center>
<div class="container">
  <form class="form-horizontal" action="http://localhost:8080/WildFlyHirlevel/login" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Gmail Cím:</label>
      <div class="col-sm-10">          
       <input name="UserName" class="form-control" value=""><br>
      </div>
    </div>
   <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Gmail Jelszó:</label>
      <div class="col-sm-10">          
       <input name="password" class="form-control" value="" type="password"><br>
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Belépés</button>
      </div>
    </div>
  </form>
</div>

	
	</body>
</html>
