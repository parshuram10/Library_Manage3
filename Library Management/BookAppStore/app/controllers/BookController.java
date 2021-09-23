package controllers;

import play.mvc.Controller;

import java.util.Set;

import javax.inject.Inject;

import model.Book;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import views.html.*;
public class BookController extends Controller{
	
	@Inject
	FormFactory formFactory;
	
	public Result index() {
		
		Set<Book> books = Book.allBooks();
		
		return ok(bookview.render(books));
	}
	
	public Result create() {
		Form<Book> bookForm = formFactory.form(Book.class);
		return ok(create.render(bookForm));
	}
	
	public Result save() {
		
		Form<Book> bookForm = formFactory.form(Book.class);
		Book book = bookForm.get();
		Book.addBook(book);
 		return ok("Save");
	}
	
	public Result edit(Integer id) {
		
		Book book = Book.findById(id);
		Form<Book> bookForm = formFactory.form(Book.class).fill(book);
		return ok(edit.render(bookForm));
	}
	
	public Result update() {
		return ok("Update");
	}
	
	public Result destroy(Integer id) {
		
		Book book = Book.findById(id);
		if(book==null) {
			return notFound("Book is Not Found");
		}
		Book.removeBook(book);
		return ok("Delete");
	}
	
	public Result show(Integer id) {
		Book book = Book.findById(id);
		return ok(show.render(book));
	}
}
