package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.gui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame {

	public MainFrame() {
		this.setTitle("Literaturdatenbank");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setJMenuBar(createMenuBar());
		this.add(createMainPane());
		this.setResizable(true);
		this.setVisible(true);

	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Datei");

		menuBar.add(menu);
		menu.add(new JMenuItem("Neu"));
		menu.add(new JMenuItem("Laden"));
		menu.add(new JMenuItem("Speichern unter"));
		menu.add(new JMenuItem("Beenden"));

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
		authorPane.setLayout(new BorderLayout());
		authorPane.add(new JLabel("Autoren"), BorderLayout.NORTH);
		// JTable authorTable = new JTable(new AuthorTableModel());
		authorPane.add(new JScrollPane(), BorderLayout.CENTER);
		authorPane
				.add(new JLabel("                       "), BorderLayout.WEST);
		authorPane.add(createAuthorButtonPane());

		return authorPane;
	}

	private JPanel createAuthorButtonPane() {
		JPanel authorButtonPane = new JPanel();
		authorButtonPane.setLayout(new BoxLayout(authorButtonPane,
				BoxLayout.X_AXIS));
		authorButtonPane
				.add(new JLabel(
						"                                                                    "));
		authorButtonPane.add(new JButton("ausgewählten Autor löschen"));
		authorButtonPane.add(new JLabel("                  "));
		authorButtonPane.add(new JButton("Neuen Autor anlegen"));
		return authorButtonPane;
	}

	private JPanel createBookPane() {
		JPanel bookPane = new JPanel();
		bookPane.setLayout(new BorderLayout());
		bookPane.add(new JLabel("Bücher"), BorderLayout.NORTH);
		// JTable bookTable = new JTable(new BookTableModel());
		bookPane.add(new JScrollPane(), BorderLayout.CENTER);
		bookPane.add(createBookButtonPane());
		return bookPane;
	}

	private JPanel createBookButtonPane() {
		JPanel bookButtonPane = new JPanel();
		bookButtonPane
				.setLayout(new BoxLayout(bookButtonPane, BoxLayout.X_AXIS));
		bookButtonPane
				.add(new JLabel(
						"                                                                    "));
		bookButtonPane.add(new JButton("ausgewähltes Buch löschen"));
		bookButtonPane.add(new JLabel("                  "));
		bookButtonPane.add(new JButton("Neues Buch anlegen"));
		return bookButtonPane;
	}

}
