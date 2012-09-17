package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature;

import java.io.IOException;

import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.controller.MainController;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.gui.MainFrame;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.MainService;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.impl.MainServiceImpl;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO implement
		MainController mainController = new MainController();
		mainController.start();

		MainService mainService = new MainServiceImpl();
		// pass mainService to the corresponding GUI classes
		
	}

}
