//Inayat Kaur
//2020csb1088
 
import java.util.Vector;

/**It imitates a Computer player. For making a move, it first check if there are two consecutive 'O's or two consecutive 'X's so as to decide if it will win or lose in the next turn. In case it doesn't find any good move, it will make a random move.**/

public class Computer extends Player{
	/**It inherits mark and number variables from Player class**/
	
	public Computer(char mark, int number){ //Constructor
		super(mark , number);
	}

	/**It performs the best move based on minimax algorithm where 'X' is the maximizing player.**/
	public void makeMove(Game game){
		int choice=0,val,minimax;
		Vector<Integer> choices = new Vector<Integer>(game.getOptions());

		if(mark=='X'){
			val = Integer.MIN_VALUE;
			for(int i=0;i<choices.size();i++){
				minimax=miniMax(game,choices,i,0,Integer.MIN_VALUE,Integer.MAX_VALUE,true);
				if(minimax>val){
					val = minimax;
					choice = choices.elementAt(i);
				}
			}
		}
		else{
			val = Integer.MAX_VALUE;
			for(int i=0;i<choices.size();i++){
				minimax=miniMax(game,choices,i,0,Integer.MIN_VALUE,Integer.MAX_VALUE,false);
				if(minimax<val){
					val = minimax;
					choice = choices.elementAt(i);
				}
			}
		} 
		game.makeMove(choice,mark);
	}

	/**Implementation of the recursive minimax function with alpha beta pruning**/
	private int miniMax(Game game,Vector<Integer> choices, int choice, int depth, int alpha, int beta, boolean maximizingPlayer){
		int temp=choices.elementAt(choice);
		choices.remove(choice);
		if(maximizingPlayer){
			updateMatrix(temp,game.getMatrix(),'X');
			char status = game.checkWinStatus();
			if(choices.isEmpty()&&status=='F'){
				updateMatrix(temp,game.getMatrix(),temp);
				choices.insertElementAt(temp,choice);
				return evaluation('D',depth);
			}
			else if(status!='F'){
				updateMatrix(temp,game.getMatrix(),temp);
				choices.insertElementAt(temp,choice);
				return evaluation(status,depth);
			}

			int maxEval = Integer.MIN_VALUE,eval;
			for(int i=0;i<choices.size();i++){
				eval = miniMax(game,choices,i, depth+1, alpha, beta, false);
				maxEval = Math.max(maxEval, eval);
				alpha = Math.max(alpha,eval);
				if(beta<=alpha)break;
			}
			choices.insertElementAt(temp,choice);
			updateMatrix(temp,game.getMatrix(),temp);
			return maxEval;
		}
		else{
			updateMatrix(temp,game.getMatrix(),'O');
			char status = game.checkWinStatus();
			if(choices.isEmpty()&&status=='F'){
				choices.insertElementAt(temp,choice);
				updateMatrix(temp,game.getMatrix(),temp);
				return evaluation('D',depth);
			}
			else if(status!='F'){
				choices.insertElementAt(temp,choice);
				updateMatrix(temp,game.getMatrix(),temp);
				return evaluation(status,depth);
			}

			int minEval = Integer.MAX_VALUE,eval;
			for(int i=0;i<choices.size();i++){
				eval = miniMax(game, choices,i, depth+1, alpha, beta, true);
				minEval = Math.min(minEval, eval);
				alpha = Math.min(alpha,eval);
				if(beta<=alpha)break;
			}
			choices.insertElementAt(temp,choice);
			updateMatrix(temp,game.getMatrix(),temp);
			return minEval;
		}
	}

	/**This function evaluates the points achieved on following a given path in minimax algorithm**/
	private int evaluation(char outcome,int depth ){
		if(outcome=='D') return 0;
		else if (outcome =='X') return 10 - depth;
		else return depth-10;
	}
	
	/** Updates the Tic-Tac-Toe matrix. It is required to evaluate the end cases of minimax function.**/
	private void updateMatrix(int position, char[][] matrix, int value){
		char mark;
		if(value>9) mark = (char)value;
		else mark = (char)(value + (int)'0');
		switch(position){
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
	}

}
