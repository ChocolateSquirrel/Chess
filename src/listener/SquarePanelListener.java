package listener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import chessboard.ChessboardController;
import chessboard.Square;
import game.Game;
import pieces.Piece;

public class SquarePanelListener implements MouseListener {
	// Coordinates of the JPanel in gridPanels 
	private int i;
	private int j;
	private Game game;
	
	public SquarePanelListener(int i, int j, Game game) {
		this.i = i;
		this.j = j;
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Square square = game.getChessboard().getChessboardModel().getSquareAt(i-1, j-1);
		System.out.println(square.toString());
		if (!square.getIsEmpty()) {
			Piece piece = game.getChessboard().getPieceAt(i-1, j-1);
			if (piece.getColor().equalsIgnoreCase(game.getPlayer().getName())) {
				game.getChessboard().getChessboardView().getGridPanels()[i][j].setBackground(Color.RED);
				game.getChessboard().giveAClue(piece);
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

}
