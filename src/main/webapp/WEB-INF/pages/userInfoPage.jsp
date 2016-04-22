<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
 
<html>
<head><title>${title}</title>
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
<div align="center"><h2>your Created Project<h2>

  <c:forEach items="${project}" var="item">
    
  <a href="${item.project_id}"+"/"><div class="alert alert-warning"><c:out value="${item.title}" /></div></a>
    
  </c:forEach>
<div>
</body>
</html>