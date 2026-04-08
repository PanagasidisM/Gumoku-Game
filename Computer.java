import java.util.Random;

/**
 * Represents the computer player in the game. It has two movement strategies:
 * complete random placement and random placement that restricts moves to the
 * area around existing pieces in a shape of a box.
 */
public class Computer extends Player {
	private Random random = new Random();
	/**
	 * if it is true, we use the box strategy, otherwise no strategy
	 */
	private boolean strategy;

	/**
	 * Constructs a Computer player with a given symbol, name, and movement
	 * strategy.
	 *
	 * @param symbol:   the character symbol representing this player on the board
	 * @param name:     the display name of this player
	 * @param strategy: true to use the box strategy, false for random moves
	 */
	public Computer(char symbol, String name, boolean strategy) {
		super(symbol, name);
		this.strategy = strategy;
	}

	/**
	 * Determines and returns the computer's next move based on the selected
	 * strategy.
	 *
	 * @param grid: the current game grid
	 * @return an array representing the chosen cell coordinates
	 */
	@Override
	public int[] makeMove(Grid grid) {
		int[] move;
		if (strategy) {
			move = strategyMove(grid);
		} else {
			move = randomMove(grid);
		}
		System.out.println(name + " plays: " + move[0] + "," + move[1]);
		return move;
	}

	private int[] randomMove(Grid grid) {
		int y, x;
		do {
			y = random.nextInt(grid.getSize());
			x = random.nextInt(grid.getSize());
		} while (!grid.checkPlace(y, x));
		return new int[] { y, x };
	}

	/**
	 * Selects a move within the box of all currently occupied cells. Falls back to
	 * a random move if no pieces have been placed yet.
	 *
	 * @param grid: the current game grid
	 * @return an array representing the chosen cell coordinates
	 */
	private int[] strategyMove(Grid grid) {
		int minY = -1, maxY = -1, minX = -1, maxX = -1;

		for (int i = 0; i < grid.getSize(); i++) {
			for (int j = 0; j < grid.getSize(); j++) {
				if (grid.getCell(i, j) != ' ') {
					if (minY == -1 || i < minY)
						minY = i;
					if (maxY == -1 || i > maxY)
						maxY = i;
					if (minX == -1 || j < minX)
						minX = j;
					if (maxX == -1 || j > maxX)
						maxX = j;
				}
			}
		}

		if (minY == -1)
			return randomMove(grid);

		int y;
		int x;
		int areaY = maxY - minY + 1;
		int areaX = maxX - minX + 1;

		if (areaY == 1) {
			minY = Math.max(0, minY - 1);
			areaY = Math.min(2, grid.getSize() - minY);
		}
		if (areaX == 1) {
			minX = Math.max(0, minX - 1);
			areaX = Math.min(2, grid.getSize() - minX);
		}

		do {
			y = minY + random.nextInt(areaY);
			x = minX + random.nextInt(areaX);
		} while (!grid.checkPlace(y, x));

		return new int[] { y, x };
	}
}
