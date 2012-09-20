package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.LiteratureDatabaseException;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.MainService;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	JMenuItem newItem = new JMenuItem("Neu");
	JMenuItem loadItem = new JMenuItem("Laden");
	JMenuItem saveItem = new JMenuItem("Speichern unter");
	JMenuItem closeItem = new JMenuItem("Beenden");

	JTable authorTable;

	JButton deleteAuthor = new JButton("ausgewählten Autor löschen",
			new ImageIcon(getClass().getResource("/delete.png")));
	JButton createAuthor = new JButton("Neuen Autor anlegen", new ImageIcon(
			getClass().getResource("/new.png")));

	JTable bookTable;
	JButton deleteBook = new JButton("ausgewähltes Buch löschen",
			new ImageIcon(getClass().getResource("/delete.png")));
	JButton createBook = new JButton("Neues Buch anlegen", new ImageIcon(
			getClass().getResource("/new.png")));

	private MainService mainService;

	public MainFrame(MainService mainService) {
		this.mainService = mainService;
		this.setTitle("Literaturdatenbank");
		this.setSize(828, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(getParent());
		this.setJMenuBar(createMenuBar());
		this.add(createMainPane());
		this.setResizable(true);
		this.setVisible(true);

	}

	public JTable getAuthorTable() {
		return authorTable;
	}

	public JTable getBookTable() {
		return bookTable;
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Datei");
		menuBar.add(menu);

		menu.add(newItem);
		menu.add(loadItem);
		menu.add(saveItem);
		menu.add(closeItem);

		return menuBar;
	}

	private JPanel createMainPane() {
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
		mainPane.add(createAuthorPane());
		mainPane.add(createBookPane());
		return mainPane;
	}

	private JPanel createAuthorPane() {
		JPanel authorPane = new JPanel();
		try {
			authorPane.setLayout(new BorderLayout());
			authorPane.add(new JLabel("             Autoren"),
					BorderLayout.NORTH);

			authorTable = new JTable(new AuthorTableModel(mainService.create()
					.getAuthors()));
			authorTable.getTableHeader().setReorderingAllowed(false);
			authorPane.add(new JScrollPane(authorTable), BorderLayout.CENTER);
			authorPane.add(new JLabel("             "), BorderLayout.WEST);
			authorPane.add(new JLabel("             "), BorderLayout.EAST);
			authorPane.add(createAuthorButtonPane(), BorderLayout.SOUTH);
		} catch (LiteratureDatabaseException e) {
			JOptionPane.showMessageDialog(this,
					"Fehler beim Sammeln der Tabellendaten", "Fehler",
					JOptionPane.ERROR_MESSAGE);
		}
		return authorPane;

	}

	private JPanel createAuthorButtonPane() {
		JPanel authorButtonPane = new JPanel();
		authorButtonPane.setLayout(new BoxLayout(authorButtonPane,
				BoxLayout.X_AXIS));
		authorButtonPane
				.add(new JLabel(
						"                                                                              "));
		deleteAuthor.setHorizontalTextPosition(AbstractButton.RIGHT);
		authorButtonPane.add(deleteAuthor);
		authorButtonPane.add(new JLabel("                  "));

		createAuthor.setHorizontalTextPosition(AbstractButton.RIGHT);
		authorButtonPane.add(createAuthor);
		return authorButtonPane;
	}

	private JPanel createBookPane() {
		JPanel bookPane = new JPanel();
		try {
			bookPane.setLayout(new BorderLayout());
			bookPane.add(new JLabel("             Bücher"), BorderLayout.NORTH);
			bookTable = new JTable(new BookTableModel(mainService.create()
					.getBooks()));
			bookTable.getTableHeader().setReorderingAllowed(false);
			bookPane.add(new JScrollPane(bookTable), BorderLayout.CENTER);
			bookPane.add(new JLabel("             "), BorderLayout.WEST);
			bookPane.add(new JLabel("             "), BorderLayout.EAST);
			bookPane.add(createBookButtonPane(), BorderLayout.SOUTH);
		} catch (LiteratureDatabaseException e) {
			JOptionPane.showMessageDialog(this,
					"Fehler beim Sammeln der Tabellendaten", "Fehler",
					JOptionPane.ERROR_MESSAGE);
		}
		return bookPane;
	}

	private JPanel createBookButtonPane() {
		JPanel bookButtonPane = new JPanel();
		bookButtonPane
				.setLayout(new BoxLayout(bookButtonPane, BoxLayout.X_AXIS));
		bookButtonPane
				.add(new JLabel(
						"                                                                              "));

		deleteBook.setHorizontalTextPosition(AbstractButton.RIGHT);
		bookButtonPane.add(deleteBook);
		bookButtonPane.add(new JLabel("                  "));

		createBook.setHorizontalTextPosition(AbstractButton.RIGHT);
		bookButtonPane.add(createBook);
		return bookButtonPane;
	}

	public void addNewItemListener(ActionListener al) {
		newItem.addActionListener(al);
	}

	public void addLoadItemListener(ActionListener al) {
		loadItem.addActionListener(al);
	}

	public void addSaveItemListener(ActionListener al) {
		saveItem.addActionListener(al);
	}

	public void addCloseItemListener(ActionListener al) {
		closeItem.addActionListener(al);
	}

	public void addDeleteAuthorListener(ActionListener al) {
		deleteAuthor.addActionListener(al);
	}

	public void addCreateAuthorListener(ActionListener al) {
		createAuthor.addActionListener(al);
	}

	public void addDeleteBookListener(ActionListener al) {
		deleteBook.addActionListener(al);
	}

	public void addCreateBookListener(ActionListener al) {
		createBook.addActionListener(al);
	}

}
