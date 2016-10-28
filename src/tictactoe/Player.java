package tictactoe;

public class Player {
	private String name;
	private Symbol usedSymbol;
	
	public Player(String name, Symbol usedSymbol) {
		this.name = name;
		this.usedSymbol = usedSymbol;
	}
	
	public String getName() {
		return name;
	}
	
	public Symbol getSymbol() {
		return usedSymbol;
	}

}