package org.futureworks.shopofthefuture.pointofsale.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.futureworks.shopofthefuture.pointofsale.logic.PointOfSale;

public class NFCButtonListener implements ActionListener {
	
	private PointOfSale logic;
	
	public NFCButtonListener(PointOfSale logic){
		this.logic = logic;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		this.logic.nfcMessage();
	}


}
