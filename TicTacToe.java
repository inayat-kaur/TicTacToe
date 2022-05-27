//Inayat Kaur
//2020csb1088

import java.util.Scanner;

public class TicTacToe{
	/**The programme starts running from here**/
	public static void main(String[] args){
		int mode,turn,pl;
		Display dis = new Display();
		dis.start();
		Scanner input = new Scanner(System.in);
		
		/**The do-while loop while run until correct mode is entered for playing the game i.e. either 1 or 2**/
		do{
		/**Asking user to choose the mode for playing**/
			mode = input.nextInt();
			
			if(mode==1){
			/**This part of code runs if user enters 1**/
				dis.startMode1();
				/**Creating 2 players - 1 is of Player class and other is of Computer class**/
				Player player1 = new Player('X',1);
				Computer player2 = new Computer('O',2);
				Game game = new Game();
				turn = 1;
				/**The loop runs until one of the players wins or there is no further move left**/
				while(game.getWinStatus() == 'F'){	
					/**Player with the turn makes move. Player 1 moves at odd turn and Player 2 at even**/				
					if(turn%2==0) pl = 2;
					else pl = 1;
					dis.nextMove(pl);
					dis.optionsForMove(game.getOptions());
					if(pl==1)player1.makeMove(game);
					else player2.makeMove(game);
					dis.currentState(game.getMatrix());
					turn++;
				}
				/**Displaying the winner or draw when the game ends**/
				dis.winStatus(game.getWinStatus());
			}
			
			else if(mode==2){
			/**This part of code runs if user enters 2**/
				dis.startMode2();
				/**Creating 2 players of Player class**/
				Player player1 = new Player('X',1);
				Player player2 = new Player('O',2);
				Game game = new Game();
				turn = 1;
				/**The loop runs until one of the players wins or there is no further move left**/
				while(game.getWinStatus() == 'F'){	
					/**Player with the turn makes move. Player 1 moves at odd turn and Player 2 at even**/				
					if(turn%2==0) pl = 2;
					else pl = 1;
					dis.nextMove(pl);
					dis.optionsForMove(game.getOptions());
					if(pl==1)player1.makeMove(game);
					else player2.makeMove(game);
					dis.currentState(game.getMatrix());
					turn++;
				}
				/**Displaying the winner or draw when the game ends**/
				dis.winStatus(game.getWinStatus());
			}
			
			else{
				/**Displaying error incase of invalid option chosen i.e. other than 1 or 2**/
				dis.invalid();			
			}
			
		}while(mode!=1&&mode!=2);
		
	}
}
