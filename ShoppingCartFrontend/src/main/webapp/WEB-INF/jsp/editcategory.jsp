<%@page import="com.niit.shoppingcart.controller.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
<%
com.niit.shoppingcart.controller.Category c=(com.niit.shoppingcart.controller.Category)request.getAttribute("category");
request.setAttribute("id", c.getId());
request.setAttribute("name", c.getName());
request.setAttribute("description",c.getDescription());
%>

<c:url var="addAction" value="/manage_category1"></c:url>
<form:form action="manage_category1" commandName="editc" method="post">
<table>
<tr>
 <td><form:label path="id"><spring:message text="ID"/></form:label></td>
 <td><form:input path="id" type="text" value='${requestScope.id}' /></td></tr>
 <tr>
 <td><form:label path="name"><spring:message text="NAME"/></form:label></td>
  <td><form:input path="name" type="text" value="${requestScope.name}"/></td></tr>
  
 <td><form:label path="description"><spring:message text="DESCRIPTION"/></form:label></td>
 <td><form:input path="description" type="text" value="${requestScope.description}"/></td></tr>
 </tr>
 <tr>
 <td>
 <input type='submit' value='edit'/>
 </td>
 </tr>
 </table>
 </form:form>
  
  </body>
</html>