package model;

import java.util.ArrayList;

import exceptions.KudomonCantBeCaughtException;

/**
 * Trainer class to represent players of KudomonGO
 * Trainers have a {@link model.Position}, and an identifying name
 *
 */
public class Trainer {
	
	private String name;
	private Position position;
	private GameField gameField;
	ArrayList<Kudomon> nearbyKudomon;
	ArrayList<Kudomon> caughtKudomon = new ArrayList<Kudomon>();
	
	/**
	 * Constructor for Trainer
	 * @param nameIn
	 * @param xPosIn
	 * @param yPosIn
	 * @param fieldIn - GameField on which the Trainer will spawn
	 */
	public Trainer(String nameIn, int xPosIn, int yPosIn, GameField fieldIn){
		
		name = nameIn;
		position = new Position(xPosIn,yPosIn);
		gameField = fieldIn;
		gameField.addTrainer(this);
	}
	
	/**
	 * Search for nearby Kudomon. Exclude Kudomon already caught by the Trainer.
	 */
	private void search(){
		
		ArrayList<Kudomon> searchedKudomon = new ArrayList<Kudomon>();
		ArrayList<Kudomon> gameFieldKudomon = gameField.getKudomon(); 
		
		//Iterate through the Kudomon on the field, if they are within a radius of 5 of the trainer..
		//...then add them to the nearby list
		for(Kudomon kudomon: gameFieldKudomon){
			if(position.isNear(kudomon.getPosition())){
				
				searchedKudomon.add(kudomon);
			}
		}
		
		//Remove Kudomon that are already caught by the Trainer
		searchedKudomon.removeAll(caughtKudomon);
		nearbyKudomon = searchedKudomon;
	}
	
	/**
	 * The Trainers current Position on the GameField
	 * @return Position 
	 */
	public Position getPosition() {
		return position;
	}
	
	/**
	 * Print the current position of a Trainer
	 */
	@Override
	public String toString(){
		
		return ("Trainer " +name+ " is currently at position: ("+ 
				position.getXPosition() +","+ position.getYPosition() +")" );
	}
	
	/**
	 * Add a Kudomon to the list of caught Kudomon for this Trainer
	 * @param kudomonIn
	 */
	public void catchKudomon(Kudomon kudomonIn) throws KudomonCantBeCaughtException{
		
		search();
		if(nearbyKudomon.contains(kudomonIn)){
			caughtKudomon.add(kudomonIn);
		}else{
			throw new KudomonCantBeCaughtException(kudomonIn.getSpecies()+" cant be caught!");
		}
	}
	
	/**
	 * Return a list of Kudomon caught by the Trainer
	 * @return
	 */
	public ArrayList<Kudomon> getCaughtKudomon(){
		return caughtKudomon;
	}
	
}
