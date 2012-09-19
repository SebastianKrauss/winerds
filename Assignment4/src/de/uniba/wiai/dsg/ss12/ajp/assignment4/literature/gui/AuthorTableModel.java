package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.gui;

import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.controller.TableController;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.model.Author;

@SuppressWarnings("serial")
public class AuthorTableModel extends AbstractTableModel {

	public AuthorTableModel(Author[] authorArray) {
		this.authorTableData = new LinkedList<Author>(
				Arrays.asList(authorArray));
	}

	private TableController tableController = new TableController();
	private String[] columnNames = { "Id", "Name", "Email",
			"Geschriebene Bücher" };

	private LinkedList<Author> authorTableData;

	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return authorTableData.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		if (column == 0) {
			return authorTableData.get(row).getId();
		} else if (column == 1) {
			return authorTableData.get(row).getName();
		} else if (column == 2) {
			return authorTableData.get(row).getEmail();
		} else {
			return authorTableData.get(row).getWrittenBooks();
		}

	}
}
