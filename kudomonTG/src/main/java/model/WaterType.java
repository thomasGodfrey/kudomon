package model;

import java.util.HashMap;

/**
 * Represents a Water Type Kudomon.
 * Provides the appropriate effectiveness multiplier
 */
public class WaterType extends Kudomon{
	
	public WaterType(ElementalType typeIn, String speciesIn, int xPosIn, int yPosIn, GameField fieldIn) {
		super(typeIn, speciesIn, xPosIn, yPosIn, fieldIn);
		
		initialiseEffectivenessMultiplier();
	}
	
	private void initialiseEffectivenessMultiplier(){
		
		multiplier.put(ElementalType.FIRE,2.0);
		multiplier.put(ElementalType.ELECTRIC,0.5);
	}

}
