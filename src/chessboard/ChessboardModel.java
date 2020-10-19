package chessboard;

public class ChessboardModel {
	/**
	 * Store Squares composing only chessboard area. For example, gridCases[0][0] stores the white case "a8".
	 */
	private static Square[][] gridSquares = new Square[8][8];
	
	public ChessboardModel() {
		createGridSquares();
	}
	
	public Square[][] getGridSquares() {
		return gridSquares;
	}
	
	public Square getSquareAt(int posX, int posY) {
		return gridSquares[posX][posY];
	}
	
	/**
	 * Store the color and the position of each squares in a Square object.
	 * For example, gridSquares[0][0] is for the the white square "a8".
	 * gridSquares[0][7] is for the the black square "a1".
	 */
	private void createGridSquares() {
		for (int i = 0; i<8; i++) {
			for (int j = 0; j<8; j++) {
				if ( (i+j)%2 == 0 ) {
					gridSquares[i][j] = new Square("white", i, j);
				} else {
					gridSquares[i][j] = new Square("black", i, j);
				}
			}
		}
	}
}
