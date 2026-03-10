/*

Program: TicTacToe.java          Last Date of this Revision: March 5, 2026

Purpose: An application that works as a game of TicTacToe between two users.

Author: Hunter Zahn, 
School: CHHS
Course: Computer Programming 3010

*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TicTacToe {
	
	boolean tracker = true; //Turn tracker
	int[][] win = new int[3][3]; //Initializes multidimensional array
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe window = new TicTacToe();
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
	public TicTacToe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public boolean winCheckHorizontal(int[][] array)
	{
	    for (int i = 0; i <= 2; i++) {
	    	//System.out.println("Horizontal Test:"); //I used these prints to ensure the method was checking the correct data
	    	//System.out.println(array[i][0]);
			//System.out.println(array[i][1]);
			//System.out.println(array[i][2]);
	    	
	    	if (
	    			((array[i][0] == array[i][1]) && (array[i][0] == array[i][2]))
	    			&& (array[i][0] != 0)
	    			&& (array[i][1] != 0)
	    			&& (array[i][2] != 0)) {
	    		return true;
	    	}
	    } return false; //If wincon isn't met returns false for the winCheckMaster method 
	}
	
	public boolean winCheckVertical(int[][] array)
	{
		for (int i = 0; i <= 2; i++) {
			//System.out.println("Vertical Test:"); //Same as the above prints
			//System.out.println(array[0][i]);
			//System.out.println(array[1][i]);
			//System.out.println(array[2][i]);
			
			if(
					(array[0][i] == array[1][i]) && (array[0][i] == array[2][i]) 
					&& (array[0][i] != 0) && (array[1][i] != 0) && (array[2][i] != 0)
					) return true;
		} return false; //If wincon isn't met returns false for the winCheckMaster method 
	}
	
	public boolean winCheckDiagonal(int[][] array)
	{
		//System.out.println("Diagonal Test:"); //Same as the above prints
		//System.out.println(array[0][0]);
		//System.out.println(array[1][1]);
		//System.out.println(array[2][2]);
		//System.out.println(array[0][2]);
		//System.out.println(array[2][0]);
		
		if(		
				(array[0][0] == array[1][1]) && (array[0][0] == array[2][2])
				&& (array[0][0] != 0) 
				&& (array[1][1] != 0) 
				&& (array[2][2] != 0) 
				) {return true; 
		} else if (
				((array[0][2] == array[1][1]) && (array[0][2] == array[2][0]))
				&& (array[0][2] != 0) 
				&& (array[1][1] != 0) 
				&& (array[2][0] != 0)
				) {return true; 
		}
		return false; //If wincon isn't met returns false for the winCheckMaster method 
	}
	
	public boolean winCheckMaster()
	{
		if (winCheckVertical(win)) {
			//System.out.println("Vertical Win"); //These are to check the exact win type
			return true;
		} else if (winCheckHorizontal(win)) {
			//System.out.println("Horizontal Win"); //Another test message
			return true;
		} else if (winCheckDiagonal(win)) {
			//System.out.println("Diagonal Win"); //Another test message
			return true;
		} else {
			//System.out.println("No Winner Currently"); //Another test message
			return false;
		}
		
	}
	
	public String turnTracker()
	{
		//Checks what turn it is, this is to display the final win message 
		if (tracker == true) { 
			return "O";
		} return "X";
	}
	
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 325, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 309, 363);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel winAnnouncer = new JLabel("");
		winAnnouncer.setHorizontalAlignment(SwingConstants.CENTER);
		winAnnouncer.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		winAnnouncer.setBounds(10, 311, 289, 33);
		panel.add(winAnnouncer);
		
		JButton TL = new JButton("");
		TL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tracker) {
					//Sets box text
					TL.setText("x");
					//Changes turn
					tracker = false;
					//Sets box value in array
					win[0][0] = 1;
				} else { //Everything here is the opposite of the aforementioned 
					TL.setText("o");
					tracker = true;
					win[0][0] = 2;
				}
				if (winCheckMaster()) {
					//Checks if the turn resulted in a winner
					winAnnouncer.setText(turnTracker() + " Wins!");
				}
			}
		});
		TL.setBounds(10, 11, 89, 89);
		panel.add(TL);
		
		JButton TM = new JButton("");
		TM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tracker) {
					TM.setText("x");
					tracker = false;
					win[0][1] = 1;
				} else {
					TM.setText("o");
					tracker = true;
					win[0][1] = 2;
				}
				if (winCheckMaster()) {
					winAnnouncer.setText(turnTracker() + " Wins!");
				}
			}
		});
		TM.setBounds(111, 11, 89, 89);
		panel.add(TM);
		
		JButton TR = new JButton("");
		TR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tracker) {
					TR.setText("x");
					tracker = false;
					win[0][2] = 1;
				} else {
					TR.setText("o");
					tracker = true;
					win[0][2] = 2;
				}
				if (winCheckMaster()) {
					winAnnouncer.setText(turnTracker() + " Wins!");
				}
			}
		});
		TR.setBounds(210, 11, 89, 89);
		panel.add(TR);
		
		JButton ML = new JButton("");
		ML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tracker) {
					ML.setText("x");
					tracker = false;
					win[1][0] = 1;
				} else {
					ML.setText("o");
					tracker = true;
					win[1][0] = 2;
				}
				if (winCheckMaster()) {
					winAnnouncer.setText(turnTracker() + " Wins!");
				}
			}
		});
		ML.setBounds(10, 111, 89, 89);
		panel.add(ML);
		
		JButton MM = new JButton("");
		MM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tracker) {
					MM.setText("x");
					tracker = false;
					win[1][1] = 1;
				} else {
					MM.setText("o");
					tracker = true;
					win[1][1] = 2;
				}
				if (winCheckMaster()) {
					winAnnouncer.setText(turnTracker() + " Wins!");
				}
			}
		});
		MM.setBounds(111, 111, 89, 89);
		panel.add(MM);
		
		JButton MR = new JButton("");
		MR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tracker) {
					MR.setText("x");
					tracker = false;
					win[1][2] = 1;
				} else {
					MR.setText("o");
					tracker = true;
					win[1][2] = 2;
				}
				if (winCheckMaster()) {
					winAnnouncer.setText(turnTracker() + " Wins!");
				}
			}
		});
		MR.setBounds(210, 111, 89, 89);
		panel.add(MR);
		
		JButton BL = new JButton("");
		BL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tracker) {
					BL.setText("x");
					tracker = false;
					win[2][0] = 1;
				} else {
					BL.setText("o");
					tracker = true;
					win[2][0] = 2;
				}
				if (winCheckMaster()) {
					winAnnouncer.setText(turnTracker() + " Wins!");
				}
			}
		});
		BL.setBounds(10, 211, 89, 89);
		panel.add(BL);
		
		JButton BM = new JButton("");
		BM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tracker) {
					BM.setText("x");
					tracker = false;
					win[2][1] = 1;
				} else {
					BM.setText("o");
					tracker = true;
					win[2][1] = 2;
				}
				if (winCheckMaster()) {
					winAnnouncer.setText(turnTracker() + " Wins!");
				}
			}
		});
		BM.setBounds(111, 211, 89, 89);
		panel.add(BM);
		
		JButton BR = new JButton("");
		BR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tracker) {
					BR.setText("x");
					tracker = false;
					win[2][2] = 1;
				} else {
					BR.setText("o");
					tracker = true;
					win[2][2] = 2;
				}
				if (winCheckMaster()) {
					winAnnouncer.setText(turnTracker() + " Wins!");
				}
			}
		});
		BR.setBounds(210, 211, 89, 89);
		panel.add(BR);
		
		
		
		
		
		
			

	}
}
