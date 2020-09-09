
import java.util.ArrayList;
import java.util.List;

public class WhitePawn extends Piece {
	
	public WhitePawn(String name, int posX, int posY, String color) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.color = color;	
		Case casePiece = ChessboardPanel.getInstance().getCaseAt(posX, posY);
		ChessboardPanel.getInstance().getJPanel(casePiece).addImageIcon("assets/white/pawn_white.png");
		casePiece.setIsEmpty(false);
	}
	
	public WhitePawn(String name, int posX, int posY, String color, String path) {
		this(name, posX, posY, color);
		this.pathToImage = path;	
	}

	@Override
	public List<Case> getPossibleCases(Case[][] gridCases) {
		List<Case> list = new ArrayList<Case>();
		switch (posY) {
		case 0 :
			break;
		
		// Starting position, pawn can move forward two cases.
		case 6 :
			for (int k = 1; k<3; k++) {
				if (gridCases[posX][posY - k].getIsEmpty() == true)
					list.add(gridCases[posX][posY - k]);
			}
			// Possible because there is piece in danger (only if it is opposing piece...it will be filtered by the method getAttackCases())
			if (posX>0 && gridCases[posX - 1][posY - 1].getIsEmpty() == false)
				list.add(gridCases[posX - 1][posY - 1]);
			if (posX<7 && gridCases[posX + 1][posY - 1].getIsEmpty() == false)
				list.add(gridCases[posX + 1][posY - 1]);
			break;
			
		default :
			if (gridCases[posX][posY - 1].getIsEmpty() == true)
				list.add(gridCases[posX][posY - 1]);
			// Possible because there is piece in danger (only if it is opposing piece...it will be filtered by the method getAttackCases())
			if (posX>0 && gridCases[posX - 1][posY - 1].getIsEmpty() == false)
				list.add(gridCases[posX - 1][posY - 1]);
			if (posX<7 && gridCases[posX + 1][posY - 1].getIsEmpty() == false)
				list.add(gridCases[posX + 1][posY - 1]);
			break;
		}
	
		return list;
	}


}
