package pieces;

import java.util.List;

import chessboard.Square;

public class Tower extends Piece {
	
	public Tower(String name, int posX, int posY, String color) {
		super(name, posX, posY, color);
	}

	@Override
	public List<Square> getPossibleSquares(Square[][] gridCases) {
		return Movable.straightMovement(gridCases, posX, posY);
	}
}
