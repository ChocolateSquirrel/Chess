package chessboard;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SquarePanel extends JPanel {
	private JLabel label;
	private ImageIcon icone;
	
	public SquarePanel() {
		setLayout(new BorderLayout());
		label = new JLabel();
		label.setPreferredSize(new Dimension(getWidth(), getHeight()));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label, BorderLayout.CENTER);
	}
	
	public JLabel getJLabel() {
		return label;
	}
	

	
	public void addImageIcon(String path) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("Wrong path");
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		icone = new ImageIcon(dimg);
		label.setIcon(icone);
	}
	
	public void removeImageIcon() {
		label.setIcon(null);
	}

}
