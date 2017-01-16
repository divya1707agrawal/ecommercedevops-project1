 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>
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


<h2>About us</h2>
<h4 style="background-color:#00FFFF">
<p>
<table>
<th><td>
  <div class="item active">
        <img src='<c:url value='/resources/images/10.jpg' />' alt="This is image" width="250" 

height="250"></td></th>
 <th><td>  <h4>  
The shoppingcart.com marketplace is operated by Shoppingcart Seller Services Private Ltd.
Shoppingcart.com seeks to build the most 
customer-centric online destination for customers to find and discover virtually anything 
they want to buy online by giving them more of what they want – vast selection, low prices,
 fast and reliable delivery, and a trusted and convenient experience; and provide sellers 
 with a world-class e-commerce platform.</h4>  </div>
</td></th></table></p>
<p><table>
<th><td>
<div class="item active">
        <img src='<c:url value='/resources/images/8.jpg' />' alt="This is image" width="300" 

height="300"></td></th>
 <th><td>    
<h4>     
All Consumers on Shoppingcart.com and the shoppingcart Mobile Shopping App for Android and iOS have an 
easy and convenient access to 80 million products across hundreds of categories. 
They benefit from a safe and secure ordering experience, convenient electronic payments, 
Cash on Delivery, Shoppingcart's 24x7 customer service support, and a globally recognized and 
comprehensive 100% purchase protection provided by Shoppingcart's A-to-Z Guarantee. 
They can also enjoy Shoppingcart.com's guaranteed next-day, two day delivery, Sunday and Morning 
delivery on products fulfilled by Shoppingcart. 
</h4> </div></td></th></table></p>

<p><u>Contact Shoppingcart India</u><br/><br/>
For customer service:Shoppingcart Customer Service<br/><br/>

For queries regarding selling on Shoppingcart: Shoppingcart Services<br/><br/>

Registered office address: <br/>
BittenMarket <br/>
Bhopal<br/>
India 
</p></h4>
</body>
</html>

