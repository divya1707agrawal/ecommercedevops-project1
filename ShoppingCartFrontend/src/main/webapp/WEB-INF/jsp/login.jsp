<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" ">
  <script src="<c:url value='/resources/jquery/jquery.min.js'/>" ></script>
  <script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>" ></script>
  <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript">
        window.history.forward();
        function goforward()
        {
        windows.history.back();
        }
       
</script>
</head>
<body onload="goforward()">
<Center>
<h3>Login Form</h3>
<form method='post' action="<c:url value='/loginprocess' />	">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" class="form-control" /> 
<div class="form-group">
<div class="container">
${errorMessage}
<label for="usr">User Id:</label>
<input  type="text" class="form-control" name="j_username"><br>
<div class="form-group">
<label for="pwd">Password:</label>
<input type="password"  class ="form-control" name="j_password" ><br>
<input type="submit" value="login">
 </div>
 </div>
 </div>
 </form>
</body>
</html>