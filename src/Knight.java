import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
	
	public Knight(String name, int posX, int posY, String color) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.color = color;	
		Case casePiece = ChessboardPanel.getInstance().getCaseAt(posX, posY);
		ChessboardPanel.getInstance().getJPanel(casePiece).getJLabel().setText(color + " " + name);	
		casePiece.setIsEmpty(false);
	}
	
	public Knight(String name, int posX, int posY, String color, String path) {
		this(name, posX, posY, color);
		this.pathToImage = path;	
	}

	@Override
	public List<Case> getAllowedCases(Case[][] gridCases) {
		List<Case> list = new ArrayList<Case>();
		// Movement which beginning on the right
		if (posX + 2 < 8) {
			if (posY-1>=0) 
				list.add(gridCases[posX + 2][posY - 1]);
			if (posY+1<8) 
				list.add(gridCases[posX + 2][posY + 1]);	
		}
		
		// Movement which beginning on the left
		if (posX - 2 >= 0) {
			if (posY-1>=0) 
				list.add(gridCases[posX - 2][posY - 1]);
			if (posY+1<8) 
				list.add(gridCases[posX - 2][posY + 1]);	
		}
		
		// Movement which beginning at up
		if (posY - 2 >=0) {
			if (posX-1>=0) 
				list.add(gridCases[posX - 1][posY - 2]);
			if (posX+1<8) 
				list.add(gridCases[posX + 1][posY - 2]);	
		}
		
		// Movement which beginning at bottom
		if (posY + 2 < 8) {
			if (posX-1>=0) 
				list.add(gridCases[posX - 1][posY + 2]);
			if (posX+1<8) 
				list.add(gridCases[posX + 1][posY + 2]);	
		}
		
		return list;
	}

}