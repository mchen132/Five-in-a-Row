
public class Stone {
    public int row, col, color;

    public Stone(int row, int col, int color){
        this.row = row;
        this.col = col;
        this.color = color;
    }
    
    public boolean equals(Object obj) {
    	if(obj == null) {
    		return false;
    	}else {
    		if(!(obj instanceof Stone)) {
    			return false;
    		}else {
    			return ((Stone)obj).row == this.row &&
    					((Stone)obj).col == this.col;
    		}
    	}
    }
}