package pieces;

import java.util.ArrayList;
import java.util.List;

import chessboard.ChessboardController;
import chessboard.Square;

public class King extends Piece {

	public King(String name, int posX, int posY, String color) {
		super(name, posX, posY, color);
	}

	@Override
	public List<Square> getPossibleSquares(ChessboardController chessboard) {
		List<Square> possibleCases = new ArrayList<Square>();
		Square[][] gridCases = chessboard.getChessboardModel().getGridSquares();
		if (posY != 0) {
			possibleCases.add(gridCases[posX][posY - 1]);
			if(posX != 7)
				possibleCases.add(gridCases[posX + 1][posY - 1]);
			if (posX != 0)
				possibleCases.add(gridCases[posX - 1][posY - 1]);
		}
			
		if (posX != 7)
			possibleCases.add(gridCases[posX + 1][posY]);
		
		if (posY != 7) {
			possibleCases.add(gridCases[posX][posY + 1]);
			if(posX != 7)
				possibleCases.add(gridCases[posX + 1][posY + 1]);
			if (posX != 0)
				possibleCases.add(gridCases[posX - 1][posY + 1]);
		}
			
		if (posX != 0)
			possibleCases.add(gridCases[posX - 1][posY]);
		
		return possibleCases;
	}

}
