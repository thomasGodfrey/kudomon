package model;

import java.util.HashMap;
import java.util.Random;

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
	private Trainer catcher;
	
	private double health_points;
	private double combat_points;
	protected HashMap<ElementalType, Double> multiplier = new HashMap<ElementalType, Double>();
	private Random myTurn;
	
	
	/**
	 * Constructor taking a Kudomon Type, a 'species', and a {@link model.Position}
	 * @param typeIn
	 * @param speciesIn
	 * @param xPosIn
	 * @param yPosIn
	 * @param fieldIn - The GameField on which the Kudomon will spawn
	 */
	public Kudomon(ElementalType typeIn, String speciesIn, int xPosIn, int yPosIn, GameField fieldIn){
		type =  typeIn;
		species = speciesIn;
		position = new Position(xPosIn,yPosIn);
		field = fieldIn;
		
		myTurn = new Random();
		field.addKudomon(this);
	}
	
	/**
	 * Print the current position of a Kudomon if its on the gameField, or just the Kudomon species name otherwise
	 */
	@Override
	public String toString(){
		
		if(field.getKudomon().contains(this)){
			return ("Kudomon " +species+ " is currently at position: ("+ position.getXPosition() +","+ position.getYPosition() +")" );
		}
		else{
			return (species);
		}

	}
	
	public String getSpecies(){
		return species;
	}

	public Position getPosition() {
		
		return position;
	}
	
	/**
	 * Set the status of the Kudomon, Is the Kudomon currently being caught by a Trainer
	 * @param beingCaughtIn
	 */
	public void setBeingCaughtBy(Trainer trainerIn){
		catcher = trainerIn;
	}

	/**
	 * Return who the Kudomon is currently being caught by
	 * @return
	 */
	public Trainer isBeingCaughtBy() {
		return catcher;
	}
	
	public double getEffectiveness(ElementalType typeIn){
		
		if(!multiplier.containsKey(typeIn)){
			return 1.0;
		}
			return multiplier.get(typeIn);
	}
	
	public void battle(Kudomon otherKudomon){
		
		boolean myTurnFirst = myTurn.nextBoolean();
		
		if(myTurnFirst){
			
		}
		
	}
	
}



