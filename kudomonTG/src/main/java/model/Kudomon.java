package model;

import java.util.HashMap;
import java.util.Random;

/**
 * Kudomon Class to represent the Kudomon species in the game.
 * Each Kudomon has a type, a species, and a {@link model.Position}
 *
 */
public class Kudomon {
	
	protected ElementalType type;
	private String species;
	private Position position;
	private GameField field;
	private Trainer catcher;
	
	private double healthPoints;
	private double combatPoints;
	protected HashMap<ElementalType, Double> multiplier = new HashMap<ElementalType, Double>();
	private Random myTurn;
	private boolean knockedOut;
	
	
	/**
	 * Constructor taking a Kudomon Type, a 'species', and a {@link model.Position}
	 * @param speciesIn - Species name
	 * @param xPosIn - x coordinate
	 * @param yPosIn - y coordinate
	 * @param healthPointsIn - The Kudomon's default health points
	 * @param combatPointsIn - The Kudomon's default combat points
	 * @param fieldIn - The GameField on which the Kudomon will spawn
	 */
	public Kudomon(String speciesIn, int xPosIn, int yPosIn, double healthPointsIn, double combatPointsIn, GameField fieldIn){
		species = speciesIn;
		position = new Position(xPosIn,yPosIn);
		healthPoints = healthPointsIn;
		combatPoints= combatPointsIn;
		field = fieldIn;
		
		myTurn = new Random();
		field.addKudomon(this);
	}
	
	/**
	 * Set the status of the Kudomon, Which Trainer is the Kudomon being caught by
	 * @param trainerIn - Specify that the Kudomon is being caught by this Trainer
	 */
	public void setBeingCaughtBy(Trainer trainerIn){
		catcher = trainerIn;
	}
	
	/**
	 * Return who the Kudomon is currently being caught by
	 * @return Trainer - Trainer that is currently catching this Kudomon
	 */
	public Trainer isBeingCaughtBy() {
		return catcher;
	}
	
	
	/**
	 * Simulate a battle between 2 Kudomon. The Kudomon {@link strike} each other until one is knocked out
	 * @param otherKudomon - The Kudomon being attacked
	 * @return Kudomon - The winning Kudomon
	 */
	public Kudomon battle(Kudomon otherKudomon){
		
		boolean itsMyTurn = myTurn.nextBoolean();
		
		while(!knockedOut && !otherKudomon.isKnockedOut()){
			
			if(itsMyTurn){
				
				strike(otherKudomon);
			}
			else{
				otherKudomon.strike(this);
			}
			
			itsMyTurn=!itsMyTurn;
		}
		if(knockedOut){
			return otherKudomon;
		}
		else{
			return this;
		}
		
	}
	
	/**
	 * Simulate one Kudomon striking another.
	 * Reduce the other Kudomon's health points by a product of the attacking Kudomon's combat points and the effectiveness multiplier
	 * @param otherKudomon - The Kudomon being struck
	 */
	public void strike(Kudomon otherKudomon){
		
		System.out.println(species + " hits " + combatPoints*getEffectiveness(otherKudomon.getType()) + " against " + otherKudomon.getSpecies());
		otherKudomon.damage(combatPoints*getEffectiveness(otherKudomon.getType()));
		
	}
	
	/**
	 * Reduce the Kudomon's health points by the specified amount
	 * @param damageAmount - The amount to be deducted from the Kudomon's health points
	 */
	public void damage(double damageAmount){
		
		healthPoints-=damageAmount;
		if(healthPoints<=0){
			knockedOut = true;
		}
		System.out.println(species+ " has " +healthPoints + " health");
	}
	
	/**
	 * Return the effectiveness multiplier against the enemy Kudomon type
	 * @param typeIn - Type of the  Kudomon 
	 * @return double - The amount of damage the attacking Kudomon will apply to the opponent
	 */
	public double getEffectiveness(ElementalType typeIn){
		
		if(!multiplier.containsKey(typeIn)){
			return 1.0;
		}
			return multiplier.get(typeIn);
	}
	
	public String getSpecies(){
		return species;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public ElementalType getType(){
		return type;
	}
	
	public boolean isKnockedOut(){
		return knockedOut;
	}
	
	/**
	 * Print the Kudomon species name
	 */
	@Override
	public String toString(){
		
		return (species);
	}
	
}



