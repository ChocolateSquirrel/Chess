import javax.swing.JPanel;

public class Case {
	protected String color;
	protected boolean isEmpty;
	protected int column;
	protected int row;
	
	public Case(String color, int row, int column) {
		this.color = color;
		this.row = row;
		this.column = column;
	}

}
