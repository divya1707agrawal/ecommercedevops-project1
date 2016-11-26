<!DOCTYPE html>
<html lang="en">
<head>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>





<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
  $http.get("cat")
  .then(function(response) {
      $scope.category = response.data;
  });
});
</script>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">ShoppingCart</a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="#">Product</a></li>
      <li><a href="#">About Us</a></li>
      <li><a href="#">Contact Us</a></li> 
      <li><a href="login">Login</a></li>
      <li><a href="#">Register</a></li> 
    </ul>
  </div>
</nav>
<br/>
	<br/>
	
 <div>
 <form class="navbar-form navbar-left">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
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
 <ul><li><a href="#">{{ x }} <span class="caret"></span>
 </a> <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          </li></ul></td> </tr>
 

</table>
</div></a>
    </div>
  </div>
</nav>



</body>
</html>