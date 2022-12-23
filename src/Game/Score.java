package Game;

//import Character.GameCharacter;

public class Score {
	private static Player player1;
	private static Player player2;
//	GameCharacter disChar1 [] = {player1.getCharacters()[0], player1.getCharacters()[1], player1.getCharacters()[2], player1.getCharacters()[3] };
//	GameCharacter disChar2 [] = {player2.getCharacters()[0], player2.getCharacters()[1], player1.getCharacters()[2], player2.getCharacters()[3] };
	public Score(Player player1, Player player2) {
		// TODO Auto-generated constructor stub
		Score.player1 = player1;
		Score.player2 = player2;
	}
	
	public static void getPlayerInfo() {
		System.out.println(String.format("--------------------------------------------------------------------------------------------------------------"));
		System.out.print(String.format("|                      %-31s|", player1.getName())); System.out.println(String.format("|                      %-31s|", player2.getName()));
		System.out.println(String.format("|-----------------------------------------------------||-----------------------------------------------------|"));
		System.out.println(String.format("|  CHARACTER  |  HEALTH | ATTACK  | DEFENCE  |  MOVES ||  CHARACTER  |  HEALTH |  ATTACK |  DEFENCE |  MOVES |"));
		System.out.println(String.format("|-----------------------------------------------------||-----------------------------------------------------|"));
		System.out.println(String.format("|     %3s     |   %3d   |   %3d   |    %3d   |   %3d  ||     %3s     |   %3d   |   %3d   |    %3d   |   %3d  |", player1.getCharacters()[0].getName(), player1.getCharacters()[0].getHealth(), player1.getCharacters()[0].getAttack(), player1.getCharacters()[0].getDefence(), player1.getCharacters()[0].getMaxMoves(), player2.getCharacters()[0].getName(), player2.getCharacters()[0].getHealth(), player2.getCharacters()[0].getAttack(), player2.getCharacters()[0].getDefence(), player2.getCharacters()[0].getMaxMoves()));
		System.out.println(String.format("|     %3s     |   %3d   |   %3d   |    %3d   |   %3d  ||     %3s     |   %3d   |   %3d   |    %3d   |   %3d  |", player1.getCharacters()[1].getName(), player1.getCharacters()[1].getHealth(), player1.getCharacters()[1].getAttack(), player1.getCharacters()[1].getDefence(), player1.getCharacters()[1].getMaxMoves(), player2.getCharacters()[1].getName(), player2.getCharacters()[1].getHealth(), player2.getCharacters()[1].getAttack(), player2.getCharacters()[1].getDefence(), player2.getCharacters()[1].getMaxMoves()));
		System.out.println(String.format("|     %3s     |   %3d   |   %3d   |    %3d   |   %3d  ||     %3s     |   %3d   |   %3d   |    %3d   |   %3d  |", player1.getCharacters()[2].getName(), player1.getCharacters()[2].getHealth(), player1.getCharacters()[2].getAttack(), player1.getCharacters()[2].getDefence(), player1.getCharacters()[2].getMaxMoves(), player2.getCharacters()[2].getName(), player2.getCharacters()[2].getHealth(), player2.getCharacters()[2].getAttack(), player2.getCharacters()[2].getDefence(), player2.getCharacters()[2].getMaxMoves()));
		System.out.println(String.format("|     %3s     |   %3d   |   %3d   |    %3d   |   %3d  ||     %3s     |   %3d   |   %3d   |    %3d   |   %3d  |", player1.getCharacters()[3].getName(), player1.getCharacters()[3].getHealth(), player1.getCharacters()[3].getAttack(), player1.getCharacters()[3].getDefence(), player1.getCharacters()[3].getMaxMoves(), player2.getCharacters()[3].getName(), player2.getCharacters()[3].getHealth(), player2.getCharacters()[3].getAttack(), player2.getCharacters()[3].getDefence(), player2.getCharacters()[3].getMaxMoves()));
		System.out.println(String.format("--------------------------------------------------------------------------------------------------------------"));
	}
}
