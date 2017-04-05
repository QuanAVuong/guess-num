package com.quan.GuessNumGUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessNumGUI extends JFrame {
	private JTextField txtInput;
	private JLabel lblOutput;
	private int number;
	
	public void evaluateGuess(){
		String input = txtInput.getText();
		String output = "";
		
		try {
			int guess = Integer.parseInt(input);
			
			if (  guess < number ) {
				output = guess + " is too low";
				lblOutput.setText(output);
			}
			else if (  guess > number ) {
				output = guess + " is too high";
				lblOutput.setText(output);
			}
			else {
				output = guess + " is correct ! Play again!";
				lblOutput.setText(output);
				lblOutput.setForeground(new Color(0, 250, 0));
				
				newGame();
			}
		}
		catch (Exception exc) {
			lblOutput.setText("Whole number between 1 - 100 only please.");
			lblOutput.setForeground(new Color(250, 0, 0));
		}
		finally {
			txtInput.requestFocus();
			txtInput.selectAll();
//			txtInput.setText("");
		}
	}
	
	public void newGame(){
		number = (int) (Math.random() * 100 + 1);
		
	}
	
	public GuessNumGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setForeground(new Color(255, 200, 0));
		getContentPane().setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JLabel lblGuessnum = new JLabel("GuessNum");
		lblGuessnum.setForeground(Color.ORANGE);
		lblGuessnum.setFont(new Font("Lucida Sans Typewriter", Font.BOLD | Font.ITALIC, 13));
		lblGuessnum.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuessnum.setBounds(0, 6, 450, 16);
		getContentPane().add(lblGuessnum);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(6, 88, 438, 36);
		getContentPane().add(panel);
		
		JLabel lblWhatNumberDo = new JLabel("What number do you think it is ?");
		lblWhatNumberDo.setForeground(Color.ORANGE);
		lblWhatNumberDo.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		panel.add(lblWhatNumberDo);
		
		txtInput = new JTextField();
		txtInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evaluateGuess();
			}
		});
		panel.add(txtInput);
		txtInput.setColumns(10);
		
		JButton btnImFeelingLucky = new JButton("I'm Feeling Lucky !");
		btnImFeelingLucky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evaluateGuess();
			}
		});
		btnImFeelingLucky.setForeground(new Color(0, 204, 51));
		btnImFeelingLucky.setBackground(new Color(0, 0, 0));
		btnImFeelingLucky.setBounds(153, 160, 144, 29);
		getContentPane().add(btnImFeelingLucky);
		
		lblOutput = new JLabel("Hint: guess 1 - 100, then hit that button (or enter)!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setForeground(Color.ORANGE);
		lblOutput.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblOutput.setBounds(6, 256, 438, 16);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessNumGUI guessNum = new GuessNumGUI();
		guessNum.newGame();
		guessNum.setSize(new Dimension(430, 330));
		guessNum.setVisible(true);

	}
}
