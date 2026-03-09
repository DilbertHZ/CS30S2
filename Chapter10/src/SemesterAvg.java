import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class SemesterAvg {

	private JFrame frame;
	private JTextField grade1;
	private JTextField grade2;
	private JTextField grade3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SemesterAvg window = new SemesterAvg();
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
	public SemesterAvg() {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		grade1 = new JTextField();
		grade1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		grade1.setBounds(225, 19, 196, 45);
		panel.add(grade1);
		grade1.setColumns(10);
		
		grade2 = new JTextField();
		grade2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		grade2.setBounds(225, 77, 196, 45);
		panel.add(grade2);
		grade2.setColumns(10);
		
		grade3 = new JTextField();
		grade3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		grade3.setBounds(225, 136, 196, 45);
		panel.add(grade3);
		grade3.setColumns(10);
		
		JLabel prompt1 = new JLabel("Enter the first grade:");
		prompt1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		prompt1.setBounds(10, 31, 184, 14);
		panel.add(prompt1);
		
		JLabel prompt2 = new JLabel("Enter the second grade:");
		prompt2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		prompt2.setBounds(10, 89, 197, 14);
		panel.add(prompt2);
		
		JLabel prompt3 = new JLabel("Enter the third grade:");
		prompt3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		prompt3.setBounds(10, 148, 197, 14);
		panel.add(prompt3);
		
		JTextArea disp = new JTextArea();
		disp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		disp.setWrapStyleWord(true);
		disp.setLineWrap(true);
		disp.setBackground(UIManager.getColor("Button.background"));
		disp.setBounds(225, 203, 196, 36);
		panel.add(disp);
		
		JButton btnNewButton = new JButton("Average");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double firstGrade = Double.parseDouble(grade1.getText());
				double secondGrade = Double.parseDouble(grade2.getText());
				double thirdGrade = Double.parseDouble(grade3.getText());
				
				double averageGrade = Math.round(((firstGrade + secondGrade + thirdGrade) / 3) * 10) / 10.0;
				
				disp.setText(String.valueOf(averageGrade));
			}

			
		});
		btnNewButton.setBounds(10, 191, 184, 45);
		panel.add(btnNewButton);
		
		
	}
}
