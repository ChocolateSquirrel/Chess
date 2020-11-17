package pieces;

import java.util.List;
import java.util.stream.Collectors;

import chessboard.ChessboardController;
import chessboard.Square;
import game.Game;

public abstract class Piece implements Movable {
	protected String name;
	protected int posX;
	protected int posY;
	protected String color;
	protected boolean isSelected;
	
	public Piece(String name, int posX, int posY, String color) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.color = color;	
	}
	
	public String getName() {
		return name.toLowerCase();
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public void setPosY(int posY) {
		this.posY = posX;
	}
	
	public String getColor() {
		return color.toLowerCase();
	}
	
	public boolean getIsSelected() {
		return isSelected;
	}
	
	public void setIsSelected(boolean answer) {
		isSelected = answer;
	}
	
	public  String toString() {
		StringBuilder str = new StringBuilder();
		str.append(name);
		str.append(color);
		str.append(posX);
		str.append(posY);
		return str.toString();
	}
	
	@Override
	public List<Square> getAttackSquares(ChessboardController chessboard) {
		List<Square> listCasesWithPiece = getPossibleSquares(chessboard).stream().filter(c -> c.getIsEmpty()==false).collect(Collectors.toList());
		List<Square> listCasesToAttack = listCasesWithPiece
				.stream()
				.filter(c -> {
					Piece piece = chessboard.getPieceAt(c.getPosX(), c.getPosY());
					return !piece.getColor().equals(color.toLowerCase());
				})
				.collect(Collectors.toList());
		return listCasesToAttack;
	}

	@Override
	public List<Square> getAllowedSquares(ChessboardController chessboard) {
		List<Square> list = getPossibleSquares(chessboard).stream().filter(c -> c.getIsEmpty()).collect(Collectors.toList());
		return list;
	}

}
