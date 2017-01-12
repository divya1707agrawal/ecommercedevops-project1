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
Product p=(Product)request.getAttribute("product");
request.setAttribute("id", p.getId());
request.setAttribute("name", p.getName());
request.setAttribute("price",p.getPrice());
request.setAttribute("description",p.getDescription());
request.setAttribute("supplier",p.getSupplier_id());
request.setAttribute("stock",p.getStock());
request.setAttribute("category",p.getCategory_id());

%>

<c:url var="addAction" value="/manage_product1"></c:url>
<form:form action="manage_product1" commandName="editp" enctype="multipart/form-data" method="post">
<table>
<tr>
 <td><form:label path="id"><spring:message text="ID"/></form:label></td>
 <td><form:input path="id" type="text" value='${requestScope.id}' /></td></tr>
 <tr>
 <td><form:label path="name"><spring:message text="NAME"/></form:label></td>
  <td><form:input path="name" type="text" value="${requestScope.name}"/></td></tr>
 <tr>
 <td><form:label path="price"><spring:message text="PRICE"/></form:label></td>
 <td><form:input path="price" type="text" value="${requestScope.price}"/></td></tr>
 <tr>
 <td><form:label path="description"><spring:message text="DESCRIPTION"/></form:label></td>
 <td><form:input path="description" type="text" value="${requestScope.description}"/></td></tr>
 <tr>
 <td><form:label path="supplier_id"><spring:message text="SUPPLIER_ID"/></form:label></td>
 <td><form:input path="supplier_id" type="text" value="${requestScope.supplier}"/></td></tr>
 
 <td><form:label path="stock"><spring:message text="STOCK"/></form:label></td>
  <td><form:input path="stock" type="text" value="${requestScope.stock}"/></td></tr>
 <tr>
 <td><form:label path="category_id"><spring:message text="category_id"/></form:label></td>
  <td><form:input path="category_id" type="text" value="${requestScope.category}"/></td>
 </tr>
 </tr>
  <td colspan="2">
 <table border="0">
    <tr>
    <td>Pick file #1:</td>
    <td><input type="file" name="fileUpload" size="50" /></td>
    </tr>
 </table>
 </td>
 <tr>
 <td>
 <input type='submit' value='edit'/>
 </td>
 </tr>
 </table>
 </form:form>
  
  </body>
</html>