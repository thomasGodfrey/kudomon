package model;

import java.util.HashMap;

/**
 * Represents a Electric Type Kudomon.
 * Provides the appropriate effectiveness multiplier
 */
public class ElectricType extends Kudomon{
	
	public ElectricType(ElementalType typeIn, String speciesIn, int xPosIn, int yPosIn, GameField fieldIn) {
		super(typeIn, speciesIn, xPosIn, yPosIn, fieldIn);
		
		initialiseEffectivenessMultiplier();
	}
	
	private void initialiseEffectivenessMultiplier(){
		
		multiplier.put(ElementalType.WATER,2.0);
		multiplier.put(ElementalType.ROCK,0.5);
	}

}
