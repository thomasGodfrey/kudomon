package model;

import java.util.Random;

/**
 * Enum to represent the 'type' of the Kudomon
 *
 */
public enum ElementalType {

	GRASS,
	ELECTRIC,
	WATER,
	ROCK,
	PSYCHIC,
	FIRE; 
	
	private static ElementalType[] TYPES = ElementalType.values();	
	private static final Random RANDOM = new Random();

	final static ElementalType getRandomType()  {
		return TYPES[RANDOM.nextInt(TYPES.length)];
	}
}
