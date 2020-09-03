import javax.swing.JPanel;

public class Case {
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
	public Case(int posX, int posY) {
		this.posY = posY;
		this.posX = posX;
	}
	
	public Case(String color, int posX, int posY) {
		this(posX, posY);
		this.color = color;
		
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
		return str.toString();
	}

}
