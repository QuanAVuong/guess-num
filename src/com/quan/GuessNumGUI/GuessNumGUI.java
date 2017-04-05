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
	private JLabel lblCount;
	private JButton btnGuess;
	
	private int number;
	private int guess;
	private int count;
	
	public void evaluateGuess(){
		String input = txtInput.getText();
		String output = "";
		
		try {
			guess = Integer.parseInt(input);
			count--;
			
			if ( count > 0 ) {
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
					lblOutput.setForeground(Color.GREEN);
					btnGuess.setEnabled(false);
					txtInput.setEditable(false);
					
				}
			} else {
				lblOutput.setText("You've lost ! Play again!");
				lblOutput.setForeground(Color.RED);
				lblCount.setForeground(Color.RED);
				btnGuess.setEnabled(false);
				txtInput.setEditable(false);
			}

		}
		catch (Exception exc) {
			lblOutput.setText("Whole number between 1 - 100 only please.");
			lblOutput.setForeground(Color.RED);
		}
		finally {
			lblCount.setText(count + " tries remaining...");
			txtInput.requestFocus();
			txtInput.selectAll();
		}
	}
	
	public void newGame(){
		number = (int) (Math.random() * 100 + 1);
		count = 7;
		
		btnGuess.setEnabled(true);
		
		txtInput.setEditable(true);
		txtInput.requestFocus();
		txtInput.setText("");
		
		lblCount.setForeground(Color.ORANGE);
		lblCount.setText("7 tries remaining...");
		lblOutput.setText("Hint: guess 1 - 100, then hit that button (or enter)!");
		lblOutput.setForeground(Color.ORANGE);
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
				if ( count <= 0 || guess == number)
					lblCount.setText("Hit New Game!");
				else
					evaluateGuess();
				
			}
		});
		panel.add(txtInput);
		txtInput.setColumns(10);
		
		btnGuess = new JButton("I'm Feeling Lucky !");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( count <= 0 || guess == number)
					lblCount.setText("Hit New Game!");
				else
					evaluateGuess();
			}
		});
		btnGuess.setForeground(new Color(0, 204, 51));
		btnGuess.setBackground(new Color(0, 0, 0));
		btnGuess.setBounds(63, 160, 144, 29);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Hint: guess 1 - 100, then hit that button (or enter)!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setForeground(Color.ORANGE);
		lblOutput.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblOutput.setBounds(6, 256, 438, 16);
		getContentPane().add(lblOutput);
		
		lblCount = new JLabel("7 tries remaining...");
		lblCount.setForeground(Color.ORANGE);
		lblCount.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCount.setBounds(116, 201, 223, 16);
		getContentPane().add(lblCount);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		btnNewGame.setForeground(Color.MAGENTA);
		btnNewGame.setBounds(270, 160, 117, 29);
		getContentPane().add(btnNewGame);
	}

	public static void main(String[] args) {
		GuessNumGUI guessNum = new GuessNumGUI();
		guessNum.newGame();
		guessNum.setSize(new Dimension(430, 330));
		guessNum.setVisible(true);
	}
}
