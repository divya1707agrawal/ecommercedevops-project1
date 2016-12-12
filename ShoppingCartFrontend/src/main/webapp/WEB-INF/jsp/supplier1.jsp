<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Page</title>
</head>
<body>
${msg}
<h1>Add a Supplier</h1>
<c:url var="addAction" value="/manage_supplier_add"></c:url>
<form:form action="${addAction}" commandName="supplier"  enctype="multipart/form-data" method="post">
<table>
<tr>
 <td><form:label path="id"><spring:message text="ID"/></form:label></td>
 <c:choose>
   <c:when test="${!empty supplier.id}">
     <td><form:input path="id" disabled="true" readonly="true"/></td>
   </c:when>
   <c:otherwise>
     <td><form:input path="id" pattern=".{5,20}" required="true" title="id should contain 5 to 20 character"/></td>
   </c:otherwise>
 </c:choose>
 </tr>
 <tr>
  <td><form:label path="name"><spring:message text="NAME"/></form:label> </td>
     <td><form:input path="name" /></td>
  </tr>
  <tr>
  <td><form:label path="address"><spring:message text="ADDRESS"/></form:label> </td>
     <td><form:input path="address" /></td>
  </tr>
   <tr>
  <td colspan="2"><c:if test="${!empty supplier.name}">
  <input type="submit" value="<spring:message text="Update Supplier"/>"/>
  </c:if><c:if test="${empty supplier.name}">
  <input type="submit" value="<spring:message text="Add Supplier"/>"/>
  </c:if></td>
  </tr>
   </table>
   </form:form></br>
   
     <h3>Supplier List</h3>
   <table class="tg" border="2">
   <tr><th width="80">Supplier ID</th>
   <th eidth="120">Supplier Name</th>
   <th width="120">Supplier Address</th>
  <th width="60">Delete</th>
    <th width="60">Edit</th>
   </tr>
   <%
   java.util.List<com.niit.shoppingcart.controller.Supplier> lst=(java.util.List)request.getAttribute("list");
   for(com.niit.shoppingcart.controller.Supplier s:lst)
   {
   %>
    <tr >
   <td>
  <%out.println(s.getId()); %>
   </td>
   <td>
   <%out.println(s.getName()); %>
   </td>
   <td>
   <%out.println(s.getAddress()); %>
   </td>
   <td>
   <a href='manage_supllier_remove/?id=<%out.println(s.getId());%>'>delete</a>
   </td>
    <td>
   <a href='editsupplier?id=<%out.println(s.getId());%>'>edit</a>
   </td>
   </tr>
   <%
   }
   %>
   </table>
  </body>
</html>