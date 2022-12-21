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
		Integer attackerHealth, defencerHealth;
		Integer attacker_pos=0,defencer_pos=0;
		// p1Health=gc.getHealth()+gc.getDefence();
		if (toattack == 1) {
			for (int i = 0; i < 4; i++) {
				if (player1.getCharacters()[i] != null && player1.getCharacters()[i].getPosX() == posX
						&& player1.getCharacters()[i].getPoY() == posY) {
					attacker = player1.getCharacters()[i];
					attacker_pos=i;
				}
				if (player2.getCharacters()[i] != null && player2.getCharacters()[i].getPosX() == posX
						&& player2.getCharacters()[i].getPoY() == posY) {
					defencer = player2.getCharacters()[i];
					defencer_pos=i;
				}
			}
		} else {
			for (int i = 0; i < 4; i++) {
				if (player2.getCharacters()[i] != null && player2.getCharacters()[i].getPosX() == posX
						&& player2.getCharacters()[i].getPoY() == posY) {
					attacker = player2.getCharacters()[i];
					attacker_pos=i;
				}
				if (player1.getCharacters()[i] != null && player1.getCharacters()[i].getPosX() == posX
						&& player1.getCharacters()[i].getPoY() == posY) {
					defencer = player1.getCharacters()[i];
					defencer_pos=i;
				}
			}
		}
		if (defencer == null) {
			return;
		}

		attackerHealth = attacker.getHealth() + attacker.getDefence();
		defencerHealth = defencer.getHealth() + defencer.getDefence();
		boolean flag = true;
		toattack = 1;
		while (attackerHealth > 0 && defencerHealth > 0) {
			if (toattack == 1) {
				defencerHealth = defencerHealth - (attacker.getAttack() + (flag == true ? 10 : 0));
				flag = false;
			} else {
				attackerHealth = attackerHealth - defencer.getAttack();
			}
		}
		attacker.setDefence(attacker.getDefence()-attackerHealth);
		attacker.setHealth(attacker.getDefence()<=0?attacker.getHealth()+attacker.getDefence():attacker.getHealth());
		attacker.setDefence(attacker.getDefence()<0?0:attacker.getDefence());
		
		defencer.setDefence(defencer.getDefence()-defencerHealth);
		defencer.setHealth(defencer.getDefence()<=0?defencer.getHealth()+defencer.getDefence():defencer.getHealth());
		defencer.setDefence(defencer.getDefence()<0?0:defencer.getDefence());
		if(attacker.getHealth()<=0)
		{
			if(toattack==1)
			{
				player1.updateCharacter(null, attacker_pos);
			}
			else
			{
				player2.updateCharacter(null, attacker_pos);
			}
		}
		if(defencer.getHealth()<=0)
		{
			if(toattack==2)
			{
				player1.updateCharacter(null, defencer_pos);
			}
			else
			{
				player2.updateCharacter(null, defencer_pos);
			}
		}
	}

}