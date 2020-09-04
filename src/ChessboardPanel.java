import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ChessboardPanel extends JPanel {
	// Store JPanel composing chessboard area and coordinates area. For example, gridPanels[0][1] stores JPanel which contains the the coordinate "8".
	private static JPanel[][] gridPanels = new JPanel[10][10];
	// Store Case composing only chessboard area. For example, gridCases[0][0] stores the white case "a8".
	private static Case[][] gridCases = new Case[8][8];
	// The unique instance of ChessboardPanel
	private static ChessboardPanel chessboardPanel = new ChessboardPanel();

	private ChessboardPanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.CYAN);
		drawCoordinates();
		drawChessboard();
		createGridCases();
		Dimension dim = new Dimension(getWidth()/10, getHeight()/10);
		for (JPanel[] panel1 : gridPanels) {
			for (JPanel panel : panel1) {
				panel.setPreferredSize(dim);
			}
		}
	}
	
	public static ChessboardPanel getInstance() {
		return chessboardPanel;
	}
	
	/**
	 * Create and place JPanels with JLabels composing coordinates area.
	 */
	private void drawCoordinates() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 1.;
		gbc.weighty = 1.;
		gbc.fill = GridBagConstraints.BOTH;
		// "Abscisses" (a, b, ..., h)
		for (int i = 0; i<10; i++) {
			// At top
			gbc.gridx = i;
			gbc.gridy = 0;
			gridPanels[i][0] = createJPanelCoordinates();
			gridPanels[i][0].add(createJLabelCoordinates(Test.COLUMNS_NUMBERING[i].toString()), BorderLayout.SOUTH);
			add(gridPanels[i][0], gbc);
			// A bottom
			gbc.gridx = i;
			gbc.gridy = 9;
			gridPanels[i][9] = createJPanelCoordinates();
			gridPanels[i][9].add(createJLabelCoordinates(Test.COLUMNS_NUMBERING[i].toString()), BorderLayout.NORTH);
			add(gridPanels[i][9], gbc);
			
		}
		// "Ordinates" (8, 7, ..., 1)
		for (int j = 1; j<10; j++) {
			// On the left
			gbc.gridx = 0;
			gbc.gridy = j;
			gridPanels[0][j] = createJPanelCoordinates();
			gridPanels[0][j].add(createJLabelCoordinates(Test.ROWS_NUMBERING[9-j].toString()), BorderLayout.EAST);
			add(gridPanels[0][j], gbc);
			// On the right
			gbc.gridx = 9;
			gbc.gridy = j;
			gridPanels[9][j] = createJPanelCoordinates();
			gridPanels[9][j].add(createJLabelCoordinates(Test.ROWS_NUMBERING[9-j].toString()), BorderLayout.WEST);
			add(gridPanels[9][j], gbc);
		}
	}
	
	/**
	 * Create and place JPanels composing only chessboard area.
	 */
	private void drawChessboard() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		
		for (int i = 1; i<9; i++) {
			for (int j = 1; j<9; j++) {
				gbc.gridx = i;
				gbc.gridy = j;
				gridPanels[i][j] = new CasePanel();
				if ( (i+j)%2 == 0 ) {
					gridPanels[i][j].setBackground(Color.LIGHT_GRAY);
				} else {
					gridPanels[i][j].setBackground(Color.BLACK);
				}
				add(gridPanels[i][j], gbc);
			}
		}	
	}
	
	/**
	 * Store the color and the position of each cases in a Case object.
	 * Warning, the position (i, j) doesn't match with the coordinates of the real chessboard. For example, gridCases[0][0] is for the the white case "a8".
	 */
	private void createGridCases() {
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
	
	/**
	 * Retrieve the JPanel corresponding to the Case.
	 * @param case1 
	 * @return
	 */
	public CasePanel getJPanel(Case case1) {
		CasePanel panel = (CasePanel) gridPanels[case1.getPosX()+1][case1.getPosY()+1];
		return panel;
	}
	
	public Case getCaseAt(int posX, int posY) {
		return gridCases[posX][posY];
	}
	
	public Case[][] getGridCases(){
		return gridCases;
	}
	
	
	
	
	private static JLabel createJLabelCoordinates(String text) {
		JLabel label = new JLabel(text, SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		Font font = new Font("Serif", Font.BOLD, 25);
		label.setFont(font);
		return label;
	}
	
	private static JPanel createJPanelCoordinates() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(new BorderLayout());
		return panel;
	}

	
}
	
	