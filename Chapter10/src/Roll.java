import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Roll {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Roll window = new Roll();
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
	public Roll() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon dice1 = new ImageIcon("../Chapter10/src/dice1.png");
		ImageIcon dice2 = new ImageIcon("../Chapter10/src/dice2.png");
		ImageIcon dice3 = new ImageIcon("../Chapter10/src/dice3.png");
		ImageIcon dice4 = new ImageIcon("../Chapter10/src/dice4.png");
		ImageIcon dice5 = new ImageIcon("../Chapter10/src/dice5.png");
		ImageIcon dice6 = new ImageIcon("../Chapter10/src/dice6.png");
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel diceImg2 = new JLabel("");
		diceImg2.setBounds(236, 11, 188, 188);
		panel.add(diceImg2);
		
		JLabel diceImg1 = new JLabel("");
		diceImg1.setBounds(10, 11, 188, 188);
		panel.add(diceImg1);
		
		JButton btnRollDice = new JButton("Roll Dice");
		btnRollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int firstDice = (int)(Math.random() * 6) + 1; 
				int secondDice = (int)(Math.random() * 6) + 1; 
				
				if (firstDice == 1)
				{
					diceImg1.setIcon(dice1);
				}
				else if (firstDice == 2)
				{
					diceImg1.setIcon(dice2);
				}
				else if (firstDice == 3)
				{
					diceImg1.setIcon(dice3);
				}
				else if (firstDice == 4)
				{
					diceImg1.setIcon(dice4);
				}
				else if (firstDice == 5)
				{
					diceImg1.setIcon(dice5);
				}
				else if (firstDice == 6)
				{
					diceImg1.setIcon(dice6);
				}
				
				if (secondDice == 1)
				{
					diceImg2.setIcon(dice1);
				}
				else if (secondDice == 2)
				{
					diceImg2.setIcon(dice2);
				}
				else if (secondDice == 3)
				{
					diceImg2.setIcon(dice3);
				}
				else if (secondDice == 4)
				{
					diceImg2.setIcon(dice4);
				}
				else if (secondDice == 5)
				{
					diceImg2.setIcon(dice5);
				}
				else if (secondDice == 6)
				{
					diceImg2.setIcon(dice6);
				}
				
			}
		});
		btnRollDice.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRollDice.setBounds(134, 210, 174, 40);
		panel.add(btnRollDice);
	}

}
