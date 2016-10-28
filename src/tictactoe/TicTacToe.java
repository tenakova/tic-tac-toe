package tictactoe;

public class TicTacToe {

	public static void main(String[] args) {
		Game ticTacToe = new Game();
		
		Result state = Result.ONGOING;
		while(state.equals(Result.ONGOING)) {
			for(int playerIndex = 0; playerIndex < Game.PLAYER_COUNT; playerIndex++) {
				state = ticTacToe.round(playerIndex);
				
				if(state.equals(Result.WIN)) {
					System.out.printf("Победител е играч %s!\n", ticTacToe.getPlayer(playerIndex).getName());
					break;
				} else if(state.equals(Result.DRAW)) {
					System.out.println("Никой не спечели!");
					break;
				}
			}
		}

	}

}
