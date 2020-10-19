package window;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InformationPanel extends JPanel {
	private JPanel timePan = new JPanel();
	private JPanel whiteTimePan = new JPanel();
	private JPanel blackTimePan = new JPanel();
	private JLabel timeLabel = new JLabel("00:00", SwingConstants.CENTER);
	private JLabel whiteTimeLabel = new JLabel("00:00 white", SwingConstants.CENTER);
	private JLabel blackTimeLabel = new JLabel("00:00 black", SwingConstants.CENTER);
	
	
	public InformationPanel() {
		timePan.setLayout(new BorderLayout());
		whiteTimePan.setLayout(new BorderLayout());
		blackTimePan.setLayout(new BorderLayout());
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; 
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 100;
		gbc.weighty = 10;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipadx = 100;
		gbc.ipady = 10;
		JLabel time = new JLabel("Total time : ", SwingConstants.CENTER);
		add(time, gbc);
		
		gbc.gridx = 1; 
		gbc.gridy = 0;
		JLabel timeW = new JLabel("White time : ", SwingConstants.CENTER);
		add(timeW, gbc);
		
		gbc.gridx = 2; 
		gbc.gridy = 0;
		JLabel timeB = new JLabel("Black time : ", SwingConstants.CENTER);
		add(timeB, gbc);
		
		gbc.gridx = 0; 
		gbc.gridy = 1;
		timePan.add(timeLabel, BorderLayout.CENTER);
		add(timePan, gbc);
		
		gbc.gridx = 1; 
		gbc.gridy = 1;
		whiteTimePan.add(whiteTimeLabel, BorderLayout.CENTER);
		add(whiteTimePan, gbc);
		
		gbc.gridx = 2; 
		gbc.gridy = 1;
		blackTimePan.add(blackTimeLabel, BorderLayout.CENTER);
		add(blackTimePan, gbc);
		
	}
	
	public void changeTime(String newText) {
		timeLabel.setText(newText);
	}
	
	public void changeWhiteTime(String newText) {
		whiteTimeLabel.setText(newText);
	}
	
	public void changeBlackTime(String newText) {
		blackTimeLabel.setText(newText);
	}
	
	public void changeColorTimePanel(Color color) {
		timePan.setBackground(color);
	}
	
	public void changeColorWhiteTimePanel(Color color) {
		whiteTimePan.setBackground(color);
	}
	
	public void changeColorBlackTimePanel(Color color) {
		blackTimePan.setBackground(color);
	}
}
