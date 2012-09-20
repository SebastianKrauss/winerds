package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.gui.AuthorDialog;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.gui.BookDialog;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.gui.MainFrame;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.DatabaseService;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.LiteratureDatabaseException;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.MainService;

public class MainController implements Observer {

	private MainService mainService;
	private MainFrame mainFrame;
	private DatabaseService databaseService;

	public MainController(MainService mainService, MainFrame mainFrame) {
		this.mainService = mainService;
		this.mainFrame = mainFrame;

		addActionListeners();
	}

	private void addActionListeners() {

		mainFrame.addNewItemListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				try {
					databaseService = mainService.create();
					mainFrame.setTitle("Neue Literaturdatenbank");
				} catch (LiteratureDatabaseException e) {
					JOptionPane.showMessageDialog(mainFrame,
							"Fehler beim Erstellen der Datenbank", "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		mainFrame.addLoadItemListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				JFileChooser fileChooser = new JFileChooser();
				int choice = fileChooser.showOpenDialog(mainFrame);
				if (choice == JFileChooser.APPROVE_OPTION) {
					try {
						databaseService = mainService.load(fileChooser
								.getSelectedFile().toString());
					} catch (LiteratureDatabaseException e) {
						JOptionPane.showMessageDialog(mainFrame,
								"Fehler beim Laden der Datenbank", "Fehler",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		mainFrame.addSaveItemListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				JFileChooser fileChooser = new JFileChooser();
				int choice = fileChooser.showSaveDialog(mainFrame);
				if (choice == JFileChooser.APPROVE_OPTION) {
					try {
						databaseService.saveXMLToFile(fileChooser
								.getSelectedFile().toString());
					} catch (LiteratureDatabaseException e) {
						JOptionPane.showMessageDialog(mainFrame,
								"Fehler beim Speichern der Datenbank",
								"Fehler", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		mainFrame.addCloseItemListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				int choice = JOptionPane.showConfirmDialog(mainFrame,
						"Wollen Sie das Progamm beenden?", "Beenden",
						JOptionPane.OK_CANCEL_OPTION);
				if (choice == JOptionPane.OK_OPTION) {
					mainFrame.dispose();
				}
			}
		});

		mainFrame.addDeleteAuthorListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				int deleteAuthorIndex = mainFrame.getAuthorTable()
						.getSelectedRow();
				if (deleteAuthorIndex != -1) {
					try {
						databaseService.removeAuthorByEmail(databaseService
								.getAuthors()[deleteAuthorIndex].getEmail());
					} catch (LiteratureDatabaseException e) {
						JOptionPane.showMessageDialog(mainFrame,
								"Fehler beim Löschen des Autors", "Fehler",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(mainFrame,
							"Kein Autor ausgewählt", "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		mainFrame.addCreateAuthorListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				AuthorDialog authorDialog = new AuthorDialog();
			}
		});

		mainFrame.addDeleteBookListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				int deleteBookIndex = mainFrame.getBookTable().getSelectedRow();
				if (deleteBookIndex != -1) {
					try {
						databaseService.removeBookByISBN(databaseService
								.getAuthors()[deleteBookIndex].getEmail());
					} catch (LiteratureDatabaseException e) {
						JOptionPane.showMessageDialog(mainFrame,
								"Fehler beim Löschen des Buchs", "Fehler",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(mainFrame,
							"Kein Buch ausgewählt", "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		mainFrame.addCreateBookListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BookDialog bookDialog = new BookDialog();
			}
		});
	}

	@Override
	public void update(Observable arg0, Object arg1) {

	}

}