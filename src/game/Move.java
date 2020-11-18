package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import chessboard.Square;
import pieces.Piece;

public class Move {
	Game currentGame;
	Piece currentPiece;
	private Square arrivalSquare;
	private boolean pieceSelected;
	private boolean arrivalSquareSelected;
	
	public Move (Game game) {
		currentGame = game;
	}
	
	public boolean getPieceSelected() {
		return pieceSelected;
	}
	
	public boolean getArrivalSquareSelected() {
		return arrivalSquareSelected;
	}
	
	public Square getArrivalSquare() {
		return arrivalSquare;
	}
	
	public void selectPiece(Piece piece) {
		pieceSelected = true;
		currentPiece = piece;
		currentGame.getChessboard().getChessboardView().getGridPanels()[currentPiece.getPosX()+1][currentPiece.getPosY()+1].setBackground(Color.RED);
	}
	
	public void chooseArrivalSquare(Square potentialArrival) {
		List<Square> squaresWherePieceCanGo = new ArrayList<Square>();
		squaresWherePieceCanGo.addAll(currentPiece.getAttackSquares(currentGame.getChessboard()));
		squaresWherePieceCanGo.addAll(currentPiece.getAllowedSquares(currentGame.getChessboard()));
		if (squaresWherePieceCanGo.contains(potentialArrival)) {
			arrivalSquare = potentialArrival;
			arrivalSquareSelected = true;
		} 
	}
	
	public void move() {
		currentGame.getChessboard().move(currentPiece, arrivalSquare);
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("piece : ");
		str.append(currentPiece);
		str.append(" ");
		str.append("arrivalSquare : ");
		str.append(arrivalSquare);
		return str.toString();
	}

}
