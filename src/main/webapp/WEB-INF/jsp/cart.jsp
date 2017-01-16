<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart page</title>
</head>
<body>
 

<table class="tg" border="2">
   <tr>
      <th align="left" width="80">Cart ID</th>
      <th align="left" width="80">Product Name</th>
      <th align="left" width="80">Price</th>
      <th colspan="2" align="center" width="60">Action</th>
    </tr>
  <!-- ${cartList}  -->
    <c:forEach items="${cartList}" var="cart">                
    <tr>
       <td align="left">${cart.id}</td>
       <td align="left">${cart.productName}</td>
       <td align="left">${cart.price}</td>
       <td align="left"><a href="<c:url value='/myCart/delete?id=${cart.id}'/>">Delete</a></td>
    </tr>
    </c:forEach>
 </table>
 <h2>Total cost:${totalAmount}</h2>
 <br>
 <br>
 <br>
</body>
</html>