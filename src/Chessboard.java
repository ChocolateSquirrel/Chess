
public class Chessboard {
	private Case[][] gridCases;
	
	public Chessboard() {
		gridCases = new Case[8][8];
		for (int i = 1; i<9; i++) {
			for (int j = 1; j<9; j++) {
				if ( (i+j)%2 == 0 ) {
					gridCases[i][j] = new Case("white", i, j);
				} else {
					gridCases[i][j] = new Case("black", i, j);
				}
			}
		}
	}

}
