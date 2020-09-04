import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CasePanel extends JPanel {
	private JLabel label;
	
	public CasePanel() {
		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label);
	}
	
	public JLabel getJLabel() {
		return label;
	}
	
	

}
