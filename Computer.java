import java.util.*;
import java.math.*;
public class Computer extends Player {
	public static final int WHITE = 1;
	public static final int BLACK = -1;
	public static final int EMPTY = 0;

	public Computer(ArrayList<Stone> stoneList, int numberOfStone, int Color) {
		super(stoneList, numberOfStone, Color);
	}

	@Override
	public void placeStone(Stone stone, Player opponent, Board board) {
		Random rand = new Random();
		int randX, randY;

		// stoneList.add(stone);
		numberOfStone++;

		if (numberOfStone == 1) {/*
									 * If the current stone is THE first stone
									 * of the game
									 */
			randX = rand.nextInt(15); 
			randY = rand.nextInt(15);
			/* Need to modify stone's coordinate */
			
			stone.row = randX;
			stone.col = randY;
			
			board.placeStone(stone);
			stoneList.add(stone);

			/* don't forget to add the stone to the stonelist at very end */

		} else if (numberOfStone == 2) { /*
											 * This is the second stone the
											 * computer places, which is also
											 * the stone to be placed after the
											 * user place its first stone
											 */
			if(addEightDirection(stone, opponent)) {
				
			}else {
				addEightDirection(stone, this);
			}
			
			board.placeStone(stone);
			stoneList.add(stone);
		} else if(numberOfStone == 3){
			if(distance(this.stoneList.get(numberOfStone - 1 - 1), opponent.stoneList.get(numberOfStone - 1)) <= 500) {
				if(addEightDirection(stone, opponent)) {
					
				}else {
					for(int i = 0; i < 15; i ++) {
						for(int j = 0; j < 15; j ++) {
							if(board.board[i][j] == EMPTY) {
								stone.row = i;
								stone.col = j;
								
								board.placeStone(stone);
								stoneList.add(stone);
								
								return;
							}
						}
					}
				}
			}else {
				addEightDirection(stone, this);
			}
		} else if(numberOfStone == 4) {
			int lowestRow = 0, lowestCol = 0;
			double shortestDistance = 450;
			Stone lastCompStone = stoneList.get(numberOfStone - 1 - 1);
			
			for(int i = 0; i < 15; i ++) {
				for(int j = 0; j < 15; j ++) {
					if(board.board[i][j] == EMPTY &&
							(Math.abs(lastCompStone.row - i) * Math.abs(lastCompStone.row - i) +
							Math.abs(lastCompStone.col - j) * Math.abs(lastCompStone.col - j)) < shortestDistance) {
						shortestDistance = Math.abs(lastCompStone.row - i) * Math.abs(lastCompStone.row - i) +
								Math.abs(lastCompStone.col - j) * Math.abs(lastCompStone.col - j);
						lowestRow = i;
						lowestCol = j;
					}
				}
			}
			stone.row = lowestRow;
			stone.col = lowestCol;
			
			board.placeStone(stone);
			stoneList.add(stone);
		}else if(numberOfStone == 5) {
			Stone lastStone = stoneList.get(numberOfStone - 1 - 1);
			 if(lastStone.row <= 9 && lastStone.col <= 9) {
				 for(int i = 1; i <= 5; i ++) {
					 if(board.board[lastStone.row + 1][lastStone.col + 1] == EMPTY) {
						 stone.row = lastStone.row + 1;
						 stone.col = lastStone.col + 1;
						 
						 board.placeStone(stone);
						 stoneList.add(stone);
						 return;
					 }
				 }
			 }else if(lastStone.row <= 9) {
				 for(int i = 1; i <=5; i ++) {
					 if(board.board[lastStone.row + 1][lastStone.col] == EMPTY) {
						 stone.row = lastStone.row + 1;
						 stone.col = lastStone.col;
						 
						 board.placeStone(stone);
						 stoneList.add(stone);
						 return;
					 }
				 }
			 }else if(lastStone.col <= 9) {
				 for(int i = 1; i <= 5; i++) {
					 if(board.board[lastStone.row][lastStone.col + 1] == EMPTY) {
						 stone.row = lastStone.row;
						 stone.col = lastStone.col + 1;
						 
						 board.placeStone(stone);
						 stoneList.add(stone);
						 return;
					 }
				 }
			 }else if(lastStone.row > 9) {
				 for(int i = 1; i <= 5; i ++) {
					 if(board.board[lastStone.row - 1][lastStone.col] == EMPTY) {
						 stone.row = lastStone.row - 1;
						 stone.col = lastStone.col;
						 
						 board.placeStone(stone);
						 stoneList.add(stone);
						 return;
					 }
				 }
			 }else if(lastStone.col > 9) {
				 for(int i = 1; i <=5; i ++) {
					 if(board.board[lastStone.row][lastStone.col - 1] == EMPTY) {
						 stone.row = lastStone.row;
						 stone.col = lastStone.col - 1;
						 
						 board.placeStone(stone);
						 stoneList.add(stone);
						 return;
					 }
				 }
			 }else {
				 for(int i = 0; i < 15; i ++) {
					 for(int j = 0; j < 15; j ++) {
						 if(board.board[i][j] == EMPTY) {
							 stone.row = i;
							 stone.col = j;
							 
							 board.placeStone(stone);
							 stoneList.add(stone);
						 }
					 }
				 }
			 }
		}else {
			int lowestRow = 0, lowestCol = 0;
			double shortestDistance = 450;
			Stone lastCompStone = stoneList.get(numberOfStone - 1 - 1);
			
			for(int i = 0; i < 15; i ++) {
				for(int j = 0; j < 15; j ++) {
					if(board.board[i][j] == EMPTY &&
							(Math.abs(lastCompStone.row - i) * Math.abs(lastCompStone.row - i) +
							Math.abs(lastCompStone.col - j) * Math.abs(lastCompStone.col - j)) < shortestDistance) {
						shortestDistance = Math.abs(lastCompStone.row - i) * Math.abs(lastCompStone.row - i) +
								Math.abs(lastCompStone.col - j) * Math.abs(lastCompStone.col - j);
						lowestRow = i;
						lowestCol = j;
					}
				}
			}
			stone.row = lowestRow;
			stone.col = lowestCol;
			
			board.placeStone(stone);
			stoneList.add(stone);
		}

	}
	
	/*This function places computer's next stone at one of the eight directions of the last piece that user has places, within 1 unit*/

	public boolean addEightDirection(Stone stone, Player opponent) {
		Stone whiteStone = opponent.stoneList.get(opponent.numberOfStone - 1); /*Since, at this point, user's number of stones is always 1 less
			than computer's number of stones, so the index of the last stone of the player is
				computer's number of stones - 1*/

		if(whiteStone.row + 1 < 15 &&
				!(opponent.stoneList.contains(new Stone(whiteStone.row + 1, whiteStone.col, WHITE)))) {
			/*The stone from the computer will be added below user's last stone, if possible*/
			stone.row = whiteStone.row + 1;
			stone.col = whiteStone.col;
			return true;
		}else if(whiteStone.row - 1 >= 0 &&
				!(opponent.stoneList.contains(new Stone(whiteStone.row - 1, whiteStone.col, WHITE)))) {
			/*The stone from the computer will be added above user's last stone, if possible*/
			stone.row = whiteStone.row - 1;
			stone.col = whiteStone.col;
			return true;
		}else if(whiteStone.col + 1 < 15 &&
				!(opponent.stoneList.contains(new Stone(whiteStone.row, whiteStone.col + 1, WHITE)))) {
			/*The stone from the computer will be added right to user's last stone, if possible*/
			stone.row = whiteStone.row;
			stone.col = whiteStone.col + 1;
			return true;
		}else if(whiteStone.col - 1 > 1 &&
				!(opponent.stoneList.contains(new Stone(whiteStone.row, whiteStone.col - 1, WHITE)))) {
			/*The stone from the computer will be added left to user's last stone, if possible*/
			stone.row = whiteStone.row;
			stone.col = whiteStone.col - 1;
			return true;
		}else if(whiteStone.row - 1 >= 0 && whiteStone.col + 1 < 15 &&
				!(opponent.stoneList.contains(new Stone(whiteStone.row - 1, whiteStone.col + 1, WHITE)))) {
			/*TheThe stone from the computer will be added north-east user's last stone, if possible*/
			stone.row = whiteStone.row - 1;
			stone.col = whiteStone.col + 1;
			return true;
		}else if(whiteStone.row + 1 < 15 && whiteStone.col + 1 < 15 &&
				!(opponent.stoneList.contains(new Stone(whiteStone.row + 1, whiteStone.col + 1, WHITE)))) {
			/*TheThe stone from the computer will be added south-east user's last stone, if possible*/
			stone.row = whiteStone.row + 1;
			stone.col = whiteStone.col + 1;
			return true;
		}else if(whiteStone.row - 1 >= 0 && whiteStone.col - 1 >= 0 &&
				!(opponent.stoneList.contains(new Stone(whiteStone.row - 1, whiteStone.col - 1, WHITE)))) {
			/*TheThe stone from the computer will be added north-west user's last stone, if possible*/
			stone.row = whiteStone.row - 1;
			stone.col = whiteStone.col - 1;
			return true;
		}else if(whiteStone.row + 1 < 15 && whiteStone.col - 1 >= 0 &&
				!(opponent.stoneList.contains(new Stone(whiteStone.row + 1, whiteStone.col - 1, WHITE)))) {
			/*TheThe stone from the computer will be added south-west user's last stone, if possible*/
			stone.row = whiteStone.row + 1;
			stone.col = whiteStone.col - 1;
			return true;
		}else {
			return false;
		}
	}
	
	public double distance(Stone stone1, Stone stone2) {
		return Math.abs(stone1.row - stone2.row) * Math.abs(stone1.row - stone2.row) +
				Math.abs(stone1.col - stone2.col) * Math.abs(stone1.col - stone2.col);
	}
}
