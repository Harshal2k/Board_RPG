package Client;

import Game.Game;
import Game.Player;

public class ClientApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player1=new Player();
		Player player2=new Player();
		Game gmGame = new Game(player1, player2);
		gmGame.getBoard();

	}

}
