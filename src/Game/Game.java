package Game;

import java.util.Scanner;

import Character.King;
import Character.Witcher;
import Utils.Colours;
import Utils.Helper;

public class Game {
	private Player player1, player2;
	private Board board = new Board();
	private Score score;

	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.score = new Score(player1, player2);
	}

	public void getBoard() {
		board.printBoard(player1, player2);
	}

	public void initializePlayers() {
		Boolean player1Initilized = false, player2Initilized = false;
		while (!player1Initilized && !player2Initilized) {
			System.out.println(Colours.USR_INPUT+"\n Player 01 Choose your characters: "+Colours.ANSI_RESET);
			player1.updateCharacter(Helper.setCharacter(player1, 1, 1), 1,false	);
			getBoard();
			player1.updateCharacter(Helper.setCharacter(player1, 2, 1), 2,false);
			getBoard();
			player1.updateCharacter(Helper.setCharacter(player1, 3, 1), 3,false);
			getBoard();
			player1Initilized = true;
			System.out.println(Colours.USR_INPUT+"\n Player 02 Choose your characters: "+Colours.ANSI_RESET);
			player2.updateCharacter(Helper.setCharacter(player2, 1, 2), 1,false);
			getBoard();
			player2.updateCharacter(Helper.setCharacter(player2, 2, 2), 2,false);
			getBoard();
			player2.updateCharacter(Helper.setCharacter(player2, 3, 2), 3,false);
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
			System.out.println(Colours.USR_INPUT+String.format("\n Player %d Make your move: ", toPlay)+Colours.ANSI_RESET);
			System.out.println(Colours.USR_INPUT+" Select your character: "+Colours.ANSI_RESET);
			character = input.next();
			// -----------TEMP REMOVE AFTERWARDS0---------------------
			if (character.contentEquals("stop")) {
				startPlay = false;
				continue;
			}
			// -------------------------------------------------------
			for (int i = 0; i < 4; i++) {
				if (player.getCharacters()[i] != null
						&& player.getCharacters()[i].getName().toLowerCase().contentEquals(character.toLowerCase())) {
					validCharacter = true;
					charPos = i;
					break;
				}
			}
			if (validCharacter == false) {
				System.out.println(Colours.ERROR+"\n Inputed character does not exist "+Colours.ANSI_RESET);
				continue;
			} else {
				System.out.println(Colours.USR_INPUT+"\n Enter position to move to: "+Colours.ANSI_RESET);
				position = input.next();
				if (Helper.isPositionValid(position)) {
					Integer posArr[] = Helper.translatePosition(position);
					if (Helper.isMoveValid(player.getCharacters()[charPos], player, enemy, posArr[1], posArr[0])) {
						player.getCharacters()[charPos].setPoY(posArr[0]);
						player.getCharacters()[charPos].setPosX(posArr[1]);
						score.calculateDamage(toPlay, posArr[1], posArr[0]);
						getBoard();
						score.printScores();
						if (!winCondition()) {
							startPlay = false;
						}
						if (toPlay == 1) {
							toPlay = 2;
						} else {
							toPlay = 1;
						}
					} else {
						continue;
					}
				} else {
					System.out.println(Colours.ERROR+"\n Invalid Position "+Colours.ANSI_RESET);
					continue;
				}

			}
		}
	}

	private Boolean winCondition() {
		Boolean continueGame = true;
		Boolean king1Present = false;
		Boolean king2Present = false;
		for (int i = 0; i < 4; i++) {
			if (player1.getCharacters()[i] instanceof King) {
				king1Present = true;
			}

			if (player2.getCharacters()[i] instanceof King) {
				king2Present = true;
			}
		}
		if (king1Present == false && king2Present == false) {
			System.out.println(Colours.WHITE_BG+Colours.BLACK_TXT+"\n It's a Draw!!! "+Colours.ANSI_RESET);
			System.out.println(Colours.ERROR+" GAME OVER!!! "+Colours.ANSI_RESET);
			continueGame = false;
		} else if (king2Present == false) {
			System.out.println(Colours.GREEN_BG+Colours.WHITE_TXT+"\n Congrats: "+player1.getName()+" Of House "+player1.getHouse()+" Won the Battle "+Colours.ANSI_RESET);
			System.out.println(Colours.ERROR+" GAME OVER!!! "+Colours.ANSI_RESET);
			continueGame = false;
		} else if (king1Present == false) {
			System.out.println(Colours.GREEN_BG+Colours.WHITE_TXT+"\n Congrats: "+player2.getName()+" Of House "+player2.getHouse()+" Won the Battle "+Colours.ANSI_RESET);
			System.out.println(Colours.ERROR+" GAME OVER!!! "+Colours.ANSI_RESET);
			continueGame = false;
		}

		return continueGame;
	}
}
