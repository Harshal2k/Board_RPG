package game;

import characters.GameCharacter;
import characters.King;

public class Player {
	private String name, house = "";
	private GameCharacter characters[] = new GameCharacter[4];

	public Player(Integer playerNo) {
		if (playerNo == 1) {
			characters[0] = new King("P1K", 150, 2, 0);
		} else if (playerNo == 2) {
			characters[0] = new King("P2K", 150, 2, 5);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public GameCharacter[] getCharacters() {
		return characters;
	}

	public void setCharacters(GameCharacter[] characters) {
		this.characters = characters;
	}

	public void updateCharacter(GameCharacter character, Integer position, Boolean delKing) {
		if (delKing && position >= 0 && position < 4) {
			characters[position] = character;
		} else if (!delKing && position > 0 && position < 4) {
			characters[position] = character;
		}
	}
}