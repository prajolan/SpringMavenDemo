<%-- 
    Document   : registration
    Created on : Aug 3, 2016, 7:32:46 AM
    Author     : Hp
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! Registration</h1>
        ${message}
        <br>
        <%
//               response.setIntHeader("Refresh", 1); This code will auto refresh the page

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sd = new SimpleDateFormat("MMMM");
            sd.format(cal.getTime());

            out.println(sd.format(cal.getTime()));
        %>
        <br>

        Today's date: <%= (new java.util.Date())%>

        <form:form method="POST" modelAttribute="user">
            <table>
                <form:input type="hidden" path="id"/>
                <tr>
                    <td><form:label path="firstName">First Name</form:label></td>
                    <td><form:input path="firstName" /></td>
                </tr>
                <tr>
                    <td><form:label path="lastName">Last Name</form:label></td>
                    <td><form:input path="lastName" /></td>
                </tr>
                <tr>
                    <td><form:label path="email">email</form:label></td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td><form:label path="username">Username</form:label></td>
                    <td><form:input path="username" /></td>
                </tr>
                <tr>
                    <td><form:label path="password">password</form:label></td>
                    <td><form:input path="password" type="password" /></td>
                </tr>
                <tr> 
                <label class="col-md-3 control-lable" for="userProfiles">Roles</label>
                
                <!--Here, itmes roles will be loaded from controller class, multiple=true means you can
                have multiple options being selected at the same time, itemValue=id means while sending request you will
                send the id value and itemLabel=type will show the name of the id such as Admin or DBA-->
                <form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm"/>
                
            </tr>
            <tr>



                <!--Option to show update or submit button according to test result-->
                <c:choose>
                    <c:when test= "${edit}">
                        <td colspan="2">
                            <input type="submit" value="Update"/>
                        </td>


                    </c:when>
                    <c:otherwise>
                        <td colspan="2">
                            <input type="submit" value="Submit"/>
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </table> 
        <c:if test="${edit}">
            <a href="<c:url value="/add-document-${userid}"/>">Upload Document</a>

        </c:if>
    </form:form>

</body>
</html>
