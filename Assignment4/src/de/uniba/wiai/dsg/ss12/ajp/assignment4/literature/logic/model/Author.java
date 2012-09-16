package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.model;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

public class Author {

	private String id;

	private String name;

	private String email;

	private List<Book> writtenBooks = new LinkedList<>();

	public Author() {
		super();
	}

	@XmlElement(required = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(required = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlID
	@XmlElement(required = true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlIDREF
	@XmlElement(name = "written")
	public List<Book> getWrittenBooks() {
		return writtenBooks;
	}

	public void setWrittenBooks(List<Book> writtenBooks) {
		this.writtenBooks = writtenBooks;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", email=" + email
				+ ", writtenBooks=" + writtenBooks + "]";
	}

	public boolean hasBooks() {
		return getWrittenBooks().isEmpty();
	}

}
