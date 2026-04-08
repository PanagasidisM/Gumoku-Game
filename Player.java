/**
 * Abstract base class representing a player in the game. Each player has a
 * unique symbol displayed on the board and a display name.
 */
public abstract class Player {
	final protected char symbol;
	final protected String name;

	/**
	 * Constructs a Player with the specified symbol and name.
	 *
	 * @param symbol: the character representing the player on the board
	 * @param name:   the display name of this player
	 */
	public Player(char symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}

	/**
	 * Determines and returns the player's next move on the given grid. This method
	 * will be overwritten.
	 *
	 * @param arena: the current game grid
	 * @return an array representing the cell coordinates y,x , or null if the
	 *         player chooses to quit
	 */
	public abstract int[] makeMove(Grid arena);

	/**
	 * Returns the character symbol representing this player on the board.
	 *
	 * @return this player's symbol
	 */
	public char getSymbol() {
		return symbol;
	}

	/**
	 * Returns the display name of this player.
	 *
	 * @return this player's name
	 */
	public String getName() {
		return name;
	}

}

