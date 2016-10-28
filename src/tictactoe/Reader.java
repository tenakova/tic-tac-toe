package tictactoe;

import java.util.Scanner;

public class Reader {
	
private Scanner reader;
	
	Reader() {
		reader = new Scanner(System.in);
	}
	
	public String getName() {
		System.out.print("Моля въведете име: ");
		return reader.nextLine();
	}
	
	public Symbol getSymbol() {
		System.out.print("Моля въведете символ: ");
		String line = reader.nextLine();
		if (line.equals("X") || line.equals("x")) return Symbol.X;
		else if(line.equals("O") || line.equals("o")) return Symbol.O;
		else return getSymbol();
	}
	
	public int getFieldNumber() {
		boolean isNotValid = true;
		String line = null;
		
		while(isNotValid) {
			line = reader.nextLine();
			if(line.length() == 1 && 
					line.charAt(0) > '0' && line.charAt(0) <= '0'+Board.SIZE*Board.SIZE) {
				isNotValid = false;
			} else {
				System.out.println("Моля въведете число!");
			}
		}
		
		return Integer.parseInt(line);
	}
}
