import java.util.ArrayList;

public abstract class Player {
	public ArrayList<Stone> stoneList;
	public int numberOfStone;
	public int Color;
	
	public Player(ArrayList<Stone> stoneList, int numberOfStone, int color) {
		super();
		this.stoneList = stoneList;
		this.numberOfStone = numberOfStone;
		this.Color = color;
	}
	
	public abstract void placeStone(Stone stone, Player opponent, Board board);
}
