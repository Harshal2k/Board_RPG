package Game;
import java.util.*;

public class Score {
	private static Player player1;
	private static Player player2;
	public Score(Player player1, Player player2) {
		// TODO Auto-generated constructor stub
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public static void getPlayerInfo() {
		System.out.println("|-----------------------------------------------------------------------------------------------------------------------|");
		System.out.print(String.format("|                          %-32s|", player1.getName())); System.out.println(String.format("|                           %-32s|", player2.getName()));
		System.out.println("|----------------------------------------------------|" + "|----------------------------------------------------|");
		System.out.println("|    CHARACTER   | HEALTH | ATTACK | DEFENCE | MOVES |" + "|    CHARACTER   | HEALTH | ATTACK | DEFENCE | MOVES |");
		System.out.println("|----------------------------------------------------|" + "|----------------------------------------------------|");
		System.out.println("|     Witcher    |   70   |   100  |    45   |   3   |");
		System.out.println("| Shadow Monster |   70   |   90   |    30   |   4   |");
		System.out.println("|      Tank      |   70   |   50   |   100   |   2   |");
		System.out.println("|---------------------------------------------------------------------------------------------------------|");
	}
}
