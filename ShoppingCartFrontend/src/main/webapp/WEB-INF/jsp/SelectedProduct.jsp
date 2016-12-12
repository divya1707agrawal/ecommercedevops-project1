<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- <c:set car="imageFolder" value="D:\\Shoppingcart\\Images\\"/> -->
<c:set var="imageFolder" value="resources/images/"/>
<table>
<tr>
<td>
<img act="${selectedProduct.name}" src="{imageFolder}${selectedProduct.id}.jpg">
</td>
<td><a class="col-xs-offset-S btn btn-lg btn-success" href="cart_checkout">checkout</a></td>
</tr>
<tr>
<td>Price:${selectedProduct.price}</td>
</tr>
<tr>
<td><a class="icon-shopping-cart" href="myCart/add/${selectedProduct.id}">Add To Cart</a></td>
</tr>
</table>
</body>
</html>