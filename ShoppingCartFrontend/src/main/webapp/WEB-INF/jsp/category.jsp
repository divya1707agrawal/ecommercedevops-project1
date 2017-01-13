<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Page</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

</head>
<body>
${msg}
<h1>Add a Category</h1>
<c:url var="addAction" value="/manage_category_add"></c:url>
<form:form action="${addAction}" commandName="category" enctype="multipart/form-data" method="post">
<table>
<tr>
 <td><form:label path="id"><spring:message text="ID"/></form:label></td>
 <c:choose>
   <c:when test="${!empty category.id}">
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
  <td><form:label path="description">
  <spring:message text="Description"/>
  </form:label></td>
  <td><form:input path="description" required="true"/></td>
  </tr>
  <tr>
  <td colspan="2"><c:if test="${!empty category.name}">
  <input type="submit" value="<spring:message text="Update Category"/>"/>
  </c:if><c:if test="${empty category.name}">
  <input type="submit" value="<spring:message text="Add Category"/>"/>
  </c:if></td>
  </tr>
   </table>
   </form:form></br>
  <!--   <script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
  $http.get("cat")
  .then(function(response) {
      $scope.category = response.data;
  });
});
</script>-->
   <h3>Category List</h3>
   <table class="tg" border="2">
   <tr><th width="80">Category ID</th>
   <th width="120">Category Name</th>
   <th width="120">Category Description</th>
   <th width="60">Delete</th>
   <th width="60">Edit</th>
   
   </tr>
  
   <%
   java.util.List<com.niit.shoppingcart.controller.Category> lst=(java.util.List)request.getAttribute("list");
   for(com.niit.shoppingcart.controller.Category c:lst)
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
   <%out.println(c.getDescription()); %>
   </td>
    <td>
   <a href='manage_category_remove/?id=<%out.println(c.getId());%>'>delete</a>
   </td>
    <td>
    <a href='editcategory?id=<%out.println(c.getId());%>'>edit</a>
   </td>
   </tr>
   <%
   }
   %>
   </table>
   
  
   
</body>
</html>