package chessboard;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import game.Game;
import listener.SquarePanelListener;
import pieces.Piece;

public class ChessboardController {
	private ChessboardView chessboardView;
	private ChessboardModel chessboardModel;
	private List<Piece> piecesOnChessboard = new ArrayList<Piece>();
	private List<Piece> piecesOutChessboard = new ArrayList<Piece>();
	
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
	
	public List<Piece> getPiecesOutChessboard(){
		return piecesOutChessboard;
	}
	
	public void add(Piece piece) {
		Square pieceSquare = chessboardModel.getSquareAt(piece.getPosX(), piece.getPosY());
		if (pieceSquare.getIsEmpty()) {
			piecesOnChessboard.add(piece);
			chessboardView.getJPanel(pieceSquare).addImageIcon("assets/" + piece.getColor() + "/" + piece.getName() + "_" + piece.getColor() + ".png");
			pieceSquare.setIsEmpty(false);
		}
	}
	
	public void moveOnFreeSquare(Piece piece, Square newSquare) {
		if (newSquare.getIsEmpty()) {
			Piece pieceToMove = piece;
			remove(piece);
			pieceToMove.setPosX(newSquare.getPosX());
			pieceToMove.setPosY(newSquare.getPosY());
			add(pieceToMove);
		}
	}
	
	public void moveAndEat(Piece piece, Square newSquare) {
		if (!newSquare.getIsEmpty()) {
			Piece pieceToEat = getPieceAt(newSquare.getPosX(), newSquare.getPosY());
			if (!pieceToEat.getColor().equalsIgnoreCase(piece.getColor())) {
				remove(pieceToEat);
				piecesOutChessboard.add(pieceToEat);
				moveOnFreeSquare(piece, newSquare);
			}
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
	
	public void addListenerToSquarePanelInChessboard(Game game) {
		JPanel[][] gridPanels = chessboardView.getGridPanels();
		for (int i = 1; i<9; i++) {
			for (int j = 1; j<9; j++) {
				gridPanels[i][j].addMouseListener(new SquarePanelListener(i, j, game));
			}
		}
	}
	
}
