package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import chessboard.Square;
import game.Game;
import game.Move;
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
		
		Square square = game.getChessboard().getChessboardModel().getSquareAt(i-1, j-1);
		if (!square.getIsEmpty()) {
			game.getChessboard().getChessboardView().paintChessboard();
			Piece piece = game.getChessboard().getPieceAt(i-1, j-1);
			if (piece.getColor().equalsIgnoreCase(game.getPlayer().getName())) {
				game.getCurrentMove().selectPiece(piece);;
				game.getChessboard().giveAClue(piece);
				System.out.println(game.getCurrentMove().toString());
			}
		} else {
			if (game.getCurrentMove().getPieceSelected()) {
				game.getCurrentMove().chooseArrivalSquare(square);
				if (game.getCurrentMove().getArrivalSquareSelected()) {
					System.out.println(game.getCurrentMove().toString());
					game.getCurrentMove().move();
					game.setCurrentMove(new Move(game));
				game.getChessboard().getChessboardView().paintChessboard();
				}	
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
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
