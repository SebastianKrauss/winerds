package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.controller;

import java.util.Observable;
import java.util.Observer;

import de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.model.Database;

public class TableController implements Observer {

	private Database db;
	
	public void register(){
		db.addObserver(this);
	}
	
	
	
	
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
