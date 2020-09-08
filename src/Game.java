import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Game {
	List<Piece> listPiece = new ArrayList<Piece>();
	Piece tower = new Tower("tower", 2, 4, "black");
	Piece pawn1 = new WhitePawn("pawn", 4, 4, "white");
	Piece pawn2 = new WhitePawn("pawn", 6, 4, "white");
	Piece pawn3 = new WhitePawn("pawn", 2, 1, "white");
	Piece knight = new Knight("cavalier", 3, 2, "white");
	
	public Game() {
		listPiece.add(tower);
		listPiece.add(pawn1);
		listPiece.add(pawn2);
		listPiece.add(pawn3);
		listPiece.add(knight);
	}
	
	public void giveIndice() {
		for (Case case1 : knight.getAllowedCases(knight.getPossibleCases(ChessboardPanel.getInstance().getGridCases()))) {
			ChessboardPanel.getInstance().getJPanel(case1).setBackground(Color.GREEN);
		}
		for (Case case1 : knight.getAttackCases(knight.getPossibleCases(ChessboardPanel.getInstance().getGridCases()), this)) {
			ChessboardPanel.getInstance().getJPanel(case1).setBackground(Color.CYAN);
		}
	}
	
	public Piece getPieceAt(int posX, int posY) {
		Case case1 = ChessboardPanel.getInstance().getGridCases()[posX][posY];
		Piece piece = null;
		if (!case1.getIsEmpty()) {
			for (Piece piece1 : listPiece) {
				if(piece1.getPosX()==posX && piece1.getPosY()==posY)
					piece = piece1;
			}
		}
		else {
			System.out.println("No piece at " + posX + " : " + posY);
		}
		return piece;
	}
}
