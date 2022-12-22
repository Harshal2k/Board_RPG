package Utils;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Character.GameCharacter;
import Character.King;
import Character.Shadow;
import Character.Tank;
import Character.Witcher;
import Game.Player;

public class Helper {

	public static void setPlayers(Player p1, Player p2) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Player 1 name: ");
		p1.setName(input.next());
		System.out.println("Enter Player 2 name: ");
		p2.setName(input.next());
		String houses[] = { "Stark", "Targaryen", "Lannister", "Greyjoy", "Baratheon", "Martell", "Arryn" };
		while (p1.getHouse() == "" && p2.getHouse() == "") {
			for (int i = 1; i < 8; i++) {
				System.out.println(i + ". House of " + houses[i - 1]);
			}
			Scanner houseInput = new Scanner(System.in);
			Integer p1Op, p2Op;
			try {
				System.out.println("Player 1 choose your house no: ");
				p1Op = houseInput.nextInt();
				System.out.println("Player 2 choose your house no: ");
				p2Op = houseInput.nextInt();
			} catch (Exception e) {
				Runtime.getRuntime().exec("clear");
				System.out.println("Invalid option, try again");
				continue;
			}
			if (p1Op == p2Op) {
				System.out.println("Both players cannot choose same house");
			} else if ((p1Op < 1 && p1Op > 7) || (p2Op < 1 && p2Op > 7)) {
				System.out.println("Invalid option, try again");
			} else {
				p1.setHouse(houses[p1Op - 1]);
				p2.setHouse(houses[p2Op - 1]);
				p1.getCharacters()[0].setName(houses[p1Op - 1].charAt(0) + "K");
				p2.getCharacters()[0].setName(houses[p2Op - 1].charAt(0) + "K");
			}
		}
	}

	@SuppressWarnings("resource")
	public static GameCharacter setCharacter(Player player, Integer chNo, Integer PlNo) {
		Boolean isCharacterValid = false;
		GameCharacter gmCharacter = null;
		while (!isCharacterValid) {
			Scanner input = new Scanner(System.in);
			System.out.println("---------------------------------------------------------------------");
			System.out.println("| SR.NO |    CHARACTER   | CODE | HEALTH | ATTACK | DEFENCE | MOVES |");
			System.out.println("|-------------------------------------------------------------------|");
			System.out.println("|   1   |     Witcher    |   W  |   70   |   100  |    45   |   3   |");
			System.out.println("|   2   | Shadow Monster |   S  |   70   |   90   |    30   |   4   |");
			System.out.println("|   3   |      Tank      |   T  |   70   |   50   |   100   |   2   |");
			System.out.println("---------------------------------------------------------------------");
			System.out.println("Enter Character " + chNo + " code: ");
			String chName = input.next();
			if (isCodeValid(chName)) {
				if (PlNo == 1) {
					System.out.println("Place your character anywhere in row A & B");
					System.out.println("Enter character position (Eg: A1): ");
				} else {
					System.out.println("Place your character anywhere in row E & F");
					System.out.println("Enter character position (Eg: F1): ");
				}
				String position = input.next();
				Boolean isCorrectRow = PlNo == 1
						? (position.toLowerCase().charAt(0) == 'a' || position.toLowerCase().charAt(0) == 'b')
						: (position.toLowerCase().charAt(0) == 'e' || position.toLowerCase().charAt(0) == 'f');
				if (isPositionValid(position) && isCorrectRow) {
					Integer posArr[] = translatePosition(position);
					if (chName.toLowerCase().charAt(0) == 't') {
						Integer count = 1;
						Boolean charPresent = false;
						for (int i = 0; i < 4; i++) {
							if (player.getCharacters()[i] != null && player.getCharacters()[i].getPoY() == posArr[0]
									&& player.getCharacters()[i].getPosX() == posArr[1]) {
								charPresent = true;
								break;
							}
							if (player.getCharacters()[i] != null && player.getCharacters()[i] instanceof Tank) {
								count++;
							}
						}
						if (charPresent == true) {
							System.out.println("Character Already present at position: " + position);
							continue;
						}
						gmCharacter = new Tank(player.getHouse().charAt(0) + "T" + count, 100, posArr[1], posArr[0]);
						isCharacterValid = true;
					} else if (chName.toLowerCase().charAt(0) == 'w') {
						Integer count = 1;
						Boolean charPresent = false;
						for (int i = 0; i < 4; i++) {
							if (player.getCharacters()[i] != null && player.getCharacters()[i].getPoY() == posArr[0]
									&& player.getCharacters()[i].getPosX() == posArr[1]) {
								charPresent = true;
								break;
							}
							if (player.getCharacters()[i] != null && player.getCharacters()[i] instanceof Witcher) {
								count++;
							}
						}
						if (charPresent == true) {
							System.out.println("Character Already present at position: " + position);
							continue;
						}
						gmCharacter = new Witcher(player.getHouse().charAt(0) + "W" + count, 80, posArr[1], posArr[0]);
						isCharacterValid = true;
					} else if (chName.toLowerCase().charAt(0) == 's') {
						Integer count = 1;
						Boolean charPresent = false;
						for (int i = 0; i < 4; i++) {
							if (player.getCharacters()[i] != null && player.getCharacters()[i].getPoY() == posArr[0]
									&& player.getCharacters()[i].getPosX() == posArr[1]) {
								charPresent = true;
								break;
							}

							if (player.getCharacters()[i] != null && player.getCharacters()[i] instanceof Shadow) {
								count++;
							}
						}
						if (charPresent == true) {
							System.out.println("Character Already present at position: " + position);
							continue;
						}
						gmCharacter = new Shadow(player.getHouse().charAt(0) + "S" + count, 75, posArr[1], posArr[0]);
						isCharacterValid = true;
					}

				} else {
					System.out.println("Invalid Position!");
					continue;
				}
			} else {
				System.out.println("Invalid character code!");
				continue;
			}
		}
		return gmCharacter;
	}

	public static Integer[] translatePosition(String position) {
		Integer arr[] = new Integer[2];
		char posChar = position.toLowerCase().charAt(0);
		if (posChar == 'a') {
			arr[0] = 0;
		} else if (posChar == 'b') {
			arr[0] = 1;
		} else if (posChar == 'c') {
			arr[0] = 2;
		} else if (posChar == 'd') {
			arr[0] = 3;
		} else if (posChar == 'e') {
			arr[0] = 4;
		} else if (posChar == 'f') {
			arr[0] = 5;
		}
		arr[1] = Integer.parseInt(String.valueOf(position.charAt(1))) - 1;
		return arr;
	}

	public static Boolean isPositionValid(String position) {
		Pattern pattern = Pattern.compile("^[A-F][1-6]$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(position);
		boolean matchFound = matcher.find();
		if (position.length() != 2 || !matchFound) {
			return false;
		} else {
			return true;
		}
	}

	public static Boolean isCodeValid(String code) {
		char gameChar = code.toLowerCase().charAt(0);
		if (gameChar == 'w' || gameChar == 's' || gameChar == 't') {
			return true;
		} else {
			return false;
		}
	}
	
	public static Boolean isMoveValid(GameCharacter character, Player player, Player enemy, Integer posX,
			Integer posY) {
		Boolean isMoveValid = true;
		if (character.getPosX() == posX && character.getPoY() == posY) {
			System.out.println("Invalid Move, you are already present on this location");
			return false;
		}
		for (int i = 0; i < 4; i++) {
			if (player.getCharacters()[i] != null && player.getCharacters()[i].getPosX() == posX
					&& player.getCharacters()[i].getPoY() == posY) {
				System.out.println("Invalid Move. One of your character is already present on this position");
				return false;
			}
		}

		if (character instanceof King) {
			if ((character.getPosX() - posX) < -1 || (character.getPosX() - posX) > 1
					|| (character.getPoY() - posY) < -1 || (character.getPoY() - posY) > 1) {
				System.out.println("Invalid Move. King can only move one step");
				isMoveValid = false;
			}
		} else if (character instanceof Tank) {
			Integer xDiff = character.getPosX() - posX;
			Integer yDiff = character.getPoY() - posY;
			if (xDiff >= -2 && xDiff <= 2 && yDiff >= -2 && yDiff <= 2
					&& (character.getPosX() == posX || character.getPoY() == posY)) {
				Integer posArr[] = new Integer[2];// {x,y}
				if (xDiff == -2) {
					posArr[0] = character.getPosX() + 1;// Mid position
					posArr[1] = posY;
				} else if (xDiff == 2) {
					posArr[0] = posX + 1;// Mid position
					posArr[1] = posY;
				} else if (yDiff == -2) {
					posArr[1] = character.getPoY() + 1;// Mid position
					posArr[0] = posX;
				} else if (yDiff == 2) {
					posArr[1] = posY + 1;// Mid position
					posArr[0] = posX;
				}
				isMoveValid = detectInbetweeners(player, enemy, posArr[0], posArr[1]);
			} else {
				System.out.println("Invalid Move. Tank can only take two straight steps");
				isMoveValid = false;
			}
		} else if (character instanceof Witcher) {
			Integer xDiff = character.getPosX() - posX;
			Integer yDiff = character.getPoY() - posY;
			if (xDiff >= -3 && xDiff <= 3 && yDiff >= -3 && yDiff <= 3
					&& (character.getPosX() == posX || character.getPoY() == posY)) {
				if (xDiff == -3) {
					isMoveValid = detectInbetweeners(player, enemy, character.getPosX() + 1, posY)
							&& detectInbetweeners(player, enemy, character.getPosX() + 2, posY);
				} else if (xDiff == 3) {
					isMoveValid = detectInbetweeners(player, enemy, posX + 1, posY)
							&& detectInbetweeners(player, enemy, posX + 2, posY);
				} else if (xDiff == -2) {
					isMoveValid = detectInbetweeners(player, enemy, character.getPosX() + 1, posY);
				} else if (xDiff == 2) {
					isMoveValid = detectInbetweeners(player, enemy, posX + 1, posY);
				} else if (yDiff == -3) {
					isMoveValid = detectInbetweeners(player, enemy, posX, character.getPoY() + 1)
							&& detectInbetweeners(player, enemy, posX, character.getPoY() + 2);
				} else if (yDiff == 3) {
					isMoveValid = detectInbetweeners(player, enemy, posX, posY + 1)
							&& detectInbetweeners(player, enemy, posX, posY + 2);
				} else if (yDiff == -2) {
					isMoveValid = detectInbetweeners(player, enemy, posX, character.getPoY() + 1);
				} else if (yDiff == 2) {
					isMoveValid = detectInbetweeners(player, enemy, posX, posY + 1);
				}
			} else {
				System.out.println("Invalid Move. Witcher can only take three straight steps");
				isMoveValid = false;
			}
		}else if(character instanceof Shadow) {
			Integer xDiff = character.getPosX() - posX;
			Integer yDiff = character.getPoY() - posY;
			Integer posxDiff=xDiff<0?(-1)*xDiff:xDiff;
			Integer posyDiff=yDiff<0?(-1)*yDiff:yDiff;
			if(xDiff>=-4 && xDiff<=4 && yDiff>=-4 && yDiff<=4 && (character.getPosX() == posX || character.getPoY() == posY||posxDiff==posyDiff)) {
				isMoveValid=true;
			}else {
				System.out.println("Invalid Move. Shadow Monster can only take four steps diagonally or straight");
				isMoveValid = false;
			}
		}
		return isMoveValid;
	}

	public static Boolean detectInbetweeners(Player player, Player enemy, Integer posX, Integer posY) {
		for (int j = 0; j < 4; j++) {
			if (player.getCharacters()[j] != null && player.getCharacters()[j].getPosX() == posX
					&& player.getCharacters()[j].getPoY() == posY) {
				System.out.println("Invalid move, you cannot jump over your own soilders");
				return false;
			}
			if (enemy.getCharacters()[j] != null && enemy.getCharacters()[j].getPosX() == posX
					&& enemy.getCharacters()[j].getPoY() == posY) {
				System.out.println("Invalid Move, Enemy encountered in your path, defeat the enemy to move forward");
				return false;
			}
		}
		return true;
	}
	
}
