/**
 * Controls the game loop, changing turns between two players and checking for
 * draw or win conditions after each move.
 */
public class Game {
	private Grid grid;
	private Player player1;
	private Player player2;
	private CheckWin checkWin;

	/**
	 * Constructs a new Game with the specified grid and two players.
	 *
	 * @param grid:   the game grid on which the game is played
	 * @param player1 the first player (plays first)
	 * @param player2 the second player
	 */
	public Game(Grid grid, Player player1, Player player2) {
		this.grid = grid;
		this.player1 = player1;
		this.player2 = player2;
		this.checkWin = new CheckWin();
	}

	/**
	 * Runs the game loop until a player wins, the board is full (draw), or a player
	 * quits. Prints the board after each move and the outcome.
	 */
	public void play() {
		Player current = player1;
		grid.printArena();

		while (true) {
			int move[] = current.makeMove(grid);

			if (move == null) {
				System.out.println(current.getName() + " quit the game.");
				return;
			}

			grid.placePiece(move[0], move[1], current.getSymbol());
			grid.printArena();

			char winner = checkWin.findWinner(grid, move[0], move[1]);
			if (winner != 'D') {
				System.out.println(current.getName() + " wins!");
				System.exit(0);
				return;
			}

			if (grid.full()) {
				System.out.println("It's a draw!");
				System.exit(0);
				return;
			}

			if (current == player1) {
				current = player2;
			} else {
				current = player1;
			}
		}
	}
}
