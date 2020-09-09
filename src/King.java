import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
	
	public King(String name, int posX, int posY, String color) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.color = color;	
		Case casePiece = ChessboardPanel.getInstance().getCaseAt(posX, posY);
		ChessboardPanel.getInstance().getJPanel(casePiece).addImageIcon("assets/" + color + "/king_" + color +".png");
		casePiece.setIsEmpty(false);
	}
	
	public King(String name, int posX, int posY, String color, String path) {
		this(name, posX, posY, color);
		this.pathToImage = path;	
	}

	@Override
	public List<Case> getPossibleCases(Case[][] gridCases) {
		List<Case> possibleCases = new ArrayList<Case>();
		if (posY != 0) {
			possibleCases.add(gridCases[posX][posY - 1]);
			if(posX != 7)
				possibleCases.add(gridCases[posX + 1][posY - 1]);
			if (posX != 0)
				possibleCases.add(gridCases[posX - 1][posY - 1]);
		}
			
		if (posX != 7)
			possibleCases.add(gridCases[posX + 1][posY]);
		
		if (posY != 7) {
			possibleCases.add(gridCases[posX][posY + 1]);
			if(posX != 7)
				possibleCases.add(gridCases[posX + 1][posY + 1]);
			if (posX != 0)
				possibleCases.add(gridCases[posX - 1][posY + 1]);
		}
			
		if (posX != 0)
			possibleCases.add(gridCases[posX - 1][posY]);
		
		return possibleCases;
	}

}
