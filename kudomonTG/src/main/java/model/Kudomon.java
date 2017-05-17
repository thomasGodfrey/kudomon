package model;

/**
 * Kudomon Class to represent the Kudomon species in the game.
 * Each Kudomon has a type, a species, and a {@link model.Position}
 *
 */
public class Kudomon {
	
	private ElementalType type;
	private String species;
	private Position position;
	private GameField field;
	
	
	/**
	 * Constructor taking a Kudomon Type, a 'species', and a {@link model.Position}
	 * @param typeIn
	 * @param speciesIn
	 * @param xPosIn
	 * @param yPosIn
	 * ------------------INCL Field
	 */
	public Kudomon(ElementalType typeIn, String speciesIn, int xPosIn, int yPosIn, GameField fieldIn){
		type =  typeIn;
		species = speciesIn;
		position = new Position(xPosIn,yPosIn);
		field = fieldIn;
		field.addKudomon(this);
	}
	
	/**
	 * Print the current position of a Kudomon
	 */
	@Override
	public String toString(){
			
		return ("Kudomon " +species+ " is currently at position: ("+ position.getXPosition() +","+ position.getYPosition() +")" );

	}
	
	public String getSpecies(){
		return species;
	}

	public Position getPosition() {
		
		return position;
	}
	
}



