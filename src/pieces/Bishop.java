package pieces;

import java.util.List;

import chessboard.ChessboardController;
import chessboard.Square;

public class Bishop extends Piece {

	public Bishop(String name, int posX, int posY, String color) {
		super(name, posX, posY, color);
	}

	@Override
	public List<Square> getPossibleSquares(ChessboardController chessboard) {
		return Movable.diagonalMovement(chessboard.getChessboardModel().getGridSquares(), posX, posY);
	}
	

}
