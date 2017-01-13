<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<table class="tg" border="2">
   <tr>
      <th align="left" width="80">PaymentMethod ID</th>
      <th align="left" width="80">PaymentMethod Type</th>
      <th align="left" width="80">OrderId</th>
      <th align="left" width="60">Action</th>
    </tr>

    <c:forEach items="${paymentmethod}" var="paymentmethod">                
    <tr>
       <td align="left">${paymentmethod.id}</td>
       <td align="left">${paymentmethod.methodtype}</td>
       <td align="left">${paymentmethod.orderid}</td>
       <td align="left"><a href="<c:url value='/paymentmethod/status?id=${paymentmethod.id}'/>">
       <c:choose>
       <c:when test="${not empty paymentmethod.status}">
       amount paid
       </c:when>
       <c:otherwise >
       amount not paid
       </c:otherwise>
       </c:choose>
       </a></td>
    </tr>
    </c:forEach>
 </table>
 <br>
 <br>
 <br>
</body>
</html>