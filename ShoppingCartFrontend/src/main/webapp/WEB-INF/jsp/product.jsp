<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
</head>
<body>
${msg}
<h1>Add a product</h1>

<c:url var="addAction" value="/manage_product_add"></c:url>
<form:form action="${addAction}" commandName="product"  method="post" enctype="multipart/form-data">
<table>
<tr>
 <td><form:label path="id"><spring:message text="ID"/></form:label></td>
 
    
 
   
     <td><form:input path="Id" pattern=".{2,20}" required="true" title="id should contain 2 to 20 character"/></td>

 </tr>
 <tr>
  <td><form:label path="name"><spring:message text="Name"/></form:label> </td>
     <td><form:input path="name"/></td>
  </tr>
  <tr>
  <td><form:label path="price"><spring:message text="Price"/></form:label> </td>
     <td><form:input path="price"/></td>
  </tr>
   <tr>
  <td><form:label path="description"><spring:message text="Description"/></form:label> </td>
     <td><form:input path="description"/></td>
  </tr>
  
<tr>
  <td><form:label path="supplier_id"><spring:message text="supplier_id"/></form:label> </td>
     <td><form:input path="supplier_id"/></td>
  </tr>
  <tr>
  <td><form:label path="stock"><spring:message text="Stock"/></form:label> </td>
     <td><form:input path="stock"/></td>
  </tr>
   <tr>
  <td><form:label path="category_id"><spring:message text="category_id"/></form:label> </td>
     <td><form:input path="category_id"/></td>
  </tr>
  <td colspan="2">
 <table border="0">
                <tr>
                    <td>Pick file #1:</td>
                    <td><input type="file" name="fileUpload" size="50" /></td>
                </tr>
               
            </table>
  <input type="submit" value='<spring:message text="Add Product"/>'/>
 </td>
  </tr>
   </table>
   
   </form:form>
   <br>
   <br>
     <h3>Product List</h3>
   <table class="tg" border="2">
   <tr><th width="80">Product ID</th>
   <th width="120">Product Name</th>
   <th width="120">Product Price</th>
   <th width="120">Category_ID</th>
   <th width="120">Supplier_ID</th>
   <th width="120">Stock</th>
   <th width="120">Product Description</th>
    <th width="60">Delete</th>
    <th width="60">Edit</th>
  
   </tr>
  
   <%
   java.util.List<com.niit.shoppingcart.controller.Product> lst=(java.util.List)request.getAttribute("list");
   for(com.niit.shoppingcart.controller.Product c:lst)
   {
   %>
    <tr >
   <td>
  <%out.println(c.getId()); %>
   </td>
   <td>
   <%out.println(c.getName()); %>
   </td>
   <td>
   <%out.println(c.getPrice()); %>
   </td>
     </td>
   <td>
   <%out.println(c.getCategory_id()); %>
   </td>
     </td>
   <td>
   <%out.println(c.getSupplier_id()); %>
   </td>
     </td>
   <td>
   <%out.println(c.getStock()); %>
   </td>
  
   <td>
   <%out.println(c.getDescription()); %>
   </td>
    <td>
   <a href='manage_product_remove/?id=<%out.println(c.getId());%>'>delete</a>
   </td>
  <!-- byte[] bt=c.getContent();
   response.setContentType("image/jpeg");
   response.setContentLength(bt.length);
  java.io.OutputStream o=response.getOutputStream();
  o.write(bt); --> 
  <td>
    <a href='editproduct?id=<%out.println(c.getId());%>'>edit</a>
   </td>
   </tr>
   <%
   }
   %>
    </table>
   </body>
</html>