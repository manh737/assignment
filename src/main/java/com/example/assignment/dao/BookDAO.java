package com.example.assignment.dao;

import com.example.assignment.model.Book;
import com.example.assignment.utl.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookDAO {
    public void saveBook(Book book) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        } catch (Exception e) {
            if( transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void updateBook(Book book) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(book);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void deleteBook(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a book object
            Book book = session.get(Book.class, id);
            if (book != null) {
                session.delete(book);
                System.out.println("book is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public Book getBook(int id) {

        Transaction transaction = null;
        Book book = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get a book object
            book = session.get(Book.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return book;
    }

    @SuppressWarnings("unchecked")
    public List< Book > getAllBooks() {

        Transaction transaction = null;
        List < Book > listOfBooks = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get a book object

            listOfBooks = session.createQuery("from Book").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfBooks;
    }

}
