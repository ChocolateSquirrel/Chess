package game;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import chessboard.ChessboardController;
import chessboard.ChessboardModel;
import chessboard.ChessboardView;
import pieces.Bishop;
import pieces.BlackPawn;
import pieces.King;
import pieces.Knight;
import pieces.Piece;
import pieces.Queen;
import pieces.Tower;
import pieces.WhitePawn;
import window.Player;

public class Game implements Runnable {
	
	public AtomicBoolean isPlayed;
	private Clock gameClock;
	private Player player;
	private List<Piece> listPieceInBlackCemetery = new ArrayList<Piece>();
	private List<Piece> listPieceInWhiteCemetery = new ArrayList<Piece>();
	private ChessboardController chessboard;
	
	//Black
	private Piece towerA8 = new Tower("tower", 0, 0, "black");
	private Piece towerH8 = new Tower("tower", 7, 0, "black");
	private Piece knightB8 = new Knight("knight", 1, 0, "black");
	private Piece knightG8 = new Knight("knight", 6, 0, "black");
	private Piece bishopC8 = new Bishop("bishop", 2, 0, "black");
	private Piece bishopF8 = new Bishop("bishop", 5, 0, "black");
	private Piece queenBlack = new Queen("queen", 3, 0, "black");
	private Piece kingBlack = new King("king", 4, 0, "black");
	private Piece pawnA7 = new BlackPawn("pawn", 0, 1, "black");
	private Piece pawnB7 = new BlackPawn("pawn", 1, 1, "black");
	private Piece pawnC7 = new BlackPawn("pawn", 2, 1, "black");
	private Piece pawnD7 = new BlackPawn("pawn", 3, 1, "black");
	private Piece pawnE7 = new BlackPawn("pawn", 4, 1, "black");
	private Piece pawnF7 = new BlackPawn("pawn", 5, 1, "black");
	private Piece pawnG7 = new BlackPawn("pawn", 6, 1, "black");
	private Piece pawnH7 = new BlackPawn("pawn", 7, 1, "black");
	
	//White
	private Piece towerA1 = new Tower("tower", 0, 7, "white");
	private Piece towerH1 = new Tower("tower", 7, 7, "white");
	private Piece knightB1 = new Knight("knight", 1, 7, "white");
	private Piece knightG1 = new Knight("knight", 6, 7, "white");
	private Piece bishopC1 = new Bishop("bishop", 2, 7, "white");
	private Piece bishopF1 = new Bishop("bishop", 5, 7, "white");
	private Piece queenWhite = new Queen("queen", 3, 7, "white");
	private Piece kingWhite = new King("king", 4, 7, "white");
	private Piece pawnA2 = new WhitePawn("pawn", 0, 6, "white");
	private Piece pawnB2 = new WhitePawn("pawn", 1, 6, "white");
	private Piece pawnC2 = new WhitePawn("pawn", 2, 6, "white");
	private Piece pawnD2 = new WhitePawn("pawn", 3, 6, "white");
	private Piece pawnE2 = new WhitePawn("pawn", 4, 6, "white");
	private Piece pawnF2 = new WhitePawn("pawn", 5, 6, "white");
	private Piece pawnG2 = new WhitePawn("pawn", 6, 6, "white");
	private Piece pawnH2 = new WhitePawn("pawn", 7, 6, "white");
	

	public Game(Player player) {
		chessboard = new ChessboardController(new ChessboardView(), new ChessboardModel());
		this.player = player;
	}
	
	public void init() {
		chessboard.add(towerA8);
		chessboard.add(towerA8);
		chessboard.add(towerH8);
		chessboard.add(knightB8);
		chessboard.add(knightG8);
		chessboard.add(bishopC8);
		chessboard.add(bishopF8);
		chessboard.add(queenBlack);
		chessboard.add(kingBlack);
		chessboard.add(pawnA7);
		chessboard.add(pawnB7);
		chessboard.add(pawnC7);
		chessboard.add(pawnD7);
		chessboard.add(pawnE7);
		chessboard.add(pawnF7);
		chessboard.add(pawnG7);
		chessboard.add(pawnH7);
		chessboard.add(towerA1);
		chessboard.add(towerH1);
		chessboard.add(knightB1);
		chessboard.add(knightG1);
		chessboard.add(bishopC1);
		chessboard.add(bishopF1);
		chessboard.add(queenWhite);
		chessboard.add(kingWhite);
		chessboard.add(pawnA2);
		chessboard.add(pawnB2);
		chessboard.add(pawnC2);
		chessboard.add(pawnD2);
		chessboard.add(pawnE2);
		chessboard.add(pawnF2);
		chessboard.add(pawnG2);
		chessboard.add(pawnH2);
	}
	
	public ChessboardController getChessboard() {
		return chessboard;
	}
	
	

	@Override
	public void run() {
		init();
		isPlayed = new AtomicBoolean(true);
		gameClock = new Clock(LocalTime.now());
		while (isPlayed.get()) {
			try {
				Thread.sleep(1000);
				System.out.println(gameClock.changeTimeInString(gameClock.giveElapsedTimeInSeconds(LocalTime.now())));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
//		Piece piece = chooseRandomPiece();
//		System.out.println(piece.toString());
//		chessboard.giveAClue(piece);
//		try {
//			Thread.sleep(5000);
//			System.out.println(gameClock.changeTimeInString(gameClock.giveElapsedTimeInSeconds(LocalTime.now())));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} finally {
//			chessboard.removeClues();
//		}
	}
	
	private Piece chooseRandomPiece() {
		List<Piece> myPieces = chessboard.getPiecesOnChessboard().stream()
				.filter(p -> p.getColor().equalsIgnoreCase(player.getName()))
				.collect(Collectors.toList());
		int randomIndex = (int) (Math.random()*(myPieces.size()-1));
		Piece pieceChoosen = myPieces.get(randomIndex);
		return pieceChoosen;
	}
	
	
	
}
