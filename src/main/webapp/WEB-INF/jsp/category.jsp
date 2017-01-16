<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

</head>
<body style="background-color: orange">
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="sec"
		uri="http://www.springframework.org/security/tags"%>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
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

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<script>
		var app = angular.module('myApp', []);
		app.controller('myCtrl', function($scope, $http) {
			$http.post("cat").then(function(response) {
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
				String user = (String) session.getAttribute("user");
				if (user == null) {
					out.println("<li><a href='login'>Login</a></li>");
					out.println("<li><a href=register>Register</a></li>");
				}
			%>
			<li><sec:authorize access="hasRole('ROLE_ADMIN')">
					<a href="category">Add Category</a>
				</sec:authorize></li>
			<li><sec:authorize access="hasRole('ROLE_ADMIN')">
					<a href="product?id=0">Add Product</a>
				</sec:authorize></li>
			<li><sec:authorize access="hasRole('ROLE_ADMIN')">
					<a href="supplier1">Add Supplier</a>
				</sec:authorize></li>
			<li><sec:authorize access="hasRole('ROLE_ADMIN')">
					<a href="paymentConfirmed">payment confirmation</a>
				</sec:authorize></li>
			<li><sec:authorize access="hasRole('ROLE_USER')">
					<a href="myCart/cart">View cart</a>
				</sec:authorize></li>
			<li><sec:authorize access="hasRole('ROLE_USER')">
					<a href="logout">Logout</a>
				</sec:authorize></li>
			<li><sec:authorize access="hasRole('ROLE_ADMIN')">
					<a href="logout">Logout</a>
				</sec:authorize></li>

		</ul>
	</div>
	</nav>
	<br />
	<br />
	<div>
		<form method="get" action="viewproduct"
			class="navbar-form navbar-left">
			<div class="form-group">
				<input type="text" name="name" class="form-control"
					placeholder="Search">

				<!--   <div ng-repeat="x in products">
         <%for (int i = 0; i < 50; i++) {%>
          <li><a href="viewproduct?name={{x.products[<%=i%>].name }}">{{ x.products[<%out.println(i);%>].name }}</a></li>
          <%}%> </div> -->

			</div>
		</form>
	</div>
	<br />
	<br />
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">
				<div ng-app="myApp" ng-controller="myCtrl">
					<table>
						<tr>
							<td ng-repeat="x in category">
								<ul>
									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" href="viewproduct?name={{ x.id }}">{{
											x.name }} <span class="caret"> </span>
									</a>
										<ul class="dropdown-menu">
											<%
												for (int i = 0; i < 50; i++) {
											%>
											<li><a
												href="viewproduct?name={{x.products[<%=i%>].name }}">{{
													x.products[<%
												out.println(i);
											%>].name }}
											</a></li>



											<%
												}
											%>
										</ul></li>
								</ul>
							</td>
						</tr>
					</table>
				</div>
			</a>
		</div>
	</div>
	</nav>

	<%
		String name = (String) session.getAttribute("user");
		if (name != null) {
			out.println("<h2>Hello " + name + "</h2>");
		}
	%>


	${msg}
	<img src='<c:url value='/resources/images/shopping 1.jpg' />'
		align="right" alt="This is image" width="500" height="200">
	<h1>Add a Category</h1>

	<c:url var="addAction" value="/manage_category_add"></c:url>
	<form:form action="${addAction}" commandName="category"
		enctype="multipart/form-data" method="post">
		<table>
			<tr>
				<td><form:label path="id">
						<spring:message text="ID" />
					</form:label></td>
				<c:choose>
					<c:when test="${!empty category.id}">
						<td><form:input path="id" disabled="true" readonly="true" /></td>
					</c:when>
					<c:otherwise>
						<td><form:input path="id" pattern=".{5,20}" required="true"
								title="id should contain 5 to 20 character" /></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td><form:label path="name">
						<spring:message text="NAME" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="description">
						<spring:message text="Description" />
					</form:label></td>
				<td><form:input path="description" required="true" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty category.name}">
						<input type="submit"
							value="<spring:message text="Update Category"/>" />
					</c:if>
					<c:if test="${empty category.name}">
						<input type="submit" value="<spring:message text="Add Category"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	</br>
	<!--   <script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
  $http.get("cat")
  .then(function(response) {
      $scope.category = response.data;
  });
});
</script>-->
	<img src='<c:url value='/resources/images/shopping 2.png' />'
		align="right" alt="This is image" width="650" height="220">
	<h3>Category List</h3>

	<style>
table {
	width: 50%;
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
	background-color: #fff;
}

table#t01 th {
	background-color: black;
	color: white;
}
</style>
	<table class="tg" border="2">
		<tr>
			<th width="80">Category ID</th>
			<th width="120">Category Name</th>
			<th width="120">Category Description</th>
			<th width="60">Delete</th>
			<th width="60">Edit</th>

		</tr>

		<%
			java.util.List<com.niit.shoppingcart.controller.Category> lst = (java.util.List) request
					.getAttribute("list");
			for (com.niit.shoppingcart.controller.Category c : lst) {
		%>
		<tr>
			<td>
				<%
					out.println(c.getId());
				%>
			</td>
			<td>
				<%
					out.println(c.getName());
				%>
			</td>
			<td>
				<%
					out.println(c.getDescription());
				%>
			</td>
			<td><a
				href='manage_category_remove/?id=<%out.println(c.getId());%>'>delete</a>
			</td>
			<td><a href='editcategory?id=<%out.println(c.getId());%>'>edit</a>
			</td>
		</tr>
		<%
			}
		%>
</table>
</body>
</html>