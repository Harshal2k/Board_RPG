package Utils;

import java.io.IOException;
import java.util.Scanner;

import Character.GameCharacter;
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
				p1.getCharacters()[0].setName(houses[p1Op-1].charAt(0)+"K");
				p2.getCharacters()[0].setName(houses[p2Op-1].charAt(0)+"K");
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
					System.out.println("Place your character anywhere in row F & G");
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

		return arr;
	}

	public static Boolean isPositionValid(String position) {
		return true;
	}

	public static Boolean isCodeValid(String code) {
		return true;
	}

}
