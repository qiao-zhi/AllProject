package Action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
	/**
	 * 
	 */

	private static final long serialVersionUID = 7212325410569226999L;
	private List<Book> books = new ArrayList<Book>();

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String execute(){
		
		books.add(new Book("JavaWeb",55));
		books.add(new Book("Spring",52));
		books.add(new Book("Struts2",55.50));
		books.add(new Book("JS",25));
		
		return "success";
	}
}
