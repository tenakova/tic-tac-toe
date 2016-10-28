package tictactoe;

public class Game {
	static final int PLAYER_COUNT = 2;
	private Player[] players;
	
	private Board board;
	private Reader reader;
	
	public Game() {
		board = new Board();
		reader = new Reader();
		players = new Player[PLAYER_COUNT];
		
		for(int i = 0; i < PLAYER_COUNT; i++) {
			players[i] = setUpPlayer();
		}
	}
	
	public Player setUpPlayer() {
		String playerName = reader.getName();
		Symbol playerSymbol = reader.getSymbol();
		return new Player(playerName, playerSymbol);
	}
	
	public Result round(int playerIndex) {
		System.out.println(board);
		Player player = players[playerIndex];
		System.out.printf("Играч %s, моля въведете своя ход (1-9)> ", player.getName());
		Point chosenField = board.getFieldCoordinates(reader.getFieldNumber());
		while(board.isTaken(chosenField)) {
			round(playerIndex);
		}
		board.markField(chosenField, player.getSymbol());
		return checkResult(chosenField, player.getSymbol());
	}
	
	public Result checkResult(Point field, Symbol symbol) {
		if(board.isWon(field, symbol)) return Result.WIN;
		if(board.isFull()) return Result.DRAW;
		else return Result.ONGOING;
	}
	
	public Player getPlayer(int playerIndex) {
		return players[playerIndex];
	}
	
}
