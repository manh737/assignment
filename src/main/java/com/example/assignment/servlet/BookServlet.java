package com.example.assignment.servlet;

import com.example.assignment.dao.AuthorDao;
import com.example.assignment.dao.BookDAO;
import com.example.assignment.model.Author;
import com.example.assignment.model.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = {"/book/*"})
public class BookServlet extends HttpServlet {
    private BookDAO bookDAO;
//    private AuthorDao authorDao;


    public void init() {
        bookDAO = new BookDAO();
//        authorDao = new AuthorDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/delete":
                    deleteBook(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                default:
                    listBooks(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        try {
            switch (action) {
                case "/insert":
                    insertBook(request, response);
                    break;
                case "/update":
                    updateBook(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Book> listBooks = bookDAO.getAllBooks();
        request.setAttribute("listBooks", listBooks);
        request.getRequestDispatcher("/book-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
//        List<Author> listAuthor = authorDao.getAllAuthors();
//        request.setAttribute("listAuthor", listAuthor);
        request.getRequestDispatcher("/book-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book existingBook = bookDAO.getBook(id);
        request.setAttribute("book", existingBook);
//        List<Author> listAuthor = authorDao.getAllAuthors();
//        request.setAttribute("listAuthor", listAuthor);
        request.getRequestDispatcher("/book-form.jsp").forward(request, response);

    }
    private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        Book newBook = new Book(name, author);
        bookDAO.saveBook(newBook);
        response.sendRedirect("list");
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String author = request.getParameter("author");

        Book book = new Book(id, name, author);
        bookDAO.updateBook(book);
        response.sendRedirect("list");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookDAO.deleteBook(id);
        response.sendRedirect("list");
    }
}
