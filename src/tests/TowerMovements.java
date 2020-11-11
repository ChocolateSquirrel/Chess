package tests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import chessboard.ChessboardController;
import chessboard.ChessboardModel;
import chessboard.ChessboardView;
import pieces.Bishop;
import pieces.Tower;

class TowerMovements {

	@Test
	void noMovement() {
		ChessboardController chessboard = new ChessboardController(new ChessboardView(), new ChessboardModel());
		// White Tower in D5.
		Tower tower = new Tower("tower", 3, 3, "white");
		// Some  white pieces around the tower.
		Bishop piece_1 = new Bishop("bishop", 3, 2, "white");
		Bishop piece_2 = new Bishop("bishop", 3, 4, "white");
		Bishop piece_3 = new Bishop("bishop", 2, 3, "white");
		Bishop piece_4 = new Bishop("bishop", 4, 3, "white");
		chessboard.add(tower);
		chessboard.add(piece_1);
		chessboard.add(piece_2);
		chessboard.add(piece_3);
		chessboard.add(piece_4);
		assertTrue(tower.getAllowedSquares(chessboard).size() == 0  && tower.getAttackSquares(chessboard).size() == 0);
	}
	
	@Test
	void justEat() {
		ChessboardController chessboard = new ChessboardController(new ChessboardView(), new ChessboardModel());
		// White Tower in D5.
		Tower tower = new Tower("tower", 3, 3, "white");
		// Some  black pieces around the tower.
		Bishop piece_1 = new Bishop("bishop", 3, 2, "black");
		Bishop piece_2 = new Bishop("bishop", 3, 4, "black");
		Bishop piece_3 = new Bishop("bishop", 2, 3, "black");
		Bishop piece_4 = new Bishop("bishop", 4, 3, "black");
		chessboard.add(tower);
		chessboard.add(piece_1);
		chessboard.add(piece_2);
		chessboard.add(piece_3);
		chessboard.add(piece_4);
		assertTrue(tower.getAllowedSquares(chessboard).size() == 0  && tower.getAttackSquares(chessboard).size() == 4);
	}
	
}
