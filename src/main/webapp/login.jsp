<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<center>
</center>
<div align="center">
    <c:if test="${message != null}">
        <h2><c:out value="${message}" /></h2>

    </c:if>
    <form action="login" method="post">
            <table border="1" cellpadding="5">
                <tr>
                    <th>UserName: </th>
                    <td>
                        <input type="text" name="username" size="45" required />
                    </td>
                </tr>
                <tr>
                    <th>Password: </th>
                    <td>
                        <input type="password" name="password" size="45" required />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Login" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>