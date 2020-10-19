package pieces;

import java.util.List;

import chessboard.Square;

public class Bishop extends Piece {

	public Bishop(String name, int posX, int posY, String color) {
		super(name, posX, posY, color);
	}

	@Override
	public List<Square> getPossibleSquares(Square[][] gridCases) {
		return Movable.diagonalMovement(gridCases, posX, posY);
	}
	

}
