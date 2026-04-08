/**
 * Describes the Gomoku game in a 2d square. Every cell has the according
 * characteristic based on the players.
 */
public class Grid {
	private final int size;
	private char arena[][];

	/**
	 * Constructs a new square grid of the given size.
	 *
	 * @param size the number of rows and columns in the grid;
	 */
	public Grid(int size) {
		if (size < 5) {
			throw new IllegalArgumentException("Arena size must be at least 5x5");
		}
		this.size = size;
		arena = new char[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				arena[i][j] = ' ';
			}
		}
	}

	/**
	 * Returns the grid size
	 * 
	 * @return grid size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Returns the character stored at the specified cell.
	 *
	 * @param x the row index
	 * @param y the column index
	 * @return the character at position y,x
	 */
	public char getCell(int x, int y) {
		return arena[x][y];
	}

	/**
	 * Places a player's symbol at the specified cell if the position is valid and
	 * empty.
	 *
	 * @param y:      the number of rows
	 * @param x:      the number of columns
	 * @param symbol: the character
	 */
	public void placePiece(int y, int x, char symbol) {
		if (y < 0 || x < 0 || x >= size || y >= size || arena[y][x] != ' ')
			return;
		arena[y][x] = symbol;
	}

	/**
	 * Checks whether the specified cell is empty.
	 *
	 * @param y the number of rows
	 * @param x the number of columns
	 * @return true if the cell is empty, false otherwise
	 */
	public boolean checkPlace(int y, int x) {
		return arena[y][x] == ' ';
	}

	public boolean full() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (arena[i][j] == ' ')
					return false;
			}
		}
		return true;
	}

	/**
	 * Prints the grid including column headers, row numbers, and cell contents
	 * formatted in a table.
	 * 
	 */
	public void printArena() {
		System.out.print("   ");
		for (int i = 0; i < size; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		for (int i = 0; i < size; i++) {
			System.out.print("   ");
			for (int j = 0; j < size; j++) {
				System.out.print("+--");
			}
			System.out.println("+");
			System.out.printf("%3d", i);
			for (int j = 0; j < size; j++) {
				System.out.printf("|%2c", arena[i][j]);
			}
			System.out.println("|");
		}
		System.out.print("   ");
		for (int col = 0; col < size; col++) {
			System.out.print("+--");
		}
		System.out.println("+");
	}

}

