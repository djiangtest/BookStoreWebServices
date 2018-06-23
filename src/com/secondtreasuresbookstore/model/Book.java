package com.secondtreasuresbookstore.model;


public class Book {

	private String isbn;
	private String title;
	private String genre;
	private String author;
	private double price;
	
	public Book () {
	}

	public Book(String isbn, String title, String genre, String author, double price) {
		this.isbn = isbn;
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.price = price;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}			

}