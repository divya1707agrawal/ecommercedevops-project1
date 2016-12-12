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
  PRICE:<%out.println(c.getPrice()); %>
   </td></tr>
   <tr >
   <td>
  DESCRIPTION:<%out.println(c.getDescription()); %>
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
   <tr>
   <td>
   
   </td>
   </tr>
</table>
 <img src='<c:url value='${requestScope.img}' />' alt="Chania" width="460" height="345">
 <a href="<c:url value='${requestScope.id}'/>">Add to cart</a>
</body>
</html>