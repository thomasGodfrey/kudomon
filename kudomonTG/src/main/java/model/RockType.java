package model;

import java.util.HashMap;

/**
 * Represents a Rock Type Kudomon.
 * Provides the appropriate effectiveness multiplier
 */
public class RockType extends Kudomon{
	
	public RockType(String speciesIn, int xPosIn, int yPosIn,double health_pointsIn, double combat_pointsIn, GameField fieldIn) {
		super(speciesIn, xPosIn, yPosIn, health_pointsIn, combat_pointsIn, fieldIn);
		
		initialiseEffectivenessMultiplier();
		type=ElementalType.ROCK;
	}
	
	private void initialiseEffectivenessMultiplier(){
		
		multiplier.put(ElementalType.ELECTRIC,2.0);
		multiplier.put(ElementalType.GRASS,0.5);
	}

}

