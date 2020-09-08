import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		List<Case> possibleCases = new ArrayList<Case>();
		// Horizontal possible cases
		for (int k = 1; k<posX+1; k++) {
			if (gridCases[posX - k][posY].getIsEmpty()) 
				possibleCases.add(gridCases[posX - k][posY]);
			// Possible because of piece in danger (only if it is opposing piece...à faire)
			else {
				possibleCases.add(gridCases[posX - k][posY]);
				break;
			}
		}
		for (int k = posX+1; k<8; k++) {
			if (gridCases[k][posY].getIsEmpty()) 
				possibleCases.add(gridCases[k][posY]);
			// Possible because of piece in danger
			else {
				possibleCases.add(gridCases[k][posY]);
				break;
			}
		}
		// Vertical possible cases
		for (int k = 1; k<posY+1; k++) {
			if (gridCases[posX][posY - k].getIsEmpty()) 
				possibleCases.add(gridCases[posX][posY - k]);
			// Possible because of piece in danger
			else {
				possibleCases.add(gridCases[posX][posY - k]);
				break;
			}
		}
		for (int k = posY+1; k<8; k++) {
			if (gridCases[posX][k].getIsEmpty()) 
				possibleCases.add(gridCases[posX][k]);
			// Possible because of piece in danger
			else {
				possibleCases.add(gridCases[posX][k]);
				break;
			}
		}
		return possibleCases;
	}

	

}
