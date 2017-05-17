package model;

import java.util.ArrayList;

/**
 * The GameField class provides a representation of an instance of a game space.
 *
 */
public class GameField {
	
	private int xRange;
	private int yRange;
	ArrayList<Trainer> trainers = new ArrayList<Trainer>();
	ArrayList<Kudomon> kudomon = new ArrayList<Kudomon>();
	
	
	public GameField(int xRangeIn, int yRangeIn){
		
		xRange = xRangeIn;
		yRange = yRangeIn;
	}
	
	/**
	 * Add a Trainer to the GameField.
	 * If the Trainer's Position is not within the GameField range, an IllegalArgumentException is thrown
	 * @param TrainerIn
	 */
	public void addTrainer(Trainer trainerIn){
		
		if(trainerIn.getPosition().isOutOfBounds(xRange,yRange)){
			throw new IllegalArgumentException("Trainer position must be within the Field boundary");
		}
		else{
			trainers.add(trainerIn);
		}
	}
	
	
	/**
	 * Add a Kudomon to the GameField.
	 * If the Kudomon's Position is not within the GameField range, an IllegalArgumentException is thrown
	 * @param kudomonIn
	 */
	public void addKudomon(Kudomon kudomonIn) {
		
		if(kudomonIn.getPosition().isOutOfBounds(xRange,yRange)){
			throw new IllegalArgumentException("Kudomon position must be within the Field boundary");
		}
		else{
			kudomon.add(kudomonIn);
		}
	}
	
	/**
	 * Return the list of Kudomon on the GameField
	 * @return ArrayList<Kudomon>
	 */
	public ArrayList<Kudomon> getKudomon(){
		return kudomon;
	}

	/**
	 * Method to remove the Kudomon from the gameField (Called after the Kudomon is captured)
	 * @param kudomonIn
	 */
	public void removeKudomon(Kudomon kudomonIn) {
		kudomon.remove(kudomonIn);
		
	}

}
