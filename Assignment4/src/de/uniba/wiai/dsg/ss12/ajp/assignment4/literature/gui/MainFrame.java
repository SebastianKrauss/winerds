package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.controller.MainController;

public class MainFrame extends JFrame {

	public MainFrame() {
		this.setTitle("Literaturdatenbank");
		this.setSize(828, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(getParent());
		this.setJMenuBar(createMenuBar());
		this.add(createMainPane());
		this.setResizable(true);
		this.setVisible(true);

	}

	private MainController controller;

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Datei");
		menuBar.add(menu);

		JMenuItem newItem = new JMenuItem("Neu");
		newItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.update(); // HUNDEGRAB

			}
		});
		JMenuItem loadItem = new JMenuItem("Laden");
		JMenuItem saveItem = new JMenuItem("Speichern unter");
		JMenuItem closeItem = new JMenuItem("Beenden");

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
		// authorPane.setBorder(BorderFactory.createLineBorder(Color.black));
		authorPane.setLayout(new BorderLayout());
		authorPane.add(new JLabel("             Autoren"), BorderLayout.NORTH);
		// JTable authorTable = new JTable(new AuthorTableModel());
		authorPane.add(new JScrollPane(), BorderLayout.CENTER);
		authorPane.add(new JLabel("             "), BorderLayout.WEST);
		authorPane.add(new JLabel("             "), BorderLayout.EAST);
		authorPane.add(createAuthorButtonPane(), BorderLayout.SOUTH);

		return authorPane;
	}

	private JPanel createAuthorButtonPane() {
		JPanel authorButtonPane = new JPanel();
		authorButtonPane.setLayout(new BoxLayout(authorButtonPane,
				BoxLayout.X_AXIS));
		authorButtonPane
				.add(new JLabel(
						"                                                                              "));
		JButton deleteAuthor = new JButton("ausgewählten Autor löschen",new ImageIcon(getClass().getResource("/delete.png")));
		deleteAuthor.setHorizontalTextPosition(AbstractButton.RIGHT);
		authorButtonPane.add(deleteAuthor);
		authorButtonPane.add(new JLabel("                  "));
		JButton createAuthor = new JButton("Neuen Autor anlegen",new ImageIcon(getClass().getResource("/new.png")));
		createAuthor.setHorizontalTextPosition(AbstractButton.RIGHT);
		authorButtonPane.add(createAuthor);
		return authorButtonPane;
	}

	private JPanel createBookPane() {
		JPanel bookPane = new JPanel();
		// bookPane.setBorder(BorderFactory.createLineBorder(Color.black));
		// IIIIHHHH
		bookPane.setLayout(new BorderLayout());
		bookPane.add(new JLabel("             Bücher"), BorderLayout.NORTH);
		// JTable bookTable = new JTable(new BookTableModel());
		bookPane.add(new JScrollPane(), BorderLayout.CENTER);
		bookPane.add(new JLabel("             "), BorderLayout.WEST);
		bookPane.add(new JLabel("             "), BorderLayout.EAST);
		bookPane.add(createBookButtonPane(), BorderLayout.SOUTH);
		return bookPane;
	}

	private JPanel createBookButtonPane() {
		JPanel bookButtonPane = new JPanel();
		bookButtonPane
				.setLayout(new BoxLayout(bookButtonPane, BoxLayout.X_AXIS));
		bookButtonPane
				.add(new JLabel(
						"                                                                              "));
		JButton deleteBook = new JButton("ausgewähltes Buch löschen",new ImageIcon(getClass().getResource("/delete.png")));
		deleteBook.setHorizontalTextPosition(AbstractButton.RIGHT);
		bookButtonPane.add(deleteBook);
		bookButtonPane.add(new JLabel("                  "));
		JButton createBook = new JButton("Neues Buch anlegen",new ImageIcon(getClass().getResource("/new.png")));
		createBook.setHorizontalTextPosition(AbstractButton.RIGHT);
		bookButtonPane.add(createBook);
		return bookButtonPane;
	}

}
