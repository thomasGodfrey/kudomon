package kudomonTG;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import model.ElementalType;
import model.GameField;
import model.Kudomon;
import model.PsychicType;
import model.WaterType;

public class EffectivenessTest {
	
	//Create a GameField and add a trainer to the field
	GameField testGameField = new GameField(100,100);	
	
	Kudomon elSquirt = new WaterType("elSquirt",0,100, 34, 5,testGameField);
	Kudomon alakazam = new PsychicType("alakazam",47,52, 22, 3,testGameField);
	
	@Test
	public void testWaterEffectiveness(){
		
		assertEquals(2.0,elSquirt.getEffectiveness(ElementalType.FIRE),0.1);
		assertEquals(0.5,elSquirt.getEffectiveness(ElementalType.ELECTRIC),0.1);
		assertEquals(1.0,elSquirt.getEffectiveness(ElementalType.ROCK),0.1);
	}
	
	@Test
	public void testPsychicEffectiveness(){
		
		assertEquals(2.0,alakazam.getEffectiveness(ElementalType.FIRE),0.1);
		assertEquals(2.0,alakazam.getEffectiveness(ElementalType.ELECTRIC),0.1);
		assertEquals(2.0,alakazam.getEffectiveness(ElementalType.ROCK),0.1);
		assertEquals(2.0,alakazam.getEffectiveness(ElementalType.GRASS),0.1);
		assertEquals(2.0,alakazam.getEffectiveness(ElementalType.WATER),0.1);
		assertEquals(1.0,alakazam.getEffectiveness(ElementalType.PSYCHIC),0.1);
	}

}
