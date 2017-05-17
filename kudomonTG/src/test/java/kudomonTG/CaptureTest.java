package kudomonTG;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.KudomonCantBeCaughtException;
import model.GameField;
import model.Kudomon;
import model.RockType;
import model.Trainer;
import model.WaterType;

public class CaptureTest {
	
	//Create a GameField and add a trainer to the field
	GameField testGameField = new GameField(100,100);
	Trainer testTrainer = new Trainer("Ash",50,50,testGameField);
	
	//Create some Kudomon and add them to the GameField
	Kudomon elSquirt = new WaterType("elSquirt",0,100, 34, 5,testGameField);
	Kudomon narcoCow = new WaterType("narcoCow",50,50,38, 4,testGameField);
	Kudomon aggron = new RockType("aggron",50,51,34, 6,testGameField);
	
	
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
	
	@Test
	public void testCaptureSameKudomonTwice(){
		
		try {
			testTrainer.attemptCapture(aggron);
			testTrainer.finishCapture();
			testTrainer.attemptCapture(aggron);
			testTrainer.finishCapture();
			
		} catch (KudomonCantBeCaughtException e) {
			
			e.printStackTrace();
		}
		
		ArrayList<Kudomon> expectedCaughtKudomon = new ArrayList<Kudomon>();
		expectedCaughtKudomon.add(aggron);

		//The Trainer should only have one copy of the aggron kudomon
		assertEquals(expectedCaughtKudomon,testTrainer.getCaughtKudomon());
	}
	
	
	
	

}
