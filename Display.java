//Inayat Kaur
//2020csb1088

import java.util.Vector;

/*The Display class contains all the strings to be displayed while running the programme.*/

public class Display{	
	/**Asking user for mode to play when the game starts**/
	public void start(){
		System.out.print("Enter '1' for 1 player mode or '2' for two player mode :");
	}
	
	/**Giving details of Mode1 to user**/
	public void startMode1(){
		System.out.println("You are Player 1 and computer is Player 2");
		System.out.println("Player 1 is 'X'");
		System.out.println("Player 2 is 'O'");
		System.out.println("Player 1 moves first ...\n");
		positions();
	}
	
	/**Giving details of Mode2 to user**/
	public void startMode2(){
		System.out.println("Player 1 is 'X'");
		System.out.println("Player 2 is 'O'");
		System.out.println("Player 1 moves first ...\n");
		positions();
	}
	
	/**Displaying error when invalid option is chosen**/
	public void invalid(){
		System.out.println("Invalid option");
	}
	
	/**Displaying the matrix positions corresponding to the number**/
	public void positions(){
		System.out.println(" 1 | 2 | 3");
		System.out.println("-----------");
		System.out.println(" 4 | 5 | 6");
		System.out.println("-----------");
		System.out.println(" 7 | 8 | 9\n");
	}
	
	/**Displaying the current state of the game**/
	public void currentState(char[][] matrix){
		System.out.println(" "+matrix[0][0] +" | "+matrix[0][1]+" | "+matrix[0][2]);
		System.out.println("-----------");
		System.out.println(" "+matrix[1][0] +" | "+matrix[1][1]+" | "+matrix[1][2]);
		System.out.println("-----------");
		System.out.println(" "+matrix[2][0] +" | "+matrix[2][1]+" | "+matrix[2][2]+"\n");
	}
	
	/**Displaying the available options for moving**/
	public void optionsForMove(Vector<Integer> options){
		System.out.print("Your options are [ ");
		for(int i=0;i<options.size();i++){
			System.out.print(options.elementAt(i) + " ");
		}
		System.out.print("]\n");
	}
	
	/**Displaying the winner or draw when the game ends**/
	public void winStatus(char w){
		if(w=='X') System.out.println("Player 1 has won the game!");
		else if(w=='O') System.out.println("Player 2 has won the game!");
		else System.out.println("It is a draw!");
	}
	
	/**Asking player-p to make next move**/
	public void nextMove(int p){
		System.out.println("Player "+p+" turn: ");
	}	
}
