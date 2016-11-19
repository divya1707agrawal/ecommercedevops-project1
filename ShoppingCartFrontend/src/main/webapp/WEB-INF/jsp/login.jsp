<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
${errorMessage}
<form action="validate" method="post">
<fieldset>
<label for="usr">User Name:</label>
<input  type="text" class="form-control" name="usr"><br>
<div class="form-group">
<label for="pwd">Password:</label>
<input type="password"  class ="form-control" name="pwd" ><br>
<input type="submit" value="login">
</fieldset>
 </form>
 </div>
</body>
</html>