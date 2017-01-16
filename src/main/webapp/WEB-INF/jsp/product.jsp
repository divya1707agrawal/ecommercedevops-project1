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

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  </style>
  
  
   <style>
         .Search {
     position: absolute;
     top: 355px;
     left: 575px;
}

.Search input {
     height: 50px;
     width: 180pt;
}

        </style>
        
  </head>
  
<body style="background-color:orange">




<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
  $http.post("cat")
  .then(function(response) {
      $scope.category = response.data;
  });
});
</script>


<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">ShoppingCart</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="aboutus">About Us</a></li>
      <li><a href="contactus">Contact Us</a></li> 
      
<%
String user=(String)session.getAttribute("user");
if(user==null)
{
	out.println("<li><a href='login'>Login</a></li>");
	   out.println("<li><a href=register>Register</a></li>"); 
}
%>

   
      <li> <sec:authorize access="hasRole('ROLE_ADMIN')"><a href="category">Add Category</a></sec:authorize></li>
      <li><sec:authorize access="hasRole('ROLE_ADMIN')"><a href="product?id=0">Add Product</a></sec:authorize></li>
      <li><sec:authorize access="hasRole('ROLE_ADMIN')"><a href="supplier1">Add Supplier</a></sec:authorize></li> 
       <li><sec:authorize access="hasRole('ROLE_ADMIN')"><a href="paymentConfirmed">payment confirmation</a></sec:authorize></li>
      <li><sec:authorize access="hasRole('ROLE_USER')"><a href="myCart/cart">View cart</a></sec:authorize></li>
      <li><sec:authorize access="hasRole('ROLE_USER')"><a href="logout">Logout</a></sec:authorize></li>
      <li><sec:authorize access="hasRole('ROLE_ADMIN')"><a href="logout">Logout</a></sec:authorize></li>
      
  </ul>
  </div>
  </nav>
  <br/><br/>
  <div>
 <form method="get" action="viewproduct" class="navbar-form navbar-left">
      <div class="form-group">
        <input type="text"  name="name" class="form-control" placeholder="Search">
        
     <!--   <div ng-repeat="x in products">
         <%for(int i=0;i<50;i++){ %>
          <li><a href="viewproduct?name={{x.products[<%=i%>].name }}">{{ x.products[<% out.println(i); %>].name }}</a></li>
          <%
         }
          %> </div> --> 
           
      </div>
    </form>
 </div>
 <br/>
 <br/>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">
      <div ng-app="myApp" ng-controller="myCtrl"> 
 <table> 
 <tr><td ng-repeat="x in category">
 <ul><li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="viewproduct?name={{ x.id }}">{{ x.name }} <span class="caret">
 </span>  </a>
 <ul class="dropdown-menu">
 <%for(int i=0;i<50;i++){ %>
 <li><a href="viewproduct?name={{x.products[<%=i%>].name }}">{{ x.products[<% out.println(i); %>].name }}</a></li>
         
         
         
          <%
 }
          %>
        </ul>
      </li></ul></td> </tr>
 </table>
</div>
</a>
    </div>
  </div>
</nav>

<%
String name=(String)session.getAttribute("user");
if(name!=null)
{
out.println("<h2>Hello "+name+"</h2>");
}
%>
${msg}
<img src='<c:url value='/resources/images/shopping 2.png' />'  align="right" alt="This is image" width="650" height="300">
<h1>Add a product</h1>
<style>
table {
    width:50%;
}
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
table#t01 tr:nth-child(even) {
    background-color: #eee;
}
table#t01 tr:nth-child(odd) {
   background-color:#fff;
}
table#t01 th {
    background-color: black;
    color: white;
}
</style>
<c:url var="addAction" value="/manage_product_add"></c:url>
<form:form action="${addAction}" commandName="product"  method="post" enctype="multipart/form-data">
<table>
<tr>
 <td><form:label path="id"><spring:message text="ID"/></form:label></td>
  <td><form:input path="Id" pattern=".{2,20}" required="true" title="id should contain 2 to 20 character"/></td>
</tr>
 <tr>
  <td><form:label path="name"><spring:message text="Name"/></form:label> </td>
     <td><form:input path="name" required="true"/></td>
  </tr>
  <tr>
  <td><form:label path="price"><spring:message text="Price"/></form:label> </td>
     <td><form:input path="price" type="number" min="1" required="true"/></td>
  </tr>
   <tr>
  <td><form:label path="description"><spring:message text="Description"/></form:label> </td>
     <td><form:input path="description" required="true"/></td>
  </tr>
  
<tr>
  <td><form:label path="supplier_id"><spring:message text="supplier_id"/></form:label> </td>
     <td><form:input path="supplier_id"/></td>
  </tr>
  <tr>
  <td><form:label path="stock"><spring:message text="Stock" /></form:label> </td>
     <td><form:input path="stock" type="number" min="1" required="true"/></td>
  </tr>
   <tr>
  <td><form:label path="category_id"><spring:message text="category_id"/></form:label> </td>
     <td><form:input path="category_id" required="true"/></td>
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
     <h3>Product List</h3>
   <table class="tg" border="2">
   <tr><th width="80">Product ID</th>
   <th width="120">Product Name</th>
   <th width="120">Product Price</th>
   <th width="120">Category_ID</th>
   <th width="120">Supplier_ID</th>
   <th width="120">Stock</th>
   <th width="120">Product Description</th>
   <th width="120">Filename</th>
  
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
   <%out.println(c.getFilename()); %>
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