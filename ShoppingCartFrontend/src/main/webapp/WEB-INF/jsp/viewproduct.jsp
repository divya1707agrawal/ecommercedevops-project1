<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>


 <%
   java.util.List<com.niit.shoppingcart.controller.Product> lst=(java.util.List)request.getAttribute("prlist");
   for(com.niit.shoppingcart.controller.Product c:lst)
   {
   %>
   <table class="tg" border="2">
   <tr >
   <td>
  NAME:<%out.println(c.getName()); %>
   </td></tr>
    <tr >
   <td>
  PRICE:<%out.println(c.getPrice());%>
   </td></tr>
   <tr >
   <td>
  DESCRIPTION:<%out.println(c.getDescription()); %>
   </td></tr>
   
    <tr >
   <td>
  		TOTAL AVAILABLE STOCK:<%out.println(c.getStock()); %>
   </td></tr>
    <%
   java.io.FileOutputStream fout=new java.io.FileOutputStream("D:\\demo project\\sample55\\ShoppingCartFrontend\\src\\main\\webapp\\resources\\images\\"+c.getFilename());
    byte[] bt=c.getContent();
    fout.write(bt);
    fout.flush();
    String imgname="/resources/images/"+c.getFilename();
    request.setAttribute("img",imgname);
    request.setAttribute("id",c.getId());
   }
   %>
   
</table>
 <img src='<c:url value='${requestScope.img}' />' alt="Chania" width="460" height="345">
<!--  <spring:form method='POST' action="myCart" commandName="addcart">
 <input type='hidden' name="id" value="${requestScope.id}"/>
 <input type='submit' value='add to cart'/>
 </spring:form> -->
 <a class="icon-shopping-cart" href="myCart/add?id=${requestScope.id}">Add To Cart</a>
 
</body>
</html>