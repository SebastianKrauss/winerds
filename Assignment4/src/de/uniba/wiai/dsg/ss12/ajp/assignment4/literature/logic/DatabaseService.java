package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic;

import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.model.Author;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.model.Book;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.model.Cover;

public interface DatabaseService {

	/**
	 * Adds a new book.
	 * 
	 * @param title
	 *            the title of the book. Must not be empty or null.
	 * @param isbn
	 *            the ISBN number of the book. Must not be empty or null. Must
	 *            be a valid isbn number.
	 * @param yearPublished
	 *            the year the book was first published. Must not be negative.
	 * @param cover
	 *            the type of the cover. Must not be null.
	 * @param authors
	 *            Must not be null; must at least contain one author; must not
	 *            contain duplicates of authors
	 * @param id
	 *            the id of the book. Must not be null or empty. Must be a valid
	 *            id and unique within the current database.
	 * @throws LiteratureDatabaseException
	 *             if any of the above preconditions are not met
	 */
	void addBook(String title, String isbn, int yearPublished, Cover cover,
			Author[] authors, String id) throws LiteratureDatabaseException;

	/**
	 * Removes an existing book identified by its ISBN
	 * 
	 * @param isbn
	 *            the ISBN number of the book to be removed. Must not be empty
	 *            or null. Must be a valid isbn.
	 * @throws LiteratureDatabaseException
	 *             if any of the above preconditions are not met
	 */
	void removeBookByISBN(String isbn) throws LiteratureDatabaseException;

	/**
	 * Removes an existing author by email
	 * 
	 * @param email
	 *            the email address of the author to be removed. Must not be
	 *            null or empty. Must be a valid email address.
	 * @throws LiteratureDatabaseException
	 *             if any of the above preconditions are not met
	 */
	void removeAuthorByEmail(String email) throws LiteratureDatabaseException;

	/**
	 * Adds a new author
	 * 
	 * @param name
	 *            the name of the author. Must not be null or empty.
	 * @param email
	 *            the email address of the author. Must not be null or empty.
	 * @param id
	 *            the id of the author. Must not be null or empty. Must be a
	 *            valid id and unique.
	 * 
	 * @throws LiteratureDatabaseException
	 *             if any of the above preconditions are not met
	 */
	void addAuthor(String name, String email, String id)
			throws LiteratureDatabaseException;

	/**
	 * Gets an array of books stored in the database
	 * 
	 * @return an array of books
	 */
	Book[] getBooks();

	/**
	 * Gets an array of authors stored in the database
	 * 
	 * @return an array of authors
	 */
	Author[] getAuthors();

	/**
	 * Removes all authors and books.
	 */
	void clear();

	/**
	 * Prints the current database to the console by marshalling it to XML
	 * 
	 * @throws LiteratureDatabaseException
	 *             if there are errors while marshalling the current database
	 */
	void printXMLToConsole() throws LiteratureDatabaseException;

	/**
	 * Saves the current database to the given file by marshalling it to XML
	 * 
	 * @param path
	 *            the path of the file. Must not be null or empty.
	 * @throws LiteratureDatabaseException
	 *             if path is null or empty or there are errors during
	 *             marshalling the current database
	 */
	void saveXMLToFile(String path) throws LiteratureDatabaseException;

}
