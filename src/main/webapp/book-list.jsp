<%--
  Created by IntelliJ IDEA.
  User: manh
  Date: 12/11/2021
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book Management Application</title>
</head>
<body>
<center>
    <h1>Book Management</h1>
    <h2>
        <a href="new">Add New Book</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Books</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Books</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Author</th>
        </tr>
        <c:forEach var="book" items="${listBooks}">
            <tr>
                <td><c:out value="${book.id}" /></td>
                <td><c:out value="${book.name}" /></td>
                <td><c:out value="${book.author_id}" /></td>
                <td>
                    <a href="edit?id=<c:out value='${book.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${book.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>