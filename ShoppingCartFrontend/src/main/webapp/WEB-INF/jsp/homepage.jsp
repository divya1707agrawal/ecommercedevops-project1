<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
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
  
<body>




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
}
%>
      <li><a href="register">Register</a></li> 
      <li> <sec:authorize access="hasRole('ROLE_ADMIN')"><a href="category">Add Category</a></sec:authorize></li>
      <li><sec:authorize access="hasRole('ROLE_ADMIN')"><a href="product?id=0">Add Product</a></sec:authorize></li>
      <li><sec:authorize access="hasRole('ROLE_ADMIN')"><a href="supplier1">Add Supplier</a></sec:authorize></li>  
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



<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-

ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" 

class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src='<c:url value='/resources/images/8.jpg' />' alt="This is image" width="460" 

height="345">
      </div>

      <div class="item">
       <img src='<c:url value='/resources/images/laptop15.jpeg' />' alt="This is image" width="460" 

height="345">
      </div>
    
      <div class="item">
       <img src='<c:url value='/resources/images/image2.jpeg' />' alt="This is image" width="460" 

height="345">
      </div>

      <div class="item">
       <img src='<c:url value='/resources/images/image4.jpeg' />' alt="This is image" width="460" 

height="345">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" 

role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-

hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" 

role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-

hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
</body>
</html>