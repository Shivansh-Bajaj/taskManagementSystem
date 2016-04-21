<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
 
<html>
<head><title>${title}</title></head>
<body>
  <h2>Message : ${message}</h2>
 
  <c:if test="${pageContext.request.userPrincipal.name != null}">
     <h3>Welcome : ${pageContext.request.userPrincipal.name}
         | <a href="<c:url value="/logout" />" >Logout</a></h3>  
  </c:if>  
</body>
</html>