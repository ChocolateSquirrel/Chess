package pieces;

import java.util.ArrayList;
import java.util.List;

import chessboard.ChessboardController;
import chessboard.Square;

public class BlackPawn extends Piece {

	public BlackPawn(String name, int posX, int posY, String color) {
		super(name, posX, posY, color);
	}

	@Override
	public List<Square> getPossibleSquares(ChessboardController chessboard) {
		List<Square> list = new ArrayList<Square>();
		Square[][] gridCases = chessboard.getChessboardModel().getGridSquares();
		switch (posY) {
		// Finishing position.
		case 7 :
			break;
		
		// Starting position, pawn can move forward two cases.
		case 1 :
			for (int k = 1; k<3; k++) {
				if (gridCases[posX][posY + k].getIsEmpty() == true)
					list.add(gridCases[posX][posY + k]);
			}
			// Possible because there is piece in danger (only if it is opposing piece...it will be filtered by the method getAttackCases())
			if (posX>0 && gridCases[posX - 1][posY + 1].getIsEmpty() == false)
				list.add(gridCases[posX - 1][posY + 1]);
			if (posX<7 && gridCases[posX + 1][posY + 1].getIsEmpty() == false)
				list.add(gridCases[posX + 1][posY + 1]);
			break;
			
		default :
			if (gridCases[posX][posY + 1].getIsEmpty() == true)
				list.add(gridCases[posX][posY + 1]);
			// Possible because there is piece in danger (only if it is opposing piece...it will be filtered by the method getAttackCases())
			if (posX>0 && gridCases[posX - 1][posY + 1].getIsEmpty() == false)
				list.add(gridCases[posX - 1][posY + 1]);
			if (posX<7 && gridCases[posX + 1][posY + 1].getIsEmpty() == false)
				list.add(gridCases[posX + 1][posY + 1]);
			break;
		}
	
		return list;
	}
	

}
