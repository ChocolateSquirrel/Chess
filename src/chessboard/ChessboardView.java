package chessboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import window.Test;

public class ChessboardView extends JPanel {
	/**
	 * 	Store JPanel composing chessboard area and coordinates area. For example, gridPanels[0][1] stores JPanel which contains the the coordinate "8".
	 */
	private static JPanel[][] gridPanels = new JPanel[10][10];
	
	public ChessboardView() {
		setLayout(new GridBagLayout());
		createCoordinates();
		createChessboard();
		paintChessboard();
	}
	
	public JPanel[][] getGridPanels(){
		return gridPanels;
	}
	
	/**
	 * Retrieve the JPanel corresponding to the Square.
	 * @param square 
	 * @return
	 */
	public SquarePanel getJPanel(Square square) {
		SquarePanel panel = (SquarePanel) gridPanels[square.getPosX()+1][square.getPosY()+1];
		return panel;
	}
	
	/**
	 * Create and place JPanels with JLabels composing coordinates area.
	 */
	private void createCoordinates() {
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
	private void createChessboard() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		
		for (int i = 1; i<9; i++) {
			for (int j = 1; j<9; j++) {
				gbc.gridx = i;
				gbc.gridy = j;
				gridPanels[i][j] = new SquarePanel();
				gridPanels[i][j].setPreferredSize(new Dimension(getWidth()/10, getHeight()/10));
				add(gridPanels[i][j], gbc);
			}
		}
	}
	
	/**
	 * Paint JPanel composing the chessboard in two colors. 
	 */
	public void paintChessboard() {
		for (int i = 1; i<9; i++) {
			for (int j = 1; j<9; j++) {
				if ( (i+j)%2 == 0 ) {
					gridPanels[i][j].setBackground(Color.LIGHT_GRAY);
				} else {
					gridPanels[i][j].setBackground(Color.GRAY);
				}
			}
		}	 
	}
	
	private JLabel createJLabelCoordinates(String text) {
		JLabel label = new JLabel(text, SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		Font font = new Font("Serif", Font.BOLD, 25);
		label.setFont(font);
		return label;
	}
	
	private JPanel createJPanelCoordinates() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(getWidth()/10, getHeight()/10));
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(new BorderLayout());
		return panel;
	}

}
