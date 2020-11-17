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
	
	public void removeAllPiecesOnChessboard() {
		piecesOnChessboard = new ArrayList<Piece>();
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
	
	/**
	 * Give the square from chessboardModel corresponding to the gridPanels[i][j] in the chessboardView.
	 * @param i : abscisse of the SquarePanel in the gridPanels from the chessboardView
	 * @param j : ordinate of the SquarePanel in the gridPanels from the chessboardView
	 * @return square from the chessboardModel corresponding to the SquarePanel
	 * @throws IllegalArgumentException if i or j is out of [1;8]
	 */
	public Square giveSquareOfASquarePanel(int i, int j) throws IllegalArgumentException {
		try {
			return chessboardModel.getSquareAt(i-1, j-1);
		} catch (Exception e) {
			throw new IllegalArgumentException("les numéros de lignes et de colonnes doivent être compris entre 1 et 8.");
		}
	}
	
	
	
}
