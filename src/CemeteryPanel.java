import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class CemeteryPanel extends JPanel {
	private static CasePanel[] gridPanels = new CasePanel[16];
	
	public CemeteryPanel(String color) {
		setLayout(new GridLayout(4, 4));
		
		switch (color) {
		case "white":
			for (int i = 0; i<16; i++) {
				gridPanels[i] = new CasePanel();
				gridPanels[i].setBackground(Color.LIGHT_GRAY);
				add(gridPanels[i]);
		
			}
			break;
		case "black":
			for (int i = 0; i<16; i++) {
				gridPanels[i] = new CasePanel();
				gridPanels[i].setBackground(Color.GRAY);
				add(gridPanels[i]);
			}
			break;	
		default :
			System.out.println("No color for that.");
		}	
	}
	
	/**
	 * Display image in the CasePanel
	 * @param path : relative path to the image
	 * @param number : number of loosing pieces.
	 */
	public void displayImage(String path, int number) {
		gridPanels[number].addImageIcon(path);
	}
}
