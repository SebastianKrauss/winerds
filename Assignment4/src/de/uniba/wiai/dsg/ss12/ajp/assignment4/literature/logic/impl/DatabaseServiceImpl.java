package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.impl;

import static de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.impl.Validator.assertNoDuplicatesInArray;
import static de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.impl.Validator.assertNoNullsInArray;
import static de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.impl.Validator.assertNotEmpty;
import static de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.impl.Validator.assertNotNegative;
import static de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.impl.Validator.assertNotNull;
import static de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.impl.Validator.assertValidEmail;
import static de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.impl.Validator.assertValidId;
import static de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.impl.Validator.assertValidIsbn;

import java.io.File;
import java.util.Arrays;

import javax.xml.bind.JAXB;

import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.DatabaseService;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.LiteratureDatabaseException;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.model.Author;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.model.Book;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.model.Cover;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.model.Database;

class DatabaseServiceImpl implements DatabaseService {

	private Database database;

	public DatabaseServiceImpl(Database database) {
		super();
		this.database = database;
	}

	@Override
	public void addBook(String title, String isbn, int yearPublished,
			Cover cover, Author[] authors, String id)
			throws LiteratureDatabaseException {

		assertNotEmpty(title, "title");

		assertValidIsbn(isbn);
		validateUniquenessOfBookIsbn(isbn);

		assertValidId(id);
		validateUniquenessOfBookId(id);

		assertNotNull(cover, "cover");

		assertNotNegative(yearPublished, "yearPublished");

		assertNoNullsInArray(authors, "authors");
		assertNoDuplicatesInArray(authors, "authors");

		Book book = new Book();
		book.setTitle(title);
		book.setIsbn(isbn);
		book.setId(id);
		book.setYearPublished(yearPublished);
		book.setCover(cover);
		book.setAuthors(Arrays.asList(authors));

		database.addBook(book);
	}

	private void validateUniquenessOfBookId(String id)
			throws LiteratureDatabaseException {
		if (database.hasBookWithId(id)) {
			throw new LiteratureDatabaseException("book with id " + id
					+ " is already added");
		}
	}

	private void validateUniquenessOfBookIsbn(String isbn)
			throws LiteratureDatabaseException {
		if (database.hasBookWithIsbn(isbn)) {
			throw new LiteratureDatabaseException("book with isbn " + isbn
					+ " is already added");
		}
	}

	@Override
	public void removeBookByISBN(String isbn)
			throws LiteratureDatabaseException {
		assertValidIsbn(isbn);

		Book book = database.findBookByIsbn(isbn);
		if (book == null) {
			throw new LiteratureDatabaseException("book with isbn " + isbn
					+ " does not exist");
		}
		database.removeBook(book);
	}

	@Override
	public void removeAuthorByEmail(String email)
			throws LiteratureDatabaseException {
		assertValidEmail(email);

		Author author = database.findAuthorByEmail(email);
		if (author == null) {
			throw new LiteratureDatabaseException("author with email " + email
					+ " does not exist");
		}
		if (author.hasBooks()) {
			database.getAuthors().remove(author);
		} else {
			throw new LiteratureDatabaseException("author still has books");
		}

	}

	@Override
	public void addAuthor(String name, String email, String id)
			throws LiteratureDatabaseException {
		assertNotEmpty(name, "name");

		assertValidEmail(email);
		assertUniquenessOfAuthorEmail(email);

		assertValidId(id);
		assertUniquenessOfAuthorId(id);

		Author author = new Author();
		author.setName(name);
		author.setEmail(email);
		author.setId(id);

		database.addAuthor(author);
	}

	private void assertUniquenessOfAuthorId(String id)
			throws LiteratureDatabaseException {
		if (database.hasAuthorWithId(id)) {
			throw new LiteratureDatabaseException("author with id " + id
					+ " is already added");
		}
	}

	private void assertUniquenessOfAuthorEmail(String email)
			throws LiteratureDatabaseException {
		if (database.hasAuthorWithEmail(email)) {
			throw new LiteratureDatabaseException("author with email " + email
					+ " is already added");
		}
	}

	@Override
	public Book[] getBooks() {
		return database.getBooks().toArray(new Book[] {});
	}

	@Override
	public Author[] getAuthors() {
		return database.getAuthors().toArray(new Author[] {});
	}

	@Override
	public void clear() {
		database.clear();
	}

	@Override
	public void printXMLToConsole() throws LiteratureDatabaseException {
		JAXB.marshal(database, System.out);
	}

	@Override
	public void saveXMLToFile(String path) throws LiteratureDatabaseException {
		assertNotEmpty(path, "path");

		JAXB.marshal(database, new File(path));
	}

}
