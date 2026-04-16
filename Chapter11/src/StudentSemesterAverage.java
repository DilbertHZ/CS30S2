/*

Program: StudentSemesterAverage.java          Last Date of this Revision: April 9, 2026

Purpose: An application that calculates and saves a students grade average to a file.

Author: Hunter Zahn, 
School: CHHS
Course: Computer Programming 30
 

*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;

public class StudentSemesterAverage {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldGradeLvl;
	private JTextField textFieldSemester;
	private JTextField textFieldGrade1;
	private JTextField textFieldGrade2;
	private JTextField textFieldGrade3;
	private JTextField textFieldGrade4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSemesterAverage window = new StudentSemesterAverage();
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
	public StudentSemesterAverage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 302);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStuName = new JLabel("Student Name:");
		lblStuName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStuName.setBounds(0, 3, 135, 14);
		panel.add(lblStuName);
		
		JLabel lblGradeLevel = new JLabel("Grade Level:");
		lblGradeLevel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGradeLevel.setBounds(0, 28, 135, 14);
		panel.add(lblGradeLevel);
		
		JLabel lblSemesterNumber = new JLabel("Semester Number:");
		lblSemesterNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSemesterNumber.setBounds(0, 53, 135, 14);
		panel.add(lblSemesterNumber);
		
		JLabel lblGrade1 = new JLabel("Grade 1:");
		lblGrade1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGrade1.setBounds(0, 78, 135, 14);
		panel.add(lblGrade1);
		
		JLabel lblGrade2 = new JLabel("Grade 2:");
		lblGrade2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGrade2.setBounds(0, 103, 135, 14);
		panel.add(lblGrade2);
		
		JLabel lblGrade3 = new JLabel("Grade 3:");
		lblGrade3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGrade3.setBounds(0, 128, 135, 14);
		panel.add(lblGrade3);
		
		JLabel lblGrade4 = new JLabel("Grade 4:");
		lblGrade4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGrade4.setBounds(0, 153, 135, 14);
		panel.add(lblGrade4);
		
		JLabel lblAverage = new JLabel("Average:");
		lblAverage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAverage.setBounds(0, 178, 135, 14);
		panel.add(lblAverage);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(221, 0, 213, 20);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldGradeLvl = new JTextField();
		textFieldGradeLvl.setColumns(10);
		textFieldGradeLvl.setBounds(221, 25, 213, 20);
		panel.add(textFieldGradeLvl);
		
		textFieldSemester = new JTextField();
		textFieldSemester.setColumns(10);
		textFieldSemester.setBounds(221, 51, 213, 20);
		panel.add(textFieldSemester);
		
		textFieldGrade1 = new JTextField();
		textFieldGrade1.setColumns(10);
		textFieldGrade1.setBounds(221, 76, 213, 20);
		panel.add(textFieldGrade1);
		
		textFieldGrade2 = new JTextField();
		textFieldGrade2.setColumns(10);
		textFieldGrade2.setBounds(221, 101, 213, 20);
		panel.add(textFieldGrade2);
		
		textFieldGrade3 = new JTextField();
		textFieldGrade3.setColumns(10);
		textFieldGrade3.setBounds(221, 126, 213, 20);
		panel.add(textFieldGrade3);
		
		textFieldGrade4 = new JTextField();
		textFieldGrade4.setColumns(10);
		textFieldGrade4.setBounds(221, 151, 213, 20);
		panel.add(textFieldGrade4);
		
		JLabel lblAverageNumber = new JLabel("");
		lblAverageNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAverageNumber.setBounds(221, 179, 213, 14);
		panel.add(lblAverageNumber);
		
		JTextArea txtAreaFileData = new JTextArea();
		txtAreaFileData.setEditable(false);
		txtAreaFileData.setBackground(new Color(240, 240, 240));
		txtAreaFileData.setWrapStyleWord(true);
		txtAreaFileData.setLineWrap(true);
		txtAreaFileData.setBounds(7, 194, 419, 68);
		panel.add(txtAreaFileData);
		
		JButton btnSave = new JButton("Save to File");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Declare variables from user inputs
				String stuName = textFieldName.getText();
				int gradeLevel = Integer.parseInt(textFieldGradeLvl.getText());
				int semesterNum = Integer.parseInt(textFieldSemester.getText());
				double grade1 = Double.parseDouble(textFieldGrade1.getText());
				double grade2 = Double.parseDouble(textFieldGrade2.getText());
				double grade3 = Double.parseDouble(textFieldGrade3.getText());
				double grade4 = Double.parseDouble(textFieldGrade4.getText());
				
				//Calculate average grade
				double average = (grade1 + grade2 + grade3 + grade4) / 4;
				
				//Create a File object with the name of your file is the parameter
				File dataFile = new File("../Chapter11/src/Average.txt");	
				
				//Declare a File writer object
				FileWriter out; 
				
				//Declare a BufferedWriter object
				BufferedWriter writeFile;
				
				try 
				{
					out = new FileWriter(dataFile);
					writeFile = new BufferedWriter(out);
					
					//Writes info to file
					writeFile.write("Name: " + stuName + " Grade level: " + gradeLevel + " Semester: " + semesterNum 
							+ " Grade 1: " + grade1 + " Grade 2: " + grade2  + " Grade 3: " + grade3  + " Grade 4: " + grade4  + " Grade average: " + average);
					
					writeFile.close();
					out.close();		
				}
				catch(IOException r)
				{
					System.out.println("Problem reading file.");
					System.err.println("IOException: " + r.getMessage());
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSave.setBounds(54, 268, 146, 25);
		panel.add(btnSave);
		
		JButton btnView = new JButton("View File Contents");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Create a File object with the name of your file is the parameter
				File dataFile = new File("../Chapter11/src/Average.txt");	
				
				//Declare a File reader object
				FileReader in;
				
				//Declare a BufferedReader object
				BufferedReader readFile;
				
				try 
				{
					in = new FileReader(dataFile);
					readFile = new BufferedReader(in);
					
					//Sets text area to the information read from the text file
					txtAreaFileData.setText(readFile.readLine());
				
					readFile.close();
					in.close();		
				}
				catch(FileNotFoundException r)
				{
					System.out.println("File does not exist.");
					System.err.println("FileNotFoundException: " + r.getMessage());
				}
				catch(IOException r)
				{
					System.out.println("Problem reading file.");
					System.err.println("IOException: " + r.getMessage());
				}
			}
		});
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnView.setBounds(232, 268, 146, 25);
		panel.add(btnView);
	}
}
