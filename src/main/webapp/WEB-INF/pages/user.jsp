<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Planner | SignUp</title>
</head>
<body>
<div>
<h2>User SignUp</h2>
<form:form method="POST" action="userRegistration">
   <table>
    <tr>
        <td><form:label path="user_name">User Name</form:label></td>
        <td><form:input path="user_name" /></td>
    </tr>
        <tr>
        <td><form:label path="RealName">real Name</form:label></td>
        <td><form:input path="RealName" /></td>
    </tr>
        <tr>
        <td><form:label path="email">E-mail</form:label></td>
        <td><form:input type="email" path="email" /></td>
    </tr>
    <tr>
        <td><form:label path="password">password</form:label></td>
        <td><form:input type="password" path="password" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>
</form:form></div>
</body>
</html>