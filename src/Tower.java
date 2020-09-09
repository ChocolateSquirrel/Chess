import java.util.List;

public class Tower extends Piece {
	
	public Tower(String name, int posX, int posY, String color) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.color = color;	
		Case casePiece = ChessboardPanel.getInstance().getCaseAt(posX, posY);
		ChessboardPanel.getInstance().getJPanel(casePiece).addImageIcon("assets/" + color + "/tower_" + color +".png");
		casePiece.setIsEmpty(false);
	}
	
	public Tower(String name, int posX, int posY, String color, String path) {
		this(name, posX, posY, color);
		this.pathToImage = path;	
	}

	@Override
	public List<Case> getPossibleCases(Case[][] gridCases) {
		return Movable.straightMovement(gridCases, posX, posY);
	}

	

}
