<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Planner | User Info</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
             <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" > 
             <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script> 
             <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" ></script> 
             <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
</head>
<body>
<div align="right">
  <c:if test="${pageContext.request.userPrincipal.name != null}">
     User Info : ${pageContext.request.userPrincipal.name}
         | <a href="<c:url value="/logout" />" >Logout</a>  
  </c:if></div>
<h2>Projects</h2>
<div class="alert alert-warning"><a href="/taskmanagement/createProject/">Create Projects</a></div>
<div class="alert alert-danger"><a href="/taskmanagement/user/projects/">your Projects</a></div>
<div class="alert alert-success"><a href="/taskmanagement/user/search/">search Projects</a></div>
 
</body>
</html>