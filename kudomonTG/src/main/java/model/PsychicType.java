package model;

import java.util.HashMap;

/**
 * Represents a Psychic Type Kudomon.
 * Provides the appropriate effectiveness multiplier
 */
public class PsychicType extends Kudomon{
	
	public PsychicType(String speciesIn, int xPosIn, int yPosIn,double health_pointsIn, double combat_pointsIn, GameField fieldIn) {
		super(speciesIn, xPosIn, yPosIn, health_pointsIn, combat_pointsIn, fieldIn);
		
		initialiseEffectivenessMultiplier();
		type=ElementalType.PSYCHIC;
	}
	
	private void initialiseEffectivenessMultiplier(){
		
		multiplier.put(ElementalType.ROCK,2.0);
		multiplier.put(ElementalType.FIRE,2.0);
		multiplier.put(ElementalType.WATER,2.0);
		multiplier.put(ElementalType.ELECTRIC,2.0);
		multiplier.put(ElementalType.GRASS,2.0);
	}

}


