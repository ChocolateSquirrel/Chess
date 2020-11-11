package chessboard;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import pieces.Piece;

public class ChessboardController {
	private ChessboardView chessboardView;
	private ChessboardModel chessboardModel;
	private List<Piece> piecesOnChessboard = new ArrayList<Piece>();
	
	public ChessboardController(ChessboardView view, ChessboardModel model) {
		chessboardView = view;
		chessboardModel = model;
	}
	
	public ChessboardView getChessboardView() {
		return chessboardView;
	}
	
	public ChessboardModel getChessboardModel() {
		return chessboardModel;
	}
	
	public List<Piece> getPiecesOnChessboard(){
		return piecesOnChessboard;
	}
	
	public void add(Piece piece) {
		Square pieceSquare = chessboardModel.getSquareAt(piece.getPosX(), piece.getPosY());
		if (pieceSquare.getIsEmpty()) {
			piecesOnChessboard.add(piece);
			chessboardView.getJPanel(pieceSquare).addImageIcon("assets/" + piece.getColor() + "/" + piece.getName() + "_" + piece.getColor() + ".png");
			pieceSquare.setIsEmpty(false);
		}
	}
	
	public void remove(Piece piece) {
		Square pieceSquare = chessboardModel.getSquareAt(piece.getPosX(), piece.getPosY());
		piecesOnChessboard.remove(piece);
		chessboardView.getJPanel(pieceSquare).removeImageIcon();
		pieceSquare.setIsEmpty(true);
	}
	
	/**
	 * Display with different colors the squares where the piece can move (green for free squares and cyan for squares in which the piece can eat an other piece)
	 * @param piece 
	 */
	public void giveAClue(Piece piece) {
		for (Square square : piece.getAllowedSquares(this)) {
			chessboardView.getJPanel(square).setBackground(Color.GREEN);
		}
		for (Square square : piece.getAttackSquares(this)) {
			chessboardView.getJPanel(square).setBackground(Color.CYAN);
		}
	}
	
	public void removeClues() {
		 chessboardView.paintChessboard();
	}
	
	public Piece getPieceAt(int posX, int posY) {
		Square square = chessboardModel.getGridSquares()[posX][posY];
		Piece piece = null;
		if (!square.getIsEmpty()) {
			for (Piece piece1 : piecesOnChessboard) {
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
