package pieces;

import java.util.ArrayList;
import java.util.List;

import chessboard.Square;

public class Knight extends Piece {
	
	public Knight(String name, int posX, int posY, String color) {
		super(name, posX, posY, color);
	}

	@Override
	public List<Square> getPossibleSquares(Square[][] gridCases) {
		List<Square> list = new ArrayList<Square>();
		// Movement which beginning on the right
		if (posX + 2 < 8) {
			if (posY-1>=0) 
				list.add(gridCases[posX + 2][posY - 1]);
			if (posY+1<8) 
				list.add(gridCases[posX + 2][posY + 1]);	
		}
		
		// Movement which beginning on the left
		if (posX - 2 >= 0) {
			if (posY-1>=0) 
				list.add(gridCases[posX - 2][posY - 1]);
			if (posY+1<8) 
				list.add(gridCases[posX - 2][posY + 1]);	
		}
		
		// Movement which beginning at up
		if (posY - 2 >=0) {
			if (posX-1>=0) 
				list.add(gridCases[posX - 1][posY - 2]);
			if (posX+1<8) 
				list.add(gridCases[posX + 1][posY - 2]);	
		}
		
		// Movement which beginning at bottom
		if (posY + 2 < 8) {
			if (posX-1>=0) 
				list.add(gridCases[posX - 1][posY + 2]);
			if (posX+1<8) 
				list.add(gridCases[posX + 1][posY + 2]);	
		}
		
		return list;
	}

}
