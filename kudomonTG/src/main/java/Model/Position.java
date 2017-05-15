package Model;

/**
 * Simple class to represent x,y coordinate position of Kudomon and Trainers
 *
 */
public class Position {
	
	private int xPos;
	private int yPos;
	
	/**
	 * Position Constructor. Initialise position as an x and y coordinate
	 * @param xPosIn
	 * @param yPosIn
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

}
