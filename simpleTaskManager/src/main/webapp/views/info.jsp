<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 17.03.2017
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head>
</head>
<title>Title</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
    function loadProjects() {
        $.ajax({
            url: "showProjects.htm",
            async: false,
            data: {id: 17},
            success: function () {
                $("#result").html();
            }
        })
</script>
<body>
<%--${manager.user_id}
${manager.user_email}--%>
${manager.user_full_name}

<a href="http://localhost:8080/managers/manager?new">Create new Project</a>
<%--<c:forEach var="project" items="${projects}">
    ${project.project_id}
    ${project.project_name}
</c:forEach>--%>

<button onclick="loadProjects()">Show my projects</button>

<div id="result">

</div>
</body>
</html>
