package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.gui;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.model.Author;

public class BookAuthorsTableModel extends AbstractTableModel {

	public BookAuthorsTableModel(LinkedList<Author> bookAuthorsList) {
		this.bookAuthorsTableData = bookAuthorsList;
	}

	private String columnName = "Autoren";
	private LinkedList<Author> bookAuthorsTableData;

	@Override
	public int getRowCount() {
		return bookAuthorsTableData.size();
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return bookAuthorsTableData.get(rowIndex).getName();
	}

}
