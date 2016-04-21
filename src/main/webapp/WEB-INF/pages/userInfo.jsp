<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Planner | User Info</title>
</head>
<body>
<h2>User Info</h2>
<div><a href="/taskmanagement/createProject/">Create Projects</a>
<div><a href="/taskmanagement/user/projects/">your Projects</a>
<div><a href="/taskmanagement/user/search">search Projects</a>
<div align="right">
  <c:if test="${pageContext.request.userPrincipal.name != null}">
     User Info : ${pageContext.request.userPrincipal.name}
         | <a href="<c:url value="/logout" />" >Logout</a>  
  </c:if></div> 
</body>
</html>