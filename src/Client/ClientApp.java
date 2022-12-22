package Client;

import java.io.IOException;

import Game.Game;
import Game.Player;
import Utils.Helper;

public class ClientApp {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Player player1=new Player(1);
		Player player2=new Player(2);
		Helper.setPlayers(player1, player2);
		Game gmGame = new Game(player1, player2);
		gmGame.getBoard();
		gmGame.initializePlayers();
		gmGame.startGame();
	}

}
