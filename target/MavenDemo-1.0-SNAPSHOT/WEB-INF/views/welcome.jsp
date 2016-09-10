<%-- 
    Document   : welcome
    Created on : Aug 17, 2016, 7:45:03 AM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div>
            <p>This can be accesed by every user</p>
        </div>
        <div>

            <sec:authorize access="hasRole('ADMIN')">
                <p>This can be accessed by admin user</p>
            </sec:authorize>
        </div>
        <div>
            <sec:authorize access="hasRole('DBA')">
                <p>This can be accessed by DBA only</p>
            </sec:authorize>
        </div>
        <div>
            <sec:authorize access="hasRole('DBA') and hasRole('ADMIN')">
                <p>This can be accessed by DBA and Admin only</p>
            </sec:authorize>
        </div>
        <a href="logout">Logout</a>

    </body>
</html>
