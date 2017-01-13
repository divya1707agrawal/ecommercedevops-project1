<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
        <h1>Successfully added to cart!</h1>
    </div>
    
    <h4>For confirmation click on confirm button</h4>
      <a href="/ShoppingCartFrontend/cart_checkout">
         Make Payment
    </a>
     <a href="cart">
      <input type="submit" value='<spring:message text="view cart"/>' />
    </a>
     
</body>
</html>