
public class Board {
	public static final int WHITE = 1;
	public static final int BLACK = -1;
	public static final int EMPTY = 0;
	
	int [][] board = new int [15][15];
	
	public Board() {
		for(int row = 0; row < 15; row ++) {
			for(int col =0; col < 15; col ++) {
				board[row][col] = EMPTY;
			}
		}
	}
	
	public boolean placeStone(Stone stone) {
		if(stone.row <0 || stone.col < 0 || stone.row >=15 || stone.col >=15) {
			return false;
		}else if(board [stone.row][stone.col] != EMPTY) {
			return false;
		}else {
			board [stone.row][stone.col] = stone.color;
			return true;
		}
	}
	
	/*public boolean win(Player player) {
		int playerRow = player.stoneList.get(player.numberOfStone - 1).row,
			playerCol = player.stoneList.get(player.numberOfStone - 1).col,
			playerColor = player.Color,
			count = 0;
		
		if(playerRow >= 0 && playerRow <= 9) {
			for 
		}
	}*/
}
