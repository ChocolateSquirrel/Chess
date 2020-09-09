import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Game {
	List<Piece> listPiece = new ArrayList<Piece>();
	Piece tower = new Tower("tower", 2, 4, "black");
	Piece pawn1 = new WhitePawn("pawn", 5, 6, "white");
	Piece pawn2 = new WhitePawn("pawn", 6, 4, "white");
	Piece pawn3 = new BlackPawn("pawn", 2, 1, "black");
	Piece knight = new Knight("cavalier", 3, 2, "white");
	Piece bishop = new Bishop("bishop", 3, 5, "white");
	Piece queen = new Queen("queen", 3, 4, "white");
	Piece king = new King("king", 3, 1, "black");
	
	public Game() {
		listPiece.add(tower);
		listPiece.add(pawn1);
		listPiece.add(pawn2);
		listPiece.add(pawn3);
		listPiece.add(knight);
		listPiece.add(bishop);
		listPiece.add(queen);
		listPiece.add(king);
	}
	
	public void giveIndice() {
		for (Case case1 : pawn3.getAllowedCases(pawn3.getPossibleCases(ChessboardPanel.getInstance().getGridCases()))) {
			ChessboardPanel.getInstance().getJPanel(case1).setBackground(Color.GREEN);
		}
		for (Case case1 : pawn3.getAttackCases(pawn3.getPossibleCases(ChessboardPanel.getInstance().getGridCases()), this)) {
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
