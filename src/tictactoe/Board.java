package tictactoe;

public class Board {
	
	static final int SIZE = 3;
	private Symbol[][] board;
	
	public Board() {
		board = new Symbol[SIZE][SIZE];
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				board[i][j] = Symbol.NONE;
			}
		}
	}
	
	@Override
	public String toString() {
		int fieldNumber = 1;
		StringBuilder displayBoard = new StringBuilder();
		
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(board[i][j].equals(Symbol.NONE)) {
					displayBoard.append(fieldNumber + " ");
				} else if(board[i][j].equals(Symbol.O)) {
					displayBoard.append( "O ");
				} else {
					displayBoard.append( "X ");
				}
				fieldNumber++;
			}
			displayBoard.append("\n");
		}
		return displayBoard.toString();
	}
	
	public Symbol[][] getBoard() {
		return board;
	}
	
	public Point getFieldCoordinates(int fieldNumber) {
		Point point = null;
		
		switch (fieldNumber) {
			case 1:
				point = new Point(0, 0);
				break;
			case 2: 
				point = new Point(0, 1);
				break;
			case 3: 
				point = new Point(0, 2);
				break;
			case 4: 
				point = new Point(1, 0);
				break;
			case 5: 
				point = new Point(1, 1);
				break;
			case 6: 
				point = new Point(1, 2);
				break;
			case 7: 
				point = new Point(2, 0);
				break;
			case 8: 
				point = new Point(2, 1);
				break;
			case 9: 
				point = new Point(2, 2);
				break;
		}	
		
		return point;
	}
	
	public void markField(Point field, Symbol symbol) {
		board[field.getX()][field.getY()] = symbol;
	}
	
	public boolean isTaken(Point field) {
		return !board[field.getX()][field.getY()].equals(Symbol.NONE);
	}
	
	public boolean isWon(Point field, Symbol symbol) {
		int symbolRowCount = 0, symbolColCount = 0,
				symbolDiagonalCount = 0, symbolRevDiagonalCount = 0;
		
		for(int i = 0; i < SIZE; i++) {
			if(board[field.getX()][i].equals(symbol)) symbolColCount++;
			if(board[i][field.getY()].equals(symbol)) symbolRowCount++;
			if(board[i][i].equals(symbol)) symbolDiagonalCount++;
			if(board[i][SIZE-i-1].equals(symbol)) symbolRevDiagonalCount++;
		}
		
		return symbolRowCount == SIZE || symbolColCount == SIZE || 
				symbolDiagonalCount == SIZE || symbolRevDiagonalCount == SIZE;
	}
	
	public boolean isFull() {
		boolean isFull = true;
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(board[i][j].equals(Symbol.NONE)) {
					isFull = false;
					break;
				}
			}
		}
		return isFull;	
	}

}
