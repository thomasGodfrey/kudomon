package model;

/**
 * Simple class to represent x,y coordinate position of Kudomon and Trainers
 *
 */
public class Position {
	
	private int xPos;
	private int yPos;
	
	/**
	 * Position Constructor. Initialise position as an x and y coordinate
	 * @param xPosIn - x coordinate
	 * @param yPosIn - y coordinate
	 */
	public Position(int xPosIn, int yPosIn){
		
		this.xPos = xPosIn;
		this.yPos = yPosIn;
	}
	
	
	//Getters to return the x and y coordinates of the Kudomon/Trainer
	public int getXPosition(){
		return xPos;
	}
	public int getYPosition(){
		return yPos;
	}


	/**
	 * Compares the calling objects Position, to a provided Position. 
	 * @param otherPosition - Position of object to compare to
	 * @return boolean - true if the Position is within 5 steps, otherwise false
	 */
	public boolean isNear(Position otherPosition) {
		
		double distance = Math.hypot(this.xPos - otherPosition.xPos, this.yPos - otherPosition.yPos);
		if(distance <= 5){
			return true;
		}
		return false;
	}


	/**
	 * Checks if the provided objects position is within the GameField bounds
	 * "Within bounds" means the position has a positive x and y coordinate
	 * and that the coordinate values are less than the GameFields x and y range
	 * @param xRange - Length of game Field
	 * @param yRange - Width of game Field
	 * @return boolean - true if object is within bounds, otherwise false
	 */
	public boolean isOutOfBounds(int xRange, int yRange) {
		
		if(xPos < 0 || yPos < 0 || xPos > xRange || yPos > yRange){
			return true;
		}
		return false;
	}

}
