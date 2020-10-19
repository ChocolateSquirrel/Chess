package pieces;

import java.util.List;
import java.util.stream.Collectors;

import chessboard.Game;
import chessboard.Square;

public abstract class Piece implements Movable {
	protected String name;
	protected int posX;
	protected int posY;
	protected String color;
	protected String pathToImage;
	
	
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
		return color.toUpperCase();
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
	public List<Square> getAttackCases(List<Square> possibleCases, Game game) {
		List<Square> listCasesWithPiece = possibleCases.stream().filter(c -> c.getIsEmpty()==false).collect(Collectors.toList());
		List<Square> listCasesToAttack = listCasesWithPiece
				.stream()
				.filter(c -> {
					Piece piece = game.getPieceAt(c.getPosX(), c.getPosY());
					return !piece.getColor().equals(color.toUpperCase());
				})
				.collect(Collectors.toList());
		return listCasesToAttack;
	}

	@Override
	public List<Square> getAllowedCases(List<Square> possibleCases) {
		List<Square> list = possibleCases.stream().filter(c -> c.getIsEmpty()).collect(Collectors.toList());
		return list;
	}

}
