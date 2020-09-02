import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChessboardPanel extends JPanel {
	private JPanel[][] gridPanels;
	private Case[][] gridCases;
	private JLabel label = new JLabel();

	public ChessboardPanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.CYAN);
		gridPanels = new JPanel[10][10];
		displayCoordinates();
		drawChessboard();
		createGridCases();
		System.out.println(gridCases[5][4].givePositionOnChessboard());
	}
	
	public void displayCoordinates() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		// Numbering of columns (a, b, ..., h)
		for (int i = 0; i<10; i++) {
			// At top
			gbc.gridx = i;
			gbc.gridy = 0;
			gridPanels[i][0] = new JPanel();
			gridPanels[i][0].setBackground(Color.DARK_GRAY);
			label = new JLabel(Test.columnsNumbering[i].toString());
			label.setForeground(Color.WHITE);
			gridPanels[i][0].add(label);
			add(gridPanels[i][0], gbc);
			// A bottom
			gbc.gridx = i;
			gbc.gridy = 9;
			gridPanels[i][9] = new JPanel();
			gridPanels[i][9].setBackground(Color.DARK_GRAY);
			label = new JLabel(Test.columnsNumbering[i].toString());
			label.setForeground(Color.WHITE);
			gridPanels[i][9].add(label);
			add(gridPanels[i][9], gbc);
			
		}

		// Numbering of rows (8, 7, ..., 1)
		for (int j = 1; j<10; j++) {
			// On the left
			gbc.gridx = 0;
			gbc.gridy = j;
			gridPanels[0][j] = new JPanel();
			gridPanels[0][j].setBackground(Color.DARK_GRAY);
			label = new JLabel(Test.rowsNumbering[9-j].toString());
			gridPanels[0][j].add(label);
			label.setForeground(Color.WHITE);
			add(gridPanels[0][j], gbc);
			// On the right
			gbc.gridx = 9;
			gbc.gridy = j;
			gridPanels[9][j] = new JPanel();
			gridPanels[9][j].setBackground(Color.DARK_GRAY);
			label = new JLabel(Test.rowsNumbering[9-j].toString());
			gridPanels[9][j].add(label);
			label.setForeground(Color.WHITE);
			add(gridPanels[9][j], gbc);
		}
	}
	
	
	
	public void drawChessboard() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		
		for (int i = 1; i<9; i++) {
			for (int j = 1; j<9; j++) {
				gbc.gridx = i;
				gbc.gridy = j;
				gridPanels[i][j] = new JPanel();
				if ( (i+j)%2 == 0 ) {
					gridPanels[i][j].setBackground(Color.LIGHT_GRAY);
				} else {
					gridPanels[i][j].setBackground(Color.BLACK);
				}
				add(gridPanels[i][j], gbc);
			}
		}
		
	}
	
	public void createGridCases() {
		gridCases = new Case[8][8];
		for (int i = 0; i<8; i++) {
			for (int j = 0; j<8; j++) {
				if ( (i+j)%2 == 0 ) {
					gridCases[i][j] = new Case("white", i, j);
				} else {
					gridCases[i][j] = new Case("black", i, j);
				}
			}
		}
	}
	
}
	
	