package Game;

import Utils.Helper;

public class Game {
	private Player player1, player2;
	public Board board = new Board();

	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public void getBoard() {
		board.printBoard(player1,player2);
	}
	
	public void initializePlayers() {
		Boolean player1Initilized = false, player2Initilized = false;
		while (!player1Initilized && !player2Initilized) {
			System.out.println("Player 01 Choose your characters:");
			player1.updateCharacter(Helper.setCharacter(player1, 1, 1), 1);
			getBoard();
			player1.updateCharacter(Helper.setCharacter(player1, 2, 1), 2);
			getBoard();
			player1.updateCharacter(Helper.setCharacter(player1, 3, 1), 3);
			getBoard();
			player1Initilized = true;
			System.out.println("Player 02 Choose your characters:");
			player2.updateCharacter(Helper.setCharacter(player2, 1, 2), 1);
			getBoard();
			player2.updateCharacter(Helper.setCharacter(player2, 2, 2), 2);
			getBoard();
			player2.updateCharacter(Helper.setCharacter(player2, 3, 2), 3);
			getBoard();
			player2Initilized = true;
		}

	}
	
}
