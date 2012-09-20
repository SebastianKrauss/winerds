package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature;

import java.io.IOException;

import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.gui.controller.MainController;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.gui.view.MainFrame;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.MainService;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.impl.MainServiceImpl;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO implement

		MainService mainService = new MainServiceImpl();
		// pass mainService to the corresponding GUI classes
		MainFrame mainFrame = new MainFrame(mainService);
		MainController mainController = new MainController(mainService,
				mainFrame);

	}

}
