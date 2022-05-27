//Inayat Kaur
//2020csb1088

import java.util.Random;

/**It imitates a Computer player. For making a move, it first check if there are two consecutive 'O's or two consecutive 'X's so as to decide if it will win or lose in the next turn. In case it doesn't find any good move, it will make a random move.**/

public class Computer extends Player{
	/**It inherits mark and number variables from Player class**/
	
	public Computer(char mark, int number){ //Constructor
		super(mark , number);
	}
	
	/**Makes move by checking initially if it will win in next move due to consecutive 'O's or it will lose in next move due to consecutive 'X's. If it is not the case then it will move randomly**/
	public void makeMove(Game game){		
		int choice;
		if(checkIfWinning(game)!=-1) choice = checkIfWinning(game);
		else if(checkIfLosing(game)!=-1) choice = checkIfLosing(game);
		else{
			Random rand = new Random();
			choice = game.getOptions().elementAt(rand.nextInt(game.getOptions().size()));
		}
		game.makeMove(choice,mark);
	}
	
	/**Check if there are 2 'O's and an empty cell**/
	private int checkIfWinning(Game game){
		char[][] matrix = new char[3][3];
		matrix[0][0] = (game.getMatrix())[0][0];
		matrix[0][1] = (game.getMatrix())[0][1];
		matrix[0][2] = (game.getMatrix())[0][2];
		matrix[1][0] = (game.getMatrix())[1][0];
		matrix[1][1] = (game.getMatrix())[1][1];
		matrix[1][2] = (game.getMatrix())[1][2];
		matrix[2][0] = (game.getMatrix())[2][0];
		matrix[2][1] = (game.getMatrix())[2][1];
		matrix[2][2] = (game.getMatrix())[2][2];
		char m;
		for(int i=0;i<game.getOptions().size();i++){
			m = checkIfMoveWorks(game.getOptions().elementAt(i),matrix,'O');
			if(m=='O') return game.getOptions().elementAt(i);
		}
		return -1;
	}
	
	/**Check if there are 2 'X's and an empty cell**/
	private int checkIfLosing(Game game){
		char[][] matrix = new char[3][3];
		matrix[0][0] = (game.getMatrix())[0][0];
		matrix[0][1] = (game.getMatrix())[0][1];
		matrix[0][2] = (game.getMatrix())[0][2];
		matrix[1][0] = (game.getMatrix())[1][0];
		matrix[1][1] = (game.getMatrix())[1][1];
		matrix[1][2] = (game.getMatrix())[1][2];
		matrix[2][0] = (game.getMatrix())[2][0];
		matrix[2][1] = (game.getMatrix())[2][1];
		matrix[2][2] = (game.getMatrix())[2][2];
		char m;
		for(int i=0;i<game.getOptions().size();i++){
			m = checkIfMoveWorks(game.getOptions().elementAt(i),matrix,'X');
			if(m=='X') return game.getOptions().elementAt(i);
		}
		return -1;
	}
	
	/**Check if the given move either makes the Computer win or lose **/
	private char checkIfMoveWorks(int i,char[][] matrix, char mark){
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
		else{
		/**In case the move won't work, revert the copy of matrix to original state**/
			switch(i){
				case 1: matrix[0][0] = '1';
				break;
				case 2: matrix[0][1] = '2';
				break;
				case 3: matrix[0][2] = '3';
				break;
				case 4: matrix[1][0] = '4';
				break;
				case 5: matrix[1][1] = '5';
				break;
				case 6: matrix[1][2] = '6';
				break;
				case 7: matrix[2][0] = '7';
				break;
				case 8: matrix[2][1] = '8';
				break;
				case 9: matrix[2][2] = '9';
				break;			
			}
		 	return 'F';
		}
	}
}
