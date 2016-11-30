<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
</head>
<body>
${msg}
<h1>Add a product</h1>
<c:url var="addAction" value="/manage_product_add"></c:url>
<form:form action="${addAction}" commandName="product" enctype="multipart/form-data" method="post">
<table>
<tr>
 <td>
  <form:lable path="id"><spring:message text="ID"/></form:lable>
 </td>
 <c:choose>
   <c:when test="${!empty product.id}">
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
  <td><form:lable path="price"><spring:message text="PRICE"/></form:lable> </td>
     <td><form"input path="price" disabled="true" readonly="true"/></td>
  </tr>
   <tr>
  <td><form:lable path="description"><spring:message text="Description"/></form:lable> </td>
     <td><form"input path="description" disabled="true" readonly="true"/></td>
  </tr>
   <tr>
  <td><form:lable path="supplier"><spring:message text="Supplier"/></form:lable> </td>
  <td><form:select path="supplier.name" item="${supplierList}" itemValue="name" itemLable="name"/></td>
  </tr>
  
 <tr>
  <td><form:lable path="category"><spring:message text="Category"/></form:lable> </td>
  <td><form:select path="category.name" item="${categoryList}" itemValue="name" itemLable="name"/></td>
  </tr> 
  <tr>
  <td align="left"><form:lable path="image">
  <spring"message text="Image"/>
  </form:lable></td>
  <td align="left"><form:input type="file" name=image path="image"/></td></tr>
  <tr>
  <td colspan="2">
  <c:if  test="${!empty product.name}">
  <input type="submit" value='<spring:message text="Edit Product"/>'/>
  </c:if>
  <c:if test="${empty product.name}">
  <input type="submit" value='<spring:message text="Add Product"/>'/>
  </c:if></td>
  </tr>
   </table>
   </form:form>
  </body>
</html>