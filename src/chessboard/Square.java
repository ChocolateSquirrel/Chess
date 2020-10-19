package chessboard;
import window.Test;

public class Square {
	
	private String color;
	private boolean isEmpty;
	private int posX;
	private int posY;
	
	/**
	 * Construct a Case
	 * @param color : white or black
	 * @param posX : abscisse from 0 to 7
	 * @param posY : ordinate from 0 to 7
	 */
	public Square(int posX, int posY) {
		this.posY = posY;
		this.posX = posX;
		isEmpty = true;
	}
	
	public Square(String color, int posX, int posY) {
		this(posX, posY);
		this.color = color;
		
	}
	
	public boolean getIsEmpty() {
		return isEmpty;
	}
	
	public void setIsEmpty(boolean answer) {
		this.isEmpty = answer;
	}
	
	public String getColor() {
		return color.toUpperCase();
	}
	
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public int getRowOnChessboard() {
		int row = 8 - posY;
		return row;
	}
	
	public String getColumnOnChessboard() {
		String column = Test.COLUMNS_NUMBERING[posX + 1];
		return column;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("colonne : ");
		str.append(Test.COLUMNS_NUMBERING[posX + 1]);
		str.append(" ");
		str.append("ligne : ");
		str.append(String.valueOf(8-posY));
		str.append(" ");
		str.append("couleur : ");
		str.append(color);
		str.append(" ");
		str.append("isEmpty : ");
		str.append(String.valueOf(isEmpty));
		return str.toString();
	}

}
