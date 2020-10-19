package chessboard;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import pieces.Bishop;
import pieces.BlackPawn;
import pieces.King;
import pieces.Knight;
import pieces.Piece;
import pieces.Queen;
import pieces.Tower;
import pieces.WhitePawn;

public class Game {
	
	private List<Piece> listPieceOnChessboard = new ArrayList<Piece>();
	private List<Piece> listPieceInBlackCemetery = new ArrayList<Piece>();
	private List<Piece> listPieceInWhiteCemetery = new ArrayList<Piece>();
	
	//Black
	private Piece towerA8 = new Tower("tower", 0, 0, "black");
	private Piece towerH8 = new Tower("tower", 7, 0, "black");
	private Piece knightB8 = new Knight("cavalier", 1, 0, "black");
	private Piece knightG8 = new Knight("cavalier", 6, 0, "black");
	private Piece bishopC8 = new Bishop("bishop", 2, 0, "black");
	private Piece bishopF8 = new Bishop("bishop", 5, 0, "black");
	private Piece queenBlack = new Queen("queen", 3, 0, "black");
	private Piece kingBlack = new King("king", 4, 0, "black");
	private Piece pawnA7 = new BlackPawn("pawn", 0, 1, "black");
	private Piece pawnB7 = new BlackPawn("pawn", 1, 1, "black");
	private Piece pawnC7 = new BlackPawn("pawn", 2, 1, "black");
	private Piece pawnD7 = new BlackPawn("pawn", 3, 1, "black");
	private Piece pawnE7 = new BlackPawn("pawn", 4, 1, "black");
	private Piece pawnF7 = new BlackPawn("pawn", 5, 1, "black");
	private Piece pawnG7 = new BlackPawn("pawn", 6, 1, "black");
	private Piece pawnH7 = new BlackPawn("pawn", 7, 1, "black");
	
	//White
	private Piece towerA1 = new Tower("tower", 0, 7, "white");
	private Piece towerH1 = new Tower("tower", 7, 7, "white");
	private Piece knightB1 = new Knight("cavalier", 1, 7, "white");
	private Piece knightG1 = new Knight("cavalier", 6, 7, "white");
	private Piece bishopC1 = new Bishop("bishop", 2, 7, "white");
	private Piece bishopF1 = new Bishop("bishop", 5, 7, "white");
	private Piece queenWhite = new Queen("queen", 3, 7, "white");
	private Piece kingWhite = new King("king", 4, 7, "white");
	private Piece pawnA2 = new WhitePawn("pawn", 0, 6, "white");
	private Piece pawnB2 = new WhitePawn("pawn", 1, 6, "white");
	private Piece pawnC2 = new WhitePawn("pawn", 2, 6, "white");
	private Piece pawnD2 = new WhitePawn("pawn", 3, 6, "white");
	private Piece pawnE2 = new WhitePawn("pawn", 4, 6, "white");
	private Piece pawnF2 = new WhitePawn("pawn", 5, 6, "white");
	private Piece pawnG2 = new WhitePawn("pawn", 6, 6, "white");
	private Piece pawnH2 = new WhitePawn("pawn", 7, 6, "white");
	
	Piece bishop = new Bishop("bishop", 4, 4, "black");
	
	
	public Game() {
		listPieceOnChessboard.add(towerA8);
		listPieceOnChessboard.add(towerH8);
		listPieceOnChessboard.add(knightB8);
		listPieceOnChessboard.add(knightG8);
		listPieceOnChessboard.add(bishopC8);
		listPieceOnChessboard.add(bishopF8);
		listPieceOnChessboard.add(queenBlack);
		listPieceOnChessboard.add(kingBlack);
		listPieceOnChessboard.add(pawnA7);
		listPieceOnChessboard.add(pawnB7);
		listPieceOnChessboard.add(pawnC7);
		listPieceOnChessboard.add(pawnD7);
		listPieceOnChessboard.add(pawnE7);
		listPieceOnChessboard.add(pawnF7);
		listPieceOnChessboard.add(pawnG7);
		listPieceOnChessboard.add(pawnH7);
		listPieceOnChessboard.add(towerA1);
		listPieceOnChessboard.add(towerH1);
		listPieceOnChessboard.add(knightB1);
		listPieceOnChessboard.add(knightG1);
		listPieceOnChessboard.add(bishopC1);
		listPieceOnChessboard.add(bishopF1);
		listPieceOnChessboard.add(queenWhite);
		listPieceOnChessboard.add(kingWhite);
		listPieceOnChessboard.add(pawnA2);
		listPieceOnChessboard.add(pawnB2);
		listPieceOnChessboard.add(pawnC2);
		listPieceOnChessboard.add(pawnD2);
		listPieceOnChessboard.add(pawnE2);
		listPieceOnChessboard.add(pawnF2);
		listPieceOnChessboard.add(pawnG2);
		listPieceOnChessboard.add(pawnH2);
		
		listPieceOnChessboard.add(bishop);
		
	}
	
	
	
	public void giveIndice() {
		for (Square case1 : bishop.getAllowedCases(bishop.getPossibleCases(ChessboardPanel.getInstance().getGridCases()))) {
			ChessboardPanel.getInstance().getJPanel(case1).setBackground(Color.GREEN);
		}
		for (Square case1 : bishop.getAttackCases(bishop.getPossibleCases(ChessboardPanel.getInstance().getGridCases()), this)) {
			ChessboardPanel.getInstance().getJPanel(case1).setBackground(Color.CYAN);
		}
	}
	
	public Piece getPieceAt(int posX, int posY) {
		Square case1 = ChessboardPanel.getInstance().getGridCases()[posX][posY];
		Piece piece = null;
		if (!case1.getIsEmpty()) {
			for (Piece piece1 : listPieceOnChessboard) {
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
