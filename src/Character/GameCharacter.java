package Character;

public class GameCharacter {
	private Integer health,posX,poY,attack,defence,maxMoves;
	private String name;
	
	public GameCharacter(String Name,Integer health,Integer posX,Integer posY,Integer attack,Integer defence,Integer maxMoves) {
		this.name=Name;
		this.health=health;
		this.posX=posX;
		this.poY=posY;
		this.attack=attack;
		this.defence=defence;
		this.maxMoves=maxMoves;		
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public Integer getPosX() {
		return posX;
	}

	public void setPosX(Integer posX) {
		this.posX = posX;
	}

	public Integer getPoY() {
		return poY;
	}

	public void setPoY(Integer poY) {
		this.poY = poY;
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	public Integer getDefence() {
		return defence;
	}

	public void setDefence(Integer defence) {
		this.defence = defence;
	}

	public Integer getMaxMoves() {
		return maxMoves;
	}

	public void setMaxMoves(Integer maxMoves) {
		this.maxMoves = maxMoves;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
