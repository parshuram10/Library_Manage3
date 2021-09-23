package model;

import java.util.HashSet;
import java.util.Set;

public class Book {
	
	private Integer id;
	private String title;
	private String author;
	private Integer price;
	
	public Book() {
		
	}
	public Book(Integer id, String title, String author, Integer price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	private static Set<Book> books;
	
	static{
		books = new HashSet<>();
		books.add(new Book(1,"Harry Poter","JK Crowns",230));
		books.add(new Book(2,"Java","Dennies Ritchie",130));
	}
	
	public static Set<Book> allBooks(){
		return books;
	}
	
	public static Book findById(Integer id) {
		for(Book book: books) {
			if(id.equals(book.id)) {
				return book;
			}
		}
		return null;
	}
	
	public static void addBook(Book book) {
		books.add(book);
	}
	
	public static boolean removeBook(Book book) {
		return books.remove(book);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
