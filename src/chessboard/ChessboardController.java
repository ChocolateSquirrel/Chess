package chessboard;

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
	
	public ChessboardView getChessboardView() {
		return chessboardView;
	}
	
	public ChessboardModel getChessboardModel() {
		return chessboardModel;
	}
	
	public List<Piece> getPiecesOnChessboard(){
		return piecesOnChessboard;
	}
	
}
