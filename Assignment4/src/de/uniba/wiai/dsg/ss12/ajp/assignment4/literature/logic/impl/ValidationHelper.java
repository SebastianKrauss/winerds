package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.impl;

import java.util.Objects;
import java.util.regex.Pattern;

class ValidationHelper {

	private static final String ZERO_OR_MORE = "*";
	private static final String ONE_OR_MORE = "+";

	/**
	 * Validates an ID.
	 * 
	 * An ID has to start with a letter followed by zero or more letters or
	 * numbers.
	 * 
	 * @param id
	 *            the id to be checked. must not be null.
	 * @return true if the id is valid, false otherwise
	 * 
	 * @throws NullPointerException
	 *             if id is null
	 */
	public static boolean isId(String id) {
		id = Objects.requireNonNull(id, "passed id is null");

		String startWithLetter = "[a-zA-Z]";
		String anyLetterOrNumber = "[a-zA-Z0-9]" + ZERO_OR_MORE;
		String regexForId = startWithLetter + anyLetterOrNumber;
		return Pattern.matches(regexForId, id);
	}

	/**
	 * Validates an email address.
	 * 
	 * This is a simple validation which does not conform to the correctness of
	 * all email addresses.
	 * 
	 * @param email
	 *            the email to be validated. must not be null.
	 * @return true if the email is valid, false otherwise
	 * 
	 * @throws NullPointerException
	 *             if email is null
	 */
	public static boolean isEmail(String email) {
		email = Objects.requireNonNull(email, "passed email is null");

		String name = "[a-zA-Z0-9._%-]" + ONE_OR_MORE;
		String at = "[@]";
		String domain = "[a-zA-Z0-9.-]" + ONE_OR_MORE;
		String dot = "[.]";
		String countryCode = "[a-zA-Z]{2,4}";
		String regexForEmail = name + at + domain + dot + countryCode;
		return Pattern.matches(regexForEmail, email);
	}

	/**
	 * Validates an ISBN number.
	 * 
	 * This validation is very simple and does not conform to the ISO norm of
	 * ISBN.
	 * 
	 * In this case, an ISBN number is defined by starting with a number
	 * followed by a sequence of zero or more numbers, dashes or spaces.
	 * 
	 * @param isbn
	 *            the isbn to be checked. must not be null
	 * @return true if the isbn is valid, false otherwise
	 * 
	 * @throws NullPointerException
	 *             if isbn is null
	 */
	public static boolean isIsbn(String isbn) {
		isbn = Objects.requireNonNull(isbn, "passed isbn is null");

		String startWithNumber = "[0-9]";
		String anyNumberSpaceOrDash = "[0-9- ]" + ZERO_OR_MORE;
		String regexForIsbn = startWithNumber + anyNumberSpaceOrDash;
		return Pattern.matches(regexForIsbn, isbn);
	}

}
