package com.example.assignment.dao;

import com.example.assignment.model.Author;
import com.example.assignment.utl.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AuthorDao {
    public void saveAuthor(Author author) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        } catch (Exception e) {
            if( transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void updateAuthor(Author author) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(author);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void deleteAuthor(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete an author object
            Author author = session.get(Author.class, id);
            if (author != null) {
                session.delete(author);
                System.out.println("author is deleted");
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
    public Author getAuthor(int id) {

        Transaction transaction = null;
        Author author = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an author object
            author = session.get(Author.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return author;
    }

    @SuppressWarnings("unchecked")
    public List< Author > getAllAuthors() {

        Transaction transaction = null;
        List < Author > listOfAuthors = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get a author object

            listOfAuthors = session.createQuery("from Author").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfAuthors;
    }

}
