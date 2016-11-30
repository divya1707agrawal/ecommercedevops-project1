<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Page</title>
</head>
<body>
${msg}
<h1>Add a Category</h1>
<c:url var="addAction" value="/manage_category_add"></c:url>
<form:form action="${addAction}" commandName="category" mathod="post">
<table>
<tr>
 <td>
  <form:lable path="id"><spring:message text="ID"/></form:lable>
 </td>
 <c:choose>
   <c:when test="${!empty category.id}">
     <td><form"input path="id" disabled="true" readonly="true"/></td>
   </c:when>
   <c:otherwise>
     <td><form"input path="id" pattern=".{5,20}" required="true" title="id should contain 5 to 20 character"/></td>
   </c:otherwise>
 </c:choose>
 
 <tr>
  <td><form:lable path="name"><spring:message text="NAME"/></form:lable> </td>
     <td><form"input path="name" disabled="true" readonly="true"/></td>
  </tr>
  <tr>
  <td><form:lable path="description">
  <spring:message text="Description"/>
  </form:lable></td>
  <td><form:input path="description" required="true"/>
  </td></tr>
  <tr>
  <td colspan="2"><c:if text="${!empty category.name}">
  <input type="submit" value="<spring:message text="Update Category"/>"/>
  </c:if><c:if text="${empty category.name}">
  <input type="submit" value="<spring:message text="Add Category"/>"/>
  </c:if></td>
  </tr>
   </table>
   </form:form></br>
   <h3>Category List</h3>
   <c:if text="${!empty categoryList}">
   <table class="tg">
   <tr><th width="80">Category ID</th>
   <th eidth="120">Category Name</th>
   <th width="120">Category Description</th>
   <th width="60">Edit</th>
   <th width="60">Delete</th>
   </table></c:if>
</body>
</html>