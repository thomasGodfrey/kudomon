package main;

import exceptions.KudomonCantBeCaughtException;
import model.ElectricType;
import model.FireType;
import model.GameField;
import model.GrassType;
import model.Kudomon;
import model.PsychicType;
import model.RockType;
import model.Trainer;
import model.WaterType;

public class KudomonGO {
	
	
	public static void main(String args[]) throws KudomonCantBeCaughtException{
		
		GameField gameField;
		
		gameField = new GameField(100,100);
		
		//Create a Trainer, adding the Trainer to the GameField
		Trainer ash = new Trainer("ash",50,50,gameField);
		Trainer josh = new Trainer("josh",49,49,gameField);
		
		//Create some Kudomon and add them to the GameField
		Kudomon elSquirt = new WaterType("elSquirt",0,100, 34, 5,gameField);
		Kudomon ercatpie = new GrassType("ercatpie",40,45,40, 7,gameField);
		Kudomon narcoCow = new WaterType("narcoCow",50,50,38, 4,gameField);
		Kudomon dedenne = new ElectricType("dedenne",55,33,45, 6,gameField);
		Kudomon aggron = new RockType("aggron",50,51,20, 6,gameField);
		Kudomon alakazam = new PsychicType("alakazam",47,52, 22, 3,gameField);
		Kudomon arkanine = new FireType("arkanine",0,0,32, 4,gameField);
		
		ash.attemptCapture(aggron);
		ash.finishCapture();
		
		ash.attemptCapture(alakazam);
		ash.finishCapture();
		
		System.out.println("Ash owns: "+ ash.getCaughtKudomon() + "\n");
		
		josh.attemptCapture(narcoCow);
		josh.finishCapture();
		
		System.out.println("josh owns: "+ josh.getCaughtKudomon()+ "\n");
		
		System.out.println("--narcoCow fought aggron--");
		System.out.println(narcoCow.battle(aggron) + " won!" + "\n");
		
		System.out.println("--narcoCow fought alakazam--");
		System.out.println(narcoCow.battle(alakazam) + " won!");
				
		
	}
	
	

}
