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

 <form>
  <div class="form-group">
      <label for="" class="contro-label col-sm-2">Address:</label>
     <div class="col-sm-10">
     <form:errors path="address" class="error" />
      <input type="text" path="address" id="Address" placeholder="Enter Address">
    </div></div>
    <div class="form-group">
      <label for="city">City:</label>
      <input type="city" class="form-control" id="city" placeholder="Enter city">
    </div>
    <div class="form-group">
      <label for="country">Country:</label>
      <input type="country" class="form-control" id="city" placeholder="Enter country">
    </div>
     <div class="form-group">
      <label for="zipcode">Zipcode:</label>
      <input type="zipcode" class="form-control" id="zipcode" placeholder="Enter zipcode">
    </div>
     <div class="col-md-offset-3">
     <input type="submit" name="_eventId_submitShippingAddress" class="btn btn-md btn-success" value="save">
     <input type="submit" name="_eventId_cancel" class="btn btn-md btn_danger" value="Cancel">
    </div>
      </form>
</body>
</html>