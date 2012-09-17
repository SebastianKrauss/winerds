package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Database extends Observable {

	private List<Author> authors = new LinkedList<>();
	private List<Book> books = new LinkedList<>();

	public Database() {
		super();
	}

	@XmlElement(name = "author")
	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	@XmlElement(name = "book")
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void addBook(Book book) {
		getBooks().add(book);

		for (Author author : book.getAuthors()) {
			author.getWrittenBooks().add(book);
		}
	}

	public void removeBook(Book book) {
		getBooks().remove(book);

		for (Author author : book.getAuthors()) {
			author.getWrittenBooks().remove(book);
		}
	}

	public Book findBookById(String id) {
		for (Book book : getBooks()) {
			if (book.getId().equals(id)) {
				return book;
			}
		}
		return null;
	}

	public boolean hasBookWithId(String id) {
		return findBookById(id) != null;
	}

	public Book findBookByIsbn(String isbn) {
		for (Book book : getBooks()) {
			if (book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}

	public boolean hasBookWithIsbn(String isdbn) {
		return findBookByIsbn(isdbn) != null;
	}

	public Author findAuthorByEmail(String email) {
		for (Author author : getAuthors()) {
			if (author.getEmail().equals(email)) {
				return author;
			}
		}
		return null;
	}

	public boolean hasAuthorWithEmail(String email) {
		return findAuthorByEmail(email) != null;
	}

	public Author findAuthorById(String id) {
		for (Author author : getAuthors()) {
			if (author.getId().equals(id)) {
				return author;
			}
		}
		return null;
	}

	public boolean hasAuthorWithId(String id) {
		return findAuthorById(id) != null;
	}

	public void addAuthor(Author author) {
		getAuthors().add(author);
	}

	public void clear() {
		setAuthors(new LinkedList<Author>());
		setBooks(new LinkedList<Book>());
	}

}
