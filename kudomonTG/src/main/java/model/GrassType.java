package model;

/**
 * Represents a Grass Type Kudomon.
 * Provides the appropriate effectiveness multiplier
 */
public class GrassType extends Kudomon{
	
	public GrassType(String speciesIn, int xPosIn, int yPosIn,double health_pointsIn, double combat_pointsIn, GameField fieldIn) {
		super(speciesIn, xPosIn, yPosIn, health_pointsIn, combat_pointsIn, fieldIn);
		
		initialiseEffectivenessMultiplier();
		type=ElementalType.GRASS;
	}
	
	private void initialiseEffectivenessMultiplier(){
		
		multiplier.put(ElementalType.ROCK,2.0);
		multiplier.put(ElementalType.FIRE,0.5);
	}

}

