<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 03.04.2017
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<style>
    .error {
        color: #ff0000;
        font-style: italic;
    }
</style>
<html>
<head>
    <title>Creating New Project</title>
</head>
<body>
<sf:form method="post" modelAttribute="project">
    <%--enctype="multipart/form-data"--%>
    <fieldset>
        <table cellspacing="0">
            <tr>
            <th><sf:label path="project_name">Project Name</sf:label></th>
            <td><sf:input path="project_name" size="15"/>
                <sf:errors path="project_name" cssClass="error"/>
            </td>
            <th></th>
            <td><input name="commit" type="submit"
                       value="Create new Project." /></td>
            </tr>
        </table>
    </fieldset>
</sf:form>
</body>
</html>
