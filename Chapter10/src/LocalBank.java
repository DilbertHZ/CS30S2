/*

Program: BreakAPlate.java          Last Date of this Revision: March 5, 2026

Purpose: An application that allows a user to create, delete, or access a bank account. Along with deposit, withdraw, or check funds. 

Author: Hunter Zahn, 
School: CHHS
Course: Computer Programming 3010

*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LocalBank {
	
	Bank bank = new Bank();

	private JFrame frame;
	private JTextField textAccNumber;
	private JTextField textAmount;
	private JTextField textfName;
	private JTextField textlName;
	private JTextField textBalance;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocalBank window = new LocalBank();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LocalBank() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 371);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox actionSelector = new JComboBox();
		actionSelector.setFont(new Font("Tahoma", Font.BOLD, 13));
		actionSelector.setModel(new DefaultComboBoxModel(new String[] {"Deposit", "Withdrawal", "Check balance", "Add an account", "Remove an account"}));
		actionSelector.setBounds(20, 25, 394, 27);
		panel.add(actionSelector);
		
		JLabel labelWarning = new JLabel("Complete the information in RED");
		labelWarning.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelWarning.setBounds(20, 63, 394, 14);
		panel.add(labelWarning);
		
		JLabel labelAccNumber = new JLabel("Account number:");
		labelAccNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelAccNumber.setForeground(Color.RED);
		labelAccNumber.setBounds(20, 84, 394, 14);
		panel.add(labelAccNumber);
		
		JLabel labelAmount = new JLabel("Amount of deposit/withdrawal:");
		labelAmount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelAmount.setForeground(Color.RED);
		labelAmount.setBounds(20, 123, 394, 14);
		panel.add(labelAmount);
		
		JLabel labelFName = new JLabel("First Name:");
		labelFName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelFName.setBounds(20, 163, 394, 14);
		panel.add(labelFName);
		
		JLabel labelLName = new JLabel("Last Name:");
		labelLName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelLName.setBounds(20, 204, 394, 14);
		panel.add(labelLName);
		
		JLabel labelBalance = new JLabel("Beginning Balance:");
		labelBalance.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelBalance.setBounds(20, 244, 394, 14);
		panel.add(labelBalance);
		
		textAccNumber = new JTextField();
		textAccNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAccNumber.setBounds(20, 98, 394, 20);
		panel.add(textAccNumber);
		textAccNumber.setColumns(10);
		
		textAmount = new JTextField();
		textAmount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAmount.setColumns(10);
		textAmount.setBounds(20, 137, 394, 20);
		panel.add(textAmount);
		
		textfName = new JTextField();
		textfName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textfName.setColumns(10);
		textfName.setBounds(20, 177, 394, 20);
		panel.add(textfName);
		
		textlName = new JTextField();
		textlName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textlName.setColumns(10);
		textlName.setBounds(20, 218, 394, 20);
		panel.add(textlName);
		
		textBalance = new JTextField();
		textBalance.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textBalance.setColumns(10);
		textBalance.setBounds(20, 258, 394, 20);
		panel.add(textBalance);
		
		JLabel labelAction = new JLabel("Select an action:");
		labelAction.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelAction.setBounds(20, 11, 394, 14);
		panel.add(labelAction);
		
		JLabel labelInfo = new JLabel("");
		labelInfo.setBounds(20, 288, 394, 38);
		panel.add(labelInfo);
		
		JButton buttonProcess = new JButton("Process Transaction");
		buttonProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				//Checks the users selection, and ensures that the necessary information isn't absent
				if (actionSelector.getSelectedItem().equals("Deposit") && !textAccNumber.getText().equals("") && !textAmount.getText().equals(""))
				 {
					//Tries to complete the action with the provided information
					try
					{
						labelInfo.setText(bank.transaction(1, textAccNumber.getText(), Double.parseDouble(textAmount.getText())));
					}
					//Catches invalid information eg: a string when an int is required
					catch(NumberFormatException e1)
					{
						labelInfo.setText("Please enter a numeric value");
					}
				 }
				 else if (actionSelector.getSelectedItem().equals("Withdrawal") && !textAccNumber.getText().equals("") && !textAmount.getText().equals(""))
				 {
					 try
						{
						 	labelInfo.setText(bank.transaction(2, textAccNumber.getText(), Double.parseDouble(textAmount.getText())));
						}
						catch(NumberFormatException e1)
						{
							labelInfo.setText("Please enter a numeric value");
						}
				 }
				 else if (actionSelector.getSelectedItem().equals("Check balance"))
				 {
					 labelInfo.setText(bank.checkBalance(textAccNumber.getText()));
				 }
				 else if(actionSelector.getSelectedItem().equals("Add an account") && !textfName.getText().equals("") && !textlName.getText().equals("") && !textBalance.getText().equals(""))
				 {
					 try
						{
						 labelInfo.setText(("Your account ID is: " + bank.addAccount(textfName.getText(), textlName.getText(), Double.parseDouble(textBalance.getText()))));
						}
						catch(NumberFormatException e1)
						{
							labelInfo.setText("Please enter a numeric value");
						}
				 }
				 else if(actionSelector.getSelectedItem().equals("Remove an account"))
				 {
					 labelInfo.setText(bank.deleteAccount(textAccNumber.getText()));
				 }
				 else 
				 {
					 labelInfo.setText("Please enter all necessary information");
				 }
				
				//Resets all text fields
				textAccNumber.setText("");
				textAmount.setText("");
				textfName.setText("");
				textlName.setText("");
				textBalance.setText("");
				
			}
		});
		buttonProcess.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonProcess.setBounds(20, 332, 156, 27);
		panel.add(buttonProcess);
		
		
	}
}
