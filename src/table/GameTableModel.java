package table;
import javax.swing.table.AbstractTableModel;

import window.Player;

public class GameTableModel extends AbstractTableModel {
	private final Object[][] donnees;
	
	private final String[] header = {"move", Player.WHITE.getName(), Player.BLACK.getName()};
	
	public GameTableModel() {
		donnees = new Object[][] {{"1", "coup1 blanc", "coup1 noir"},
				{"2", "coup2 blanc", "coup2 noir"},
				{"3", "coup3 blanc", "coup3 noir"},
				{"4", "coup4 blanc", "coup4 noir"},
				{"5", "coup5 blanc", "coup5 noir"},
				{"6", "coup6 blanc", "coup6 noir"},
				{"7", "coup7 blanc", "coup7 noir"}
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
	
	public String getColumnName(int col) {
		return header[col];
	}

}
