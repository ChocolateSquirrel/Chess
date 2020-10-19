package window;
import javax.swing.table.AbstractTableModel;

public class ModelGameTable extends AbstractTableModel {
	private final Object[][] donnees;
	
	private final Object[] header = {Player.WHITE.getName(), Player.BLACK.getName()};
	
	public ModelGameTable() {
		donnees = new Object[][] {{"coup1 blanc", "coup1 noir"},
				{"coup2 blanc", "coup2 noir"},
				{"coup3 blanc", "coup3 noir"},
				{"coup4 blanc", "coup4 noir"},
				{"coup2 blanc", "coup2 noir"},
				{"coup3 blanc", "coup3 noir"},
				{"coup4 blanc", "coup4 noir"}
				};
	}

	@Override
	public int getRowCount() {
		return donnees.length;
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return donnees[rowIndex][columnIndex];
	}

}
