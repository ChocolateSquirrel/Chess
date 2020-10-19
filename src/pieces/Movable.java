package pieces;

import java.util.ArrayList;
import java.util.List;

import chessboard.Game;
import chessboard.Square;

public interface Movable {
	
	/**
	 * Store squares where the piece can move even if there is a piece (black or white) on this square.
	 * @param gridSquares
	 * @return
	 */
	public List<Square> getPossibleSquares(Square[][] gridSquares);
	
	
	/**
	 * Store squares where the piece can both move and eat opponent piece. 
	 * @param possibleSquares : list of squares where the piece can go even if there is an other piece.
	 * @param game
	 * @return
	 */
	public List<Square> getAttackSquares(List<Square> possibleSquares, Game game);
	
	
	/**
	 * Store free squares where the piece can move.
	 * @param possibleSquares
	 * @return
	 */
	public List<Square> getAllowedSquares(List<Square> possibleSquares);
	
	
	/**
	 * Store squares where a piece can move horizontally and vertically even if there is a piece (black or white) on this square.
	 * @param gridSquares : array of squares composing the chessboard.
	 * @param posX : vertical position of the piece.
	 * @param posY : horizontal position of the piece.
	 * @return
	 */
	public static List<Square> straightMovement(Square[][] gridSquares, int posX, int posY){
		List<Square> possibleSquares = new ArrayList<Square>();
		// Horizontal possible cases
		for (int k = 1; k<posX+1; k++) {
			if (gridSquares[posX - k][posY].getIsEmpty()) 
				possibleSquares.add(gridSquares[posX - k][posY]);
			// Possible because there is piece in danger (only if it is opponent piece...it will be filtered by the method getAttackCases())
			else {
				possibleSquares.add(gridSquares[posX - k][posY]);
				break;
			}
		}
		for (int k = posX+1; k<8; k++) {
			if (gridSquares[k][posY].getIsEmpty()) 
				possibleSquares.add(gridSquares[k][posY]);
			// Possible because there is piece in danger (only if it is opponent piece...it will be filtered by the method getAttackCases())
			else {
				possibleSquares.add(gridSquares[k][posY]);
				break;
			}
		}
		// Vertical possible cases
		for (int k = 1; k<posY+1; k++) {
			if (gridSquares[posX][posY - k].getIsEmpty()) 
				possibleSquares.add(gridSquares[posX][posY - k]);
			// Possible because there is piece in danger (only if it is opponent piece...it will be filtered by the method getAttackCases())
			else {
				possibleSquares.add(gridSquares[posX][posY - k]);
				break;
			}
		}
		for (int k = posY+1; k<8; k++) {
			if (gridSquares[posX][k].getIsEmpty()) 
				possibleSquares.add(gridSquares[posX][k]);
			// Possible because there is piece in danger (only if it is opponent piece...it will be filtered by the method getAttackCases())
			else {
				possibleSquares.add(gridSquares[posX][k]);
				break;
			}
		}
		return possibleSquares;
	}
	
	
	/**
	 * Store squares where a piece can move diagonally even if there is a piece (black or white) on this square.
	 * @param gridSquares : array of squares composing the chessboard.
	 * @param posX : vertical position of the piece.
	 * @param posY : horizontal position of the piece.
	 * @return
	 */
	public static List<Square> diagonalMovement(Square[][] gridSquares, int posX, int posY){
		List<Square> possibleSquares = new ArrayList<Square>();
		
		// Descendant diagonal
		int posMin = Math.min(posX,  posY);
		int posMax = Math.max(posX, posY);
		if (posX != 0) {
			for (int k = 1; k<posMin+1; k++) {
				if (gridSquares[posX - k][posY - k].getIsEmpty())
					possibleSquares.add(gridSquares[posX - k][posY - k]);
				// Possible because there is piece in danger (only if it is opponent piece...it will be filtered by the method getAttackCases())
				else {
					possibleSquares.add(gridSquares[posX - k][posY - k]);
					break;
				}
			}
		}
		if (posX != 7) {
			for (int k = 1; k<8-posMax; k++) {
				if (gridSquares[posX + k][posY + k].getIsEmpty())
					possibleSquares.add(gridSquares[posX + k][posY + k]);
				// Possible because there is piece in danger (only if it is opponent piece...it will be filtered by the method getAttackCases())
				else {
					possibleSquares.add(gridSquares[posX + k][posY + k]);
					break;
				}
			}
		}
		
		//Ascendant diagonal
		posMin = Math.min(posX+1,  8-posY);
		posMax = Math.min(8-posX, posY+1);
		if (posX != 0) {
			for (int k = 1; k<posMin; k++) {
				if (gridSquares[posX - k][posY + k].getIsEmpty())
					possibleSquares.add(gridSquares[posX - k][posY + k]);
				// Possible because there is piece in danger (only if it is opponent piece...it will be filtered by the method getAttackCases())
				else {
					possibleSquares.add(gridSquares[posX - k][posY + k]);
					break;
				}
			}
		}
		if (posX != 7) {
			for (int k = 1; k<posMax; k++) {
				if (gridSquares[posX + k][posY - k].getIsEmpty())
					possibleSquares.add(gridSquares[posX + k][posY - k]);
				// Possible because there is piece in danger (only if it is opponent piece...it will be filtered by the method getAttackCases())
				else {
					possibleSquares.add(gridSquares[posX + k][posY - k]);
					break;
				}
			}
		}
		return possibleSquares;
	}


}
