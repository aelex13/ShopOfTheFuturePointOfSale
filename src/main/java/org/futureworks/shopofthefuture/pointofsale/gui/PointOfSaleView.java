package org.futureworks.shopofthefuture.pointofsale.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.futureworks.shopofthefuture.pointofsale.gui.controller.CashButtonListener;
import org.futureworks.shopofthefuture.pointofsale.gui.controller.NFCButtonListener;
import org.futureworks.shopofthefuture.pointofsale.gui.controller.PINButtonListener;
import org.futureworks.shopofthefuture.pointofsale.gui.controller.SearchButtonListener;
import org.futureworks.shopofthefuture.pointofsale.logic.PointOfSale;

@SuppressWarnings("serial")
public class PointOfSaleView extends JPanel {

	private PointOfSale logic;
	
	private BorderLayout layout;
	
	private JPanel leftContainer;
	private JPanel rightContainer;
	
	private JLabel searchFieldLabel;
	private JTextField searchField;
	private JButton searchButton;
	
	private JList<String> shoppingListView;
	
	private JButton nfcButton;
	private JButton pinButton;
	private JButton cashButton;
	
	private JButton randomCheckButton;
	
	public PointOfSaleView(PointOfSale logic){
		// TODO : Layout management
		this.layout = new BorderLayout();
		super.setLayout(layout);
		
		super.add(this.createLeftContainer(), BorderLayout.WEST);
		super.add(this.createRightContainer(), BorderLayout.EAST);
		
		this.createActionListeners(logic);
	}
	
	public void update(){
		this.createJList(this.logic.getShoppingList());
		this.repaint();
	}
	
	private void createJList(String[] data){
		if(data == null){
			this.shoppingListView = new JList<String>();
		}else{
			this.shoppingListView = new JList<String>(data);
		}
		this.leftContainer.add(this.shoppingListView, BorderLayout.SOUTH);
	}
	
	private JPanel createLeftContainer(){
		this.leftContainer = new JPanel();
		
		this.searchFieldLabel = new JLabel("Shopping List Search");

		this.searchField = new JTextField();
		this.searchButton = new JButton("Search");
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(this.searchFieldLabel, BorderLayout.NORTH);
		buttonPanel.add(this.searchButton, BorderLayout.CENTER);
		buttonPanel.add(this.searchField, BorderLayout.SOUTH);
		
		
		this.leftContainer.setLayout(new BorderLayout());
		this.leftContainer.add(buttonPanel, BorderLayout.NORTH);

		this.createJList(null);
		
		return this.leftContainer;
	}
	
	private JPanel createRightContainer(){
		this.rightContainer = new JPanel();
		
		this.rightContainer.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
		
		this.nfcButton = new JButton("NFC");
		this.pinButton = new JButton("PIN");
		this.cashButton = new JButton("Cash");
		
		this.randomCheckButton = new JButton("Random Item Check");
		
		buttonPanel.add(this.nfcButton);
		buttonPanel.add(this.pinButton);
		buttonPanel.add(this.cashButton);
		
		buttonPanel.add(this.randomCheckButton);
		
		this.rightContainer.add(buttonPanel, BorderLayout.NORTH);
		
		return this.rightContainer;
	}
	
	private void createActionListeners(PointOfSale logic){
		
		this.searchButton.addActionListener(new SearchButtonListener(logic, this.searchField));
		
		this.nfcButton.addActionListener(new NFCButtonListener(logic));
		
		this.pinButton.addActionListener(new PINButtonListener(logic));
		
		this.cashButton.addActionListener(new CashButtonListener(logic));
	}
}
