package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AuthorDialog extends JDialog {

	public AuthorDialog() {
		this.setTitle("Autor hinzufügen");
		this.setSize(200, 150);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.add(createAuthorDialogPane());
		this.setLocationRelativeTo(getParent());
		this.setResizable(false);
		this.setVisible(true);
	}

	private JPanel createAuthorDialogPane() {
		JPanel authorDialogPane = new JPanel();
		authorDialogPane.setLayout(new BoxLayout(authorDialogPane,
				BoxLayout.Y_AXIS));
		authorDialogPane.add(createAuthorIdPane());
		authorDialogPane.add(createAuthorNamePane());
		authorDialogPane.add(createAuthorEmailPane());
		authorDialogPane.add(createAuthorAddButtonPane());
		return authorDialogPane;
	}

	private JPanel createAuthorIdPane() {
		JPanel authorIdPane = new JPanel();
		authorIdPane.setLayout(new BoxLayout(authorIdPane, BoxLayout.X_AXIS));
		authorIdPane.add(new JLabel("   ID        "));
		authorIdPane.add(new JTextField(""));
		return authorIdPane;
	}

	private JPanel createAuthorNamePane() {
		JPanel authorNamePane = new JPanel();
		authorNamePane
				.setLayout(new BoxLayout(authorNamePane, BoxLayout.X_AXIS));
		authorNamePane.add(new JLabel("   Name   "));
		authorNamePane.add(new JTextField(""));
		return authorNamePane;
	}

	private JPanel createAuthorEmailPane() {
		JPanel authorEmailPane = new JPanel();
		authorEmailPane.setLayout(new BoxLayout(authorEmailPane,
				BoxLayout.X_AXIS));
		authorEmailPane.add(new JLabel("   Email   "));
		authorEmailPane.add(new JTextField(""));
		return authorEmailPane;
	}

	private JPanel createAuthorAddButtonPane() {
		JPanel authorAddButtonPane = new JPanel();
		authorAddButtonPane.setLayout(new BoxLayout(authorAddButtonPane,
				BoxLayout.X_AXIS));
		authorAddButtonPane.add(new JLabel("            "));
		authorAddButtonPane.add(new JButton("Autor hinzufügen"));
		return authorAddButtonPane;
	}

}
