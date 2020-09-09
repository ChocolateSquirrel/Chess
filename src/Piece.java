
import java.util.List;
import java.util.stream.Collectors;

public abstract class Piece implements Movable {
	protected String name;
	protected int posX;
	protected int posY;
	protected String color;
	protected String pathToImage;
	
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public void setPosY(int posY) {
		this.posY = posX;
	}
	
	public String getColor() {
		return color.toUpperCase();
	}
	
	public  String toString() {
		StringBuilder str = new StringBuilder();
		str.append(name);
		str.append(color);
		str.append(posX);
		str.append(posY);
		return str.toString();
	}
	
	@Override
	public List<Case> getAttackCases(List<Case> possibleCases, Game game) {
		List<Case> listCasesWithPiece = possibleCases.stream().filter(c -> c.getIsEmpty()==false).collect(Collectors.toList());
		List<Case> listCasesToAttack = listCasesWithPiece
				.stream()
				.filter(c -> {
					Piece piece = game.getPieceAt(c.getPosX(), c.getPosY());
					return !piece.getColor().equals(color.toUpperCase());
				})
				.collect(Collectors.toList());
		return listCasesToAttack;
	}

	@Override
	public List<Case> getAllowedCases(List<Case> possibleCases) {
		List<Case> list = possibleCases.stream().filter(c -> c.getIsEmpty()).collect(Collectors.toList());
		return list;
	}

}
