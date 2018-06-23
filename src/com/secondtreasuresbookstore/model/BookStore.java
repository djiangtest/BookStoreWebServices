package com.secondtreasuresbookstore.model;


import java.util.Hashtable;
import java.util.Map;

public class BookStore {
	
	private Map<String, Book> books = new Hashtable<String, Book>();
	
	public final static BookStore store = new BookStore();
	
	private BookStore() {
	}
	
	public synchronized int addBook(Book book) {
		if(books.get(book.getIsbn()) == null) {
			books.put(book.getIsbn(), book);
			return 0;
		}
		return 1;	
	}
	
	public Book getBookByID(String isbn) {
		return books.get(isbn);
	}
	
	public Book[] getAllBooks(){
		return books.values().toArray(new Book[0]);
	}
	
	public synchronized int removeBook(String isbn) {
		Book booktobeUpdated = books.get(isbn);
		if(booktobeUpdated != null) {
			books.remove(isbn);
			return 0;
		}
		return 1;
	}
	
	public synchronized int updateBook(Book book) {
		Book booktobeUpdated = books.get(book.getIsbn());
		if(booktobeUpdated != null) {
			 booktobeUpdated.setAuthor(book.getAuthor());
			 booktobeUpdated.setGenre(book.getGenre());
			 booktobeUpdated.setTitle(book.getTitle());
			 booktobeUpdated.setPrice(book.getPrice());
			 return 0;
		}
		return 1;
	}
}
