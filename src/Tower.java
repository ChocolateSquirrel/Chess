import java.util.ArrayList;
import java.util.List;

public class Tower extends Piece {
	
	public Tower(String name, int posX, int posY, String color) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.color = color;	
	}
	
	public Tower(String name, int posX, int posY, String color, String path) {
		this(name, posX, posY, color);
		this.pathToImage = path;	
	}

	@Override
	public List<Case> getAllowedCases(Case[][] gridCases) {
		List<Case> list = new ArrayList<Case>();
		// Horizontal allowed cases
		for (int k = 1; k<posX+1; k++) {
			if (gridCases[posX - k][posY].getIsEmpty()) 
				list.add(gridCases[posX - k][posY]);
			// Allowed because of piece in danger (only if it is opposing piece...à faire)
			else {
				list.add(gridCases[posX - k][posY]);
				break;
			}
		}
		for (int k = posX+1; k<8; k++) {
			if (gridCases[k][posY].getIsEmpty()) 
				list.add(gridCases[k][posY]);
			// Allowed because of piece in danger
			else {
				list.add(gridCases[k][posY]);
				break;
			}
		}
		// Vertical allowed cases
		for (int k = 1; k<posY+1; k++) {
			if (gridCases[posX][posY - k].getIsEmpty()) 
				list.add(gridCases[posX][posY - k]);
			// Allowed because of piece in danger
			else {
				list.add(gridCases[posX][posY - k]);
				break;
			}
		}
		for (int k = posY+1; k<8; k++) {
			if (gridCases[posX][k].getIsEmpty()) 
				list.add(gridCases[posX][k]);
			// Allowed because of piece in danger
			else {
				list.add(gridCases[posX][k]);
				break;
			}
		}
		return list;
	}

}
