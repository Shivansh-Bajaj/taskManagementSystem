<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Planner | SignUp</title>
</head>
<body>
<div align="center">
<h2>Add project</h2>
<form:form method="POST" action="addTask/">
   <table border="4">
    <tr>
        <td><form:label path="createdBy">your User name</form:label></td>
        <td><form:input path="createdBy" /></td>
    </tr>
        <tr>
        <td><form:label path="startDate">startDate(mm/dd/yyyy):</form:label></td>
        <td><form:input type="date" path="startDate" /></td>
    </tr>
        <tr>
        <td><form:label path="endDate">endDate(mm/dd/yyyy):</form:label></td>
        <td><form:input type="date" path="endDate" /></td>
    </tr>
        <tr>
        <td><form:label path="detail">detail</form:label></td>
        <td><form:input path="detail" /></td>
    </tr>
    <tr>
        <td><form:label path="title">title</form:label></td>
        <td><form:input path="title" /></td>
    </tr>
    <tr>
        <td><form:label path="status">Status("todo","wip","done")</form:label></td>
        <td><form:input path="status" /></td>
    </tr>
    
    <tr>
        <td><form:label path="assignTo">assignTo</form:label></td>
        <td><form:input path="assignTo" /></td>
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