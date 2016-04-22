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
  </c:if></div> <div align="center" class="jumbotron">
<c:forEach items="${project}" var="item">
      <div align="center"><h1><c:out value="${item.title}" /></h1></div>
                    </c:forEach>
          
            <table >
            <c:forEach items="${project}" var="item">
                <thead>
                    
                </thead>
                <tbody>
                    <tr><th><small>title</small></th>&nbsp
                        <td><small><c:out value="${item.title}" /></small></td> </tr>
                       <tr> <th><small>Start Date</small></th>&nbsp
                        <td><small><c:out value="${item.startDate}" /></small></td></tr>
                       <tr> <th><small>End Date</small></th>&nbsp
                        <td><small><c:out value="${item.endDate}" /></small></td> </tr>
                       <tr> <th><small>detail</small></th>&nbsp &nbsp
                       <td><small><c:out value="${item.detail}" /></small></td> </tr>
                       <tr> <th><small>createdBy</small></th>&nbsp
                        <td><small><c:out value="${item.createdBy}" /></small></td>
                   </tr>
                  </tbody>
                  </c:forEach>
                </table>
           </div>
            <h2>task</h2>
             <c:forEach items="${project}" var="item">
          <c:if test="${pageContext.request.userPrincipal.name==item.createdBy}"> <a href="/taskmanagement/user/projects/${item.project_id}/Task/"> <div class="alert alert-success"> create new</div></a><h4>or Search with status</h4></c:if>
           <div>
            <a href="/taskmanagement/user/projects/${item.project_id}/todo/"><div class="alert alert-warning">To DO</div></a>
            <a href="/taskmanagement/user/projects/${item.project_id}/wip/"><div class="alert alert-warning">WIP</div></a>
            <a href="/taskmanagement/user/projects/${item.project_id}/done/"><div class="alert alert-warning">DONE</div></a></div>
            </c:forEach> 
</body>
</html>