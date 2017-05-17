package model;

import java.util.HashMap;

/**
 * Represents a Grass Type Kudomon.
 * Provides the appropriate effectiveness multiplier
 */
public class GrassType extends Kudomon{
	
	public GrassType(ElementalType typeIn, String speciesIn, int xPosIn, int yPosIn, GameField fieldIn) {
		super(typeIn, speciesIn, xPosIn, yPosIn, fieldIn);
		
		initialiseEffectivenessMultiplier();
	}
	
	private void initialiseEffectivenessMultiplier(){
		
		multiplier.put(ElementalType.ROCK,2.0);
		multiplier.put(ElementalType.FIRE,0.5);
	}

}

