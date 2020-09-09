
import java.util.ArrayList;
import java.util.List;

public interface Movable {
	
	/**
	 * Store cases where the piece can move even if there is a piece (black or white) on this case.
	 * @param gridCases
	 * @return
	 */
	public List<Case> getPossibleCases(Case[][] gridCases);
	
	/**
	 * Store cases where the piece can both move and eat opponent piece. 
	 * @param possibleCases : list of cases where the piece can go even if there is an other piece.
	 * @param game
	 * @return
	 */
	public List<Case> getAttackCases(List<Case> possibleCases, Game game);
	
	
	/**
	 * Store free cases where the piece can move.
	 * @param possibleCases
	 * @return
	 */
	public List<Case> getAllowedCases(List<Case> possibleCases);
	
	
	/**
	 * Store cases where a piece can move horizontally and vertically even if there is a piece (black or white) on this case.
	 * @param gridCases : array of cases composing the chessboard.
	 * @param posX : vertical position of the piece.
	 * @param posY : horizontal position of the piece.
	 * @return
	 */
	public static List<Case> straightMovement(Case[][] gridCases, int posX, int posY){
		List<Case> possibleCases = new ArrayList<Case>();
		// Horizontal possible cases
		for (int k = 1; k<posX+1; k++) {
			if (gridCases[posX - k][posY].getIsEmpty()) 
				possibleCases.add(gridCases[posX - k][posY]);
			// Possible because there is piece in danger (only if it is opposing piece...it will be filtered by the method getAttackCases())
			else {
				possibleCases.add(gridCases[posX - k][posY]);
				break;
			}
		}
		for (int k = posX+1; k<8; k++) {
			if (gridCases[k][posY].getIsEmpty()) 
				possibleCases.add(gridCases[k][posY]);
			// Possible because there is piece in danger (only if it is opposing piece...it will be filtered by the method getAttackCases())
			else {
				possibleCases.add(gridCases[k][posY]);
				break;
			}
		}
		// Vertical possible cases
		for (int k = 1; k<posY+1; k++) {
			if (gridCases[posX][posY - k].getIsEmpty()) 
				possibleCases.add(gridCases[posX][posY - k]);
			// Possible because there is piece in danger (only if it is opposing piece...it will be filtered by the method getAttackCases())
			else {
				possibleCases.add(gridCases[posX][posY - k]);
				break;
			}
		}
		for (int k = posY+1; k<8; k++) {
			if (gridCases[posX][k].getIsEmpty()) 
				possibleCases.add(gridCases[posX][k]);
			// Possible because there is piece in danger (only if it is opposing piece...it will be filtered by the method getAttackCases())
			else {
				possibleCases.add(gridCases[posX][k]);
				break;
			}
		}
		return possibleCases;
	}
	
	
	/**
	 * Store cases where a piece can move diagonally even if there is a piece (black or white) on this case.
	 * @param gridCases : array of cases composing the chessboard.
	 * @param posX : vertical position of the piece.
	 * @param posY : horizontal position of the piece.
	 * @return
	 */
	public static List<Case> diagonalMovement(Case[][] gridCases, int posX, int posY){
		List<Case> possibleCases = new ArrayList<Case>();
		
		// Descendant diagonal
		int posMin = Math.min(posX,  posY);
		int posMax = Math.max(posX, posY);
		if (posX != 0) {
			for (int k = 1; k<posMin+1; k++) {
				if (gridCases[posX - k][posY - k].getIsEmpty())
					possibleCases.add(gridCases[posX - k][posY - k]);
				// Possible because there is piece in danger (only if it is opposing piece...it will be filtered by the method getAttackCases())
				else {
					possibleCases.add(gridCases[posX - k][posY - k]);
					break;
				}
			}
		}
		if (posX != 7) {
			for (int k = 1; k<8-posMax; k++) {
				if (gridCases[posX + k][posY + k].getIsEmpty())
					possibleCases.add(gridCases[posX + k][posY + k]);
				// Possible because there is piece in danger (only if it is opposing piece...it will be filtered by the method getAttackCases())
				else {
					possibleCases.add(gridCases[posX + k][posY + k]);
					break;
				}
			}
		}
		
		//Ascendant diagonal
		posMin = Math.min(posX+1,  8-posY);
		posMax = Math.min(8-posX, posY+1);
		if (posX != 0) {
			for (int k = 1; k<posMin; k++) {
				if (gridCases[posX - k][posY + k].getIsEmpty())
					possibleCases.add(gridCases[posX - k][posY + k]);
				// Possible because there is piece in danger (only if it is opposing piece...it will be filtered by the method getAttackCases())
				else {
					possibleCases.add(gridCases[posX - k][posY + k]);
					break;
				}
			}
		}
		if (posX != 7) {
			for (int k = 1; k<posMax; k++) {
				if (gridCases[posX + k][posY - k].getIsEmpty())
					possibleCases.add(gridCases[posX + k][posY - k]);
				// Possible because there is piece in danger (only if it is opposing piece...it will be filtered by the method getAttackCases())
				else {
					possibleCases.add(gridCases[posX + k][posY - k]);
					break;
				}
			}
		}
		return possibleCases;
	}


}
