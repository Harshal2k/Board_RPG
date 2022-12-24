package game;

import characters.GameCharacter;
import utils.Colours;

public class Score {
	private Player player1, player2;

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
				System.out.println(Colours.WHITE_BG+Colours.BLACK_TXT + "\n ⚰️ " + player1.getCharacters()[attacker_pos].getName()+ " of House " + player1.getHouse() + " got Killed \n" + Colours.ANSI_RESET);
				player1.updateCharacter(null, attacker_pos, true);
			} else {
				System.out.println(Colours.WHITE_BG+Colours.BLACK_TXT + "\n ⚰️ " + player2.getCharacters()[attacker_pos].getName()+ " of House " + player2.getHouse() + " got Killed \n" + Colours.ANSI_RESET);
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
				System.out.println(Colours.WHITE_BG+Colours.BLACK_TXT + "\n ⚰️ " + player1.getCharacters()[defencer_pos].getName()+ " of House " + player1.getHouse() + " got Killed \n" + Colours.ANSI_RESET);
				player1.updateCharacter(null, defencer_pos, true);
			} else {
				System.out.println(Colours.WHITE_BG+Colours.BLACK_TXT + "\n ⚰️ " + player2.getCharacters()[defencer_pos].getName()+ " of House " + player2.getHouse() + " got Killed \n" + Colours.ANSI_RESET);
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
		System.out.println("");
		System.out.println(Colours.BLUE_BG + Colours.WHITE_TXT
				+ String.format("-------------------------------------------------------") + Colours.ANSI_RESET);
		System.out.println(Colours.BLUE_BG + Colours.WHITE_TXT
				+ String.format("|                      %-31s|", player1.getName()) + Colours.ANSI_RESET);
		System.out.println(Colours.BLUE_BG + Colours.WHITE_TXT
				+ String.format("-------------------------------------------------------") + Colours.ANSI_RESET);
		System.out.println(String.format(Colours.BLACK_BG + Colours.WHITE_TXT
				+ "|  CHARACTER  |  HEALTH | ATTACK  | DEFENCE  |  MOVES |" + Colours.ANSI_RESET));
		for (GameCharacter val1 : player1.getCharacters()) {
			if (val1 != null) {
				System.out.println(String.format(
						Colours.CYAN_BG + Colours.BLACK_TXT + "|     %3s     |   %3d   |   %3d   |    %3d   |   %3d  |"
								+ Colours.ANSI_RESET,
						val1.getName(), val1.getHealth(), val1.getAttack(), val1.getDefence(), val1.getMaxMoves()));
			}
		}
		System.out.println(String.format(Colours.CYAN_BG + Colours.BLACK_TXT
				+ "-------------------------------------------------------" + Colours.ANSI_RESET));

		System.out.println("");
		System.out.println(Colours.BLUE_BG + Colours.WHITE_TXT
				+ String.format("-------------------------------------------------------") + Colours.ANSI_RESET);
		System.out.println(Colours.BLUE_BG + Colours.WHITE_TXT
				+ String.format("|                      %-31s|", player2.getName()) + Colours.ANSI_RESET);
		System.out.println(Colours.BLUE_BG + Colours.WHITE_TXT
				+ String.format("-------------------------------------------------------") + Colours.ANSI_RESET);
		System.out.println(Colours.BLUE_BG + Colours.WHITE_TXT + String.format(Colours.BLACK_BG + Colours.WHITE_TXT
				+ "|  CHARACTER  |  HEALTH | ATTACK  | DEFENCE  |  MOVES |" + Colours.ANSI_RESET));
		for (GameCharacter val1 : player2.getCharacters()) {
			if (val1 != null) {
				System.out.println(String.format(
						Colours.CYAN_BG + Colours.BLACK_TXT + "|     %3s     |   %3d   |   %3d   |    %3d   |   %3d  |"
								+ Colours.ANSI_RESET,
						val1.getName(), val1.getHealth(), val1.getAttack(), val1.getDefence(), val1.getMaxMoves()));
			}
		}
		System.out.println(String.format(Colours.CYAN_BG + Colours.BLACK_TXT
				+ "-------------------------------------------------------" + Colours.ANSI_RESET));
	}

}