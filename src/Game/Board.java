package Game;

public class Board {
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	public void printBoard() {
		int a=65;
		System.out.println("  -------------------------------------");
		System.out.println(String.format("            HOUSE OF %s           ", "STARK"));
		System.out.println("  -------------------------------------");
		for(int i=0;i<7;i++) {
		    System.out.println("");
		    System.out.println("  -------------------------------------");
			for(int j=0;j<6;j++) {
				if(i==6) {
					System.out.print(String.format((j==0?"  ":"")+"  " + "%2s " + " ",(j+1)));	
				}else {
					System.out.print(String.format((j==0?(char)a+++" ":"")+"| " + "%3s" + " ","CH1"));	
				}
			}
			if(i<6) {
			      System.out.print("|");	
			}
		}
		System.out.println("");
		System.out.println("  -------------------------------------");
		System.out.println(String.format("            HOUSE OF %s           ", "STARK"));
		System.out.println("  -------------------------------------");
	}
}
