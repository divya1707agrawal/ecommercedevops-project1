<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>please fill the details</h2>
<form:form action="registration" method="post" commandName="user"><br>
<table>

<tr><td>
<form:lable path="id">
<Spring:message text="ID"/>
</form:lable></td>
<td><form:input path="id" pattern=".{4,15}" required="true" title="id should contain 4 to 15 characters:"/>
</td></tr>

<tr><td>
<form:lable path="name">
<spring:message text="User Name"/>
</form:lable></body></td>
<td><form:input path="name" required="true" title="name should not be empty"/>
</td></tr>

<tr><td>
<form:lable path="password">
<spring:message text="password"/>
</form:lable></body></td>
<td><form:input type="password" path="password" pattern=".{4,15}" required="true" placeholder="enter you password" title="password should contain 4 to 15 characters"/>
</td></tr>

<tr><td>
<form:lable path="contact">
<spring:message text="contact"/>
</form:lable></td>
<td><form:input type="tel" path="contact" pattern="^\{10}$" required="true" title="please enter valid contact number"/>
</td></tr>

<tr><td>
<form:lable path="mail">
<spring:message text="mail"/>
</form:lable></td>
<td><form:input type="email" path="mail"/>
</td></tr>

<tr>
<td><input type="submit" ></td>
<td><input type="reset"/>
</td></tr>
UserID:<input type="text" name="UserID"><br>
Name:<input type="text" name="UserName"><br>
Password:<input type="text" name="password"><br>
Email:<input type="text" name="email"><br>
Contact:<input type="text" name="contact"><br>
Address:<input type="text" name="address"><br>
<input type="submit" value="Register">
<input type="reset" value="reset">
</table>
</form:form>
</body>
</html>