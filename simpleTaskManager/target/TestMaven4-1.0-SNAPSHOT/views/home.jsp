<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 15.03.2017
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags"%>--%>

<html>
<%--<!DOCTYPE html>--%>
    <title>Title</title>
    <!--[if lt IE 7]>      <html lang="en" ng-app="app" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
    <!--[if IE 7]>         <html lang="en" ng-app="app" class="no-js lt-ie9 lt-ie8"> <![endif]-->
    <!--[if IE 8]>         <html lang="en" ng-app="app" class="no-js lt-ie9"> <![endif]-->
    <!--[if gt IE 8]><!--> <html lang="en" ng-app="app" class="no-js"> <!--<![endif]-->
<head>
<%--    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Spring and Angularjs Tutorial</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <link rel="stylesheet" href="../css/app.css">
    <%--<base href="/">--%>
</head>


<body>
<%--<c:forEach var="manager" items="${managers}">
    ${manager.user_full_name}
    ${manager.user_email}
    ${manager.user_id}
</c:forEach>
<a href="http://localhost:8080/managers/manager?id=1">Info about 1st manager</a>
<a href="http://localhost:8080/managers?new">Register as manager</a>
<%@include file="home.html"%>--%>
<%--
<sf:form method="post" modelAttribute="loginClass">
    <fieldset>
        <table cellspacing="0">
            <tr>
                <th><sf:label path="login">Login</sf:label></th>
                <td><sf:input path="login" size="15"/>
            </tr>
            <tr>
                <th><sf:label path="password">Password</sf:label></th>
                <td><sf:input path="password" size="15"/>
            </tr>
            <tr>
                <th></th>
                <td><input name="commit" type="submit"
                           value="Log In" /></td>
            </tr>
        </table>
    </fieldset>
</sf:form>
--%><%--
<sec:authorize access="hasRole('ROLE_MANAGER')">--%>
<%--<a href="http://localhost:8080/register?new">Register</a>
<a href="http://localhost:8080/login">Enter</a>--%>

<div class="home-section">
    <ul class="menu-list">
        <li><a href="#/projects">Show Projects</a></li>
        <li><a href="#/createProject">Create Project</a></li>
        <li><a href="#/tasks">Show tasks</a></li>
        <li><a href="#/createTask">Create task</a></li>
        <li><a href="#/findDeveloper">Find Developer</a></li>
    </ul>
</div>
<div ng-view></div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-resource.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
<script src="../js/app.js"></script>
<script src="../js/controller.js"></script>
</body>
</html>
