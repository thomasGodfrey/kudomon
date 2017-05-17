package model;

/**
 * Represents a Electric Type Kudomon.
 * Provides the appropriate effectiveness multiplier
 */
public class ElectricType extends Kudomon{
	
	public ElectricType(String speciesIn, int xPosIn, int yPosIn,double health_pointsIn, double combat_pointsIn, GameField fieldIn) {
		super(speciesIn, xPosIn, yPosIn, health_pointsIn, combat_pointsIn, fieldIn);
		
		initialiseEffectivenessMultiplier();
		type=ElementalType.ELECTRIC;
	}
	
	private void initialiseEffectivenessMultiplier(){
		
		multiplier.put(ElementalType.WATER,2.0);
		multiplier.put(ElementalType.ROCK,0.5);
	}

}
