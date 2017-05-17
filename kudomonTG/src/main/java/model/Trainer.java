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
	ArrayList<Kudomon> caughtKudomon = new ArrayList<Kudomon>();
	Kudomon capturingKudomon;
	
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
	public ArrayList<Kudomon> search(){
		
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
		return searchedKudomon;
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
	 * Start the capturing process of a Kudomon. 
	 * Checks if the kudomon is in range, and if its not already being captured by another trainer
	 * @param kudomonIn
	 * @throws KudomonCantBeCaughtException
	 */
	public void attemptCapture(Kudomon kudomonIn) throws KudomonCantBeCaughtException{
		
		//Call Search to retrieve the nearby Kudomon
		ArrayList<Kudomon> nearbyKudomon = search();
		
		//If the Kudomon is not nearby, throw an error
		if(!nearbyKudomon.contains(kudomonIn)){
			throw new KudomonCantBeCaughtException(kudomonIn.getSpecies() + " is not nearby!");
		
		//If the Kudomon is not being caught, then start capture
		}else if(kudomonIn.isBeingCaughtBy()==null){
			kudomonIn.setBeingCaughtBy(this);
			capturingKudomon = kudomonIn;
		
		//Otherwise another Trainer has already caught the kudomon, throw an error
		}else{
			throw new KudomonCantBeCaughtException(kudomonIn.getSpecies() +" has been stolen from you!");
		}
	}
	
	/**
	 * Completes the capturing process.
	 * Add the currently capturing Kudomon to the list of caught Kudomon for this Trainer.
	 * @param kudomonIn
	 */
	public void finishCapture(){
		
		gameField.removeKudomon(capturingKudomon);
		capturingKudomon.setBeingCaughtBy(null);
		caughtKudomon.add(capturingKudomon);
		
	}
	
	/**
	 * Return a list of Kudomon caught by the Trainer
	 * @return
	 */
	public ArrayList<Kudomon> getCaughtKudomon(){
		return caughtKudomon;
	}
	
}
