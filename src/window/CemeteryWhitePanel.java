package window;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import chessboard.SquarePanel;

public class CemeteryWhitePanel extends JPanel {
	private SquarePanel[] gridPanels = new SquarePanel[16];
	private static int numberOfLoosingPiece = 0;
	
	public CemeteryWhitePanel() {
		setLayout(new GridLayout(4, 4));
		for (int i = 0; i<16; i++) {
			gridPanels[i] = new SquarePanel();
			gridPanels[i].setBackground(Color.LIGHT_GRAY);
			add(gridPanels[i]);
		}
	}
	
	/**
	 * Display image in the SquarePanel
	 * @param path : relative path to the image
	 * @param number : number of loosing pieces.
	 */
	public void displayImage(String path, int number) {
		gridPanels[number].addImageIcon(path);
		numberOfLoosingPiece++;
	}
	
	public int getNumberOfPiece() {
		return numberOfLoosingPiece;
	}

}
