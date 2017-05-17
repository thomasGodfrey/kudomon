package kudomonTG;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import exceptions.KudomonCantBeCaughtException;
import model.ElectricType;
import model.ElementalType;
import model.FireType;
import model.GameField;
import model.GrassType;
import model.Kudomon;
import model.PsychicType;
import model.RockType;
import model.WaterType;

public class EffectivenessTest {
	
	//Create a GameField and add a trainer to the field
	GameField testGameField = new GameField(100,100);	
	
	Kudomon elSquirt = new WaterType(ElementalType.WATER,"elSquirt",0,100,testGameField);
	Kudomon ercatpie = new GrassType(ElementalType.GRASS,"ercatpie",40,45,testGameField);
	Kudomon narcoCow = new WaterType(ElementalType.WATER,"narcoCow",50,50,testGameField);
	Kudomon dedenne = new ElectricType(ElementalType.ELECTRIC,"dedenne",55,33,testGameField);
	Kudomon aggron = new RockType(ElementalType.ROCK,"aggron",50,51,testGameField);
	Kudomon alakazam = new PsychicType(ElementalType.PSYCHIC,"alakazam",47,52,testGameField);
	Kudomon arkanine = new FireType(ElementalType.FIRE,"arkanine",0,0,testGameField);
	
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
