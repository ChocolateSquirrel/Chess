import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Game {
	List<Piece> listPiece = new ArrayList<Piece>();
	//Black
	Piece towerA8 = new Tower("tower", 0, 0, "black");
	Piece towerH8 = new Tower("tower", 7, 0, "black");
	Piece knightB8 = new Knight("cavalier", 1, 0, "black");
	Piece knightG8 = new Knight("cavalier", 6, 0, "black");
	Piece bishopC8 = new Bishop("bishop", 2, 0, "black");
	Piece bishopF8 = new Bishop("bishop", 5, 0, "black");
	Piece queenBlack = new Queen("queen", 3, 0, "black");
	Piece kingBlack = new King("king", 4, 0, "black");
	Piece pawnA7 = new BlackPawn("pawn", 0, 1, "black");
	Piece pawnB7 = new BlackPawn("pawn", 1, 1, "black");
	Piece pawnC7 = new BlackPawn("pawn", 2, 1, "black");
	Piece pawnD7 = new BlackPawn("pawn", 3, 1, "black");
	Piece pawnE7 = new BlackPawn("pawn", 4, 1, "black");
	Piece pawnF7 = new BlackPawn("pawn", 5, 1, "black");
	Piece pawnG7 = new BlackPawn("pawn", 6, 1, "black");
	Piece pawnH7 = new BlackPawn("pawn", 7, 1, "black");
	
	//White
	Piece towerA1 = new Tower("tower", 0, 7, "white");
	Piece towerH1 = new Tower("tower", 7, 7, "white");
	Piece knightB1 = new Knight("cavalier", 1, 7, "white");
	Piece knightG1 = new Knight("cavalier", 6, 7, "white");
	Piece bishopC1 = new Bishop("bishop", 2, 7, "white");
	Piece bishopF1 = new Bishop("bishop", 5, 7, "white");
	Piece queenWhite = new Queen("queen", 3, 7, "white");
	Piece kingWhite = new King("king", 4, 7, "white");
	Piece pawnA2 = new WhitePawn("pawn", 0, 6, "white");
	Piece pawnB2 = new WhitePawn("pawn", 1, 6, "white");
	Piece pawnC2 = new WhitePawn("pawn", 2, 6, "white");
	Piece pawnD2 = new WhitePawn("pawn", 3, 6, "white");
	Piece pawnE2 = new WhitePawn("pawn", 4, 6, "white");
	Piece pawnF2 = new WhitePawn("pawn", 5, 6, "white");
	Piece pawnG2 = new WhitePawn("pawn", 6, 6, "white");
	Piece pawnH2 = new WhitePawn("pawn", 7, 6, "white");
	
	Piece bishop = new Bishop("bishop", 4, 5, "black");
	
	
	public Game() {
		listPiece.add(towerA8);
		listPiece.add(towerH8);
		listPiece.add(knightB8);
		listPiece.add(knightG8);
		listPiece.add(bishopC8);
		listPiece.add(bishopF8);
		listPiece.add(queenBlack);
		listPiece.add(kingBlack);
		listPiece.add(pawnA7);
		listPiece.add(pawnB7);
		listPiece.add(pawnC7);
		listPiece.add(pawnD7);
		listPiece.add(pawnE7);
		listPiece.add(pawnF7);
		listPiece.add(pawnG7);
		listPiece.add(pawnH7);
		listPiece.add(towerA1);
		listPiece.add(towerH1);
		listPiece.add(knightB1);
		listPiece.add(knightG1);
		listPiece.add(bishopC1);
		listPiece.add(bishopF1);
		listPiece.add(queenWhite);
		listPiece.add(pawnA2);
		listPiece.add(pawnB2);
		listPiece.add(pawnC2);
		listPiece.add(pawnD2);
		listPiece.add(pawnE2);
		listPiece.add(pawnF2);
		listPiece.add(pawnG2);
		listPiece.add(pawnH2);
		
		listPiece.add(bishop);
		
	}
	
	
	
	public void giveIndice() {
		for (Case case1 : bishop.getAllowedCases(bishop.getPossibleCases(ChessboardPanel.getInstance().getGridCases()))) {
			ChessboardPanel.getInstance().getJPanel(case1).setBackground(Color.GREEN);
		}
		for (Case case1 : bishop.getAttackCases(bishop.getPossibleCases(ChessboardPanel.getInstance().getGridCases()), this)) {
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
