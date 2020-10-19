package window;

public enum Player {
	WHITE("White"), 
	BLACK("Black");
	
	Player(String name){
		this.name = name;
	}
	
	private String name;
	public String getName() {
		return name;
	}
	
}


