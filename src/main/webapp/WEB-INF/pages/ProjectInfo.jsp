<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
 
<html>
<head><title>${title}</title></head>
<body>

<c:forEach items="${project}" var="item">
      <div><h1><c:out value="${item.title}" /></h1></div>
                    </c:forEach>
          
            <table >
                <thead>
                    <tr>
                        <th><small>title:</small></th>
                        <th><small>Start Date</small></th>
                        <th><small>End Date</small></th>
                        <th><small>detail</small></th>
                        <th><small>createdBy</small></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <c:forEach items="${project}" var="item">
                        <td><small><c:out value="${item.title}" /></small></td>
                        <td><small><c:out value="${item.startDate}" /></small></td>
                        <td><small><c:out value="${item.endDate}" /></small></td>
                        <td><small><c:out value="${item.detail}" /></small></td>
                        <td><small><c:out value="${item.createdBy}" /></small></td></c:forEach>
                    </tr>
                  </tbody>
                </table>
           
            <h2>task</h2>
             <c:forEach items="${project}" var="item">
            <div><a href="/taskmanagement/user/projects/${item.project_id}/Task/"> create new</a></div>
            <h4>or Search with status</h4><div>
            <a href="/taskmanagement/user/projects/${item.project_id}/todo/">To DO</a>
            <a href="/taskmanagement/user/projects/${item.project_id}/wip/">WIP</a>
            <a href="/taskmanagement/user/projects/${item.project_id}/done/">DONE</a></div>
            </c:forEach>
 <div align="right">
  <c:if test="${pageContext.request.userPrincipal.name != null}">
     User Info : ${pageContext.request.userPrincipal.name}
         | <a href="<c:url value="/logout" />" >Logout</a>  
  </c:if></div>  
</body>
</html>