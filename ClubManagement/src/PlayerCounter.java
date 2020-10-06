
public class PlayerCounter {
	
	private int i = 0; // this is player number
	private int j; // this is array index
	String string;
	//private int j;
	
	PlayerCounter(){
		
	}
	
	public void increasePlayerNumber() {
		i = i + 1;
		j = i-1;
	}
	
	public int getPlayerNumber() {
		return i;
	}
	
	public int getArrayIndex() {
		return j;
	}
	
	public String toString() {
		
		string = Integer.toString(i);
		System.out.println("\nPlayer no: " + i);
		return string;
	}

}
