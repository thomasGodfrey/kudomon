package model;

import java.util.HashMap;

/**
 * Represents a Rock Type Kudomon.
 * Provides the appropriate effectiveness multiplier
 */
public class RockType extends Kudomon{
	
	public RockType(ElementalType typeIn, String speciesIn, int xPosIn, int yPosIn, GameField fieldIn) {
		super(typeIn, speciesIn, xPosIn, yPosIn, fieldIn);
		
		initialiseEffectivenessMultiplier();
	}
	
	private void initialiseEffectivenessMultiplier(){
		
		multiplier.put(ElementalType.ELECTRIC,2.0);
		multiplier.put(ElementalType.GRASS,0.5);
	}

}

