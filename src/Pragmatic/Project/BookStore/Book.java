package Pragmatic.Project.BookStore;

import java.util.UUID;

public class Book {
	private UUID id;
	private String title;
	private String author;
	private double price;
	private String publisher;
	private String origin;
	private int stock;

	public Book(String title, String author, double price, String publisher,
			String foreign, int stock) {
		this.id = UUID.randomUUID();
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.origin = foreign;
		this.stock = stock;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String newTitle) {
		this.title = newTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String newAuthor) {
		this.author = newAuthor;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int newPrice) {
		this.price = newPrice;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String newPublisher) {
		this.publisher = newPublisher;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String newOrigin) {
		this.origin = newOrigin;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int newStock) {
		this.stock = newStock;
	}
	


}
