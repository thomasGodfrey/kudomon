package model;

import java.util.HashMap;

/**
 * Represents a Psychic Type Kudomon.
 * Provides the appropriate effectiveness multiplier
 */
public class PsychicType extends Kudomon{
	
	public PsychicType(ElementalType typeIn, String speciesIn, int xPosIn, int yPosIn, GameField fieldIn) {
		super(typeIn, speciesIn, xPosIn, yPosIn, fieldIn);
		
		initialiseEffectivenessMultiplier();
	}
	
	private void initialiseEffectivenessMultiplier(){
		
		multiplier.put(ElementalType.ROCK,2.0);
		multiplier.put(ElementalType.FIRE,2.0);
		multiplier.put(ElementalType.WATER,2.0);
		multiplier.put(ElementalType.ELECTRIC,2.0);
		multiplier.put(ElementalType.GRASS,2.0);
	}

}


