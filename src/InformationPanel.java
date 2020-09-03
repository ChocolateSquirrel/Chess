import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InformationPanel extends JPanel {
	
	
	public InformationPanel() {
		setLayout(new GridLayout(1,3));
		JPanel timePan = createTimePan();
		JPanel whiteTimePan = createWhiteTimePan();
		JPanel blackTimePan = createBlackTimePan();
		add(timePan);
		add(whiteTimePan);
		add(blackTimePan);
	}
	
	private JPanel createTimePan() {
		JPanel timePan = new JPanel();
		timePan.setBackground(Color.PINK);
		timePan.setLayout(new GridLayout(2,1));
		JLabel label = new JLabel("Total time : ", SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		Font font = new Font("Serif", Font.BOLD, 20);
		label.setFont(font);
		timePan.add(label, BorderLayout.EAST);
		return timePan;
	}
	
	private JPanel createWhiteTimePan() {
		JPanel whiteTimePan = new JPanel();
		whiteTimePan.setBackground(Color.RED);
		JLabel label = new JLabel("White time : ");
		label.setForeground(Color.WHITE);
		Font font = new Font("Serif", Font.BOLD, 20);
		label.setFont(font);
		whiteTimePan.add(label);
		return whiteTimePan;
	}
	
	private JPanel createBlackTimePan() {
		JPanel blackTimePan = new JPanel();
		blackTimePan.setBackground(Color.YELLOW);
		JLabel label = new JLabel("Black time : ");
		label.setForeground(Color.WHITE);
		Font font = new Font("Serif", Font.BOLD, 20);
		label.setFont(font);
		blackTimePan.add(label);
		return blackTimePan;
	}
	

}
