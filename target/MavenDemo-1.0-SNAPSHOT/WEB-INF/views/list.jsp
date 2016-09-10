<%-- 
    Document   : list
    Created on : Aug 5, 2016, 10:18:49 AM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>


            </tbody>
            <c:forEach items="${users}" var="u">
                <tr>
                    <td>${u.firstName}</td>
                    <td>${u.lastName}</td>
                    <td>${u.email}</td>
                    <td><a href="edit-${u.id}">Edit</a></td>
                    <td><a href="delete?id=${u.id}">delete</a></td>

                </tr>

            </c:forEach>
        </table>
    </body>
</html>
