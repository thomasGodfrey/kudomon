package model;

import java.util.HashMap;

/**
 * Represents a Fire Type Kudomon.
 * Provides the appropriate effectiveness multiplier
 */
public class FireType extends Kudomon{
	
	public FireType(String speciesIn, int xPosIn, int yPosIn,double health_pointsIn, double combat_pointsIn, GameField fieldIn) {
		super(speciesIn, xPosIn, yPosIn, health_pointsIn, combat_pointsIn, fieldIn);
		
		initialiseEffectivenessMultiplier();
		type=ElementalType.FIRE;
	}
	
	private void initialiseEffectivenessMultiplier(){
		
		multiplier.put(ElementalType.ROCK,2.0);
		multiplier.put(ElementalType.WATER,0.5);
	}

}
