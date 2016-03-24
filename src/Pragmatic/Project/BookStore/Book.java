package Pragmatic.Project.BookStore;

import java.util.UUID;

public class Book {
	private UUID id;
	private String title;
	private String author;
	private String price;
	private String publisher;
	private String origin;
	private String stock;

	public Book(String title, String author, String price, String publisher,
			String foreign, String stock) {
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String newPrice) {
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

	public String getStock() {
		return stock;
	}

	public void setStock(String newStock) {
		this.stock = newStock;
	}

}
