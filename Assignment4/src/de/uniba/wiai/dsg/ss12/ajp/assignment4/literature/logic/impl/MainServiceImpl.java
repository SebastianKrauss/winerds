package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.impl;

import static de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.impl.Validator.assertFileExists;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXB;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.DatabaseService;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.LiteratureDatabaseException;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.MainService;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.model.Database;

public class MainServiceImpl implements MainService {

	private static final String XSD_SCHEMA_PATH = "schema1.xsd";

	/**
	 * Default constructor required for grading.
	 */
	public MainServiceImpl() {
		/*
		 * DO NOT REMOVE - REQUIRED FOR GRADING
		 * 
		 * YOU CAN EXTEND IT BELOW THIS COMMENT
		 */
	}

	@Override
	public void validate(String path) throws LiteratureDatabaseException {
		assertFileExists(path, "path");

		SchemaFactory sf = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try {
			Schema schema = sf.newSchema(new File(XSD_SCHEMA_PATH));
			schema.newValidator().validate(new StreamSource(new File(path)));
		} catch (SAXException | IOException e) {
			throw new LiteratureDatabaseException("could not be validated", e);
		}
	}

	@Override
	public DatabaseService load(String path) throws LiteratureDatabaseException {
		assertFileExists(path, "path");

		return new DatabaseServiceImpl(loadDatabase(path));
	}

	private Database loadDatabase(String path) {
		return JAXB.unmarshal(new File(path), Database.class);
	}

	@Override
	public DatabaseService create() throws LiteratureDatabaseException {
		return new DatabaseServiceImpl(new Database());
	}

}
