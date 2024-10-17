package ro.emanuel.book.pojo;

public class Book {

	private int id;
	private String name;
	private String author;
	private int pages;
	
	public Book(int id, String name, String author, int pages) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.pages = pages;
	}
	
	public Book(String name, String author, int pages) {
		super();
		this.id = id; // do I need this line of code here if I dont have a parameter for it?
		this.name = name;
		this.author = author;
		this.pages = pages;
	}
	
	public Book() {}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", pages=" + pages + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
	
	
}
