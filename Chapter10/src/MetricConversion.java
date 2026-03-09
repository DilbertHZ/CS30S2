import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class MetricConversion {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MetricConversion window = new MetricConversion();
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
	public MetricConversion() {
		initialize();
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 205);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 166);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel prompt = new JLabel("Select a conversion type:");
		prompt.setFont(new Font("Tahoma", Font.BOLD, 17));
		prompt.setBounds(37, 22, 229, 19);
		panel.add(prompt);
		
		JTextArea disp = new JTextArea();
		disp.setWrapStyleWord(true);
		disp.setLineWrap(true);
		disp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		disp.setBackground(UIManager.getColor("Button.background"));
		disp.setBounds(37, 104, 372, 36);
		panel.add(disp);
		
		JComboBox selectionBox = new JComboBox();
		selectionBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 if (selectionBox.getSelectedItem().equals("Inches to Centimeters"))
			 {
				 disp.setText("1 inch = 2.54 centimeters");
			 }
			 else if (selectionBox.getSelectedItem().equals("Feet to Meters"))
			 {
				 disp.setText("1 foot = 0.3048 meters");
			 }
			 else if (selectionBox.getSelectedItem().equals("Gallons to Liters"))
			 {
				 disp.setText("1 gallon = 4.5461 liters");
			 }
			 else if(selectionBox.getSelectedItem().equals("Pounds to Kilograms"))
			 {
				 disp.setText("1 pound = 0.4536 kilograms");
			 }
		
			}
		});
		selectionBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		selectionBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Inches to Centimeters", "Feet to Meters", "Gallons to Liters", "Pounds to Kilograms"}));
		selectionBox.setBounds(37, 52, 372, 41);
		panel.add(selectionBox);
		
		
		
		
	}
}
