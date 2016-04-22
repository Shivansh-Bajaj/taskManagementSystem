<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
 
<html>
<head><title>${title}</title>
<meta name="viewport" content="width=device-width, initial-scale=1"> 
             <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" > 
             <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script> 
             <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" ></script> 
             <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> </head>
<body>
 <div align="right">
  <c:if test="${pageContext.request.userPrincipal.name != null}">
     User Info : ${pageContext.request.userPrincipal.name}
         | <a href="<c:url value="/logout" />" >Logout</a>  
  </c:if></div>  
<c:forEach items="${taskDetail}" var="item">
      <div align="center"><h1><c:out value="${item.title}" /></h1></div>
                    </c:forEach>
          <div align="center" class="jumbotron ">
           <c:forEach items="${taskDetail}" var="item">
                <thead>
                    
                </thead>
                <tbody>
                    <tr><th>title:</th>&nbsp
                        <td><c:out value="${item.title}" /></td> </tr><br />
                       <tr> <th>Start Date:</small></th>&nbsp
                        <td><c:out value="${item.startDate}" /></td></tr><br />
                       <tr> <th>End Date:</small></th>&nbsp
                        <td><c:out value="${item.endDate}" /></td> </tr><br />
                       <tr> <th>detail:</small></th>&nbsp &nbsp
                       <td><small><c:out value="${item.detail}" /></td> </tr><br />
                       <tr> <th>createdBy:</small></th>&nbsp
                        <td><c:out value="${item.createdBy}" /></td></tr><br />
                        <tr> <th>status:</small></th>&nbsp
                        <td><c:out value="${item.status}" /></td></tr><br />
                   
                  </tbody>
                  </c:forEach>
          </div>
          <div><h2>Comments</h2>
          <c:forEach items="${comments}" var="item">
          	<div>
          		<div><b>${item.user_name}</b>
          		<small>${item.detail}</small>
          		</div>
          	</div>
          	</c:forEach>
          </div>
          <div class="col-md-12"><div><h3>add comment:</h3>
<div ><form method="get" action="addcomment"><input type='text' name='comment' class="form-control"> </div><input type="submit" value="add"></form></div>

<c:forEach items="${taskDetail}" var="item"></div>
         <c:if test="${pageContext.request.userPrincipal.name==item.createdBy}"> <div class="col-md-6"><div><h3>change status("todo","wip","done"):</h3>
<div ><form method="get" action="ChangeStatus"><input type='text' name='status' class="form-control"></form> </div><input type="submit" value="change"></div>
 </div></c:if></c:forEach>
</body>
</html>