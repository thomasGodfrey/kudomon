package model;

import java.util.HashMap;

/**
 * Represents a Fire Type Kudomon.
 * Provides the appropriate effectiveness multiplier
 */
public class FireType extends Kudomon{
	
	public FireType(ElementalType typeIn, String speciesIn, int xPosIn, int yPosIn, GameField fieldIn) {
		super(typeIn, speciesIn, xPosIn, yPosIn, fieldIn);
		
		initialiseEffectivenessMultiplier();
	}
	
	private void initialiseEffectivenessMultiplier(){
		
		multiplier.put(ElementalType.ROCK,2.0);
		multiplier.put(ElementalType.WATER,0.5);
	}

}
