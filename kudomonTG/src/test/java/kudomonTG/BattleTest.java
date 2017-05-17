package kudomonTG;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.ElectricType;
import model.FireType;
import model.GameField;
import model.GrassType;
import model.Kudomon;
import model.PsychicType;
import model.RockType;
import model.Trainer;
import model.WaterType;

public class BattleTest {
	
	//Create a GameField and add a trainer to the field
	GameField testGameField = new GameField(100,100);
	Trainer testTrainer1 = new Trainer("Ash",50,50,testGameField);
	Trainer testTrainer2 = new Trainer("James",51,51,testGameField);
			
	//Create some Kudomon and add them to the GameField
	Kudomon elSquirt = new WaterType("elSquirt",0,100, 34, 5,testGameField);
	Kudomon ercatpie = new GrassType("ercatpie",40,45,40, 7,testGameField);
	Kudomon narcoCow = new WaterType("narcoCow",50,50,38, 3,testGameField);
	Kudomon dedenne = new ElectricType("dedenne",55,33,45, 6,testGameField);
	Kudomon aggron = new RockType("aggron",50,51,34, 6,testGameField);
	Kudomon alakazam = new PsychicType("alakazam",47,52, 30, 5,testGameField);
	Kudomon arkanine = new FireType("arkanine",0,0,32, 4,testGameField);
	
	
	@Test
	public void testEffectiveWinBattle(){
		
		assertEquals(2.0, elSquirt.getEffectiveness(arkanine.getType()), 0.1);
		assertEquals(elSquirt,elSquirt.battle(arkanine));
		assertEquals(true,arkanine.isKnockedOut());
		assertEquals(false,elSquirt.isKnockedOut());
	}
	
	@Test
	public void testUneffectiveLoseBattle(){
		
		assertEquals(0.5, aggron.getEffectiveness(ercatpie.getType()), 0.1);
		assertEquals(ercatpie,aggron.battle(ercatpie));
		assertEquals(false,ercatpie.isKnockedOut());
		assertEquals(true,aggron.isKnockedOut());
	}
	
	@Test
	public void testMultipleoponentBattle(){
		
		assertEquals(dedenne,dedenne.battle(narcoCow));
		assertEquals(dedenne,dedenne.battle(elSquirt));
		assertEquals(false,dedenne.isKnockedOut());
		assertEquals(true,narcoCow.isKnockedOut());
		assertEquals(true,elSquirt.isKnockedOut());
	}
	
	@Test
	public void testPsychicBattle(){
		
		assertEquals(2.0, alakazam.getEffectiveness(ercatpie.getType()), 0.1);
		assertEquals(alakazam,alakazam.battle(ercatpie));
		assertEquals(false,alakazam.isKnockedOut());
		assertEquals(true,ercatpie.isKnockedOut());
	}
	
	@Test
	public void testSameTypeBattle(){
		
		assertEquals(elSquirt,elSquirt.battle(narcoCow));
		assertEquals(false,alakazam.isKnockedOut());
		assertEquals(true,narcoCow.isKnockedOut());
	}

}
