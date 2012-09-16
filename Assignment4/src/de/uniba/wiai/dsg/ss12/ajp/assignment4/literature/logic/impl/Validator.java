package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.impl;

import java.io.File;

import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.LiteratureDatabaseException;

class Validator {

	public static void assertNotNull(Object object, String name)
			throws LiteratureDatabaseException {
		if (object == null) {
			throw new LiteratureDatabaseException(name + " should not be null");
		}
	}

	public static void assertNotEmpty(String string, String name)
			throws LiteratureDatabaseException {
		assertNotNull(string, name);
		if (string.isEmpty()) {
			throw new LiteratureDatabaseException(name + " should not be empty");
		}
	}

	public static void assertNotNegative(int yearPublished, String name)
			throws LiteratureDatabaseException {
		if (yearPublished < 0) {
			throw new LiteratureDatabaseException(name
					+ " should not be negative");
		}
	}

	public static <T> void assertNotEmpty(T[] elements, String name)
			throws LiteratureDatabaseException {
		assertNotNull(elements, name);
		if (elements.length == 0) {
			throw new LiteratureDatabaseException(name + " should not be empty");
		}
	}

	public static <T> void assertNoNullsInArray(T[] elements, String name)
			throws LiteratureDatabaseException {
		assertNotEmpty(elements, name);

		for (T element : elements) {
			if (element == null) {
				throw new LiteratureDatabaseException(name
						+ " should not contain null values");
			}
		}
	}

	public static <T> void assertNoDuplicatesInArray(T[] elements, String name)
			throws LiteratureDatabaseException {
		assertNotEmpty(elements, name);

		for (T element : elements) {
			int duplicates = 0;
			for (T otherElement : elements) {

				// duplicates are checked using == instead of equals here.
				if (element == otherElement) {
					duplicates++;
				}

				if (duplicates > 1) {
					throw new LiteratureDatabaseException(name
							+ " should not contain duplicates");
				}
			}
		}
	}

	public static void assertValidIsbn(String isbn)
			throws LiteratureDatabaseException {
		assertNotEmpty(isbn, "isbn");
		if (!ValidationHelper.isIsbn(isbn)) {
			throw new LiteratureDatabaseException("isbn is not valid");
		}
	}

	public static void assertValidId(String id)
			throws LiteratureDatabaseException {
		assertNotEmpty(id, "id");

		if (!ValidationHelper.isId(id)) {
			throw new LiteratureDatabaseException("id is not valid");
		}
	}

	public static void assertValidEmail(String email)
			throws LiteratureDatabaseException {
		assertNotEmpty(email, "email");
		if (!ValidationHelper.isEmail(email)) {
			throw new LiteratureDatabaseException("email is not valid");
		}
	}

	public static void assertFileExists(String path, String name)
			throws LiteratureDatabaseException {
		assertNotEmpty(path, name);

		if (!new File(path).exists()) {
			throw new LiteratureDatabaseException(path + " does not exist");
		}
	}
}
