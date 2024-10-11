package com.libraryManagement.LibraryManagement.dao;

import com.libraryManagement.LibraryManagement.entity.Book;

import java.util.List;

public interface BookDAO {
    void save(Book book);

    Book findByID(Integer id);

    void findAll();

    void update(Book book);

    void delete(Book book);


}

