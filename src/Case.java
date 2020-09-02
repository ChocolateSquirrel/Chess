import javax.swing.JPanel;

public class Case {
	protected String color;
	protected boolean isEmpty;
	protected int column;
	protected int row;
	
	public Case(String color, int column, int row) {
		this.color = color;
		this.row = row;
		this.column = column;
	}
	
	public String givePositionOnChessboard() {
		StringBuilder str = new StringBuilder();
		str.append("colonne : ");
		str.append(Test.columnsNumbering[column + 1]);
		str.append(" ");
		str.append("ligne : ");
		str.append(String.valueOf(8-row));
		str.append(" ");
		str.append("couleur : ");
		str.append(color);
		return str.toString();
	}

}
