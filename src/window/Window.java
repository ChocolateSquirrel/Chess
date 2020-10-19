package window;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;

import chessboard.ChessboardPanel;
import chessboard.Game;

public class Window extends JFrame {
	private Game game = new Game();
	private JPanel pan = new JPanel();
	private CemeteryPanel whiteCemetery = new CemeteryPanel("white");
	private CemeteryPanel blackCemetery = new CemeteryPanel("black");
	
	private JTable gameTable = new JTable(new ModelGameTable());
	private InformationPanel infoPan = new InformationPanel();
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu gameMenu = new JMenu("Game");
	private JMenu helpMenu = new JMenu("Help");
	private JMenu newGame = new JMenu("New Game");
	private JMenuItem quit = new JMenuItem("Quit");
	private JMenuItem white = new JMenuItem(Player.WHITE.getName());
	private JMenuItem black = new JMenuItem(Player.BLACK.getName());
	private JMenuItem help = new JMenuItem("help");

	
	public Window() {
		build();
		initMenu();
		game.giveIndice();
		whiteCemetery.displayImage("assets/black/queen_black.png", 0);
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
		cemeteryPan.setLayout(new BorderLayout());
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, blackCemetery, whiteCemetery);
		split.setDividerLocation(225);
		cemeteryPan.add(split, BorderLayout.CENTER);
		
		Dimension dimArray = new Dimension(3*widthPanUp/21, heightPanUp);
		Dimension dimCemetery = new Dimension(3*widthPanUp/21, heightPanUp);
		Dimension dimChess = new Dimension(15*widthPanUp/21, heightPanUp);
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
		white.addActionListener(new StartGameWhiteListener());
		black.addActionListener(new StartGameBlackListener());
		newGame.add(white);
		newGame.add(black);
		
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		gameMenu.add(newGame);
		gameMenu.add(quit);
		
		help.addActionListener(new HelpListener());
		helpMenu.add(help);
		
		menuBar.add(gameMenu);
		menuBar.add(helpMenu);
		setJMenuBar(menuBar);
	}
	
	public class StartGameWhiteListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			infoPan.changeColorWhiteTimePanel(Color.CYAN);
			infoPan.changeWhiteTime("coucou");
			System.out.println("Tu joues avec les blancs.");
		}
	}
	
	public class StartGameBlackListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			infoPan.changeColorBlackTimePanel(Color.CYAN);
			System.out.println("Tu joues avec les noirs.");
		}
	}
	
	public class HelpListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(null, "You asked for help ? ", "Help", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Coucou");
		}
	}

	

}
