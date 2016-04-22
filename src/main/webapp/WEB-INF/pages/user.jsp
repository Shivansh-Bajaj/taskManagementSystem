<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Planner | SignUp</title>
      <meta name="viewport" content="width=device-width, initial-scale=1"> 
             <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" > 
             <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script> 
             <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" ></script> 
             <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
</head>
<body>
<div align="center">
<form:form method="POST" action="userRegistration">
	<div class="form-group">
	        <form:label path="user_name">User Name</form:label>
	        <form:input path="user_name" class="form-control"/>
	</div>
    <div class="form-group">
        
        <form:label path="RealName">real Name</form:label>
        <form:input path="RealName" class="form-control"/>
   	</div>
    <div class="form-group">
        <form:label path="email">E-mail</form:label>
        <form:input type="email" path="email" class="form-control"/>
    </div>
    <div class="form-group">
        <form:label path="password">password</form:label>
        <form:input type="password" path="password" class="form-control"/>
    </div>
        <button class="btn btn-default" type="submit" value="Submit"/>SUBMIT</button>
    
</form:form></div>
</body>
</html>