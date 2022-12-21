package Helper;

import java.io.IOException;
import java.util.Scanner;

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
}
