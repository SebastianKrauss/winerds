package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.model;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

public class Book {

	private String title;
	private int yearPublished;
	private Cover cover;
	private String isbn;
	private String id;

	private List<Author> authors = new LinkedList<>();

	public Book() {
		super();
	}

	@XmlAttribute(required = true)
	public Cover getCover() {
		return cover;
	}

	public void setCover(Cover cover) {
		this.cover = cover;
	}

	@XmlAttribute(required = true)
	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	@XmlElement(required = true)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlID
	@XmlElement(required = true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(required = true)
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@XmlIDREF
	@XmlElement(name = "author", required = true)
	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", yearPublished=" + yearPublished
				+ ", cover=" + cover + ", isbn=" + isbn + ", id=" + id
				+ ", authors=" + authors + "]";
	}

}
