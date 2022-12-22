package Game;

import Character.GameCharacter;

public class Score {
	Player player1, player2;

	public Score(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public void calculateDamage(Integer toattack, Integer posX, Integer posY) {
		GameCharacter attacker = null, defencer = null;
		Integer attackerHealth, defencerHealth, initAttHealth, initDefHealth;
		Integer attacker_pos = 0, defencer_pos = 0;
		if (toattack == 1) {
			for (int i = 0; i < 4; i++) {
				if (player1.getCharacters()[i] != null && player1.getCharacters()[i].getPosX() == posX
						&& player1.getCharacters()[i].getPoY() == posY) {
					attacker = player1.getCharacters()[i];
					attacker_pos = i;
				}
				if (player2.getCharacters()[i] != null && player2.getCharacters()[i].getPosX() == posX
						&& player2.getCharacters()[i].getPoY() == posY) {
					defencer = player2.getCharacters()[i];
					defencer_pos = i;
				}
			}
		} else {
			for (int i = 0; i < 4; i++) {
				if (player2.getCharacters()[i] != null && player2.getCharacters()[i].getPosX() == posX
						&& player2.getCharacters()[i].getPoY() == posY) {
					attacker = player2.getCharacters()[i];
					attacker_pos = i;
				}
				if (player1.getCharacters()[i] != null && player1.getCharacters()[i].getPosX() == posX
						&& player1.getCharacters()[i].getPoY() == posY) {
					defencer = player1.getCharacters()[i];
					defencer_pos = i;
				}
			}
		}
		if (defencer == null) {
			return;
		}
		attackerHealth = attacker.getHealth() + attacker.getDefence();
		defencerHealth = defencer.getHealth() + defencer.getDefence();
		initAttHealth = attackerHealth;
		initDefHealth = defencerHealth;
		boolean flag = true;
		Integer currentAttacker = 1;
		while (attackerHealth > 0 && defencerHealth > 0) {
			if (currentAttacker == 1) {
				Integer extraAttack = attacker.getAttack();
				if (flag == true) {
					extraAttack = extraAttack + 10;
					flag = false;
				}
				defencerHealth = defencerHealth - extraAttack;
				currentAttacker = 2;
			} else {
				attackerHealth = attackerHealth - defencer.getAttack();
				currentAttacker = 1;
			}
		}

		if (attackerHealth <= 0) {
			if (toattack == 1) {
				player1.updateCharacter(null, attacker_pos, true);
			} else {
				player2.updateCharacter(null, attacker_pos, true);
			}
		} else {
			attacker.setDefence(attacker.getDefence() - (initAttHealth - attackerHealth));
			if (attacker.getDefence() < 0) {
				attacker.setHealth(attacker.getHealth() + attacker.getDefence());
				attacker.setDefence(0);
			}
			if (toattack == 1) {
				player1.updateCharacter(attacker, attacker_pos, true);
			} else {
				player2.updateCharacter(attacker, attacker_pos, true);
			}
		}

		if (defencerHealth <= 0) {
			if (toattack == 2) {
				player1.updateCharacter(null, defencer_pos, true);
			} else {
				player2.updateCharacter(null, defencer_pos, true);
			}
		} else {
			defencer.setDefence(defencer.getDefence() - (initDefHealth - defencerHealth));
			if (defencer.getDefence() < 0) {
				defencer.setHealth(defencer.getHealth() + defencer.getDefence());
				defencer.setDefence(0);
			}
			if (toattack == 2) {
				player1.updateCharacter(defencer, defencer_pos, true);
			} else {
				player2.updateCharacter(defencer, defencer_pos, true);
			}
		}
	}

	public void printScores() {
		System.out.println("Player 01");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("| CHARACTER  | HEALTH  |  ATTACK | DEFENCE | MOVES |");
		System.out.println("|-------------------------------------------------------------------|");
		for (int i = 0; i < 4; i++) {
			if (player1.getCharacters()[i] != null) {
				System.out.println(String.format("|     %3s    |   %3s   |   %3s   |   %3s   |   %1s   |",
						player1.getCharacters()[i].getName(), player1.getCharacters()[i].getHealth(),
						player1.getCharacters()[i].getAttack(), player1.getCharacters()[i].getDefence(), 2));
			}
		}
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Player 01");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("|    CHARACTER   | HEALTH  |  ATTACK | DEFENCE | MOVES |");
		System.out.println("|-------------------------------------------------------------------|");
		for (int i = 0; i < 4; i++) {
			if (player2.getCharacters()[i] != null) {
				System.out.println(String.format("|     %3s    |   %3s   |   %3s   |   %3s   |   %1s   |",
						player2.getCharacters()[i].getName(), player2.getCharacters()[i].getHealth(),
						player2.getCharacters()[i].getAttack(), player2.getCharacters()[i].getDefence(), 2));
			}
		}
		System.out.println("---------------------------------------------------------------------");
	}

}