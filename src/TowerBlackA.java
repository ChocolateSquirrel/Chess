
public class TowerBlackA {
	private String color;
	private String name;
	private int posX;
	private int posY;
	private String pathToImage;
	
	public TowerBlackA() {
		posX = 0;
		posY = 0;
		color = "black";
		name = "black tower A";
		pathToImage = "assets/black/black_tower.png";
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public String getPathToImage() {
		return pathToImage;
	}

}
