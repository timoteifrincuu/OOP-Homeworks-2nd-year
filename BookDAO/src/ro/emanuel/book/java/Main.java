package ro.emanuel.book.java;

import java.sql.SQLException;
import java.util.List;

import ro.emanuel.book.dao.BookDao;
import ro.emanuel.book.pojo.Book;

public class Main {

	public static void main(String[] args) throws SQLException {
	
		List<Book> books = BookDao.getAllBooks();
        System.out.println("Lista cartilor:");
        for (Book b : books) {
            System.out.println(b);
        }        
        
        System.out.println("=====================");
        
        Book newBook = new Book("Jucatorul", "Feodor Dostoievski", 200);
        BookDao.createOneNewBook(newBook);
        Book newBook2 = new Book("Crima si Pedeapsa", "Feodor Dostoievski", 500);
        BookDao.createOneNewBook(newBook2);
        Book newBook3 = new Book("Insemnari din Subterana", "Feodor Dostoievski", 230);
        BookDao.createOneNewBook(newBook3);
        int rowsInserted = BookDao.createOneNewBook(newBook3);
        System.out.println("Book nou a fost creat. Rinduri inserate: " + rowsInserted);
       
        System.out.println("=====================");

        Book nBook = BookDao.getBookById(1);
        System.out.println("Book gasit dupa ID: " + nBook);
      
        System.out.println("=====================");

        // nu inteleg cum functioneaza update method... 
        // cum se updateaza o carte daca eu nu ii dau id-ul?
        // am pus idu la inceput, mere amu?
        Book bookToUpdate = new Book(3, "Adolescentul", "Feodor Dostoievski", 560);
        int rowsUpdated = BookDao.updateBook(bookToUpdate);
        System.out.println("Book a fost actualizat. Rinduri updatate: " + rowsUpdated);
        nBook = BookDao.getBookById(3);
        System.out.println("Book actualizat: " + nBook);
       
        System.out.println("=====================");
        
        int rowsDeleted = BookDao.deleteOneBook(4);
        System.out.println("Book a fost sters. Rinduri sterse: " + rowsDeleted);
	}

}
