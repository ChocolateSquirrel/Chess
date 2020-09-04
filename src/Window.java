import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Window extends JFrame {
	private JPanel pan = new JPanel();
	private JPanel panUp = new JPanel();
	private JPanel panBottom = new JPanel();
	
	private ChessboardPanel chessboardPan = new ChessboardPanel();
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
		Case case1 = new Case("black", 7, 2);
		chessboardPan.getJPanel(case1).setBackground(Color.ORANGE);
		System.out.println(case1.toString());
		setVisible(true);
	}
	
	private void build() {
		setTitle("Chess");
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		
		// Positioning different panels with layouts
		pan.setBackground(Color.WHITE);
		pan.setLayout(new BorderLayout());
		
		GameTablePanel arrayPan = new GameTablePanel(gameTable);
	
		JPanel cemeteryPan = new JPanel();
		cemeteryPan.setBackground(Color.MAGENTA);

		panUp.setLayout(new GridBagLayout());
		Dimension dimArray = new Dimension(panUp.getWidth()/6, panUp.getHeight());
		Dimension dimCemetery = new Dimension(panUp.getWidth()/6, panUp.getHeight());
		Dimension dimChessboard = new Dimension(4*panUp.getWidth()/6, panUp.getHeight());
		

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 1;
		gbc.weighty = 4;
		gbc.fill = GridBagConstraints.BOTH;
		arrayPan.setPreferredSize(dimArray);
		panUp.add(arrayPan, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 1;
		cemeteryPan.setPreferredSize(dimCemetery);
		panUp.add(cemeteryPan, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 4;
		chessboardPan.setPreferredSize(dimChessboard);
		panUp.add(chessboardPan, gbc);
		
		panBottom.add(infoPan);
		
		pan.add(panUp, BorderLayout.CENTER);
		pan.add(panBottom,BorderLayout.SOUTH);
		setContentPane(pan);
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
