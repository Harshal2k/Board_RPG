package Game;

import Character.GameCharacter;
import Utils.Colours;

public class Board {
	
	public void printBoard(Player p1,Player p2) {
		int a=65;
		System.out.println(Colours.BLACK_BG+"   -------------------------------------   "+Colours.ANSI_RESET);
		System.out.println(Colours.BLACK_BG+String.format("             HOUSE OF %-9s            ", p1.getHouse())+Colours.ANSI_RESET);
		System.out.println(Colours.BLACK_BG+"   -------------------------------------   "+Colours.ANSI_RESET);
		for(int i=0;i<7;i++) {
			if(i==0) {
				System.out.println(Colours.CYAN_BG+"                                           "+Colours.ANSI_RESET);	
			}else {
				System.out.println("");
			}
		    System.out.println(Colours.CYAN_BG+"   "+Colours.GREEN_BG+"-------------------------------------"+Colours.CYAN_BG+"   "+Colours.ANSI_RESET);
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
					System.out.print(String.format(Colours.CYAN_BG+(j==0?"   ":"")+"  " + "%2s " + (j==5?"     ":" "),(j+1))+Colours.ANSI_RESET);	
				}else {
					System.out.print(String.format((j==0?Colours.CYAN_BG+" "+(char)a+++" ":"")+Colours.GREEN_BG+"| "+Colours.BLACK_TXT + "%3s" + " "+Colours.ANSI_RESET,chName));	
				}
			}
			if(i<6) {
			      System.out.print(Colours.GREEN_BG+"|"+Colours.CYAN_BG+"   "+Colours.ANSI_RESET);	
			}
		}
		System.out.println("");
		System.out.println(Colours.BLACK_BG+"   -------------------------------------   "+Colours.ANSI_RESET);
		System.out.println(Colours.BLACK_BG+String.format("             HOUSE OF %-9s            ", p2.getHouse())+Colours.ANSI_RESET);
		System.out.println(Colours.BLACK_BG+"   -------------------------------------   "+Colours.ANSI_RESET);
	}
}
