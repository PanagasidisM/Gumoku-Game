/**
 * Utility class for checking win conditions. A player wins by placing 5 symbols
 * in a row, column, or diagonal.
 */
public final class CheckWin {
	/**
	 * Determines the winner at a given cell position by checking all directions.
	 *
	 * @param a the game grid
	 * @param y the row index of the last placed piece
	 * @param x the column index of the last placed piece
	 * @return the winning symbol character, or 'D' if there is no winner
	 */
	public char findWinner(Grid a, int y, int x) {
		if (a.getCell(y, x) == ' ')
			return 'D';
		char winner = 'D';
		winner = checkRow(a, y, x);
		if (winner != 'D')
			return winner;
		winner = checkColumn(a, y, x);
		if (winner != 'D')
			return winner;
		winner = checkMainDiagonal(a, y, x);
		if (winner != 'D')
			return winner;
		winner = checkSecondDiagonal(a, y, x);
		if (winner != 'D')
			return winner;
		return 'D';
	}

	/**
	 * Checks whether there are 5 matching symbols in the same row as the given
	 * cell.
	 *
	 * @param a the game grid
	 * @param y the row index of the cell to check
	 * @param x the column index of the cell to check
	 * @return the winning symbol if a winning row is found, or 'D' if there is no
	 *         winner
	 */
	public char checkRow(Grid a, int y, int x) {
		char symbol = a.getCell(y, x);
		int counter = 1;
		for (int i = x - 1; i >= 0 && a.getCell(y, i) == symbol; i--)
			counter++;
		for (int i = x + 1; i < a.getSize() && a.getCell(y, i) == symbol; i++)
			counter++;
		if (counter >= 5)
			return symbol;
		return 'D';
	}

	/**
	 * Checks whether there are 5 matching symbols in the same column as the given
	 * cell.
	 *
	 * @param a the game grid
	 * @param y the row index of the cell to check
	 * @param x the column index of the cell to check
	 * @return the winning symbol if a winning column is found, or 'D' if there is
	 *         no winner
	 */
	public char checkColumn(Grid a, int y, int x) {
		char symbol = a.getCell(y, x);
		int counter = 1;
		for (int i = y - 1; i >= 0 && a.getCell(i, x) == symbol; i--)
			counter++;
		for (int i = y + 1; i < a.getSize() && a.getCell(i, x) == symbol; i++)
			counter++;
		if (counter >= 5)
			return symbol;
		return 'D';
	}

	/**
	 * Checks whether there are 5 matching symbols along the main diagonal through
	 * the given cell.
	 *
	 * @param a the game grid
	 * @param y the row index of the cell to check
	 * @param x the column index of the cell to check
	 * @return the winning symbol if a winning main diagonal iss found, or 'D' if
	 *         there is no winner
	 */
	public char checkMainDiagonal(Grid a, int y, int x) {
		char symbol = a.getCell(y, x);
		int counter = 1;
		for (int i = 1; y - i >= 0 && x - i >= 0 && a.getCell(y - i, x - i) == symbol; i++)
			counter++;
		for (int i = 1; y + i < a.getSize() && x + i < a.getSize() && a.getCell(y + i, x + i) == symbol; i++)
			counter++;
		if (counter >= 5)
			return symbol;
		return 'D';
	}

	/**
	 * Checks whether there are 5 matching symbols along the secondary diagonal
	 * through the given cell.
	 *
	 * @param a the game grid
	 * @param y the row index of the cell to check
	 * @param x the column index of the cell to check
	 * @return the winning symbol if a winning secondary diagonal is found, or 'D'
	 *         if ther eis no winner
	 */
	public char checkSecondDiagonal(Grid a, int y, int x) {
		char symbol = a.getCell(y, x);
		int counter = 1;
		for (int i = 1; y - i >= 0 && x + i < a.getSize() && a.getCell(y - i, x + i) == symbol; i++)
			counter++;
		for (int i = 1; y + i < a.getSize() && x - i >= 0 && a.getCell(y + i, x - i) == symbol; i++)
			counter++;
		if (counter >= 5)
			return symbol;
		return 'D';
	}
}
