<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book Management Application</title>
</head>
<body>
<center>
    <h1>Book Management</h1>
    <h2>
        <a href="list">List All books</a>

    </h2>
</center>
<div align="center">
    <c:if test="${book != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${book == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${book != null}">
                            Edit Book
                        </c:if>
                        <c:if test="${book == null}">
                            Add New Book
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${book != null}">
                    <input type="hidden" name="id" value="<c:out value='${book.id}' />" />
                </c:if>
                <tr>
                    <th>Book Name: </th>
                    <td>
                        <input type="text" name="name" size="45" required
                               value="<c:out value='${book.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Author: </th>
                    <td>
<%--                        <select name="author">--%>
<%--                            <c:forEach var="author" items="${listAuthor}">--%>
<%--                                <option value="<c:out value="${author.id}" />"><c:out value="${author.lastName}" /></option>--%>
<%--                            </c:forEach>--%>
<%--                        </select>--%>
                        <input type="text" name="author" size="45" required
                               value="<c:out value='${book.author}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>