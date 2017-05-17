package kudomonTG;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.KudomonCantBeCaughtException;
import model.ElementalType;
import model.GameField;
import model.Kudomon;
import model.Trainer;

public class CaptureTest {
	
	//Create a GameField and add a trainer to the field
	GameField testGameField = new GameField(100,100);
	Trainer testTrainer = new Trainer("Ash",50,50,testGameField);
	
	//Create some Kudomon and add them to the GameField
	Kudomon elSquirt = new Kudomon(ElementalType.WATER,"elSquirt",0,100,testGameField);
	Kudomon ercatpie = new Kudomon(ElementalType.GRASS,"ercatpie",40,45,testGameField);
	Kudomon narcoCow = new Kudomon(ElementalType.WATER,"narcoCow",50,50,testGameField);
	Kudomon dedenne = new Kudomon(ElementalType.ELECTRIC,"dedenne",55,33,testGameField);
	Kudomon aggron = new Kudomon(ElementalType.ROCK,"aggron",50,51,testGameField);
	Kudomon alakazam = new Kudomon(ElementalType.PSYCHIC,"alakazam",47,52,testGameField);
	Kudomon arkanine = new Kudomon(ElementalType.FIRE,"arkanine",0,0,testGameField);
	
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldTestExceptionMessage() throws KudomonCantBeCaughtException {
	 
	    thrown.expect(KudomonCantBeCaughtException.class);
	    thrown.expectMessage("elSquirt is not nearby!");
	    testTrainer.attemptCapture(elSquirt);
	    testTrainer.finishCapture();
	}
	
	@Test
	public void testSuccesfulCapture(){
		
		try {
			testTrainer.attemptCapture(aggron);
			testTrainer.finishCapture();
		} catch (KudomonCantBeCaughtException e) {
			
			e.printStackTrace();
		}
		
		ArrayList<Kudomon> expectedCaughtKudomon = new ArrayList<Kudomon>();
		expectedCaughtKudomon.add(aggron);
		
		assertEquals(expectedCaughtKudomon,testTrainer.getCaughtKudomon());
	}
	
	@Test
	public void testMultipleCapture(){
		
		try {
			testTrainer.attemptCapture(aggron);
			testTrainer.finishCapture();
			testTrainer.attemptCapture(narcoCow);
			testTrainer.finishCapture();
			
		} catch (KudomonCantBeCaughtException e) {
			
			e.printStackTrace();
		}
		
		ArrayList<Kudomon> expectedCaughtKudomon = new ArrayList<Kudomon>();
		expectedCaughtKudomon.add(aggron);
		expectedCaughtKudomon.add(narcoCow);
		
		assertEquals(expectedCaughtKudomon,testTrainer.getCaughtKudomon());
	}
	
	
	
	

}
