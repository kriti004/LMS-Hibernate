package com.libraryManagement.LibraryManagement.dao;

import com.libraryManagement.LibraryManagement.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private EntityManager entityManager;

    @Autowired
    public BookDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Book book) {
        entityManager.persist(book);
    }

    @Override
    public Book findByID(Integer id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public void findAll() {
        TypedQuery<Book> theQuery = entityManager.createQuery("FROM Book", Book.class);
        System.out.println(theQuery.getResultList());
    }

    @Override
    @Transactional
    public void update(Book book) {
        entityManager.merge(book);
    }


    @Override
    @Transactional
    public void delete(Book book) {
        entityManager.remove(book);
    }
}
