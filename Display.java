//Inayat Kaur
//2020csb1088

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*The Display class contains all the strings to be displayed while running the programme.*/

public class Display {
	private static final JFrame frame = new JFrame();
	private static final JPanel panel = new JPanel(new FlowLayout());
	private static final JPanel panelGrid = new JPanel(new GridLayout(3, 3));
	private static final JButton button1 = new JButton();
	private static final JButton button2 = new JButton();
	private static final JButton button3 = new JButton();
	private static final JButton button4 = new JButton();
	private static final JButton button5 = new JButton();
	private static final JButton button6 = new JButton();
	private static final JButton button7 = new JButton();
	private static final JButton button8 = new JButton();
	private static final JButton button9 = new JButton();
	private static final JLabel heading = new JLabel();
	private static final JLabel beggining = new JLabel();
	private static final JLabel end = new JLabel();

	private static int mode = 0;
	private int chosenOption = 0;

	private void paintFrame() {
		heading.setText("Welcome to Tic Tac Toe!");
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(heading);
		panel.add(beggining);
		panel.add(panelGrid);
		panel.add(end);
		panel.add(Box.createVerticalStrut(10));
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic Tac Toe");
		frame.setSize(800, 800);
		frame.setVisible(true);
	}

	/** Asking user for mode to play when the game starts **/
	public int start() {
		paintFrame();
		panelGrid.setLayout(new GridLayout(2,1));
		button1.setText("1 Player");
		button1.setSize(100, 25);
		button1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mode = 1;
			}
		});
		button2.setText("2 Player");
		button2.setSize(100, 25);
		button2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mode = 2;
			}
		});

		panelGrid.add(button1);
		panelGrid.add(button2);
		panelGrid.revalidate();
		panelGrid.repaint();
		panel.revalidate();
		panel.repaint();
		while (mode == 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Error");
			}
		}
		return mode;
	}

	/** Giving details of Mode1 to user **/
	public void startMode1() {
		beggining.setText("You are Player 1 and computer is Player 2\nPlayer 1 is 'X'\nPlayer 2 is 'O'\nPlayer 1 moves first ...\n");
		panel.revalidate();
		panel.repaint();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** Giving details of Mode2 to user **/
	public void startMode2() {
		beggining.setText("Player 1 is 'X'\nPlayer 2 is 'O'\nPlayer 1 moves first ...\n");
		panel.revalidate();
		panel.repaint();
	}

	/**
	 * Displaying the current state of the game and waiting for next player to make
	 * move
	 **/
	public int makeMove(char[][] matrix, int player) {
		panelGrid.removeAll();
		button1.removeAll();
		button2.removeAll();
		button3.removeAll();
		button4.removeAll();
		button5.removeAll();
		button6.removeAll();
		button7.removeAll();
		button8.removeAll();
		button9.removeAll();
		panelGrid.setLayout(new GridLayout(3, 3));
		chosenOption = 0;
		beggining.setText("Player " + player + "'s turn");
		button1.setText(Character.toString(matrix[0][0]));
		button1.setSize(100, 50);
		if (matrix[0][0] != 'O' && matrix[0][0] != 'X')
			button1.addActionListener(
					new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							chosenOption = 1;
						}
					});
		button2.setText(Character.toString(matrix[0][1]));
		button2.setSize(100, 50);
		if (matrix[0][1] != 'O' && matrix[0][1] != 'X')
			button2.addActionListener(
					new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							chosenOption = 2;
						}
					});
		button3.setText(Character.toString(matrix[0][2]));
		button3.setSize(100, 50);
		if (matrix[0][2] != 'O' && matrix[0][2] != 'X')
			button3.addActionListener(
					new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							chosenOption = 3;
						}
					});
		button4.setText(Character.toString(matrix[1][0]));
		button4.setSize(100, 50);
		if (matrix[1][0] != 'O' && matrix[1][0] != 'X')
			button4.addActionListener(
					new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							chosenOption = 4;
						}
					});
		button5.setText(Character.toString(matrix[1][1]));
		button5.setSize(100, 50);
		if (matrix[1][1] != 'O' && matrix[1][1] != 'X')
			button5.addActionListener(
					new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							chosenOption = 5;
						}
					});
		button6.setText(Character.toString(matrix[1][2]));
		button6.setSize(100, 50);
		if (matrix[1][2] != 'O' && matrix[1][2] != 'X')
			button6.addActionListener(
					new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							chosenOption = 6;
						}
					});
		button7.setText(Character.toString(matrix[2][0]));
		button7.setSize(100, 50);
		if (matrix[2][0] != 'O' && matrix[2][0] != 'X')
			button7.addActionListener(
					new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							chosenOption = 7;
						}
					});
		button8.setText(Character.toString(matrix[2][1]));
		button8.setSize(100, 50);
		if (matrix[2][1] != 'O' && matrix[2][1] != 'X')
			button8.addActionListener(
					new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							chosenOption = 8;
						}
					});
		button9.setText(Character.toString(matrix[2][2]));
		button9.setSize(100, 50);
		if (matrix[2][2] != 'O' && matrix[2][2] != 'X')
			button9.addActionListener(
					new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							chosenOption = 9;
						}
					});

		panelGrid.add(button1);
		panelGrid.add(button2);
		panelGrid.add(button3);
		panelGrid.add(button4);
		panelGrid.add(button5);
		panelGrid.add(button6);
		panelGrid.add(button7);
		panelGrid.add(button8);
		panelGrid.add(button9);
		panelGrid.revalidate();
		panelGrid.repaint();

		panel.revalidate();
		panel.repaint();

		while (chosenOption == 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Error");
			}
		}
		return chosenOption;
	}

	/** Displaying the winner or draw when the game ends **/
	public void winStatus(char w) {
		if (w == 'X')
			end.setText("Player 1 has won the game!");
		else if (w == 'O')
			end.setText("Player 2 has won the game!");
		else
			end.setText("It is a draw!");
		panel.revalidate();
		panel.repaint();
	}
}
