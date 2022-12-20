package Game;

public class Game {
	private Player player1, player2;
	public Board board = new Board();

	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public void getBoard() {
		board.printBoard();
	}
}
