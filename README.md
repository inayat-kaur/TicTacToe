# TicTacToe  

* Compile the source files using:  
  javac TicTacToe.java  
  javac Game.java  
  javac Player.java  
  javac Computer.java  
  javac Display.java  

* Run the program using: java TicTacToe  

* Enter 1 for Computer vs Player and 2 for Player vs Player  

* If you entered 1, You will be Player1 with 'X' mark and first turn.  
  Computer will be Player2 with 'O' mark.  
  Enter your choice from the available options.
  After that computer will make its choice.
  The game ends when either of Player1 or Player2 wins or there is a draw.
  
* If you entered 2, You can be either player1 with 'X' or player2 with 'O'.
  Player1 always makes the first move.
  So, Player1 enters choice from given options followed by Player2.
  The game ends when either of Player1 or Player2 wins or there is a draw.  
    <br>
1. TicTacToe:
	It contains the main function. The user enters the mode of playing the game i.e. 1 for Player vs Computer and 2 for Player vs Player. After this it starts the game and asks the players to move turn by turn. At the end of the game, it displays the winner.
	
	
2. Game:
	It imitates the board of the tic-tac-toe which also acts as a referee to check when a player wins the game.
	It contains the following private variables:
	* private char[][] matrix = new char[3][3]
	* private Vector<Integer> options
	* private char winStatus

	It contains the folowing methods:
	* public Game()    //Constructor
	* public char[][] getMatrix()
	* public Vector<Integer> getOptions()	
	* public char getWinStatus()
	* public void makeMove(int i, char mark)
	* public char checkWinStatus()
	

3. Player:
	It imitates a player in real life.
	It contains the following two protected variables:
	* protected char mark
	* protected int number
	
	It contains the folowing public methods:
	* public Player(char mark, int number)     //Constructor
	* public void makeMove(Game game)

4. Computer:
	It imitates a Computer player. For making a move, it uses the minimax algorithm where computer is the minimizing player. It is optimized using alpha-beta pruning.
	It inherits the following two variables from Player class:
	* protected char mark
	* protected int number
	
	It contains the following methods:
	* public Computer(char mark, int number)     //Constructor
	* public void makeMove(Game game)     //Overrides makeMove() of Player class
	* private int miniMax(Game game,Vector<Integer> choices, int choice, int depth, int alpha, int beta, boolean maximizingPlayer)
	* private int evaluation(char outcome,int depth )
	* private void updateMatrix(int position, char[][] matrix, int value)
	

5. Display:
	It contains the following methods for displaying strings while running the programme :
	* public void start()
	* public void startMode1()
	* public void startMode2()
	* public void invalid()
	* public void positions()
	* public void currentState(char[][] matrix)
	* public void optionsForMove(Vector<Integer> options)
	* public void winStatus(char w)
	* public void nextMove(int p)
        All these methods are used to only display strings and do not make any modifications to the game.
