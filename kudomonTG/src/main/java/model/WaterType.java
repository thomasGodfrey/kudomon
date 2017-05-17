package model;

/**
 * Represents a Water Type Kudomon.
 * Provides the appropriate effectiveness multiplier
 */
public class WaterType extends Kudomon{
	
	public WaterType(String speciesIn, int xPosIn, int yPosIn,double health_pointsIn, double combat_pointsIn, GameField fieldIn) {
		super(speciesIn, xPosIn, yPosIn, health_pointsIn, combat_pointsIn, fieldIn);
		
		initialiseEffectivenessMultiplier();
		type=ElementalType.WATER;
	}
	
	private void initialiseEffectivenessMultiplier(){
		
		multiplier.put(ElementalType.FIRE,2.0);
		multiplier.put(ElementalType.ELECTRIC,0.5);
	}

}
