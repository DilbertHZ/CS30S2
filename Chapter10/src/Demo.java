import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class Demo {

	private JFrame frame;
	private JTextField fName;
	private JTextField lName;
	private JComboBox grades;
	private JComboBox schools;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo window = new Demo();
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
	public Demo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ImageIcon western = new ImageIcon("../Chapter10/src/Western.png");
		ImageIcon crescent = new ImageIcon("../Chapter10/src/Crescent.png");
		ImageIcon churchill = new ImageIcon("../Chapter10/src/Churchill.jpg");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 545, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 529, 308);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		fName = new JTextField();
		fName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(fName.getText().equals("First Name"))
					fName.setText("");
			}
		});
		fName.setForeground(Color.GRAY);
		fName.setText("First Name");
		fName.setBounds(60, 65, 118, 37);
		panel.add(fName);
		fName.setColumns(10);
		
		lName = new JTextField();
		lName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(lName.getText().equals("Last Name"))
					lName.setText("");
			}
		});
		lName.setForeground(Color.GRAY);
		lName.setText("Last Name");
		lName.setColumns(10);
		lName.setBounds(211, 65, 118, 37);
		panel.add(lName);
		
		grades = new JComboBox();
		grades.setFont(new Font("Tahoma", Font.PLAIN, 13));
		grades.setModel(new DefaultComboBoxModel(new String[] {"Select Grade", "10", "11", "12"}));
		grades.setBounds(60, 113, 118, 22);
		panel.add(grades);
		
		schools = new JComboBox();
		schools.setModel(new DefaultComboBoxModel(new String[] {"Select School", "Crescent", "Western", "Churchill"}));
		schools.setFont(new Font("Tahoma", Font.PLAIN, 13));
		schools.setBounds(211, 114, 118, 22);
		panel.add(schools);
		
		JTextArea disp = new JTextArea();
		disp.setBackground(new Color(240, 240, 240));
		disp.setWrapStyleWord(true);
		disp.setLineWrap(true);
		disp.setBounds(60, 146, 269, 140);
		panel.add(disp);
		
		JLabel pic = new JLabel("");
		pic.setBounds(346, 146, 161, 140);
		panel.add(pic);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String fn = fName.getText();
				String ln = lName.getText();
				String grade = "";
				String school = "";
				
				//Grade level
				if(grades.getSelectedItem().equals("12"))
				{
					grade = "12";
				}
				else if(grades.getSelectedItem().equals("11"))
				{
					grade = "11";
				}
				else if(grades.getSelectedItem().equals("10"))
				{
					grade = "10";
				}
				
				//School
				if(schools.getSelectedItem().equals("Crescent"))
				{
					school = "Crescent";
					
					pic.setIcon(crescent);
				}
				else if(schools.getSelectedItem().equals("Western"))
				{
					school = "Western";
					
					pic.setIcon(western);
				}
				else if(schools.getSelectedItem().equals("Churchill"))
				{
					school = "Churchill";
					
					pic.setIcon(churchill);
				}
				
				disp.setText(fn + " " + ln + " is in grade " + grade + " and goes to " + school
						);
				
			}
		});
		submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		submit.setBounds(360, 65, 118, 37);
		panel.add(submit);
		
		
	}
}
