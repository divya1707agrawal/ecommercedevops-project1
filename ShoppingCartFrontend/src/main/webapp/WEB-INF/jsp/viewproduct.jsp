<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
  $http.get("viewproduct")
  .then(function(response) {
      $scope.product = response.data;
  });
});
</script>
 <%
   java.util.List<com.niit.shoppingcart.controller.Product> lst=(java.util.List)request.getAttribute("list");
   for(com.niit.shoppingcart.controller.Product c:lst)
   {
   %>
    <tr >
   <td>
  <%out.println(c.getPrice()); %>
   </td></tr>
   <%
   }
   %>
 <div ng-app="myApp" ng-controller="myCtrl"> 
 <table> 
 <tr><td ng-repeat="p in product">
      {{ p.price }}
 </td> </tr>
 </table>
</div>
<jsp:forward page="viewproductdata"/>
</body>
</html>