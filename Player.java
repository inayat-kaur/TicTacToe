//Inayat Kaur
//2020csb1088

/** This class imitates a player in real world **/
public class Player {
	/** The variables store the mark ('O','X') and number (1 or 2) of the player **/
	protected char mark;
	protected int number;

	public Player(char mark, int number) { // Constructor
		this.mark = mark;
		this.number = number;
	}

	/**
	 * Scanning input from user for the move and asking game class to make the move
	 **/
	public void makeMove(Game game) {
		Display dis = new Display();
		int choice = dis.makeMove(game.getMatrix(), this.number);
		game.makeMove(choice, mark);
	}
}
