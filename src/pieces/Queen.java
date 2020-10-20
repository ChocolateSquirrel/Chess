package pieces;

import java.util.ArrayList;
import java.util.List;

import chessboard.ChessboardController;
import chessboard.Square;

public class Queen extends Piece {
	
	public Queen(String name, int posX, int posY, String color) {
		super(name, posX, posY, color);
	}

	@Override
	public List<Square> getPossibleSquares(ChessboardController chessboard) {
		List<Square> possibleCases = new ArrayList<Square>();
		Square[][] gridCases = chessboard.getChessboardModel().getGridSquares();
		possibleCases.addAll(Movable.straightMovement(gridCases, posX, posY));
		possibleCases.addAll(Movable.diagonalMovement(gridCases, posX, posY));
		return possibleCases;
	}

}
