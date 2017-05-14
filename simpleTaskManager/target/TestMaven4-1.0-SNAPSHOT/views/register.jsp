<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 17.03.2017
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<style>
    .error {
        color: #ff0000;
        font-style: italic;
    }
</style>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<sf:form method="post" modelAttribute="manager">
<%--enctype="multipart/form-data"--%>
    <fieldset>
        <table cellspacing="0">
            <%--Контейнер для строкт таблицы--%>
 <%--               <tr>

                    <td><sf:hidden path="user_id"/> </td>

                </tr>
            <tr>--%>
                <%--одна ячека таблицы--%><%--label устанавливает связь ячейки с элементом user_fill_name--%>

                <th><sf:label path="user_full_name">Full Name</sf:label></th>
                <td><sf:input path="user_full_name" size="15"/>
                <sf:errors path="user_full_name" cssClass="error"/>
                    </td>
            </tr>
            <tr>
                <th><sf:label path="user_login">Login</sf:label></th>
                <td><sf:input path="user_login" size="15"/>
                <sf:errors path="user_login" cssClass="error"/></td>
            </tr>
            <tr>
                <th><sf:label path="user_password">Password</sf:label></th>
                <td><sf:input path="user_password" size="15"/>
                <sf:errors path="user_password" cssClass="error"/></td>
            </tr>
            <tr>
                <th><sf:label path="user_email">Email</sf:label></th>
                <td><sf:input path="user_email" size="15"/>
                <sf:errors path="user_email" cssClass="error"/></td>
            </tr>
            <tr>
                <th><sf:label path="user_role">Speciality</sf:label></th>
                <td><sf:input path="user_role" size="15"/>
                <sf:errors path="user_role" cssClass="error"/></td>
            </tr>
                <tr>
                    <th></th>
                    <td><input name="commit" type="submit"
                               value="I accept. Create my account." /></td>
                </tr>
        </table>
    </fieldset>
</sf:form>
</body>
</html>
