package client;

import java.io.IOException;

import game.Game;
import game.Player;
import utils.Colours;
import utils.Helper;

public class ClientApp {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("\n"+Colours.BLACK_BG+"                                                       \n"+Colours.ANSI_RESET
				+Colours.BLACK_BG+"  "+Colours.YELLOW_BG+Colours.BLACK_TXT+ " ______                     _  ____________ _____  "+Colours.BLACK_BG+"  \n"+Colours.ANSI_RESET
				+Colours.BLACK_BG+"  "+Colours.YELLOW_BG+Colours.BLACK_TXT+ " | ___ \\                   | | | ___ \\ ___ \\  __ \\ "+Colours.BLACK_BG+"  \n"+Colours.ANSI_RESET
				+Colours.BLACK_BG+"  "+Colours.YELLOW_BG+Colours.BLACK_TXT+ " | |_/ / ___   __ _ _ __ __| | | |_/ / |_/ / |  \\/ "+Colours.BLACK_BG+"  \n"+Colours.ANSI_RESET
				+Colours.BLACK_BG+"  "+Colours.YELLOW_BG+Colours.BLACK_TXT+ " | ___ \\/ _ \\ / _` | '__/ _` | |    /|  __/| | __  "+Colours.BLACK_BG+"  \n"+Colours.ANSI_RESET
				+Colours.BLACK_BG+"  "+Colours.YELLOW_BG+Colours.BLACK_TXT+ " | |_/ / (_) | (_| | | | (_| | | |\\ \\| |   | |_\\ \\ "+Colours.BLACK_BG+"  \n"+Colours.ANSI_RESET
				+Colours.BLACK_BG+"  "+Colours.YELLOW_BG+Colours.BLACK_TXT+ " \\____/ \\___/ \\__,_|_|  \\__,_| \\_| \\_\\_|    \\____/ "+Colours.BLACK_BG+"  \n"+Colours.ANSI_RESET
				+Colours.BLACK_BG+"  "+Colours.YELLOW_BG+Colours.BLACK_TXT+ "                                                   "+Colours.BLACK_BG+"  \n"+Colours.ANSI_RESET
				+ Colours.BLACK_BG+"                                                       \n"+Colours.ANSI_RESET);

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
