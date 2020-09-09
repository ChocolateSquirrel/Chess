
import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
	
	public Queen(String name, int posX, int posY, String color) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.color = color;	
		Case casePiece = ChessboardPanel.getInstance().getCaseAt(posX, posY);
		ChessboardPanel.getInstance().getJPanel(casePiece).addImageIcon("assets/" + color + "/queen_" + color +".png");
		casePiece.setIsEmpty(false);
	}
	
	public Queen(String name, int posX, int posY, String color, String path) {
		this(name, posX, posY, color);
		this.pathToImage = path;	
	}

	@Override
	public List<Case> getPossibleCases(Case[][] gridCases) {
		List<Case> possibleCases = new ArrayList<Case>();
		possibleCases.addAll(Movable.straightMovement(gridCases, posX, posY));
		possibleCases.addAll(Movable.diagonalMovement(gridCases, posX, posY));
		return possibleCases;
	}

}
