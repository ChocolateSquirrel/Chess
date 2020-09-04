
public abstract class Piece implements Moveable {
	protected String name;
	protected int posX;
	protected int posY;
	protected String color;
	protected String pathToImage;
	
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public void setPosY(int posY) {
		this.posY = posX;
	}

}
