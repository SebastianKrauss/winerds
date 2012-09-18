package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.model.Cover;

public class BookDialog extends JDialog {
	public BookDialog() {
		this.setTitle("Buch hinzufügen");
		this.setSize(300, 235);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.add(createBookDialogPane());
		this.setLocationRelativeTo(getParent());
		this.setResizable(false);
		this.setVisible(true);
	}

	private JPanel createBookDialogPane() {
		JPanel bookDialogPane = new JPanel();
		bookDialogPane
				.setLayout(new BoxLayout(bookDialogPane, BoxLayout.Y_AXIS));
		bookDialogPane.add(createBookIdPane());
		bookDialogPane.add(createBookTitlePane());
		bookDialogPane.add(createBookYearPublishedPane());
		bookDialogPane.add(createBookAddCoverPane());
		bookDialogPane.add(createBookIsbnPane());
		bookDialogPane.add(createBookAuthorsPane());
		bookDialogPane.add(createBookAddButtonPane());
		return bookDialogPane;
	}

	private JPanel createBookIdPane() {
		JPanel bookIdPane = new JPanel();
		bookIdPane.setLayout(new BoxLayout(bookIdPane, BoxLayout.X_AXIS));
		bookIdPane.add(new JLabel("   ID                           "));
		bookIdPane.add(new JTextField(""));
		return bookIdPane;
	}

	private JPanel createBookTitlePane() {
		JPanel bookTitlePane = new JPanel();
		bookTitlePane.setLayout(new BoxLayout(bookTitlePane, BoxLayout.X_AXIS));
		bookTitlePane.add(new JLabel("   Titel                       "));
		bookTitlePane.add(new JTextField(""));
		return bookTitlePane;
	}

	private JPanel createBookYearPublishedPane() {
		JPanel bookYearPublishedPane = new JPanel();
		bookYearPublishedPane.setLayout(new BoxLayout(bookYearPublishedPane,
				BoxLayout.X_AXIS));
		bookYearPublishedPane.add(new JLabel("   Erscheinungsjahr   "));
		bookYearPublishedPane.add(new JTextField(""));
		return bookYearPublishedPane;
	}

	private JPanel createBookAddCoverPane() {
		JPanel bookAddCoverPane = new JPanel();
		bookAddCoverPane.setLayout(new BoxLayout(bookAddCoverPane,
				BoxLayout.X_AXIS));
		JComboBox<Cover> CoverBox = new JComboBox<Cover>(Cover.values());
		bookAddCoverPane.add(new JLabel("   Cover                     "));
		bookAddCoverPane.add(CoverBox);
		return bookAddCoverPane;
	}

	private JPanel createBookIsbnPane() {
		JPanel bookIsbnPane = new JPanel();
		bookIsbnPane.setLayout(new BoxLayout(bookIsbnPane, BoxLayout.X_AXIS));
		bookIsbnPane.add(new JLabel("   ISBN                       "));
		bookIsbnPane.add(new JTextField(""));
		return bookIsbnPane;
	}

	private JPanel createBookAuthorsPane() {
		JPanel bookAuthorsPane = new JPanel();
		bookAuthorsPane.setLayout(new BoxLayout(bookAuthorsPane,
				BoxLayout.X_AXIS));
		bookAuthorsPane.add(new JLabel("   Autoren                  "));
		// JTable bookAuthorsTable = new JTable(new BookAuthorsTableModel());
		bookAuthorsPane.add(new JScrollPane());
		bookAuthorsPane.add(new JLabel(" "));
		return bookAuthorsPane;
	}

	private JPanel createBookAddButtonPane() {
		JPanel bookAddButtonPane = new JPanel();
		bookAddButtonPane.setLayout(new BoxLayout(bookAddButtonPane,
				BoxLayout.X_AXIS));
		bookAddButtonPane.add(new JLabel(
				"                                      "));
		bookAddButtonPane.add(new JButton("Buch hinzufügen"));
		return bookAddButtonPane;
	}

}
