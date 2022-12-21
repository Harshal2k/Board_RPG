package Game;

import Character.GameCharacter;

public class Board {
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	public void printBoard(Player p1,Player p2) {
		int a=65;
		System.out.println("  -------------------------------------");
		System.out.println(String.format("            HOUSE OF %s           ", p1.getHouse()));
		//System.out.println("            HOUSE OF DRAGONS           ");
		System.out.println("  -------------------------------------");
		for(int i=0;i<7;i++) {
		    System.out.println("");
		    System.out.println("  -------------------------------------");
			for(int j=0;j<6;j++) {
				String chName="";
				for(int k=0;k<4;k++) {
					GameCharacter gmCharacter = p1.getCharacters()[k];
					if(gmCharacter!=null && gmCharacter.getPosX()==j && gmCharacter.getPoY()==i) {
						chName=gmCharacter.getName();
						break;
					}
					gmCharacter=p2.getCharacters()[k];
					if(gmCharacter!=null && gmCharacter.getPosX()==j && gmCharacter.getPoY()==i) {
						chName=gmCharacter.getName();
						break;
					}
				}
				if(i==6) {
					System.out.print(String.format((j==0?"  ":"")+"  " + "%2s " + " ",(j+1)));	
				}else {
					System.out.print(String.format((j==0?(char)a+++" ":"")+"| " + "%3s" + " ",chName));	
				}
			}
			if(i<6) {
			      System.out.print("|");	
			}
		}
		System.out.println("");
		System.out.println("  -------------------------------------");
		System.out.println(String.format("            HOUSE OF %s           ", p2.getHouse()));
		System.out.println("  -------------------------------------");
	}
}
