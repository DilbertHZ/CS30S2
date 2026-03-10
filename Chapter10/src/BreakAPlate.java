/*

Program: BreakAPlate.java          Last Date of this Revision: March 5, 2026

Purpose: An application that checks if 3 random numbers are equal to zero, if so the user wins.

Author: Hunter Zahn, 
School: CHHS
Course: Computer Programming 3010

*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class BreakAPlate {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BreakAPlate window = new BreakAPlate();
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
	public BreakAPlate() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ImageIcon plates = new ImageIcon("../Chapter10/src/plates.gif");
		ImageIcon platesAllBroken = new ImageIcon("../Chapter10/src/plates_all_broken.gif");
		ImageIcon platesTwoBroken = new ImageIcon("../Chapter10/src/plates_two_broken.gif");
		ImageIcon sticker = new ImageIcon("../Chapter10/src/sticker.jpg");
		ImageIcon tiger = new ImageIcon("../Chapter10/src/tiger_plush.gif");
		ImageIcon placeholder = new ImageIcon("../Chapter10/src/placeholder.gif");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 407, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(0, 0, 391, 296);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel platesImg;
		platesImg = new JLabel("");
		platesImg.setBounds(58, 18, 275, 76);
		panel.add(platesImg);
		
		JLabel prizeImg = new JLabel("");
		prizeImg.setBounds(139, 155, 111, 111);
		panel.add(prizeImg);
		
		JButton playButton = new JButton("Play");
		playButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		playButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				platesImg.setIcon(platesAllBroken);
				prizeImg.setIcon(placeholder);
				
				if (playButton.getText() == "Play") {
					
					int firstRoll = (int)(Math.random() * 2); 
					int secondRoll = (int)(Math.random() * 2); 
					int thirdRoll = (int)(Math.random() * 2); 
					
					if (firstRoll == 0 && secondRoll == 0 && thirdRoll == 0) {
						platesImg.setIcon(platesAllBroken);
						prizeImg.setIcon(tiger);
					}
					else {
						platesImg.setIcon(platesTwoBroken);
						prizeImg.setIcon(sticker);
					}
					
					playButton.setText("Play Again");
					
				}
				else if (playButton.getText() == "Play Again") {
					platesImg.setIcon(plates);
					prizeImg.setIcon(placeholder);
					playButton.setText("Play");
				}
				
				
			}
		});
		playButton.setBounds(101, 105, 189, 39);
		panel.add(playButton);
		
		
		
		
	}
}
