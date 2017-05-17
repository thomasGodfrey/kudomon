package kudomonTG;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.KudomonCantBeCaughtException;
import model.ElementalType;
import model.GameField;
import model.Kudomon;
import model.Trainer;

public class MultiplayerCaptureTest {
	
	//Create a GameField and add a trainer to the field
		GameField testGameField = new GameField(100,100);
		Trainer testTrainer1 = new Trainer("Ash",50,50,testGameField);
		Trainer testTrainer2 = new Trainer("James",51,51,testGameField);
		
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
		public void testKudomonStolen() throws KudomonCantBeCaughtException {
		 
			//Both Trainers attempt to catch the same Kudomon. 
			//The second Trainer receives an error, the Kudomon was stolen by Trainer1
		    thrown.expect(KudomonCantBeCaughtException.class);
		    thrown.expectMessage("aggron has been stolen from you!");
		    testTrainer1.attemptCapture(aggron);
		    testTrainer2.attemptCapture(aggron);
		}
		
		@Test
		public void testFirstTrainerSuccessfullyCatch(){
		 
			//Both Trainers attempt to catch the same Kudomon
		    try {
				testTrainer1.attemptCapture(aggron);
				testTrainer2.attemptCapture(aggron);
			} catch (KudomonCantBeCaughtException e) {
				
				e.printStackTrace();
			}
		    
		    //The first Trainer completes the catch
			testTrainer1.finishCapture();
			
		    ArrayList<Kudomon> expectedCaughtKudomon = new ArrayList<Kudomon>();
			expectedCaughtKudomon.add(aggron);
			
			//Trainer1 catches their Kudomon successfully
			assertEquals(expectedCaughtKudomon,testTrainer1.getCaughtKudomon());
		    
		}
		
		@Test
		public void testTrainersCatchDifferentKudomon(){
		 
			//Both Trainers attempt to catch different Kudomon
		    try {
				testTrainer1.attemptCapture(aggron);
				testTrainer2.attemptCapture(alakazam);
			} catch (KudomonCantBeCaughtException e) {
				
				e.printStackTrace();
			}
		    
		    //Both Trainers complete the catch
			testTrainer1.finishCapture();
			testTrainer2.finishCapture();
			
		    ArrayList<Kudomon> expectedTrainer1CaughtKudomon = new ArrayList<Kudomon>();
		    expectedTrainer1CaughtKudomon.add(aggron);
		    
		    ArrayList<Kudomon> expectedTrainer2CaughtKudomon = new ArrayList<Kudomon>();
		    expectedTrainer2CaughtKudomon.add(alakazam);
			
		    //Both Trainers successfully catch their respective Kudomon
			assertEquals(expectedTrainer1CaughtKudomon,testTrainer1.getCaughtKudomon());
			assertEquals(expectedTrainer2CaughtKudomon,testTrainer2.getCaughtKudomon());
		    
		}

}
