import java.util.Scanner;

public class RunGame {
	/**
	 * Main method that launches the game. Reads board size and game mode from
	 * standard input, creates the grid and players, and starts a Game session.
	 * 
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter board size: ");
		int size = Integer.parseInt(scan.nextLine().trim());

		System.out.println("Select mode:");
		System.out.println("  1 - Human vs Human");
		System.out.println("  2 - Computer vs Computer");
		System.out.println("  3 - Human vs Computer");

		int mode = scan.nextInt();

		while (!(mode == 1 || mode == 2 || mode == 3)) {
			System.out.println("Wrong input");
			System.out.println("Select mode:");
			System.out.println("  1 - Human vs Human");
			System.out.println("  2 - Computer vs Computer");
			System.out.println("  3 - Human vs Computer");
			mode = scan.nextInt();
		}
		Grid grid = new Grid(size);
		Player p1, p2;
		if (mode == 1) {
			p1 = new Human('O', "Player 1");
			p2 = new Human('X', "Player 2");
		} else if (mode == 2) {
			p1 = new Computer('O', "Computer 1", false);
			p2 = new Computer('X', "Computer 2", true);
		} else {
			p1 = new Human('O', "Player 1");
			p2 = new Computer('X', "Computer2", true);
		}

		Game game = new Game(grid, p1, p2);
		game.play();
	}
}
