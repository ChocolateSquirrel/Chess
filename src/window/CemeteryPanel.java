package window;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import pieces.Piece;

public class CemeteryPanel extends JPanel {
	private CemeteryWhitePanel whiteCemetery = new CemeteryWhitePanel();
	private CemeteryBlackPanel blackCemetery = new CemeteryBlackPanel();
	
	public CemeteryPanel() {
		setLayout(new BorderLayout());
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, blackCemetery, whiteCemetery);
		split.setDividerLocation(225);
		add(split, BorderLayout.CENTER);
	}
	
	public CemeteryWhitePanel getWhiteCemetery() {
		return whiteCemetery;
	}
	
	public CemeteryBlackPanel getBlackCemetery() {
		return blackCemetery;
	}
	
	public void addPieceInCemetery(Piece piece) {
		if (piece.getColor().equalsIgnoreCase("black")) {
			String path = "assets/" + piece.getColor() + "/" + piece.getName() + "_" + piece.getColor() + ".png";
			whiteCemetery.displayImage(path, whiteCemetery.getNumberOfPiece());	
		} else {
			String path = "assets/" + piece.getColor() + "/" + piece.getName() + "_" + piece.getColor() + ".png";
			blackCemetery.displayImage(path, blackCemetery.getNumberOfPiece());	
		}
	}

}
