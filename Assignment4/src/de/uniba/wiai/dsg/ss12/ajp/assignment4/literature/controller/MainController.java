package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.controller;

import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.gui.MainFrame;
import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.MainService;

public class MainController {

	private MainService mainService;
	private MainFrame mainFrame;

	public MainController(MainService mainService, MainFrame mainFrame) {
		this.mainService = mainService;
		this.mainFrame = mainFrame;
	}

}
