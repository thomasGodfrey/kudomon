package Model;

/**
 * Trainer class to represent players of KudomonGO
 * Trainers have a {@link Model.Position}, and an identifying name
 *
 */
public class Trainer {
	
	private String name;
	private Position position;
	
	/**
	 * Constructor for Trainer. Initialise member variables
	 * @param nameIn
	 * @param xPosIn
	 * @param yPosIn
	 */
	public Trainer(String nameIn, int xPosIn, int yPosIn){
		
		name = nameIn;
		position = new Position(xPosIn,yPosIn);
	}
	
	//Print the current position of a Trainer
	@Override
	public String toString(){
		
		return ("Trainer " +name+ " is currently at position: ("+ position.getXPosition() +","+ position.getYPosition() +")" );
	}

}
