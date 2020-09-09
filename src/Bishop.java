import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
	public Bishop(String name, int posX, int posY, String color) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.color = color;	
		Case casePiece = ChessboardPanel.getInstance().getCaseAt(posX, posY);
		ChessboardPanel.getInstance().getJPanel(casePiece).addImageIcon("assets/" + color + "/bishop_" + color +".png");
		casePiece.setIsEmpty(false);
	}
	
	public Bishop(String name, int posX, int posY, String color, String path) {
		this(name, posX, posY, color);
		this.pathToImage = path;	
	}

	@Override
	public List<Case> getPossibleCases(Case[][] gridCases) {
		List<Case> possibleCases = new ArrayList<Case>();
		int posMin = Math.min(posX,  posY);
		int posMax = Math.max(posX, posY);
		
		if (posX<posY) {
			
		}
		
		// Descendant diagonal
		
		for (int k = 1; k<posMin+1; k++) {
			if (gridCases[posX - k][posY - k].getIsEmpty())
				possibleCases.add(gridCases[posX - k][posY - k]);
			// Because there is a piece on the case.
			else {
				possibleCases.add(gridCases[posX - k][posY - k]);
				break;
			}
		}
		
//		for (int k = 1; k<8-posMax; k++) {
//			if (gridCases[posX + k][posY + k].getIsEmpty())
//				possibleCases.add(gridCases[posX + k][posY + k]);
//			// Because there is a piece on the case.
//			else {
//				possibleCases.add(gridCases[posX + k][posY + k]);
//				break;
//			}
//		}
//	
//		// Ascendant diagonal
//		for (int k = 1; k<8-posMax; k++) {
//			if (gridCases[posX - k][posY +k].getIsEmpty())
//				possibleCases.add(gridCases[posX - k][posY + k]);
//			// Because there is a piece on the case.
//			else {
//				possibleCases.add(gridCases[posX - k][posY + k]);
//				break;
//			}
//		}
//		for (int k = 1; k<8-posMin; k++) {
//			if (gridCases[posX + k][posY - k].getIsEmpty())
//				possibleCases.add(gridCases[posX + k][posY - k]);
//			// Because there is a piece on the case.
//			else {
//				possibleCases.add(gridCases[posX + k][posY - k]);
//				break;
//			}
//		}
		
		return possibleCases;
	}
	

}
