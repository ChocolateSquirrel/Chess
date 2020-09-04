import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CasePanel extends JPanel {
	private JLabel label;
	private ImageIcon icone;
	
	public CasePanel() {
		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label);
	}
	
	public JLabel getJLabel() {
		return label;
	}
	
	public void addImageIcon(String path) {
		icone = new ImageIcon(path);
		label.setIcon(icone);
	}
	
	public void removeImageIcon() {
		label.setIcon(null);
	}

}
