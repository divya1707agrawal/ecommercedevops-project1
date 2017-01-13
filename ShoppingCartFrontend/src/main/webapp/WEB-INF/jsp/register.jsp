<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>please fill the details</h4>
<form:form  action="registration" commandName="user">
<table>
<tr>
<td>
<form:label path="id">
<spring:message text="ID"/>
</form:label></td>
<td>
<form:input path="Id" type="text"/></td></tr>
<tr><td>
<form:label path="name">
<spring:message text="User name"/>
</form:label></td>
<td><form:input path="name" required="true" title="name should not be empty"/></td>
</tr>
<tr><td>
<form:label path="password">
<spring:message text="Password"/>
</form:label></td>
<td><form:input path="password" type="password" required="true" title="password should not be empty"/></td>
</tr>
<tr><td>
<form:label path="contact">
<spring:message text="Contact"/>
</form:label></td>
<td><form:input path="contact" required="true" title="contact should not be empty"/></td>
</tr>
<tr><td>
<form:label path="mail">
<spring:message text="Mail"/>
</form:label></td>
<td><form:input path="mail" required="true" title="mail should not be empty"/></td>
</tr>
<tr><td>
<form:label path="role">
<spring:message text="Role"/>
</form:label></td>
<td><form:input path="role" required="true" title="role should not be empty"/></td>
</tr>
<tr>
<td><input type="submit" value="<spring:message text="Register"/>"/></td>
<td><input type="reset" value="<spring:message text="Reset"/>"/>
</td></tr>
</table>
</form:form>
</body>
</html>