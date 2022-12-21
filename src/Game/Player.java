package Game;

import Character.GameCharacter;

public class Player {
	private String name, house = "";
	private GameCharacter characters[] = new GameCharacter[4];

	public Player() {
	
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
}