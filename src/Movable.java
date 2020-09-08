import java.util.List;

public interface Movable {
	
	/**
	 * Store cases where the piece can move even if there is a piece (black or white) on this case.
	 * @param gridCases
	 * @return
	 */
	public List<Case> getPossibleCases(Case[][] gridCases);
	
	/**
	 * Store cases where the piece can both move and eat opponent piece. 
	 * @param possibleCases : list of cases where the piece can go even if there is an other piece.
	 * @param game
	 * @return
	 */
	public List<Case> getAttackCases(List<Case> possibleCases, Game game);
	
	
	/**
	 * Store free cases where the piece can move.
	 * @param possibleCases
	 * @return
	 */
	public List<Case> getAllowedCases(List<Case> possibleCases);
 
	
	


}
