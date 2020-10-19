package window;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GameTablePanel extends JPanel {
	private JTable gameTable;
	
	public GameTablePanel() {
		setLayout(new BorderLayout());
	}
	
	public GameTablePanel(JTable gameTable) {
		this();
		this.gameTable = gameTable;
		gameTable.getTableHeader().setReorderingAllowed(false);
		add(gameTable.getTableHeader(), BorderLayout.NORTH);
		add(new JScrollPane(gameTable), BorderLayout.CENTER);
	}
	
	public JTable getGameTable() {
		return gameTable;
	}
	
	public void setGameTable(JTable gameTable) {
		this.gameTable = gameTable;
	}
	

}
