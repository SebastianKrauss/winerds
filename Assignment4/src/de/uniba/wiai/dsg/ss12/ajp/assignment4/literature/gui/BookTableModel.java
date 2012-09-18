package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.gui;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.controller.TableController;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.model.Book;

public class BookTableModel extends AbstractTableModel {
	
	public BookTableModel(LinkedList<Book> bookList){
		this.bookTableData = bookList;
	}
	
	private TableController bookTableController = new TableController();
	private String[] columnNames = {"Id","Titel","ISBN", "Cover","E.-Jahr","Autoren"};
	
	private LinkedList<Book> bookTableData;

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return bookTableData.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		if(column == 0){
			return bookTableData.get(row).getId();
		} else if(column == 1){
			return bookTableData.get(row).getTitle();
		}else if(column == 2){
			return bookTableData.get(row).getIsbn();
		}else if(column == 3){
			return bookTableData.get(row).getCover();
		}else if(column == 4){
			return bookTableData.get(row).getYearPublished();
		}else return bookTableData.get(row).getAuthors();
	}

}
