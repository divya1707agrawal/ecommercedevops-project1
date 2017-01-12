
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="${flowExecutionUrl}">
<input type="hidden" name="_eventId" value="submitPaymentMethod">
<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />

<div class="container">

<div class="radio">
      <label><input type="radio" name="methodtype" value="cash">cash on delivery</label>
    </div>
    <div class="radio">
      <label><input type="radio" name="methodtype" value="online">online payment</label>
    </div>

<a href="paymentgateway">payment gateway</a>

     <div class="col-md-offset-3"></div>
     
    <input type="submit"  class="btn btn-md btn-success" value="save"> 
     <input type="submit" name="_eventId_cancel" class="btn btn-md btn_danger" value="Cancel">
    </div>
      </form>
     
</body>
</html>