package ro.emanuel.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.book.helper.DBHelper;
import ro.emanuel.book.pojo.Book;

public class BookDao {

	// in dao adaug toate metodele de care ma voi folosi sa citesc, 
	// modific, inserez si sterg informatii din baza de date
	
    public static List<Book> getAllBooks() throws SQLException {
        List<Book> bookList = new ArrayList<>(); // conteaza daca deschid conexiunea dupa crearea listei?
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from book");
        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String author = rs.getString("author");
            int pages = rs.getInt("pages");
            Book buk = new Book(id, name, author, pages);
            bookList.add(buk);
        }
        DBHelper.closeConnection();        
        return bookList; // Trebuie sa inchid conexiunea inaintea return-ului?
    }
    
    public static int deleteOneBook(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        int deletedRows = stmt.executeUpdate("delete from book where id = " + id);
        DBHelper.closeConnection();
        return deletedRows; 
    }
    
    public static int createOneNewBook(Book bookToCreate) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "insert into book (name, author, pages) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, bookToCreate.getName()); 
        ps.setString(2, bookToCreate.getAuthor());
        ps.setInt(3, bookToCreate.getPages());
        int affectedRows = ps.executeUpdate();
        DBHelper.closeConnection();
        return affectedRows; 
    }
    
    public static int updateBook(Book book) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "update book set name= ?, author= ?, pages= ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, book.getName());
        ps.setString(2, book.getAuthor());
        ps.setInt(3, book.getPages());
        ps.setInt(4, book.getId());
        int rowsUpdated = ps.executeUpdate();
        DBHelper.closeConnection();
        return rowsUpdated; 
    }
    
    // Metoda care ia o carte dupa id
    public static Book getBookById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection(); // 1. deschidem conexiunea
        List<Book> book = getAllBooks(); // 2. creem o variabila de tip lista care ia valoarile din metoda getAllBooks()
        for(Book buk : book) { // 3. un for pentru a parcurge  fiecare carte din tabela
            if(buk.getId() == id) { // 4. daca id ul pus ca parametru e acelasi cu cel al cartii luate la rand, 
                return buk; // 5. se returneaza cartea respectiva
            }
        }
        return null; // 6. daca nu se gaseste, atunci da null
    }
    
}
