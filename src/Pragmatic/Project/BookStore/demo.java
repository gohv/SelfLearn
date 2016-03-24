package Pragmatic.Project.BookStore;

public class demo {

	public static void main(String[] args) {
		Book b1 = new Book("title", "author", 5.2, "publisher", "foreign", 5);


	
		System.out.println(b1.getAuthor());
		Bookstore bstore = new Bookstore();
	
		bstore.addBook(b1);
		bstore.listBooksAndStockCount();

	//	System.out.println(bstore.sellBook(b1));
	//	System.out.println(bstore.sellBook(b1));
	//	System.out.println(bstore.sellBook(b1));
	//	System.out.println(bstore.sellBook(b1));
//		System.out.println(bstore.sellBook(b1));
//		System.out.println(bstore.sellBook(b1));

	//	bstore.listBooksAndStockCount();
	//	bstore.removeBook(b1);
	//	bstore.listBooksAndStockCount();
	//	System.out.println(b1.getTitle().contains("do"));
	}

}
