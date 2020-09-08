import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Window extends JFrame {
	private Game game = new Game();
	private JPanel pan = new JPanel();
	
	private InformationPanel infoPan = new InformationPanel();
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu gameMenu = new JMenu("Game");
	private JMenu helpMenu = new JMenu("Help");
	private JMenu newGame = new JMenu("New Game");
	private JMenuItem quit = new JMenuItem("Quit");
	private JMenuItem white = new JMenuItem(Player.WHITE.getName());
	private JMenuItem black = new JMenuItem(Player.BLACK.getName());

	private JTable gameTable = new JTable(new ModelGameTable());

	
	public Window() {
		build();
		initMenu();
		game.giveIndice();
		
		setVisible(true);
	}
	
	private void build() {
		setTitle("Chess");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		
		// Positioning different panels with layouts
		pan.setBackground(Color.WHITE);
		pan.setLayout(new BorderLayout());
		pan.add(createPanUp(), BorderLayout.CENTER);
		pan.add(createPanBottom(), BorderLayout.SOUTH);
		setContentPane(pan);
	}
	
	private JPanel createPanUp() {
		JPanel panUp = new JPanel();
		int widthPanUp = panUp.getWidth();
		int heightPanUp = panUp.getHeight();
		
		GameTablePanel arrayPan = new GameTablePanel(gameTable);
		JPanel chessPan = new JPanel();
		JPanel cemeteryPan = new JPanel();
		cemeteryPan.setBackground(Color.MAGENTA);
		
		Dimension dimArray = new Dimension(3*widthPanUp/12, heightPanUp);
		Dimension dimCemetery = new Dimension(3*widthPanUp/12, heightPanUp);
		Dimension dimChess = new Dimension(6*widthPanUp/12, heightPanUp);
		arrayPan.setPreferredSize(dimArray);
		cemeteryPan.setPreferredSize(dimCemetery);
		chessPan.setPreferredSize(dimChess);
		
		panUp.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 3;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		panUp.add(arrayPan, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 3;
		panUp.add(cemeteryPan, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 6;
		chessPan.setLayout(new BorderLayout());
		int widthChessPan = chessPan.getWidth();
		int heightChessPan = chessPan.getHeight();
		Dimension dimChessboard = new Dimension(widthChessPan, heightChessPan);
		if (widthChessPan > heightChessPan) {
			dimChessboard = new Dimension(heightChessPan, heightChessPan);
		} else {
			dimChessboard = new Dimension(widthChessPan, widthChessPan);
		}
		chessPan.setBackground(Color.RED);
		ChessboardPanel.getInstance().setPreferredSize(dimChessboard);
		chessPan.add(ChessboardPanel.getInstance(), BorderLayout.CENTER);
		panUp.add(chessPan, gbc);
		
		return panUp;
	}
	
	private JPanel createPanBottom() {
		JPanel panBottom = new JPanel();
		panBottom.add(infoPan);
		return panBottom;
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
