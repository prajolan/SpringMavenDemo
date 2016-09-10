<%-- 
    Document   : ManageDocument
    Created on : Aug 8, 2016, 10:34:25 AM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form method="POST" modelAttribute="filebucket" enctype="multipart/form-data">
            <table>
                <%--<form:input type="hidden" path="id"/>--%>
                <thead>
                    <tr>
                <th>Sn</th>
                <th>Content</th>
                <th>Description</th>
                <th>File Name</th>
                <th>Type</th>
                    </tr>
            </thead>
            <tbody>
                
            <c:forEach items="${documents}" var="documents">
                <tr>
                <td>${documents.id}</td>
                <td>${documents.content}</td>
                <td>${documents.description}</td>
                <td>${documents.fileName}</td>
                <td>${documents.type}</td>
                <td><a href="<c:url value="/download-document-${documents.id}"></c:url>">Download</a></td>
                <td><a href="<c:url value="/delete-document-${documents.id}"></c:url>">Delete</a></td>
                </tr>
                </c:forEach>
                
                
            </tbody>
        </table>
                <table>
                    <td><form:input path="file" type="file" /></td>
                </tr> 
            </table>
            <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>
