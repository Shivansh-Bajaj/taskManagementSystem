<html>
<head><title>Login</title>
 <meta name="viewport" content="width=device-width, initial-scale=1"> 
             <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" > 
             <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script> 
             <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" ></script> 
             <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
</head>
<body>
<c:if test="${messages}!=null"><div class="alert alert-warning">${messages}</div></c:if>
<div></div>
<h1>Login</h1>
<form name='f' action="j_spring_security_check" method='POST'>
  <div class="form-group">
    <label for="username"> username:</label>
    <input type='text' name='username' class="form-control"> 
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input  type='password' name='password' class="form-control">
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
    
</body>
</html>