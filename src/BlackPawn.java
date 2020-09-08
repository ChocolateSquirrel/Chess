import java.util.ArrayList;
import java.util.List;

public class BlackPawn extends Piece {
	
	public BlackPawn(String name, int posX, int posY, String color) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.color = color;
		Case casePiece = ChessboardPanel.getInstance().getCaseAt(posX, posY);
		ChessboardPanel.getInstance().getJPanel(casePiece).addImageIcon("assets/" + color + "/pawn_" + color +".png");
		casePiece.setIsEmpty(false);
	}
	
	public BlackPawn(String name, int posX, int posY, String color, String path) {
		this(name, posX, posY, color);
		this.pathToImage = path;	
	}

	@Override
	public List<Case> getPossibleCases(Case[][] gridCases) {
		List<Case> list = new ArrayList<Case>();
		switch (posY) {
		case 7 :
			break;
		case 6 :
			if (gridCases[posX][posY + 1].getIsEmpty() == true)
				list.add(gridCases[posX][posY - 1]);
			// Allowed because of opposing piece in danger (only if it is opposing piece...� faire)
			if (posX>0 && gridCases[posX - 1][posY + 1].getIsEmpty() == false)
				list.add(gridCases[posX - 1][posY + 1]);
			if (posX<7 && gridCases[posX + 1][posY + 1].getIsEmpty() == false)
				list.add(gridCases[posX + 1][posY + 1]);
			break;
		default :
			for (int k = 1; k<3; k++) {
				if (gridCases[posX][posY + k].getIsEmpty() == true)
					list.add(gridCases[posX][posY + k]);
			}
			// Allowed because of opposing piece in danger (only if it is opposing piece...� faire)
			if (gridCases[posX - 1][posY + 1].getIsEmpty() == false && posX>0)
				list.add(gridCases[posX - 1][posY + 1]);
			if (gridCases[posX + 1][posY + 1].getIsEmpty() == false && posX<7)
				list.add(gridCases[posX + 1][posY + 1]);
			break;
		}
	
		return list;
	}


	@Override
	public List<Case> getAllowedCases(List<Case> possibleCases) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Case> getAttackCases(List<Case> possibleCases, Game game) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
