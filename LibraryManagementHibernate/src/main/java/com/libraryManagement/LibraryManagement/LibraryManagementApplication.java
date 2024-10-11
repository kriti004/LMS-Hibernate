package com.libraryManagement.LibraryManagement;

import com.libraryManagement.LibraryManagement.dao.BookDAO;
import com.libraryManagement.LibraryManagement.entity.Book;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.Scanner;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

//	private LibraryFunc libraryFunc;
//
//	@Autowired
//	public LibraryManagementApplication(LibraryFunc libraryFunc) {
//		this.libraryFunc = libraryFunc;
//	}
//
//

	private Book book;

	@Autowired
	public LibraryManagementApplication(Book book) {
		this.book = book;
	}

	@Bean
	public CommandLineRunner CommandLineRunner(BookDAO bookDAO){
		return runner ->{
			read(bookDAO);
		};
	}

	private void read(BookDAO bookDAO) {
		bookDAO.findAll();
	}

	private void delete(BookDAO bookDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id of book you wanna delete");
		int id = sc.nextInt();
		bookDAO.delete(bookDAO.findByID(id));
	}

	private void update(BookDAO bookDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id of book you wanna change");
		int id = sc.nextInt();
		Book temp  = bookDAO.findByID(id);
		System.out.println("Enter the book title an author");
		temp.setTitle(sc.nextLine());
		temp.setAuthor(sc.nextLine());
		bookDAO.update(temp);
		System.out.println(temp);
	}

	private void addBook(BookDAO bookDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the book title");
		book.setTitle(sc.nextLine());
		System.out.println("Enter the book author");
		book.setAuthor(sc.nextLine());
		System.out.println("Enter the book isbn");
		book.setIsbn(sc.nextLine());
		System.out.println("Enter the book date");
		book.setPublicationDate(sc.nextLine());
		Book book1 = new Book(book.getTitle(),book.getAuthor(),book.getAuthor(),book.getPublicationDate());
		bookDAO.save(book1);
	}
}
