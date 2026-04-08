import java.util.Scanner;

/**
 * Represents the human player that reads moves from the user. The player enters
 * moves as y and x cordinates, or a negative number to quit the game.
 * 
 */
public class Human extends Player {
	private Scanner scan = new Scanner(System.in);

	/**
	 * Constructs a Human player with the given symbol and display name.
	 *
	 * @param symbol: the character symbol representing this player on the board
	 * @param name:   the display name of this player
	 */
	public Human(char symbol, String name) {
		super(symbol, name);
	}

	/**
	 * Prompts the human player to enter a move and checks the input. Returns null
	 * if the player enters a negative coordinate to quit.
	 *
	 * @param grid: the current game grid
	 * @return an array representing the y,x coordinates, or null if the player
	 *         chooses to quit
	 * 
	 */
	public int[] makeMove(Grid grid) {
		while (true) {
			System.out.println(name + " move (y,x) or negative number quit:");
			String input = scan.nextLine().trim();
			String[] numbers = input.split(",");

			if (numbers.length != 2) {
				System.out.println("Wrong move");
				continue;
			}

			String y = numbers[0].trim();
			String x = numbers[1].trim();
			boolean rowValid = !y.isEmpty();
			boolean colValid = !x.isEmpty();

			for (int i = 0; i < y.length(); i++)
				if (i == 0 && y.charAt(i) == '-')
					continue;
				else if (!Character.isDigit(y.charAt(i))) {
					rowValid = false;
					break;
				}

			for (int i = 0; i < x.length(); i++)
				if (i == 0 && x.charAt(i) == '-')
					continue;
				else if (!Character.isDigit(x.charAt(i))) {
					colValid = false;
					break;
				}

			if (!rowValid || !colValid) {
				System.out.println("Wrong move");
				continue;
			}

			int row = Integer.parseInt(y);
			int col = Integer.parseInt(x);

			if (row < 0 || col < 0)
				return null;

			if (row >= grid.getSize() || col >= grid.getSize()) {
				System.out.println("Wrong move");
				continue;
			}

			if (!grid.checkPlace(row, col)) {
				System.out.println("Wrong move");
				continue;
			}

			return new int[] { row, col };
		}
	}
}
