import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame 
{
	private JTextField txtGuess;  //text field for user's guess
	private JLabel lblOutput;  // label for too high/too low output
	private int theNumber;
	
	public void checkGuess()
	{
		String guessText = txtGuess.getText();
		String message = "";
		try
		{			
			//	check the guess for too high/too low
			int guess = Integer.parseInt(guessText);
			//	too high
			if (guess < theNumber)
			{
				message = guess + " Was too low. Guess again.";
				lblOutput.setText(message);
			}
			else
			{ 
				//guessed correctly
				message = guess + " Was right! You win. Play again.";
				lblOutput.setText(message);
				newGame();
			}
		}
		catch (Exception e)
		{
			lblOutput.setText("Couldn't understand that answer.  Try again.");
		}
		finally
		{
			//this focuses the text field
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}        
	}
	public void newGame()
	{ 
		// create a new random number between 1-100
		theNumber = (int)(Math.random() * 100 + 1);
	}
	public GuessingGame()
	{
		setBackground(new Color(51, 204, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(51, 204, 255));
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("GUESSING GAME");
		lblTitle.setBounds(0, 27, 434, 20);
		lblTitle.setBackground(Color.GRAY);
		lblTitle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTitle);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 255));
		panel.setBounds(0, 74, 434, 48);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100:");
		lblGuessANumber.setBounds(32, 17, 231, 14);
		panel.add(lblGuessANumber);
		lblGuessANumber.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				checkGuess();
			}
		});
		txtGuess.setBounds(273, 14, 86, 20);
		panel.add(txtGuess);
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("GUESS");
		btnGuess.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnGuess.setForeground(new Color(0, 0, 0));
		btnGuess.setBackground(new Color(0, 204, 0));
		btnGuess.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				checkGuess();
			}
		});
		btnGuess.setBounds(131, 133, 166, 48);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Try to guess a number");
		lblOutput.setToolTipText("Guess a number between 1 and 100");
		lblOutput.setBackground(new Color(153, 204, 255));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(85, 199, 257, 34);
		getContentPane().add(lblOutput);
	}
	
	public static void main(String[] args)
	{
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(430, 330));
		theGame.setVisible(true);
	}
}