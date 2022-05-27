//Inayat Kaur
//2020csb1088

import java.util.Vector;

/**This class imitates the board of the tic-tac-toe which also acts as a referree to check when a player wins the game.**/
public class Game{
	
	/**The variables store the current state of the board**/
	private char[][] matrix = new char[3][3];
	private Vector<Integer> options;
	private char winStatus;
	
	public Game(){		//Constructor
		winStatus = 'F';	//by default winStatus is 'F' implying none has won the game and there is not a draw
		options = new Vector<Integer>();
		options.addElement(1);
		options.addElement(2);
		options.addElement(3);
		options.addElement(4);
		options.addElement(5);
		options.addElement(6);
		options.addElement(7);
		options.addElement(8);
		options.addElement(9);
		matrix[0][0]='1';
		matrix[0][1]='2';
		matrix[0][2]='3';
		matrix[1][0]='4';
		matrix[1][1]='5';
		matrix[1][2]='6';
		matrix[2][0]='7';
		matrix[2][1]='8';
		matrix[2][2]='9';
	}
	
	/**getters for private variables**/
	public char[][] getMatrix(){
		return matrix;
	}
	
	public Vector<Integer> getOptions(){
		return options;
	}
	
	public char getWinStatus(){
		return winStatus;
	}
	
	/**Making the required move**/
	public void makeMove(int i, char mark){
		switch(i){
			case 1: matrix[0][0] = mark;
			break;
			case 2: matrix[0][1] = mark;
			break;
			case 3: matrix[0][2] = mark;
			break;
			case 4: matrix[1][0] = mark;
			break;
			case 5: matrix[1][1] = mark;
			break;
			case 6: matrix[1][2] = mark;
			break;
			case 7: matrix[2][0] = mark;
			break;
			case 8: matrix[2][1] = mark;
			break;
			case 9: matrix[2][2] = mark;
			break;			
		}
		options.removeElement(i);   //Removing the move from available choices
		winStatus = checkWinStatus(); //Rechecking the winStatus after the move
	}
	
	/**Checking if some player has won or there is a draw**/
	private char checkWinStatus(){
		if(options.isEmpty())return 'D';
		char m;
		m = matrix[0][0];
		if(matrix[1][0]==m&&matrix[2][0]==m)return m;
		else if(matrix[1][1]==m&&matrix[2][2]==m) return m;
		else if(matrix[0][1]==m&&matrix[0][2]==m) return m;
		m = matrix[0][1];
		if(matrix[1][1]==m&&matrix[2][1]==m)return m;
		m = matrix[0][2];
		if(matrix[1][2]==m&&matrix[2][2]==m)return m;
		else if(matrix[1][1]==m&&matrix[2][0]==m)return m;
		m = matrix[1][0];
		if(matrix[1][1]==m&&matrix[1][2]==m)return m;
		m = matrix[2][0];
		if(matrix[2][1]==m&&matrix[2][2]==m)return m;
		else return 'F';
	}
}
