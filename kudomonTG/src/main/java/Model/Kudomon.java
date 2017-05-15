package Model;

/**
 * Kudomon Class to represent the Kudomon species in the game.
 * Each Kudomon has a type, a species, and a {@link Model.Position}
 *
 */
public class Kudomon {
	
	private ElementalType type;
	private String species;
	private Position position;
	
	
	/**
	 * Constructor taking a Kudomon Type, a 'species', and a {@link Model.Position}
	 * @param typeIn
	 * @param speciesIn
	 * @param xPosIn
	 * @param yPosIn
	 */
	public Kudomon(ElementalType typeIn, String speciesIn, int xPosIn, int yPosIn){
		type =  typeIn;
		species = speciesIn;
		position = new Position(xPosIn,yPosIn);
	}
	
	//Print the current position of a Kudomon
	@Override
	public String toString(){
			
		return ("Kudomon " +species+ " is currently at position: ("+ position.getXPosition() +","+ position.getYPosition() +")" );

	}
	
}



