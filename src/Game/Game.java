package Game;

import java.util.Scanner;

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
	
	public void startGame() {
		Boolean startPlay = true;
		Integer toPlay = 1;
		while (startPlay) {
			Scanner input = new Scanner(System.in);
			String character = "", position = "";
			Boolean validCharacter = false;
			Integer charPos = 0;
			Player player = player1, enemy = player2;
			if (toPlay == 1) {
				player = player1;
				enemy = player2;
			} else {
				player = player2;
				enemy = player1;
			}
			System.out.println(String.format("Player %d Make your move: ", toPlay));
			System.out.println("Select your character: ");
			character = input.next();
			// -----------TEMP REMOVE AFTERWARDS0---------------------
			if (character.contentEquals("stop")) {
				startPlay = false;
				continue;
			}
			// -------------------------------------------------------
			for (int i = 0; i < 4; i++) {
				if (player.getCharacters()[i].getName().toLowerCase().contentEquals(character.toLowerCase())) {
					validCharacter = true;
					charPos = i;
					break;
				}
			}
			if (validCharacter == false) {
				System.out.println("Inputed character does not exist");
				continue;
			} else {
				System.out.println("Enter position:");
				position = input.next();
				if (Helper.isPositionValid(position)) {
					Integer posArr[] = Helper.translatePosition(position);
					if (Helper.isMoveValid(player.getCharacters()[charPos], player, enemy, posArr[1], posArr[0])) {
						player.getCharacters()[charPos].setPoY(posArr[0]);
						player.getCharacters()[charPos].setPosX(posArr[1]);
						getBoard();
						if (toPlay == 1) {
							toPlay = 2;
						} else {
							toPlay = 1;
						}
					}else {
						continue;
					}
				} else {
					System.out.println("Invalid Position");
					continue;
				}

			}
		}
	}
	
}
