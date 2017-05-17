package exceptions;

/**
 * Exception to be thrown if a Kudomon cannot be caught by a Trainer
 */
public class KudomonCantBeCaughtException extends Exception{

	public KudomonCantBeCaughtException(){}
	
	public KudomonCantBeCaughtException(String message){
		super(message);
	}

}
