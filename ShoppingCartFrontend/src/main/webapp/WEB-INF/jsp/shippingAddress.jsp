<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ShippingAddress page</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

  <form method="post" action="${flowExecutionUrl}">
<input type="hidden" name="_eventId" value="submitShippingAddress">
<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
 <h4>Enter your Shipping Address</h4>
 
  <div class="form-group">
      <label for="" class="contro-label col-sm-2">Hno:</label>
     <div class="col-sm-10">
      <input type="text" name="hno" placeholder="Enter House number" required="true">
    </div></div>
    
    <div class="form-group">
      <label for="" class="contro-label col-sm-2">Street:</label>
     <div class="col-sm-10">
      <input type="text" name="street" placeholder="Enter Street" required="true">
    </div></div>
    
     <div class="form-group">
      <label for="" class="contro-label col-sm-2">city:</label>
     <div class="col-sm-10">
      <input type="text" name="city" placeholder="Enter city" required="true">
    </div></div>
    
      
    
     <div class="form-group">
      <label for="" class="contro-label col-sm-2">country:</label>
     <div class="col-sm-10">
      <input type="text"name="country" placeholder="Enter country" required="true">
    </div></div>
    
     <div class="form-group">
      <label for="" class="contro-label col-sm-2">zipcode:</label>
     <div class="col-sm-10">
      <input type="text" name="pin" placeholder="Enter zipcode" required="true">
    </div></div>
   
     <div class="col-md-offset-3">
     <input type="submit"  class="btn btn-md btn-success" value="save">
     <input type="submit" name="_eventId_cancel" class="btn btn-md btn_danger" value="Cancel">
    </div>
      </form>
</body>
</html>