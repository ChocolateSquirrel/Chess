import javax.swing.JTable;

public class GameTable extends JTable {
	private Object[] columNames = {Player.WHITE.getName(), Player.BLACK.getName()};
	private Object[][] donnees = {
			{"coup1 blanc", "coup1 noir"},
			{"coup2 blanc", "coup2 noir"},
			{"coup3 blanc", "coup3 noir"},
			{"coup4 blanc", "coup4 noir"},
	};
	
	public GameTable() {
		super();
	}
	
	public GameTable(Object[][] donnees, Object[] columnNames) {
		super(donnees, columnNames);
		this.columNames = columnNames;
		this.donnees = donnees;
	}

}
