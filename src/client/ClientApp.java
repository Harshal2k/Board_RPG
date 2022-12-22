package client;

import java.io.IOException;

import game.Game;
import game.Player;
import utils.Colours;
import utils.Helper;

public class ClientApp {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println(Colours.BLACK_BG + Colours.WHITE_TXT + " ======    ======    ========  ");
		System.out.println(" ||    ||  ||    ||  ||        ");
		System.out.println(" ||    //  ||    //  ||        ");
		System.out.println(" ||====    ||====    ||   ==|| ");
		System.out.println(" ||  \\\\    ||        ||     || ");
		System.out.println(" ||   \\\\   ||        ========  " + Colours.ANSI_RESET);

		Helper.printRules();
		
		Player player1=new Player(1);
		Player player2=new Player(2);
		Helper.setPlayers(player1, player2);
		Game gmGame = new Game(player1, player2);
		gmGame.getBoard();
		gmGame.initializePlayers();
		gmGame.startGame();
	}

}
