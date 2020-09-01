import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Window extends JFrame {
	private JPanel pan = new JPanel();
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu gameMenu = new JMenu("Game");
	private JMenu helpMenu = new JMenu("Help");
	private JMenu newGame = new JMenu("New Game");
	private JMenuItem quit = new JMenuItem("Quit");
	private JMenuItem white = new JMenuItem(Player.WHITE.getName());
	private JMenuItem black = new JMenuItem(Player.BLACK.getName());
	
	
	public Window() {
		setTitle("Chess");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		
		// Positioning different panels with layouts
		pan.setBackground(Color.WHITE);
		JPanel arrayPan = new JPanel();
		arrayPan.setBackground(Color.BLUE);
		JPanel chessboardPan = new JPanel();
		chessboardPan.setBackground(Color.GREEN);
		JPanel cemeteryPan = new JPanel();
		cemeteryPan.setBackground(Color.MAGENTA);
		JPanel dialogPan = new JPanel();
		dialogPan.setBackground(Color.YELLOW);
		
		pan.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 0.25;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		arrayPan.add(new GameTable());
		pan.add(arrayPan, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 0.1;
		pan.add(cemeteryPan, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		pan.add(chessboardPan, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		pan.add(dialogPan, gbc);
		
		setContentPane(pan);
		initMenu();
	}
	
	private void initMenu() {
		newGame.add(white);
		newGame.add(black);
		gameMenu.add(newGame);
		gameMenu.add(quit);
		menuBar.add(gameMenu);
		menuBar.add(helpMenu);
		setJMenuBar(menuBar);
	}

}
